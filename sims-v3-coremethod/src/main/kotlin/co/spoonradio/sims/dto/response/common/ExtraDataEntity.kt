package co.spoonradio.sims.dto.response.common

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable


data class ExtraDataEntity(
    @JsonProperty("totalPageCount")
    val total_page_count: Long=0,
    @JsonProperty("totalRowCount")
    val total_row_count: Long=0,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("totalExchangedAmount")
    val total_Exchanged_Amount: Long?=null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("totalExpectedAmount")
    val total_Expected_Amount: Long?=null
): Serializable