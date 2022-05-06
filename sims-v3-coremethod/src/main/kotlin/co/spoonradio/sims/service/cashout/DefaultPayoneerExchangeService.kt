package co.spoonradio.sims.service.cashout

import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.common.excel.ExcelGenerator
import co.spoonradio.sims.common.excel.models.PayoneerExchangeLogDownload
import co.spoonradio.sims.component.download.MailManager
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
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.ExchangeUser
import co.spoonradio.sims.dto.response.cashout.payoneer.PayoneerExchange
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.users.UserProfileEntity
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.gateway.BalanceApiGateway
import co.spoonradio.sims.gateway.PayoneerApiGateway
import co.spoonradio.sims.gateway.RedisEventGateway
import co.spoonradio.sims.repository.cashout.AdminMysqlExchangeRepository
import co.spoonradio.sims.repository.cashout.BillingExchangeRepository
import co.spoonradio.sims.repository.users.PostgresUserProfileRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Service
class DefaultPayoneerExchangeService(val userProfileRepository: PostgresUserProfileRepository,
                                     val adminExchangeRepository: AdminMysqlExchangeRepository,
                                     val billingExchangeRepository: BillingExchangeRepository,
                                     val balanceApiGateway: BalanceApiGateway,
                                     val redisEventGateway: RedisEventGateway,
                                     val payoneerApiGateway: PayoneerApiGateway,
                                     val mailManager: MailManager,
) :PayoneerExchangeService {
    override fun getPayoneerExchangeList(param: RequestExchange): SimsResponseEntity<List<PayoneerExchange>, ExtraDataEntity> {
        var searchUser = this.getSearchUserProfile(param)
        param.apply {
            user_Ids = searchUser?.keys
        }

        //Billing 환전 데이터 조회
        val result = billingExchangeRepository.getExchangeList(param)

        //환전 리스트 userIds 추출
        var userIds = result.first.map {
            it.applicantId
        }
        val spoonUserEntity = searchUser ?: userProfileRepository.findUserProfileByUserIds(userIds) //spoonCast DB 조회

        //Billing DB && spoonCast main DB aggregation
        val exchangeList = result.first.map {
            PayoneerExchange(it).apply {
                spoonUserEntity[it.applicantId]?.let { user ->
                    val spoonExchangeUser = ExchangeUser(user)
                    this.applicant = spoonExchangeUser.profileInfo
                    this.tierInfo = spoonExchangeUser.tierInfo
                }
            }
        }

        val totalCount = result.second
        val summary = billingExchangeRepository.getExchangeSummary(param)

        return SimsResponseEntity(
            exchangeList,
            ExtraDataEntity(
                CommonUtils.getPageCount(totalCount, param.base!!.page_size),
                totalCount,
                summary.totalExchangedAmount,
                summary.totalExpectedAmount
            )
        )
    }

    override fun getPayoneerExchangeAmountList(param: RequestExchangeHistories): SimsResponseEntity<List<Amount>, ExtraDataEntity> {
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

    override fun getPayoneerExchangeHistories(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity> {
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

    @Transactional("billingTxManager")
    override fun confirmPayoneerExchange(requestExchangeMultiple: RequestExchangeMultiple) {
        requestExchangeMultiple.actionType = listOf("UNDER_REVIEW")

        billingExchangeRepository.getExchangeListByIdsAndStatus(requestExchangeMultiple).forEach { exchange ->
            billingExchangeRepository.updateExchange(exchange.id, "DEPOSIT_WAITING")
            billingExchangeRepository.insertExchangeHistory(exchange.id, "DEPOSIT_WAITING")

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

            redisEventGateway.notificationRequestEvent(
                NotificationRequestsEvent(
                    "REQUEST_CREATE",
                    2000000005,
                    exchange.applicantId.toLong(),
                    "NOTI_27",
                    BillingData(ExchangeData(DueDateData(exchange.expectedExchangedDate))).toString()
                )
            )
        }
    }

    @Transactional
    override fun rejectExchange(requestExchangeReject: RequestExchangeReject) {
        billingExchangeRepository.getExchangeByIdAndStatus(requestExchangeReject.id, listOf("UNDER_REVIEW", "DEPOSIT_WAITING")).let { exchange ->
            val amountList =
                billingExchangeRepository.getExchangeAmountListByExchangeId(requestExchangeReject.id)
            val pendingAmountList = mutableListOf<Amount>()
            amountList.forEach{ amount ->
                if(amount.status == "DEPOSIT_WAITING" || amount.status == "EXCHANGED") {
                    throw GeneralException("00027") //이 처리가 SIMS 코드+문서에는 있는데 정상 동작을 안하는 것 같음
                }

                if(amount.status == "DEPOSIT_PENDING") {
                    pendingAmountList.add(amount)
                }
            }

            if (pendingAmountList.size > 0) {
                pendingAmountList.forEach { pending ->
                    billingExchangeRepository.updateExchangeAmount(pending.id, "CANCELED")
                    var txId: String = CommonUtils.generateUUID()
                    //SIMS DB
                    adminExchangeRepository.insertExchangeActionHistory(
                        RequestExchangeActionHistory(
                            txId,
                            pending.balanceLockId,
                            "REJECT",
                            AdminUserInfoManager.getUserInfo().userId.toLong()
                        )
                    )

                    //balance reject API
                    balanceApiGateway.rejectExchange(RequestBalanceReject(txId, pending.balanceLockId))
                }
            }

            billingExchangeRepository.insertExchangeRejectReason(requestExchangeReject.apply {
                creator = AdminUserInfoManager.getUserInfo().userId.toLong()
                updater = AdminUserInfoManager.getUserInfo().userId.toLong()
            })
            billingExchangeRepository.updateExchange(requestExchangeReject.id, "REJECTED")
            billingExchangeRepository.insertExchangeHistory(requestExchangeReject.id, "REJECTED")
        }
    }

    @Transactional
    override fun rejectMultipleExchange(requestExchangeMultipleReject: RequestExchangeMultipleReject) {
        val requestExchangeMultiple = RequestExchangeMultiple(requestExchangeMultipleReject.exchange_ids).apply {
            actionType = listOf("UNDER_REVIEW", "DEPOSIT_WAITING")
        }

        billingExchangeRepository.getExchangeListByIdsAndStatus(requestExchangeMultiple).forEach { exchange ->
            val amountList = billingExchangeRepository.getExchangeAmountListByExchangeId(exchange.id)
            val pendingAmountList = mutableListOf<Amount>()
            amountList.forEach{ amount ->
                if(amount.status == "DEPOSIT_WAITING" || amount.status == "EXCHANGED") {
                    throw GeneralException("00027") //이 처리가 SIMS 코드+문서에는 있는데 정상 동작을 안하는 것 같음
                }

                if(amount.status == "DEPOSIT_PENDING") {
                    pendingAmountList.add(amount)
                }
            }

            pendingAmountList.forEach { amount ->
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
        }
    }

    @Transactional("billingTxManager")
    override fun requestPayoutPayoneerExchange(requestPayoneerExchangePayout: RequestPayoneerExchangePayout) {
        val exchangeAmount = billingExchangeRepository.getExchangeAmountByIdAndStatus(
            requestPayoneerExchangePayout.amount_id,
            "DEPOSIT_PENDING"
        )

        val exchange = billingExchangeRepository.getExchangeById(exchangeAmount.exchange)
        billingExchangeRepository.updateExchangeAmount(requestPayoneerExchangePayout.amount_id, "DEPOSIT_WAITING")

        val requestDate = ZonedDateTime.now()

        payoneerApiGateway.payouts(
            RequestPayouts(
                exchange.applicantId, exchangeAmount.amount, exchangeAmount.id, "Spoon", "USD", requestDate.format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ), requestDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
            )
        )
    }

    @Transactional("billingTxManager")
    override fun requestMultiplePayoutPayoneerExchange(requestExchangeMultiple: RequestExchangeMultiple) {
        val requestDate = ZonedDateTime.now()
        billingExchangeRepository.getLatestExchangeAmountListByExchangeId(requestExchangeMultiple.exchange_ids, listOf("DEPOSIT_PENDING")).forEach {
            billingExchangeRepository.updateExchangeAmount(it.amountId, "DEPOSIT_WAITING")
            payoneerApiGateway.payouts(
                RequestPayouts(
                    it.applicantId, it.amount, it.amountId, "Spoon", "USD", requestDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    ), requestDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                )
            )
        }
    }

    @Transactional
    override fun acceptPayoneerExchange(amountId: Long) {
        val exchangeAmount = billingExchangeRepository.getExchangeAmountByIdAndStatus(
            amountId,
            "DEPOSIT_WAITING"
        )
        val exchange = billingExchangeRepository.getExchangeByIdAndStatus(exchangeAmount.exchange, listOf("DEPOSIT_WAITING"))

        val remainExchangeAmount = billingExchangeRepository.getExchangeAmountCountByExchangeIdAndStatusAndIdNot(amountId, exchange.id, listOf("DEPOSIT_PENDING", "DEPOSIT_WAITING" ))

        val payout = payoneerApiGateway.getPayouts(amountId)
        if (payout.statusCategory != "Transferred") throw GeneralException("00033")

        billingExchangeRepository.updateExchangeAmount(amountId, "EXCHANGED")
        if (remainExchangeAmount > 0 ) {
            billingExchangeRepository.updateExchangeAccept(exchange.id, exchangeAmount.amount, LocalDate.parse(exchange.expectedExchangedDate).plusDays(7))
        } else {
            billingExchangeRepository.updateExchangeAcceptComplete(exchange.id, "EXCHANGED", exchangeAmount.amount)
        }

        billingExchangeRepository.insertExchangeHistory(exchange.id, "EXCHANGED")

        var txId: String = CommonUtils.generateUUID()
        //SIMS DB
        adminExchangeRepository.insertExchangeActionHistory(
            RequestExchangeActionHistory(
                txId,
                exchangeAmount.balanceLockId,
                "ACCEPT",
                AdminUserInfoManager.getUserInfo().userId.toLong()
            )
        )
        //balance accept API
        balanceApiGateway.acceptExchange(RequestBalanceAccept(txId, exchangeAmount.balanceLockId))
    }

    @Transactional
    override fun acceptMultiplePayoneerExchange(requestExchangeMultiple: RequestExchangeMultiple) {
        requestExchangeMultiple.apply {
            actionType = listOf("DEPOSIT_WAITING")
        }

        // 환전 데이터 조회
        val exchangeList = billingExchangeRepository.getExchangeListByIdsAndStatus(requestExchangeMultiple)
        // 최대, 최소 expectedExchangedDate 추출

        val minDate = exchangeList.stream().map {it.created.toLocalDate()}.min(LocalDate::compareTo).get().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val maxDate = exchangeList.stream().map {it.created.toLocalDate()}.max(LocalDate::compareTo).get().plusDays(14).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        // payoneer API 호출
        val payeesStatusReports = payoneerApiGateway.getPayeesStatus(minDate, maxDate)

        val payoutReports = mutableMapOf<String, String>()
        payeesStatusReports.payees.forEach {
            it.payouts.forEach { payout ->
                payoutReports.put(payout.clientReferenceId, payout.statusCategory)
            }
        }
        val targetExchangeIds = exchangeList.map { it.id }

        billingExchangeRepository.getExchangeAmountListByExchangeIdsAndStatus(targetExchangeIds, listOf("DEPOSIT_WAITING")).forEach { exchangeAmount ->
            if (payoutReports.get(exchangeAmount.amountId.toString()).equals("Transferred")) {
                billingExchangeRepository.updateExchangeAmount(exchangeAmount.amountId, "EXCHANGED")
                val remainExchangeAmount = billingExchangeRepository.getExchangeAmountCountByExchangeIdAndStatusAndIdNot(exchangeAmount.amountId, exchangeAmount.exchangeId, listOf("DEPOSIT_PENDING", "DEPOSIT_WAITING"))
                if (remainExchangeAmount > 0 ) {
                    billingExchangeRepository.updateExchangeAccept(exchangeAmount.exchangeId, exchangeAmount.amount, LocalDate.parse(exchangeAmount.expectedExchangedDate).plusDays(7))
                } else {
                    billingExchangeRepository.updateExchangeAcceptComplete(exchangeAmount.exchangeId, "EXCHANGED", exchangeAmount.amount)
                }

                billingExchangeRepository.insertExchangeHistory(exchangeAmount.exchangeId, "EXCHANGED")

                var txId: String = CommonUtils.generateUUID()
                //SIMS DB
                adminExchangeRepository.insertExchangeActionHistory(
                    RequestExchangeActionHistory(
                        txId,
                        exchangeAmount.balanceLockId,
                        "ACCEPT",
                        AdminUserInfoManager.getUserInfo().userId.toLong()
                    )
                )
                //balance accept API
                balanceApiGateway.acceptExchange(RequestBalanceAccept(txId, exchangeAmount.balanceLockId))
            }
        }
    }

    override fun createExchangeExcel(param: RequestExchange, body: RequestDownloadExcelExchange) {
        var searchUser = this.getSearchUserProfile(param)

        param.apply {
            user_Ids = searchUser?.keys
        }

        //Billing 환전 데이터 조회
        val result = billingExchangeRepository.getExchangeList(param)
        if (result.first.isEmpty()) throw GeneralException("00010")
        //환전 리스트 userIds 추출
        var userIds = result.first.map {
            it.applicantId
        }
        val spoonUserEntity = searchUser ?: userProfileRepository.findUserProfileByUserIds(userIds) //spoonCast DB 조회

        //Billing DB && spoonCast main DB aggregation
        val exchangeList = result.first.map {
            spoonUserEntity[it.applicantId]?.let { user ->
                val spoonExchangeUser = ExchangeUser(user)
                PayoneerExchangeLogDownload(
                    it,
                    spoonExchangeUser.profileInfo,
                    spoonExchangeUser.tierInfo
                )
            }
        }
        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            sourceData = ExcelGenerator.generateToByteArray(exchangeList, body.password),
            password = body.password,
            filename = "PayoneerCashOut_"+ZonedDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHmmssSSS"))+".xlsx"
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
