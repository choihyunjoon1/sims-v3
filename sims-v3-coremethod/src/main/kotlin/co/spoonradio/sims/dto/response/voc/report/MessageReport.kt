package co.spoonradio.sims.dto.response.voc.report

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
data class MessageReport(
    @field:ExcelColumn("id", "id") val id: Int,
    @field:ExcelColumn("reporter", "reporter") val reporter: String,
    @field:ExcelColumn("report_type", "report_type") val report_type: Int,
    @field:ExcelColumn("report_descr", "report_descr") val report_descr: String,
    @field:ExcelColumn("reported", "reported") val reported: ZonedDateTime,
    @field:ExcelColumn("live", "live") val live: String,
    @field:ExcelColumn("live_created", "live_created") val live_created: ZonedDateTime,
    @field:ExcelColumn("live_author", "live_author") val live_author: String,
    @field:ExcelColumn("message_contents", "message_contents") val message_contents: String,
    @field:ExcelColumn("message_author", "message_author") val message_author: String,
    @field:ExcelColumn("status", "status") val status: Int,
    val totalCount: Long
)
