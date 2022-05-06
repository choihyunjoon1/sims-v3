package co.spoonradio.sims.dto.common

import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/13.
 * @Desc
 */
data class AuditLog(
    val access_ip: String,
    val access_agent: String,
    val api_url: String,
    val api_method: String,
    val api_detail: String,
    val req_parameter: String,
    val sub_menu_id: Int? = null,
    val sub_menu_name: String,
    val user_id: Int? = 0,
    val user_name: String,
    val result_cd: String,
    val create_dt: ZonedDateTime,
    val download_reason: String,
    val en_api_detail: String,
    val en_sub_menu_name: String
)
