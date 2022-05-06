package co.spoonradio.sims.dto.response.voc.ban

import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
data class BanHistory(
    var bans_history_id: Int? = null,
    val bans_id: Long,
    val bans_user_id: Long,
    val handler_user_id: Long? = null ,
    val handler_user_name: String?= null,
    var create_dt: ZonedDateTime?=null
)
