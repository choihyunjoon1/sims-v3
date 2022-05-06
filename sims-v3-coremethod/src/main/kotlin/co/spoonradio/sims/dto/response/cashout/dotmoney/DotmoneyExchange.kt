package co.spoonradio.sims.dto.response.cashout.dotmoney

import co.spoonradio.sims.dto.response.cashout.Exchange
import co.spoonradio.sims.dto.response.cashout.RejectReason
import co.spoonradio.sims.dto.response.users.ProfileInfo
import co.spoonradio.sims.dto.response.users.TierInfo
import java.io.Serializable
import java.time.ZonedDateTime

data class DotmoneyExchange(
    val id: Long,
    var applicant: ProfileInfo? = null,
    //var niceInfo: NiceInfo? = null, //없어도 UI 안꺠지는지 확인
    var tierInfo: TierInfo? = null,
    val rejectReason: RejectReason?,
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
    constructor(exchange: Exchange) : this(
        id = exchange.id,
        rejectReason = exchange.rejectReason,
        applicantId = exchange.applicantId,
        methodType = exchange.methodType,
        totalExchangeSpoon = exchange.totalExchangeSpoon,
        currency = exchange.currency,
        totalExchangeAmount = exchange.totalExchangeAmount,
        estimatedExchangeAmount = exchange.estimatedExchangeAmount,
        expectedExchangedDate = exchange.expectedExchangedDate,
        status = exchange.status,
        created = exchange.created,
        updated = exchange.updated,
        totalCount = exchange.totalCount
    )
}
