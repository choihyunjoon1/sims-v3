package co.spoonradio.sims.dto.request.voc.ban

import java.time.ZonedDateTime
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
data class RequestRegistBan(
    @field:NotNull @field:Min(1)
    val category_content_id: Int,
    @field:NotNull @field:Min(1)
    val category_main_id: Int,
    @field:NotNull @field:Min(1)
    val category_sub_id: Int,
    @field:NotNull @field:NotBlank
    val detail: String,
    val memo: String,
    @field:NotNull
    val type: String,
    @field:NotNull
    var user_id: Int = -1,
    var device_unique_id: String? = null,
    var end_date: ZonedDateTime? = null,
    var created: ZonedDateTime? = null

)
