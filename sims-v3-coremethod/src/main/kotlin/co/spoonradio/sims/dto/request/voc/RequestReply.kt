package co.spoonradio.sims.dto.request.voc

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * @author whale@spoonradio.co
 * @date   2021/11/22.
 * @Desc
 */
data class RequestReply(
    @field:NotNull
    @field:Min(1)
    val vocHistId:Int,

    @field:NotBlank
    val reply:String?,

    var member_user_id:Int?
)
