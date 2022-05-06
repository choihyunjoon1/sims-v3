package co.spoonradio.sims.dto.request.voc.ban

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/12/07.
 * @Desc
 */
data class RequestBan(
    var base: RequestBaseDto? = null,
    var category_main_id: Int? = null,
    var ban_status: String? = null,
    var type: Int? = null
) : Serializable
