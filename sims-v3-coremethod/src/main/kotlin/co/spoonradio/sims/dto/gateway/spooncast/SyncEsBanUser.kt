package co.spoonradio.sims.dto.gateway.spooncast

import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/12/09.
 * @Desc
 */
data class SyncEsBanUser(
    val service: String,
    val target_type: String,
    val event_type: String,
    val target_ids: List<Int>
) : Serializable
