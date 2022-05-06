package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class JasracDownload(
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("user.id", "유저 번호") val userId: Long,
    @field:ExcelColumn("user.tag", "유저 태그") val userTag: String,
    @field:ExcelColumn("user.nickname", "유저 닉네임") val userNickname: String,
    @field:ExcelColumn("composer", "작곡가") val composer: String,
    @field:ExcelColumn("singer", "가수") val singer: String,
    @field:ExcelColumn("title", "타이틀") val title: String,
    @field:ExcelColumn("code", "코드") val code: String,
    @field:ExcelColumn("created", "생성일") val created: String)