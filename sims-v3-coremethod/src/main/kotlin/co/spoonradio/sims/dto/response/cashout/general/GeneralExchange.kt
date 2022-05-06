package co.spoonradio.sims.dto.response.cashout.general

import co.spoonradio.sims.dto.response.cashout.RejectReason
import co.spoonradio.sims.dto.response.users.NiceInfo
import co.spoonradio.sims.dto.response.users.ProfileInfo
import co.spoonradio.sims.dto.response.users.TierInfo
import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.ZonedDateTime

data class GeneralExchange(
    val id: Long,
    var applicant: ProfileInfo? = null,
    var niceInfo: NiceInfo? = null,
    var tierInfo: TierInfo? = null,
    val deposit: Deposit,
    val rejectReason: RejectReason?,
    val submitDocumentCount: Int,
    val applicantId: Int,
    val methodType: String,
    val totalExchangeSpoon: Int,
    val currency: String,
    val totalExchangeAmount: Long,
    val estimatedExchangeAmount: Long,
    val expectedExchangedDate: String,
    val status: String,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
    val totalCount: Long
) : Serializable {
    constructor(exchangeDeposit: ExchangeDeposit) : this(
        id = exchangeDeposit.id,
        deposit = exchangeDeposit.deposit,
        rejectReason = exchangeDeposit.rejectReason,
        submitDocumentCount = exchangeDeposit.submitDocumentCount,
        applicantId = exchangeDeposit.applicantId,
        methodType = exchangeDeposit.methodType,
        totalExchangeSpoon = exchangeDeposit.totalExchangeSpoon,
        currency = exchangeDeposit.currency,
        totalExchangeAmount = exchangeDeposit.totalExchangeAmount,
        estimatedExchangeAmount = exchangeDeposit.estimatedExchangeAmount,
        expectedExchangedDate = exchangeDeposit.expectedExchangedDate,
        status = exchangeDeposit.status,
        created = exchangeDeposit.created,
        updated = exchangeDeposit.updated,
        totalCount = exchangeDeposit.totalCount
    )
}

