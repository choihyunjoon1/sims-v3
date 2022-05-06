package co.spoonradio.sims.exception

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorMessage(
    var timestamp: Long = System.currentTimeMillis(),
    var status: String,
    var code: String,
    var message: String,
    @JsonIgnore var errorData: String,
    @JsonIgnore var trace: String
)
