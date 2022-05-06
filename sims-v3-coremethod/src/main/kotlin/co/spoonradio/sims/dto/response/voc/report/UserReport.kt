package co.spoonradio.sims.dto.response.voc.report

import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
data class UserReport(
    @field:ExcelColumn("id", "id") val id: Int,
    @field:ExcelColumn("reporter", "reporter") val reporter: String,
    @field:ExcelColumn("report_type", "report_type") val report_type: Int,
    @field:ExcelColumn("report_descr", "report_descr") val report_descr: String?,
    @field:ExcelColumn("reported", "reported") val reported: ZonedDateTime,
    @field:ExcelColumn("abuser", "abuser") val abuser:String,
    @field:ExcelColumn("abuser_sns_id", "abuser_sns_id") val abuser_sns_id:String,
    @field:ExcelColumn("abuser_tag", "abuser_tag") val abuser_tag:String,
    @field:ExcelColumn("abuser_sns_type", "abuser_sns_type") val abuser_sns_type:String,
    @field:ExcelColumn("status", "status") val status: Int,
    val totalCount:Long
)
