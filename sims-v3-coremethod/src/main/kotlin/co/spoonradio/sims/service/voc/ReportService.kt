package co.spoonradio.sims.service.voc

import co.spoonradio.sims.dto.request.voc.report.RequestReport
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.report.*

/**
 * @author whale@spoonradio.co
 * @date   2021/11/29.
 * @Desc
 */
interface ReportService {
    fun getReportLive(param: RequestReport): SimsResponseEntity<List<LiveReport>, ExtraDataEntity>
    fun getReportLiveMessage(param: RequestReport): SimsResponseEntity<List<MessageReport>, ExtraDataEntity>
    fun getReportCast(param: RequestReport): SimsResponseEntity<List<CastReport>, ExtraDataEntity>
    fun getReportCastComment(param: RequestReport): SimsResponseEntity<List<CastCommentReport>, ExtraDataEntity>
    fun getReportTalk(param: RequestReport): SimsResponseEntity<List<TalkReport>, ExtraDataEntity>
    fun getReportTalkComment(param: RequestReport): SimsResponseEntity<List<TalkCommentReport>, ExtraDataEntity>
    fun getReportUser(param: RequestReport): SimsResponseEntity<List<UserReport>, ExtraDataEntity>
    fun getReportMailBoxMessage(param: RequestReport): SimsResponseEntity<List<MailBoxMessageReport>, ExtraDataEntity>

    fun createReportLiveExcel(param: RequestReport, password:String)
    fun createReportLiveMessageExcel(param: RequestReport, password: String)
    fun createReportCastExcel(param: RequestReport, password: String)
    fun createReportCastCommentExcel(param: RequestReport, password: String)
    fun createReportTalkExcel(param: RequestReport, password: String)
    fun createReportTalkCommentExcel(param: RequestReport, password: String)
    fun createReportUserExcel(param: RequestReport, password: String)
    fun createMailBoxMessageExcel(param: RequestReport, password: String)

}