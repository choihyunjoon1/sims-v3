package co.spoonradio.sims.dto.response.voc.ban

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/07.
 * @Desc
 */
data class Ban(
    var ban_status: String,
    val category_main_id: Int,
    val main_category_name: String,
    val category_sub_id: Int,
    val sub_category_name: String,
    val category_content_id: Int,
    val content_category_name: String,
    val detail: String,
    val device_unique_id: String,
    val end_date: ZonedDateTime,
    val id: Int,
    val memo: String,
    val nickname: String?,
    val remain_time: String,
    val tag: String?,
    val type: Int,
    val user_id: Int,
    val created: ZonedDateTime,
    @JsonIgnore
    val totalCount:Long?=0
) : Serializable
