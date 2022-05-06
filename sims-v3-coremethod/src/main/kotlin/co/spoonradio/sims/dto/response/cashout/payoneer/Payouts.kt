package co.spoonradio.sims.dto.response.cashout.payoneer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Payouts @JsonCreator constructor(
    @JsonProperty("audit_id") val auditId: Long,
    @JsonProperty("code") val code: Long,
    @JsonProperty("description") val description: String,
    @JsonProperty("payout_id") val payoutId: String,
    @JsonProperty("amount") val amount: Double,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("status") val status: String,
    @JsonProperty("status_category") val statusCategory: String,
    @JsonProperty("payee_id") val payeeId: String,
    @JsonProperty("payout_date") val payoutDate: String,
    @JsonProperty("load_date") val loadDate: String
)