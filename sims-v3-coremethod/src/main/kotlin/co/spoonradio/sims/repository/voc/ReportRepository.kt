package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.dto.request.voc.report.RequestReport
import co.spoonradio.sims.dto.response.voc.report.*

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
interface ReportRepository {
    fun getReportLive(param: RequestReport): Pair<List<LiveReport>, Long>
    fun getReportMessage(param: RequestReport): Pair<List<MessageReport>, Long>
    fun getReportCast(param: RequestReport):  Pair<List<CastReport>, Long>
    fun getReportCastComment(param: RequestReport): Pair<List<CastCommentReport>, Long>
    fun getReportTalk(param: RequestReport): Pair<List<TalkReport>, Long>
    fun getReportTalkComment(param: RequestReport):  Pair<List<TalkCommentReport>, Long>
    fun getReportUser(param:RequestReport): Pair<List<UserReport>, Long>
    fun getReportMailBoxMessage(param:RequestReport): Pair<List<MailBoxMessageReport> , Long>
}