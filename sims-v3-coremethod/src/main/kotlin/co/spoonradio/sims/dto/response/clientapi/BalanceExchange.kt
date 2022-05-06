package co.spoonradio.sims.dto.response.clientapi

import org.codehaus.jackson.annotate.JsonCreator
import org.codehaus.jackson.annotate.JsonProperty

data class BalanceExchange @JsonCreator constructor(
    @JsonProperty("lockId") val lockId: String,
    @JsonProperty("itemCount") val itemCount: Long,
    @JsonProperty("userId") val userId: Int,
    @JsonProperty("exchangeStatus") val exchangeStatus: String,
    @JsonProperty("subscribe") val subscribe: Map<String, Long> = HashMap(),
    @JsonProperty("item") val item: Map<String, Long> = HashMap()
)