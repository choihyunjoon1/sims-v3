package co.spoonradio.sims.dto.response.voc.report

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
data class TalkCommentReport(
    @field:ExcelColumn("id", "id") val id: Int,
    @field:ExcelColumn("reporter", "reporter") val reporter: String,
    @field:ExcelColumn("report_type", "report_type") val report_type: Int,
    @field:ExcelColumn("report_descr", "report_descr") val report_descr: String?,
    @field:ExcelColumn("reported", "reported") val reported: ZonedDateTime,
    @field:ExcelColumn("talk", "talk") val talk:String,
    @field:ExcelColumn("talk_created", "talk_created") val talk_created:ZonedDateTime,
    @field:ExcelColumn("talk_author", "talk_author") val talk_author:String,
    @field:ExcelColumn("comment_url", "comment_url") val comment_url:String?,
    @field:ExcelColumn("comment_created", "comment_created") val comment_created:ZonedDateTime,
    @field:ExcelColumn("comment_author", "comment_author") val comment_author:String,
    @field:ExcelColumn("status", "status") val status: Int,
    val totalCount:Long
)
