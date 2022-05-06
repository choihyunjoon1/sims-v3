package co.spoonradio.sims.dto.request.voc

import javax.validation.constraints.NotNull

/**
 * @author whale@spoonradio.co
 * @date   2021/11/24.
 * @Desc
 */
data class RequestMultipleMemberUpdateAction(
    @field:NotNull
    val member_user_id: Int,
    @field:NotNull
    val voc_hist_ids: List<Int>
)
