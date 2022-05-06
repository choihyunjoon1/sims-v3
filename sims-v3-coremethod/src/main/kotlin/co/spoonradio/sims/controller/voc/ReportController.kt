package co.spoonradio.sims.controller.voc

import co.spoonradio.sims.common.annotation.TestAnnotation
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.excel.RequestExcel
import co.spoonradio.sims.dto.request.voc.report.RequestReport
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.report.*
import co.spoonradio.sims.service.voc.ReportService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * @author whale@spoonradio.co
 * @date   2021/11/29.
 * @Desc
 */
@Api(tags = ["VOC"])
@RestController
@RequestMapping("/voc/report")
@Validated
class ReportController(val reportService: ReportService) {

    companion object{
        val EXCEL_MAX_ROW_LIMIT = 1000
    }


    @TestAnnotation
    @ApiOperation(value = "[신고] 라이브")
    @GetMapping(value = ["/live"])
    fun getReportLive(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<LiveReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportLive(param)
    }


    @ApiOperation(value = "[신고] 라이브 엑셀 다운로드")
    @PostMapping(value = ["/live/excel"])
    fun getReportLiveDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportLiveExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }


    @ApiOperation(value = "[TAB] 라이브 채팅 신고", notes = "")
    @GetMapping(value = ["/livemessage"])
    fun getReportMessage(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<MessageReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportLiveMessage(param)
    }

    @ApiOperation(value = "[신고] 라이브 엑셀 다운로드")
    @PostMapping(value = ["/livemessage/excel"])
    fun getReportMessageDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportLiveMessageExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }


    @ApiOperation(value = "[TAB] 캐스트 신고", notes = "")
    @GetMapping(value = ["/cast"])
    fun getReportCast(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<CastReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportCast(param)
    }

    @ApiOperation(value = "[신고] 캐스트 엑셀 다운로드")
    @PostMapping(value = ["/cast/excel"])
    fun getReportCastDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportCastExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }


    @ApiOperation(value = "[TAB] 캐스트 댓글 신고", notes = "")
    @GetMapping(value = ["/castcomment"])
    fun getReportCastComment(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<CastCommentReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportCastComment(param)
    }


    @ApiOperation(value = "[신고] 캐스트 댓글 엑셀 다운로드")
    @PostMapping(value = ["/castcomment/excel"])
    fun getReportCastCommentDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportCastCommentExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }


    @ApiOperation(value = "[TAB] 톡 신고", notes = "")
    @GetMapping(value = ["/talk"])
    fun getReportTalk(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<TalkReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportTalk(param)
    }

    @ApiOperation(value = "[신고] 톡 엑셀 다운로드")
    @PostMapping(value = ["/talk/excel"])
    fun getReportTalkDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportTalkExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }



    @ApiOperation(value = "[TAB] 톡 댓글 신고", notes = "")
    @GetMapping(value = ["/talkcomment"])
    fun getReportTalkComment(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<TalkCommentReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportTalkComment(param)
    }

    @ApiOperation(value = "[신고] 톡 댓글 엑셀 다운로드")
    @PostMapping(value = ["/talkcomment/excel"])
    fun getReportTalkCommentDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportTalkCommentExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }




    @ApiOperation(value = "[TAB] 이용자 신고", notes = "")
    @GetMapping(value = ["/user"])
    fun getReportUser(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<UserReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportUser(param)
    }


    @ApiOperation(value = "[신고] 이용자 엑셀 다운로드")
    @PostMapping(value = ["/user/excel"])
    fun getReportUserDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createReportUserExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }


    @ApiOperation(value = "[TAB] 편지함 신고", notes = "")
    @GetMapping(value = ["/mail-box-message"])
    fun getMailBoxMessage(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport
    ): SimsResponseEntity<List<MailBoxMessageReport>, ExtraDataEntity> {
        param.base = baseDto
        return reportService.getReportMailBoxMessage(param)
    }



    @ApiOperation(value = "[신고] 이용자 엑셀 다운로드")
    @PostMapping(value = ["/mail-box-message/excel"])
    fun getMailBoxMessageDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestReport,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = EXCEL_MAX_ROW_LIMIT
        param.base = baseDto
        reportService.createMailBoxMessageExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }
}