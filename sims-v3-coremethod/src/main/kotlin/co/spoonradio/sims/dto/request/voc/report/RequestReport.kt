package co.spoonradio.sims.dto.request.voc.report

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/11/29.
 * @Desc
 */
data class RequestReport(
    var base: RequestBaseDto? = null,
    var report_type: Int? = null,
    var is_ban: Boolean? = null
) : Serializable
