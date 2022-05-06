package co.spoonradio.sims.dto.response.voc.report

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
data class MailBoxMessageReport(
    @field:ExcelColumn("id", "id") val id: Int,
    @field:ExcelColumn("report_descr", "report_descr") val report_descr: String,
    @field:ExcelColumn("message_author_id", "message_author_id") val message_author_id: Int,
    @field:ExcelColumn("message_author_nickname", "message_author_nickname") val message_author_nickname: String?,
    @field:ExcelColumn("reporter_nickname", "reporter_nickname") val reporter_nickname: String?,
    @field:ExcelColumn("report_type", "report_type") val report_type: Int,
    @field:ExcelColumn("reported", "reported") val reported: ZonedDateTime,
    @field:ExcelColumn("live", "live") val live: String,
    @field:ExcelColumn("mailbox", "mailbox") val mailbox: String,
    @field:ExcelColumn("live_created", "live_created") val live_created: ZonedDateTime,
    @field:ExcelColumn("message_author_status", "message_author_status") val message_author_status: String?,
    @field:ExcelColumn("message_contents", "message_contents") val message_contents: String,
    @field:ExcelColumn("live_author", "live_author") val live_author: String,
    @field:ExcelColumn("reporter_id", "reporter_id") val reporter_id: Int,
    val totalCount: Long
)
