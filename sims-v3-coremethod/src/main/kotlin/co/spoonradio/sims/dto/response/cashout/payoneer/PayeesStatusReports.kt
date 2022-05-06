package co.spoonradio.sims.dto.response.cashout.payoneer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class PayeesStatusReports @JsonCreator constructor(
    @JsonProperty("audit_id") val auditId: Long,
    @JsonProperty("code") val code: Int,
    @JsonProperty("description") val description: String,
    @JsonProperty("payees") val payees: List<Payees>
)
