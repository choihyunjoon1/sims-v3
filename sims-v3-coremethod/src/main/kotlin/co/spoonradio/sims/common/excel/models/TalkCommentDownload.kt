package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class TalkCommentDownload(
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("reporter", "신고자 닉네임") val reporter: String,
    @field:ExcelColumn("report_type", "신고 타입") val reportType: String,
    @field:ExcelColumn("reported", "신고 날짜") val reported: String,
    @field:ExcelColumn("talk_author", "톡 DJ") val talkAuthor: String,
    @field:ExcelColumn("status", "차단 여부") val status: String,
    @field:ExcelColumn("comment_author", "댓글 작성자") val commentAuthor: String,
)