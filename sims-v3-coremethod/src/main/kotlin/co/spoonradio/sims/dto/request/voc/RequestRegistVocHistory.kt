package co.spoonradio.sims.dto.request.voc

import java.time.ZonedDateTime
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * @author whale@spoonradio.co
 * @date   2021/11/22.
 * @Desc
 */
data class RequestRegistVocHistory(
    @field:NotNull
    var voc_hist_id:Int,

    @field:NotNull @field:Size(min = 5, max = 5)
    val bound_type_cd: String,

    @field:NotNull @field:Size(min = 5, max = 5)
    val category_cd: String,

    @field:NotNull @field:Size(min = 5, max = 5)
    val channel_cd: String,

    @field:NotNull @field:Size(min = 5, max = 5)
    val criticality_type_cd: String?,

    @field:NotNull @field:Size(min = 5, max = 5)
    val division_cd: String?,

    @field:NotNull @field:Size(min = 5, max = 5)
    val section_cd: String?,

    @field:NotNull @field:Size(min = 5, max = 5)
    val status_cd: String?,

    @field:NotNull @field:Size(min = 5, max = 5)
    val type_cd: String?,

    @field:NotNull @field:Size(min = 5, max = 5)
    var register_type_cd:String? = "VR001",
    val comment: String? = "",
    val reply:String? = "",
    val non_spoon_member_email: String?,
    val spoon_user_id: Int?,
    val spoon_user_nickname: String? ="",
    var member_user_id: Int?
    /*var create_dt: ZonedDateTime?,//#use
    var update_dt: ZonedDateTime?,
    val is_des:Int? = 0,*/


)
