package co.spoonradio.sims.dto.response.voc.report

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
data class CastCommentReport(
    @field:ExcelColumn("id", "id") val id: Int,
    @field:ExcelColumn("reporter", "reporter") val reporter: String,
    @field:ExcelColumn("report_type", "report_type") val report_type: Int,
    @field:ExcelColumn("report_descr", "report_descr") val report_descr: String?,
    @field:ExcelColumn("reported", "reported") val reported: ZonedDateTime,
    @field:ExcelColumn("cast", "cast") val cast:String,
    @field:ExcelColumn("cast_created", "cast_created") val cast_created: ZonedDateTime,
    @field:ExcelColumn("cast_author", "cast_author") val cast_author:String,
    @field:ExcelColumn("comment_contents", "comment_contents") val comment_contents:String,
    @field:ExcelColumn("comment_author", "comment_author") val comment_author:String,
    @field:ExcelColumn("comment_created", "comment_created") val comment_created:ZonedDateTime,
    @field:ExcelColumn("status", "status") val status: Int,
    val totalCount:Long
)
