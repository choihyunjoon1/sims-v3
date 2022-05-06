package co.spoonradio.sims.dto.response.cashout.payoneer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Payees @JsonCreator constructor(
    @JsonProperty("payee_id") val payeeId: String,
    @JsonProperty("status") val status: String,
    @JsonProperty("registration_date") val registrationDate: String,
    @JsonProperty("payout_method") val payoutMethod: String,
    @JsonProperty("total_amount") val totalAmount: Double,
    @JsonProperty("payouts") val payouts: List<PayeesStatusPayouts>
)