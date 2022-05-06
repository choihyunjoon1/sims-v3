package co.spoonradio.sims.dto.request.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import java.io.Serializable
import javax.validation.constraints.Min

/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */
data class RequestVoc(
    var base: RequestBaseDto? = null,
    @field:Min(5) var register_type_cd: String? = "VR001",
    @field:Min(5) var status_cd: String? = null,
    @field:Min(5) var bound_type_cd: String? = null,
    @field:Min(5) var criticality_type_cd:String? = null,
    @field:Min(5) var channel_cd: String? = null,
    @field:Min(5) var category_cd:String? = null,
    @field:Min(5) var division_cd: String? = null,
    var tier_id: Int? = null
) : Serializable
