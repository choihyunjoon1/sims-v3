package co.spoonradio.sims.dto.request.voc.ban

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/06.
 * @Desc
 */
data class RequestRegistBanMainCategory(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val created: ZonedDateTime?= null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val id: Int? = null,
    val is_use: Boolean,
    val name: String
)
