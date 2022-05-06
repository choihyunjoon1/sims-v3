package co.spoonradio.sims.service.cashout

import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.common.cipher.AESCipher
import co.spoonradio.sims.common.excel.ExcelGenerator
import co.spoonradio.sims.common.excel.models.GeneralExchangeLogDownload
import co.spoonradio.sims.component.aws.s3.FileRequestFactory
import co.spoonradio.sims.component.aws.s3.FileRequestType
import co.spoonradio.sims.component.aws.s3.S3FileManager
import co.spoonradio.sims.component.download.MailManager
import co.spoonradio.sims.controller.cashout.RequestChangeExchange
import co.spoonradio.sims.dto.enum.ExchangeBank
import co.spoonradio.sims.dto.gateway.awsLambda.RequestSms
import co.spoonradio.sims.dto.request.balance.RequestBalanceAccept
import co.spoonradio.sims.dto.request.balance.RequestBalanceReject
import co.spoonradio.sims.dto.request.cashout.*
import co.spoonradio.sims.dto.request.notification.NotificationRequestsEvent
import co.spoonradio.sims.dto.request.notification.exchange.BillingData
import co.spoonradio.sims.dto.request.notification.exchange.DueDateData
import co.spoonradio.sims.dto.request.notification.exchange.ExchangeData
import co.spoonradio.sims.dto.request.push.ArgsData
import co.spoonradio.sims.dto.request.push.PushData
import co.spoonradio.sims.dto.request.push.PushRequestsEvent
import co.spoonradio.sims.dto.response.cashout.Amount
import co.spoonradio.sims.dto.response.cashout.Exchange
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.ExchangeUser
import co.spoonradio.sims.dto.response.cashout.general.ExchangeApplyManually
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDocument
import co.spoonradio.sims.dto.response.cashout.general.GeneralExchange
import co.spoonradio.sims.dto.response.cashout.general.SubmitDocument
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.users.UserProfileEntity
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.gateway.AwsLambdaGateway
import co.spoonradio.sims.gateway.BalanceApiGateway
import co.spoonradio.sims.gateway.BillingApiGateway
import co.spoonradio.sims.gateway.RedisEventGateway
import co.spoonradio.sims.repository.cashout.AdminMysqlExchangeRepository
import co.spoonradio.sims.repository.cashout.BillingExchangeRepository
import co.spoonradio.sims.repository.users.PostgresUserProfileRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import org.slf4j.MDC
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.net.URL
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.imageio.ImageIO

@Service
class DefaultGeneralExchangeService(
    val billingExchangeRepository: BillingExchangeRepository,
    val userProfileRepository: PostgresUserProfileRepository,
    val adminExchangeRepository: AdminMysqlExchangeRepository,
    val awsLambdaGateway: AwsLambdaGateway,
    val balanceApiGateway: BalanceApiGateway,
    val redisEventGateway: RedisEventGateway,
    val billingApiGateway: BillingApiGateway,
    val mailManager: MailManager,
    val s3FileManager: S3FileManager,
    val fileRequestFactory: FileRequestFactory
) : GeneralExchangeService {
    override fun getGeneralExchangeList(param: RequestExchange): SimsResponseEntity<List<GeneralExchange>, ExtraDataEntity> {

        var searchUser = this.getSearchUserProfile(param)

        param.apply {
            user_Ids = searchUser?.keys
        }

        //Billing 환전 데이터 조회
        val result = billingExchangeRepository.getGeneralExchangeDepositList(param)

        //환전 리스트 userIds 추출
        var userIds = result.first.map {
            it.applicantId
        }
        val spoonUserEntity = searchUser ?: userProfileRepository.findUserProfileByUserIds(userIds) //spoonCast DB 조회

        //Billing DB && spoonCast main DB aggregation
        val generalExchangeList = result.first.map {
            GeneralExchange(it).apply {
                spoonUserEntity[it.applicantId]?.let { user ->
                    val spoonExchangeUser = ExchangeUser(user)
                    this.niceInfo = spoonExchangeUser.niceInfo
                    this.applicant = spoonExchangeUser.profileInfo
                    this.tierInfo = spoonExchangeUser.tierInfo
                }
            }
        }

        val totalCount = result.second
        val summary = billingExchangeRepository.getGeneralExchangeDepositSummary(param)

        return SimsResponseEntity(
            generalExchangeList,
            ExtraDataEntity(
                CommonUtils.getPageCount(totalCount, param.base!!.page_size),
                totalCount,
                summary.totalExchangedAmount,
                summary.totalExpectedAmount
            )
        )
    }

    override fun getGeneralExchangeAmountList(param: RequestExchangeHistories): SimsResponseEntity<List<Amount>, ExtraDataEntity> {
        val result = billingExchangeRepository.getExchangeAmountList(param)
        val totalCount = result.second
        return SimsResponseEntity(
            result.first,
            ExtraDataEntity(
                CommonUtils.getPageCount(totalCount, param.base!!.page_size),
                totalCount
            )
        )
    }

    override fun getGeneralExchangeHistories(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity> {
        val result = billingExchangeRepository.getExchangeHistories(param)
        val totalCount = result.second
        return SimsResponseEntity(
            result.first,
            ExtraDataEntity(
                CommonUtils.getPageCount(totalCount, param.base!!.page_size),
                totalCount
            )
        )
    }

    override fun getGeneralExchangeSubmitDocuments(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeDocument>, ExtraDataEntity> {
        val result = billingExchangeRepository.getGeneralExchangeSubmitDocuments(param)
        val exchangeDocuments = result.first
        exchangeDocuments.forEach {
            if (MDC.get("UNMASKING").equals("true")) {
                val documentS3URL = URL(it.url)
                val file = s3FileManager.getFile(
                    fileRequestFactory.createDownloadRequest(
                        FileRequestType.VIEW_PRIVACY_IMAGE,
                        documentS3URL.path.substring(1)
                    )
                )

                val prefixMeta = "data:"+file.response().contentType()+";base64,"
                val originalImage = ImageIO.read(file)

                val outputImageStream = ByteArrayOutputStream()
                val resultingImage: Image = originalImage.getScaledInstance(originalImage.width, originalImage.height, Image.SCALE_DEFAULT)
                val resizingImage = BufferedImage(originalImage.width, originalImage.height, BufferedImage.TYPE_INT_RGB)
                resizingImage.graphics.drawImage(resultingImage, 0, 0, null)
                ImageIO.write(resizingImage, "jpg", outputImageStream)

                val outputImageBytes = prefixMeta.encodeToByteArray() + Base64.getEncoder().encode(outputImageStream.toByteArray())
                it.document = SubmitDocument(outputImageBytes.decodeToString(), file.response().contentType())
            } else {
                it.document = SubmitDocument(it.url, "masking")
            }
        }

        val totalCount = result.second
        return SimsResponseEntity(
            exchangeDocuments,
            ExtraDataEntity(
                CommonUtils.getPageCount(totalCount, param.base!!.page_size),
                totalCount
            )
        )
    }

    @Transactional
    override fun rejectGeneralExchange(requestExchangeReject: RequestExchangeReject) {
        requestExchangeReject.apply {
            creator = AdminUserInfoManager.getUserInfo().userId.toLong()
            updater = AdminUserInfoManager.getUserInfo().userId.toLong()
        }

        billingExchangeRepository.getGeneralExchangeByIdAndStatus(requestExchangeReject.id, listOf("UNDER_REVIEW", "DEPOSIT_WAITING")).let { exchange ->
            val amountList =
                billingExchangeRepository.getExchangeAmountListByExchangeIdAndStatus(requestExchangeReject.id, "DEPOSIT_WAITING")
            amountList.forEach {
                billingExchangeRepository.updateExchangeAmount(it.id, "CANCELED")
                var txId: String = CommonUtils.generateUUID()
                //SIMS DB
                adminExchangeRepository.insertExchangeActionHistory(
                    RequestExchangeActionHistory(
                        txId,
                        it.balanceLockId,
                        "REJECT",
                        requestExchangeReject.creator ?: 0L
                    )
                )

                //balance reject API
                balanceApiGateway.rejectExchange(RequestBalanceReject(txId, it.balanceLockId))
            }

            billingExchangeRepository.insertExchangeRejectReason(requestExchangeReject)
            billingExchangeRepository.updateExchange(requestExchangeReject.id, "REJECTED")
            billingExchangeRepository.insertExchangeHistory(requestExchangeReject.id, "REJECTED")

            try{
                awsLambdaGateway.sendSms(
                    RequestSms(
                        exchange.id.toString(),
                        exchange.phoneNumber,
                        1,
                        "환전 취소\n[Spoon] 환전 정보 확인 과정에서 " + requestExchangeReject.sms + " (으)로 인하여 환전 취소 처리되었음을 안내드립니다.\n자세한 사항은 고객문의(https://spoon-support.spooncast.net/?country=kr)를 통해 문의 접수 바랍니다."
                    )
                )
            } catch (e: Exception) {
                //TODO() Slack -> Balance API를 제외하고 외부 연동 하는 포인트는 에러가 발생 되더라도 throw 하지 않도로 개발 함.
            }
        }
    }



    @Transactional
    override fun rejectMultipleGeneralExchange(requestExchangeMultipleReject: RequestExchangeMultipleReject) {
        val requestExchangeMultiple = RequestExchangeMultiple(requestExchangeMultipleReject.exchange_ids).apply {
            actionType = listOf("UNDER_REVIEW", "DEPOSIT_WAITING")
        }

        billingExchangeRepository.getGeneralExchangeListByIdsAndStatus(requestExchangeMultiple).forEach { exchange ->
            val amountList = billingExchangeRepository.getExchangeAmountListByExchangeIdAndStatus(exchange.id, "DEPOSIT_WAITING")
            amountList.forEach { amount ->
                billingExchangeRepository.updateExchangeAmount(amount.id, "CANCELED")
                var txId: String = CommonUtils.generateUUID()
                //SIMS DB
                adminExchangeRepository.insertExchangeActionHistory(
                    RequestExchangeActionHistory(
                        txId,
                        amount.balanceLockId,
                        "REJECT",
                        AdminUserInfoManager.getUserInfo().userId.toLong()
                    )
                )

                //balance reject API
                balanceApiGateway.rejectExchange(RequestBalanceReject(txId, amount.balanceLockId))
            }

            billingExchangeRepository.insertExchangeRejectReason(
                RequestExchangeReject(
                    exchange.id,
                    requestExchangeMultipleReject.reason,
                    requestExchangeMultipleReject.sms
                ).apply {
                    creator = AdminUserInfoManager.getUserInfo().userId.toLong()
                    updater = AdminUserInfoManager.getUserInfo().userId.toLong()
                }
            )
            billingExchangeRepository.updateExchange(exchange.id, "REJECTED")
            billingExchangeRepository.insertExchangeHistory(exchange.id, "REJECTED")
            try {
                awsLambdaGateway.sendSms(
                    RequestSms(
                        exchange.id.toString(),
                        exchange.phoneNumber,
                        1,
                        "환전 취소\n[Spoon] 환전 정보 확인 과정에서 " + requestExchangeMultipleReject.sms + " (으)로 인하여 환전 취소 처리되었음을 안내드립니다.\n자세한 사항은 고객문의(https://spoon-support.spooncast.net/?country=kr)를 통해 문의 접수 바랍니다."
                    )
                )
            } catch (e: Exception) {
                //TODO() Slack -> Balance API를 제외하고 외부 연동 하는 포인트는 에러가 발생 되더라도 throw 하지 않도로 개발 함.
            }


        }
    }

    override fun changeExpectedExchangeDate(param: RequestChangeExchange): SimsResponseEntity<Exchange, ExtraDataEntity> {
        val exchange = billingExchangeRepository.getExchangeById(param.id)
        if (exchange.status != "UNDER_REVIEW")
            throw GeneralException("00028")

        billingExchangeRepository.updateExchangeExpectedExchangedDateById(param.id, LocalDate.parse(param.expectedExchangedDate))
        return SimsResponseEntity(exchange, ExtraDataEntity())
    }

    @Transactional("billingTxManager")
    override fun confirmGeneralExchange(requestExchangeMultiple: RequestExchangeMultiple) {
        requestExchangeMultiple.actionType = listOf("UNDER_REVIEW")

        billingExchangeRepository.getGeneralExchangeListByIdsAndStatus(requestExchangeMultiple).forEach { exchange ->
            billingExchangeRepository.updateExchange(exchange.id, "DEPOSIT_WAITING")
            billingExchangeRepository.insertExchangeHistory(exchange.id, "DEPOSIT_WAITING")
            val requestSms = RequestSms(
                exchange.id.toString(),
                exchange.phoneNumber,
                1,
                "[Spoon] 환전 정보 확인이 완료되어 " + exchange.expectedExchangedDate + " 21:00 이전에 입금 완료될 예정입니다.\n 기타 문의 사항은 고객문의(https://spoon-support.spooncast.net/?country=kr)를 통해 접수 바랍니다."
            )

            redisEventGateway.pushRequestEvent(
                PushRequestsEvent(
                    "REQUEST_CREATE",
                    2000000005,
                    "PUSH_EXCHANGE_PENDING",
                    PushData(
                        ArgsData(listOf(exchange.expectedExchangedDate), emptyList()),
                        ArgsData(emptyList(), listOf(exchange.expectedExchangedDate))
                    ),
                    exchange.applicantId
                )
            )

            redisEventGateway.notificationRequestEvent(NotificationRequestsEvent(
                "REQUEST_CREATE",
                2000000005,
                exchange.applicantId.toLong(),
                "NOTI_27",
                BillingData(ExchangeData(DueDateData(exchange.expectedExchangedDate))).toString()
            ))

            awsLambdaGateway.sendSms(requestSms)
        }
    }

    @Transactional
    override fun acceptExchange(requestExchangeMultiple: RequestExchangeMultiple) {
        requestExchangeMultiple.actionType = listOf("DEPOSIT_WAITING")
        val exchangeList = billingExchangeRepository.getGeneralExchangeListByIdsAndStatus(requestExchangeMultiple)
        if (exchangeList.isEmpty()) throw GeneralException("00020")

        exchangeList.forEach { exchange ->
            val amountList = billingExchangeRepository.getExchangeAmountListByExchangeIdAndStatus(exchange.id, "DEPOSIT_WAITING")
            var totalAmount = 0
            amountList.forEach {
                billingExchangeRepository.updateExchangeAmount(it.id, "EXCHANGED")

                var txId: String = CommonUtils.generateUUID()

                var actionHistory = RequestExchangeActionHistory(
                    txId,
                    it.balanceLockId,
                    "ACCEPT",
                    AdminUserInfoManager.getUserInfo().userId.toLong()
                )
                //SIMS DB
                adminExchangeRepository.insertExchangeActionHistory(actionHistory)

                //balance accept API
                balanceApiGateway.acceptExchange(RequestBalanceAccept(txId, it.balanceLockId))
                totalAmount += it.amount
            }

            billingExchangeRepository.updateExchangeAcceptComplete(exchange.id, "EXCHANGED", totalAmount)
            billingExchangeRepository.insertExchangeHistory(exchange.id, "EXCHANGED")
            try {
                redisEventGateway.pushRequestEvent(
                    PushRequestsEvent(
                        "REQUEST_CREATE",
                        2000000005,
                        "PUSH_EXCHANGE_COMPLETE",
                        PushData(ArgsData(), ArgsData()),
                        exchange.applicantId
                    )
                )

                redisEventGateway.notificationRequestEvent(NotificationRequestsEvent(
                    "REQUEST_CREATE",
                    2000000005,
                    exchange.applicantId.toLong(),
                    "NOTI_28",
                    "{}"
                ))

                awsLambdaGateway.sendSms(
                    RequestSms(
                        exchange.id.toString(),
                        exchange.phoneNumber,
                        1,
                        "[Spoon] 환전 입금이 완료되었습니다.\n신청하신 계좌 정보를 통해 입금 여부를 확인 바랍니다.\n"
                    )
                )
            } catch(e: Exception) {
                //TODO() Slack -> Balance API를 제외하고 외부 연동 하는 포인트는 에러가 발생 되더라도 throw 하지 않도로 개발 함.
            }

        }
    }

    override fun applyManuallyGeneralExchange(exchangeApplyManually: RequestExchangeApplyManually) : ExchangeApplyManually {
        val bank = ExchangeBank.fromBankCode(exchangeApplyManually.exchangeBank) ?: throw GeneralException("00035")

        val result = billingApiGateway.depositExchanges(
            exchangeApplyManually.userId,
            RequestDepositExchange(
                exchangeApplyManually.exchangeSpoon,
                exchangeApplyManually.applicantName,
                exchangeApplyManually.email,
                exchangeApplyManually.phoneNumber,
                exchangeApplyManually.residentFirstNumber,
                exchangeApplyManually.residentLastNumber,
                exchangeApplyManually.accountHolder,
                bank.name,
                exchangeApplyManually.accountNumber,
                exchangeApplyManually.privacyConsent,
                exchangeApplyManually.residentCollectionConsent,
                exchangeApplyManually.familyRelationCertificates,
                exchangeApplyManually.legalRepresentativeAgreement)
        )
        return result
    }

    override fun createExchangeExcel(param: RequestExchange, body: RequestDownloadExcelExchange) {
        var searchUser = this.getSearchUserProfile(param)

        param.apply {
            user_Ids = searchUser?.keys
        }

        //Billing 환전 데이터 조회
        val result = billingExchangeRepository.getGeneralExchangeDepositList(param)
        if (result.first.isEmpty()) throw GeneralException("00010")
        //환전 리스트 userIds 추출
        var userIds = result.first.map {
            it.applicantId
        }
        val spoonUserEntity = searchUser ?: userProfileRepository.findUserProfileByUserIds(userIds) //spoonCast DB 조회

        //Billing DB && spoonCast main DB aggregation
        val generalExchangeList = result.first.map {
            spoonUserEntity[it.applicantId]?.let { user ->
                val spoonExchangeUser = ExchangeUser(user)
                GeneralExchangeLogDownload(
                    it,
                    spoonExchangeUser.profileInfo,
                    spoonExchangeUser.niceInfo,
                    spoonExchangeUser.tierInfo
                )
            }
        }

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            sourceData = ExcelGenerator.generateToByteArray(generalExchangeList, body.password),
            password = body.password,
            filename = "GeneralCashOut_"+ ZonedDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHmmssSSS"))+".xlsx"
        )
    }

    private fun getSearchUserProfile(param: RequestExchange): MutableMap<Int?, UserProfileEntity>? {
        // id, tag, nickname 검색
        param.base?.let { it ->
            if (it.field == "id" && !it.value.isNullOrBlank()) //userId 검색
                it.value?.let { value ->
                    return userProfileRepository.findUserProfileByUserIds(listOf(value.toInt()))
                }

            if (it.field == "tag" && !it.value.isNullOrBlank()) //tag 검색
                it.value?.let { value ->
                    return userProfileRepository.findUserProfileByTag(value)
                }

            if (it.field == "nickname" && !it.value.isNullOrBlank()) //nickname 검색
                it.value?.let { value ->
                    return userProfileRepository.findUserProfileByNickname(value)
                }
        }

        // 티어 검색
        param.tier_id?.let { value ->
            return userProfileRepository.findUserProfileByTierId(value)
        }

        return null
    }

}

