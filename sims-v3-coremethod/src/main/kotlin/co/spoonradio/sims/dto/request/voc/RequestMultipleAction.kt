package co.spoonradio.sims.dto.request.voc

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * @author whale@spoonradio.co
 * @date   2021/11/24.
 * @Desc
 */
data class RequestMultipleAction(
    @field:NotNull
    @field:NotBlank
    @field:Size(min = 5, max = 5)
    val code: String,
    @field:NotNull
    val voc_hist_ids: List<Int>
)
