package co.spoonradio.sims.dto.response.cashout.general

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class ExchangeApplyManually(
    @JsonProperty("created")
    val created: String,
    @JsonProperty("id")
    val id: Int
) : Serializable