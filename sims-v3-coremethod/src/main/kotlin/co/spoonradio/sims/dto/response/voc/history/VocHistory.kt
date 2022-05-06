package co.spoonradio.sims.dto.response.voc.history

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */
data class VocHistory(
    @field:ExcelColumn("voc_hist_id", "히스토리 ID") val voc_hist_id: Int,//#use
    @field:ExcelColumn("status_cd", "status_cd") val status_cd: String?,//#use
    @field:ExcelColumn("spoon_user_id", "spoon_user_id") val spoon_user_id: Int,//#use
    @field:ExcelColumn("register_type_cd", "register_type_cd") val register_type_cd: String?,
    @field:ExcelColumn("bound_type_cd", "bound_type_cd") val bound_type_cd: String?,//#use
    @field:ExcelColumn("criticality_type_cd", "criticality_type_cd") val criticality_type_cd: String?,//#use
    @field:ExcelColumn("channel_cd", "channel_cd") val channel_cd: String?,//#use
    @field:ExcelColumn("type_cd", "type_cd") val type_cd: String?,//#use
    @field:ExcelColumn("category_cd", "category_cd") val category_cd: String?,//#use
    @field:ExcelColumn("division_cd", "division_cd") val division_cd: String?,//#use
    @field:ExcelColumn("section_cd", "section_cd") val section_cd: String?,//#use
    @field:ExcelColumn("comment", "comment") val comment: String?,//#use
    @field:ExcelColumn("reply", "reply") val reply: String?,//#use
    @field:ExcelColumn("create_dt", "create_dt") val create_dt: ZonedDateTime?,//#use
    @field:ExcelColumn("update_dt", "update_dt") val update_dt: ZonedDateTime?,
    @field:ExcelColumn("member_user_id", "member_user_id") val member_user_id: Int?,
    @field:ExcelColumn("reply_user_id", "reply_user_id") val reply_user_id: Int?,
    @field:ExcelColumn("spoon_user_nickname", "spoon_user_nickname") val spoon_user_nickname: String?,
    @field:ExcelColumn("non_spoon_member_email", "non_spoon_member_email") val non_spoon_member_email: String?,//#use
    @field:ExcelColumn("reply_dt", "reply_dt") val reply_dt: ZonedDateTime?,//#use
    @field:ExcelColumn("des_dt", "des_dt") val des_dt: ZonedDateTime?,
    @field:ExcelColumn("is_des", "is_des") val is_des: Boolean,
    @field:ExcelColumn("upload_dt", "upload_dt") val upload_dt: ZonedDateTime?,
    @field:ExcelColumn("os", "os") val os: String?,//#use
    @field:ExcelColumn("carrier", "carrier") val carrier: String?,
    @field:ExcelColumn("app_version", "app_version") val app_version: String?,
    @field:ExcelColumn("device_model", "device_model") val device_model: String?,
    @field:ExcelColumn("username", "username") var username: String?,//#use
    @field:ExcelColumn("attachments_count", "attachments_count") val attachments_count: Int = 0
) : Serializable
