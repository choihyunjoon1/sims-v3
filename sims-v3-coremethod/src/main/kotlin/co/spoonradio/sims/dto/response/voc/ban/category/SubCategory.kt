package co.spoonradio.sims.dto.response.voc.ban.category

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
data class SubCategory(
    val category_main_id: Int,
    @field:JsonIgnore
    val category_main_name: String?=null,
    val created: ZonedDateTime?=null,
    val id: Int,
    val is_use: Boolean,
    val name: String,
    @JsonIgnore
    val totalCount:Long
): Serializable
