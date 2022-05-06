package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import co.spoonradio.sims.dto.response.cashout.Exchange
import co.spoonradio.sims.dto.response.users.ProfileInfo
import co.spoonradio.sims.dto.response.users.TierInfo
import java.io.Serializable

data class PayoneerExchangeLogDownload(
    @field:ExcelColumn("id", "신청 번호") val id: Long,
    @field:ExcelColumn("status", "환전 상태") val status: String,
    @field:ExcelColumn("expectedExchangedDate", "예정일") val expectedExchangedDate: String,
    @field:ExcelColumn("applicantId", "신청자 번호") val applicantId: Int,
    @field:ExcelColumn("applicant.nickname", "신청자 닉네임") val applicantNickname: String,
    @field:ExcelColumn("applicant.tag", "신청자 태그") val applicantTag: String?,
    @field:ExcelColumn("applicant.status", "신청자 상태") val applicantStatus: Int?,
    @field:ExcelColumn("tierInfo.tierName", "티어") val tierInfoTierName: String?,
    @field:ExcelColumn("totalExchangeSpoon", "총 환전 스푼") val totalExchangeSpoon: Int,
    @field:ExcelColumn("totalExchangeAmount", "총 환전 금액") val totalExchangeAmount: Long,
    @field:ExcelColumn("estimatedExchangeAmount", "총 환전 될 금액") val estimatedExchangeAmount: Long,
    @field:ExcelColumn("created", "신청일") val created: String
) : Serializable {
    constructor(payoneerExchange: Exchange, profileInfo: ProfileInfo, tierInfo: TierInfo?) : this (
        id = payoneerExchange.id,
        status = payoneerExchange.status,
        expectedExchangedDate = payoneerExchange.expectedExchangedDate,
        applicantId = payoneerExchange.applicantId,
        applicantNickname = profileInfo.nickname,
        applicantTag = profileInfo.tag,
        applicantStatus = profileInfo.status,
        tierInfoTierName = tierInfo?.tierName,
        totalExchangeSpoon = payoneerExchange.totalExchangeSpoon,
        totalExchangeAmount = payoneerExchange.totalExchangeAmount,
        estimatedExchangeAmount = payoneerExchange.estimatedExchangeAmount,
        created = payoneerExchange.created.toString(),
    )


}