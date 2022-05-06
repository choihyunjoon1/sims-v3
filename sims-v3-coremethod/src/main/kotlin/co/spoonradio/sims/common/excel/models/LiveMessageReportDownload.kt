package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class LiveMessageReportDownload (
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("reporter", "신고자 닉네임") val reporter: String,
    @field:ExcelColumn("report_type", "신고 타입") val reportType: String,
    @field:ExcelColumn("reported", "신고 날짜") val reported: String,
    @field:ExcelColumn("live_author", "라이브 DJ") val liveAuthor: String,
    @field:ExcelColumn("status", "차단 여부") val status: String,
    @field:ExcelColumn("message_author", "라이브 채팅 유저") val messageAuthor: String,
    @field:ExcelColumn("live_created", "라이브 생성일") val liveCreated: String,
    @field:ExcelColumn("live", "라이브 제목") val live: String,
    @field:ExcelColumn("message_contents", "메세지 내용") val messageContents: String
)