package co.spoonradio.sims.service.voc

import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.common.excel.ExcelGenerator
import co.spoonradio.sims.component.download.MailManager
import co.spoonradio.sims.dto.request.voc.report.RequestReport
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.report.*
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.voc.PostgresReportRepository
import org.springframework.stereotype.Service

/**
 * @author whale@spoonradio.co
 * @date   2021/11/29.
 * @Desc
 */
@Service
class DefaultReportService(
    val postgresReportRepository: PostgresReportRepository,
    val mailManager: MailManager
) : ReportService {
    override fun getReportLive(param: RequestReport): SimsResponseEntity<List<LiveReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportLive(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }


    override fun getReportLiveMessage(param: RequestReport): SimsResponseEntity<List<MessageReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportMessage(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }

    override fun getReportCast(param: RequestReport): SimsResponseEntity<List<CastReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportCast(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }

    override fun getReportCastComment(param: RequestReport): SimsResponseEntity<List<CastCommentReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportCastComment(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }

    override fun getReportTalk(param: RequestReport): SimsResponseEntity<List<TalkReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportTalk(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }

    override fun getReportTalkComment(param: RequestReport): SimsResponseEntity<List<TalkCommentReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportTalkComment(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }

    override fun getReportUser(param: RequestReport): SimsResponseEntity<List<UserReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportUser(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }

    override fun getReportMailBoxMessage(param: RequestReport): SimsResponseEntity<List<MailBoxMessageReport>, ExtraDataEntity> {
        val retList = postgresReportRepository.getReportMailBoxMessage(param)

        return SimsResponseEntity(
            retList.first,
            CommonUtils.getResponseExtraData(retList.second, param.base!!)
        )
    }


    /********************************/
    /** 테스트 미작성 */
    /********************************/
    override fun createReportLiveExcel(param: RequestReport, password: String) {
        val list = this.getReportLive(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<LiveReport>(list, password),
            password,
            "liveReportList.xlsx"
        )
    }

    override fun createReportLiveMessageExcel(param: RequestReport, password: String) {
        val list = this.getReportLiveMessage(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<MessageReport>(list, password),
            password,
            "liveMessageReportList.xlsx"
        )
    }

    override fun createReportCastExcel(param: RequestReport, password: String) {
        val list = this.getReportCast(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<CastReport>(list, password),
            password,
            "CastReportList.xlsx"
        )
    }

    override fun createReportCastCommentExcel(param: RequestReport, password: String) {
        val list = this.getReportCastComment(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<CastCommentReport>(list, password),
            password,
            "CastCommentReportList.xlsx"
        )
    }

    override fun createReportTalkExcel(param: RequestReport, password: String) {
        val list = this.getReportTalk(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<TalkReport>(list, password),
            password,
            "TalkReportList.xlsx"
        )
    }

    override fun createReportTalkCommentExcel(param: RequestReport, password: String) {
        val list = this.getReportTalkComment(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<TalkCommentReport>(list, password),
            password,
            "TalkCommentReportList.xlsx"
        )
    }

    override fun createReportUserExcel(param: RequestReport, password: String) {
        val list = this.getReportUser(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<UserReport>(list, password),
            password,
            "UserReportList.xlsx"
        )
    }

    override fun createMailBoxMessageExcel(param: RequestReport, password: String) {
        val list = this.getReportMailBoxMessage(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        mailManager.sendDownloadMail(
            ExcelGenerator.generateToByteArray<MailBoxMessageReport>(list, password),
            password,
            "MailBoxMessageReportList.xlsx"
        )
    }
}