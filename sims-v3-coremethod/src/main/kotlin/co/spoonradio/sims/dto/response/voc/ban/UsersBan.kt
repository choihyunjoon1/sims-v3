package co.spoonradio.sims.dto.response.voc.ban

import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
data class UsersBan(
    val id: Int,
    val ban_status: String,
    val created: ZonedDateTime,
    val end_date: ZonedDateTime,
    val remain_time: String,
    var handler_user_name: String?
) : Serializable
