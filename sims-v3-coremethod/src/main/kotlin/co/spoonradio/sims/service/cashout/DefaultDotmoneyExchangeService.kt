package co.spoonradio.sims.service.cashout

import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.common.excel.ExcelGenerator
import co.spoonradio.sims.common.excel.models.DotmoneyExchangeLogDownload
import co.spoonradio.sims.component.download.MailManager
import co.spoonradio.sims.dto.request.cashout.RequestDownloadExcelExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchangeHistories
import co.spoonradio.sims.dto.response.cashout.Amount
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.ExchangeUser
import co.spoonradio.sims.dto.response.cashout.dotmoney.DotmoneyExchange
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.users.UserProfileEntity
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.cashout.BillingExchangeRepository
import co.spoonradio.sims.repository.users.PostgresUserProfileRepository
import org.springframework.stereotype.Service
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Service
class DefaultDotmoneyExchangeService(val userProfileRepository: PostgresUserProfileRepository,
                                     val billingExchangeRepository: BillingExchangeRepository,
                                     val mailManager: MailManager,
) : DotmoneyExchangeService {
    override fun getDotmoneyExchangeList(param: RequestExchange): SimsResponseEntity<List<DotmoneyExchange>, ExtraDataEntity> {
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
            DotmoneyExchange(it).apply {
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

    override fun getDotmoneyExchangeAmountList(param: RequestExchangeHistories): SimsResponseEntity<List<Amount>, ExtraDataEntity> {
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

    override fun getDotmoneyExchangeHistories(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity> {
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
                DotmoneyExchangeLogDownload(
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
            filename = "DotmoneyCashOut_"+ ZonedDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHmmssSSS"))+".xlsx"
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
