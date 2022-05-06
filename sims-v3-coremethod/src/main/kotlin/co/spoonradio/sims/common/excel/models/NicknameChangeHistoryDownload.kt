package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class NicknameChangeHistoryDownload(
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("user_id", "유저 번호") val user_id: Long,
    @field:ExcelColumn("tag", "유저 태그") val tag: String,
    @field:ExcelColumn("nickname", "현재 닉네임") val nickname: String,
    @field:ExcelColumn("old_nickname", "변경 전") val old_nickname: String,
    @field:ExcelColumn("new_nickname", "변경 후") val new_nickname: String,
    @field:ExcelColumn("created", "변경 일자") val created: String
)

