package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

// 이용자 내역 다운로드
data class SpoonUserStatusDownload(
    @field:ExcelColumn("id", "유저 번호") val id: Long,
    @field:ExcelColumn("nickname", "닉네임") val nickname: String,
    @field:ExcelColumn("tag", "유저 아이디") val tag: String,
    @field:ExcelColumn("profile_url", "프로필 url") val profileUrl: String,
    @field:ExcelColumn("fan_notice", "팬 공지") val fanNotice: String,
    @field:ExcelColumn("status", "상태") val status: String,
    @field:ExcelColumn("fan_count", "팔로워 수") val fanCount: Int,
    @field:ExcelColumn("my_count", "팔로잉") val myCount: Int
)