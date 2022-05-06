package co.spoonradio.sims.dto.response.voc.ban.category

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
data class ContentCategory(
    val id: Int,
    val name: String,
    val created: ZonedDateTime?=null,
    val is_use: Boolean,
    @JsonIgnore
    val totalCount:Long
): Serializable