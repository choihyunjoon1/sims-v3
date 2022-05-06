package co.spoonradio.sims.dto.response.cashout

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class Amount (
    val id: Long,
    val exchange:Long,
    val balanceLockId:String,
    val currency:String,
    val amount:Int,
    val status:String,
    val created:ZonedDateTime,
    val updated:ZonedDateTime
)