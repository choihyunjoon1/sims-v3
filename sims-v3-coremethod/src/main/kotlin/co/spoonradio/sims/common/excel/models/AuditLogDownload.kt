package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class AuditLogDownload (
    @field:ExcelColumn("create_dt", "요청 날짜") val createDt: String,
    @field:ExcelColumn("group_cd", "대상자 그룹명") val groupCd: String,
    @field:ExcelColumn("user_name", "유저명") val userName: String,
    @field:ExcelColumn("access_ip", "IP 주소") val accessIp: String,
    @field:ExcelColumn("api_detail", "조회상세로그") val apiDetail: String,
    @field:ExcelColumn("result_cd", "결과값") val resultCd: String,
    @field:ExcelColumn("req_parameter", "파라미터") val reqParameter: String,
    @field:ExcelColumn("sub_menu_name", "메뉴명") val subMenuName: String,
    @field:ExcelColumn("user_id", "유저번호") val userId: Long,
    @field:ExcelColumn("api_url", "API 명") val apiUrl: String,
    @field:ExcelColumn("download_reason", "다운로드 사유") val downloadReason: String,
)