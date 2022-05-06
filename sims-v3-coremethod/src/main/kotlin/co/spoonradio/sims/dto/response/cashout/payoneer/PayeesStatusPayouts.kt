package co.spoonradio.sims.dto.response.cashout.payoneer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class PayeesStatusPayouts @JsonCreator constructor(
    @JsonProperty("client_reference_id") val clientReferenceId: String,
    @JsonProperty("date") val date: String,
    @JsonProperty("amount") val amount: Double,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("status") val status: String,
    @JsonProperty("status_category") val statusCategory: String
)