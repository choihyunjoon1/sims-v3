package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.time.LocalDateTime

data class AuthGrantLogDownload(
    @field:ExcelColumn("grantee_user_id", "유저번호") val granteeUserId: Long,
    @field:ExcelColumn("grantee_user_name", "유저명") val granteeUserName: String,
    @field:ExcelColumn("grantee_user_grp_cd", "대상자 그룹명") val granteeUserGrpCd: String,
    @field:ExcelColumn("access_ip", "IP 주소") val accessIp: String,
    @field:ExcelColumn("grant_status", "신청 상태") val grantStatus: String,
    @field:ExcelColumn("grant_type", "부여 종류") val grantType: String,
    @field:ExcelColumn("main_menu_name", "대메뉴") val mainMenuName: String,
    @field:ExcelColumn("sub_menu_name", "서브메뉴") val subMenuName: String,
    @field:ExcelColumn("grant_to_apply", "신청 권한") val grantToApply: String,
    @field:ExcelColumn("grant_before", "신청 전 권한") val grantBefore: String,
    @field:ExcelColumn("grant_after", "신청 후 권한") val grantAfter: String,
    @field:ExcelColumn("create_dt", "신청일") val createDt: LocalDateTime,
    @field:ExcelColumn("grant_user_id", "승인자 번호") val grantUserId: Long,
    @field:ExcelColumn("grant_user_name", "승인자명") val grantUserName: String,
    @field:ExcelColumn("grant_user_grp_cd", "승인자 그룹명") val grantUserGrpCd: String
)