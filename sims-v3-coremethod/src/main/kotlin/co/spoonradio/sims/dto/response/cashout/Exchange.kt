package co.spoonradio.sims.dto.response.cashout

import java.io.Serializable
import java.time.ZonedDateTime

data class Exchange(
    val id: Long,
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
    val totalCount: Long = 0
) : Serializable
