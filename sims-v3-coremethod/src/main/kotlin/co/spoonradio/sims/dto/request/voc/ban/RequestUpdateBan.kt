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
data class RequestUpdateBan(
    val ban_status: String,
    @field:NotNull
    val category_content_id: Int,
    @field:NotNull
    val category_main_id: Int,
    @field:NotNull
    val category_sub_id: Int,
    @field:NotNull @field:NotBlank
    val detail: String? = null,
    @field:NotNull
    val type: String,
    @field:NotNull @field:Min(1)
    val user_id: Int,
    var device_unique_id: String? = null,
    val id: Int? = null,
    val memo: String = "",
    val nickname: String,
    val remain_time: String,
    val tag: String,
    var created_utc: ZonedDateTime,
    var end_date_utc: ZonedDateTime? = null,
)
