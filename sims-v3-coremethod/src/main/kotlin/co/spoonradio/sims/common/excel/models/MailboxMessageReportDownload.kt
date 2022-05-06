package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class MailboxMessageReportDownload(
    @field:ExcelColumn("id", "번호") val Id: Long,
    @field:ExcelColumn("reporter_id", "신고자 번호") val reporterId: Long,
    @field:ExcelColumn("reporter_nickname", "신고자 닉네임") val reporterNickname: String,
    @field:ExcelColumn("report_type", "신고 타입") val reportType: String,
    @field:ExcelColumn("reported", "신고 날짜") val reported: String,
    @field:ExcelColumn("mailbox", "메일 박스") val mailbox: String,
    @field:ExcelColumn("live", "라이브") val live: String,
    @field:ExcelColumn("live_author", "라이브 생성자") val liveAuthor: String,
    @field:ExcelColumn("live_created", "라이브 생성일") val liveCreated: String,
    @field:ExcelColumn("message_author_id", "메세지 작성자 번호") val messageAuthorId: String,
    @field:ExcelColumn("message_author_nickname", "메세지 작성자 닉네임") val messageAuthorNickname: String,
    @field:ExcelColumn("message_author_status", "메세지 작성자 차단 여부") val messageAuthorStatus: String,
)