package co.spoonradio.sims.dto.response.voc.history

import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/23.
 * @Desc
 */
data class Reply(
    val reply_id: Int,
    val voc_hist_id: Int,
    val reply: String,
    val create_dt: ZonedDateTime?,
    val update_dt: ZonedDateTime?,
    val member_user_id: Int
)
