package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDeposit
import co.spoonradio.sims.dto.response.cashout.general.GeneralExchange
import co.spoonradio.sims.dto.response.users.NiceInfo
import co.spoonradio.sims.dto.response.users.ProfileInfo
import co.spoonradio.sims.dto.response.users.TierInfo
import java.io.Serializable

data class GeneralExchangeLogDownload(
    @field:ExcelColumn("id", "신청 번호") val id: Long,
    @field:ExcelColumn("status", "환전 상태") val status: String,
    @field:ExcelColumn("expectedExchangedDate", "예정일") val expectedExchangedDate: String,
    @field:ExcelColumn("applicantId", "신청자 번호") val applicantId: Int,
    @field:ExcelColumn("applicant.nickname", "신청자 닉네임") val applicantNickname: String?,
    @field:ExcelColumn("applicant.tag", "신청자 태그") val applicantTag: String?,
    @field:ExcelColumn("applicant.status", "신청자 상태") val applicantStatus: Int?,
    @field:ExcelColumn("tierInfo.tierName", "티어") val tierInfoTierName: String?,
    @field:ExcelColumn("deposit.isMinor", "성인 여부") val depositIsMinor: Boolean,
    @field:ExcelColumn("deposit.isDifferentAccountHolder", "예금주 일치 여부") val depositIsDifferentAccountHolder: Boolean,
    @field:ExcelColumn("niceInfo.name", "나이스 이름") val niceInfoName: String?,
    @field:ExcelColumn("niceInfo.birthDate", "나이스 생일") val niceInfoBirthDate: String?,
    @field:ExcelColumn("deposit.applicantName", "신청자 실명") val depositApplicantName: String,
    @field:ExcelColumn("deposit.residentFirstNumber", "주민 번호1") val depositResidentFirstNumber: String,
    @field:ExcelColumn("deposit.residentLastNumber", "주민 번호2") val depositResidentLastNumber: String,
    @field:ExcelColumn("deposit.accountHolder", "예금주 명") val depositAccountHolder: String,
    @field:ExcelColumn("deposit.accountNumber", "계좌 번호") val depositAccountNumber: String,
    @field:ExcelColumn("deposit.exchangeBank", "은행") val depositExchangeBank: String,
    @field:ExcelColumn("totalExchangeSpoon", "총 환전 스푼") val totalExchangeSpoon: Int,
    @field:ExcelColumn("totalExchangeAmount", "총 환전 금액") val totalExchangeAmount: Long,
    @field:ExcelColumn("estimatedExchangeAmount", "총 환전 될 금액") val estimatedExchangeAmount: Long,
    @field:ExcelColumn("created", "신청일") val created: String,
) : Serializable {
    constructor(generalExchange: ExchangeDeposit, profileInfo: ProfileInfo, niceInfo: NiceInfo?, tierInfo: TierInfo?) : this (
                id = generalExchange.id,
                status = generalExchange.status,
                expectedExchangedDate = generalExchange.expectedExchangedDate,
                applicantId = generalExchange.applicantId,
                applicantNickname = profileInfo.nickname,
                applicantTag = profileInfo.tag,
                applicantStatus = profileInfo.status,
                tierInfoTierName = tierInfo?.tierName,
                depositIsMinor = generalExchange.deposit.isMinor,
                depositIsDifferentAccountHolder = generalExchange.deposit.isDifferentAccountHolder,
                niceInfoName = niceInfo?.name,
                niceInfoBirthDate = niceInfo?.birthDate,
                depositApplicantName = generalExchange.deposit.applicantName,
                depositResidentFirstNumber = generalExchange.deposit.residentFirstNumber,
                depositResidentLastNumber = generalExchange.deposit.residentLastNumber,
                depositAccountHolder = generalExchange.deposit.accountHolder,
                depositAccountNumber = generalExchange.deposit.accountNumber,
                depositExchangeBank = generalExchange.deposit.exchangeBank,
                totalExchangeSpoon = generalExchange.totalExchangeSpoon,
                totalExchangeAmount = generalExchange.totalExchangeAmount,
                estimatedExchangeAmount = generalExchange.estimatedExchangeAmount,
                created = generalExchange.created.toString()
    )
}