package co.spoonradio.sims.dto.response.clientapi

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc https://kapentaz.github.io/kotlin/json/Kotlin-and-Jackson-(ObjectMapper)/#
 */
data class BalanceInfo @JsonCreator constructor(
    @JsonProperty("usableTotalCount") val usableTotalCount: Int,
    @JsonProperty("usedTotalCount") val usedTotalCount: Int,
    @JsonProperty("receiveTotalCount") val receiveTotalCount: Int,
    @JsonProperty("chargedTotalCount") val chargedTotalCount: Int,
    @JsonProperty("exchangeableTotalCount") val exchangeableTotalCount: Int,
    @JsonProperty("exchangedTotalCount") val exchangedTotalCount: Int
) : Serializable
