package co.spoonradio.sims.dto.response.cashout.general

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.ZonedDateTime

data class ExchangeDocument(
    val id: Long,
    val exchange: Long,
    val type: String,
    val url:String,
    val created: ZonedDateTime
) :Serializable {
    var document: SubmitDocument? = null
}
