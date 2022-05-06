package co.spoonradio.sims.dto.response.cashout

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class ExchangeHistory(
    val id: Long,
    val exchange: Long,
    val status: String,
    var created: ZonedDateTime
)