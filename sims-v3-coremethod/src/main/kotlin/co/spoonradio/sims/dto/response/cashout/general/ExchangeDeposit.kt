package co.spoonradio.sims.dto.response.cashout.general

import co.spoonradio.sims.dto.response.cashout.RejectReason
import java.io.Serializable
import java.time.ZonedDateTime

data class ExchangeDeposit(
    val id:Long,
    val deposit: Deposit,
    val rejectReason: RejectReason?,
    val submitDocumentCount:Int,
    val applicantId:Int,
    val methodType:String,
    val totalExchangeSpoon:Int,
    val currency:String,
    val totalExchangeAmount:Long,
    val estimatedExchangeAmount:Long,
    val expectedExchangedDate:String,
    val status:String,
    val created:ZonedDateTime,
    val updated:ZonedDateTime,
    val totalCount: Long
) : Serializable
