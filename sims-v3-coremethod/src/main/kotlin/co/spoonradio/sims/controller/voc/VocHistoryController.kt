package co.spoonradio.sims.controller.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.excel.RequestExcel
import co.spoonradio.sims.dto.request.voc.*
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.history.Attachment
import co.spoonradio.sims.dto.response.voc.history.Reply
import co.spoonradio.sims.dto.response.voc.history.VocHistory
import co.spoonradio.sims.repository.redis.StoreRepository
import co.spoonradio.sims.service.voc.VocHistoryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */

@Api(tags = ["VOC"])
@RestController
@RequestMapping("/voc/history")
@Validated
class VocHistoryController(
    val historyService: VocHistoryService
) {


    @ApiOperation(value = "상담 리스트")
    @GetMapping
    fun getHistory(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestVoc
    ): SimsResponseEntity<List<VocHistory>, ExtraDataEntity> {
        param.base = baseDto
        return historyService.getVocHistory(param)
    }


    @ApiOperation(value = "상담 등록")
    @PostMapping
    fun registHistory(
        @RequestBody registVocParam: RequestRegistVocHistory
    ): ResponseEntity<CommonResponseMessage> {
        historyService.createVoc(registVocParam)
        return ResponseEntity(CommonResponseMessage(), HttpStatus.OK)
    }


    @ApiOperation(value = "엑셀다운로드")
    @PostMapping("/excel")
    fun vocHistoryExcelDownload(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestVoc,
        @RequestBody requestExcel: RequestExcel
    ): CommonResponseMessage {
        baseDto.page_size = 1000
        param.base = baseDto
        historyService.createVocExcel(param, requestExcel.password)
        return CommonResponseMessage()
    }

    @ApiOperation(value = "상담 1건 조회 (Detail)")
    @GetMapping("/{histId}")
    fun getHistoryDetail(
        @PathVariable(value = "histId") histId: Int
    ): SimsResponseEntity<VocHistory?, ExtraDataEntity> {
        return historyService.getVocHistoryDetail(histId)
    }


    @ApiOperation(value = "상담 삭제")
    @DeleteMapping("/{histId}")
    fun deleteHistory(
        @PathVariable histId: Int
    ): ResponseEntity<CommonResponseMessage> {
        historyService.deleteVoc(histId)
        return ResponseEntity(CommonResponseMessage("Deleted"), HttpStatus.OK)
    }


    @ApiOperation(value = "상담 수정")
    @PutMapping("/{histId}")
    fun modifyHistory(
        @RequestBody putVocParam: RequestRegistVocHistory
    ): ResponseEntity<CommonResponseMessage> {
        historyService.updateVoc(putVocParam)
        return ResponseEntity(CommonResponseMessage("Updated"), HttpStatus.OK)
    }


    @ApiOperation(value = "댓글 수정(등록)")
    @PutMapping("/{histId}/reply")
    fun modifyReply(
        @PathVariable histId: Int,
        @Valid @RequestBody updateReply: RequestReply,
        bindingResult: BindingResult
    ): ResponseEntity<CommonResponseMessage> {
        historyService.updateReply(updateReply)
        return ResponseEntity(CommonResponseMessage(), HttpStatus.OK)
    }


    @ApiOperation(value = "상담 첨부파일 리스트")
    @GetMapping("/{histId}/support-attachments")
    fun getSupportAttachments(
        @PathVariable histId: Int
    ): SimsResponseEntity<List<Attachment>, ExtraDataEntity> {
        return historyService.getAttachments(histId)
    }


    @ApiOperation(value = "답변(스푼서포트) 리스트")
    @GetMapping("/{histId}/support-replies")
    fun getSpoonSupportReplies(
        @PathVariable histId: Int
    ): SimsResponseEntity<List<Reply>, ExtraDataEntity> {
        return historyService.getSpoonSupportReplies(histId)
    }

    @ApiOperation(value = "답변(스푼서포트) 등록")
    @PostMapping("/{histId}/support-replies")
    fun registReplySpoonSupport(
        @PathVariable histId: Int,
        @RequestBody requestReply: RequestReply
    ): ResponseEntity<CommonResponseMessage> {
        historyService.registSpoonSupportReply(requestReply)
        return ResponseEntity(CommonResponseMessage(), HttpStatus.OK)
    }


    @ApiOperation(value = "일괄상태변경")
    @PostMapping("/multiple-update-status")
    fun updateMultipleState(
        @RequestBody multipleParam: RequestMultipleAction
    ): ResponseEntity<CommonResponseMessage> {
        historyService.updateMultipleStatus(multipleParam)
        return ResponseEntity(CommonResponseMessage(), HttpStatus.OK)
    }

    @ApiOperation(value = "일괄상담구분변경")
    @PostMapping("/multiple-update-criticality-type")
    fun updateMultipleUpdateCriticalityType(
        @Valid @RequestBody multipleParam: RequestMultipleAction
    ): ResponseEntity<CommonResponseMessage> {
        historyService.updateMultipleUpdateCriticalityType(multipleParam)
        return ResponseEntity(CommonResponseMessage(), HttpStatus.OK)
    }

    @ApiOperation(value = "일괄담당자변경")
    @PostMapping("/multiple-update-member-user")
    fun updateMultipleUpdateMemberUser(
        @RequestBody multipleParam: RequestMultipleMemberUpdateAction
    ): ResponseEntity<CommonResponseMessage> {
        historyService.updateMultipleUpdateMemberUser(multipleParam)
        return ResponseEntity(CommonResponseMessage(), HttpStatus.OK)
    }
}
