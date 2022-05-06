package co.spoonradio.sims.controller.voc

import co.spoonradio.sims.common.annotation.TestAnnotation
import co.spoonradio.sims.common.excel.ExcelParser
import co.spoonradio.sims.common.extension.toFile
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.ban.*
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.ban.Ban
import co.spoonradio.sims.dto.response.voc.ban.UsersBanEntity
import co.spoonradio.sims.dto.response.voc.ban.category.ContentCategory
import co.spoonradio.sims.dto.response.voc.ban.category.MainCategory
import co.spoonradio.sims.dto.response.voc.ban.category.SubCategory
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.service.voc.BanService
import co.spoonradio.sims.type.event.EventType
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
@Api(tags = ["VOC"])
@RestController
@RequestMapping("/voc/bans")
class BanController(val defaultBanService: BanService) {

    @ApiOperation(value = "[제재관리] 제재 리스트 ")
    @GetMapping
    fun bansList(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestBan
    ): SimsResponseEntity<List<Ban>, ExtraDataEntity> {
        param.base = baseDto
        return defaultBanService.getBans(param = param)
    }


    @ApiOperation(value = "[제재관리] 제재 등록") //TODO - 테스트 미작성
    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun bundleRegistBan(
        @ModelAttribute requestRegistBan: RequestRegistBan,
        @RequestPart xlsx_file: MultipartFile?
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        val list = ExcelParser.parseExcel<RequestBundleRegistUserIdBan>(xlsx_file?.toFile()?: throw GeneralException("00001"))
        list.forEach { item ->
            requestRegistBan.user_id =  item.user_id
            defaultBanService.registBan(requestRegistBan)
            defaultBanService.executeBanEvent(requestRegistBan.user_id, EventType.CREATED)
        }
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }


    @ApiOperation(value = "[제재관리] 제재 등록")
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun registBan(
        @RequestBody requestRegistBan: RequestRegistBan
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.registBan(requestRegistBan)
        return defaultBanService.executeBanEvent(requestRegistBan.user_id, EventType.CREATED)
    }

    @ApiOperation(value = "[제재관리] 제재 해제")
    @PutMapping(value = ["/recovery"])
    fun recoverryBan(
        @RequestBody requestRecoveryBan: RequestRecoveryBan
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.recovertyBan(requestRecoveryBan)
        return defaultBanService.executeBanEvent(requestRecoveryBan.user_id, EventType.DELETED)
    }


    @ApiOperation(value = "[제재관리] 제재 수정")
    @PutMapping
    fun updateBan(
        @RequestBody requestUpdateBan: RequestUpdateBan
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        return defaultBanService.updateBan(requestUpdateBan)
    }


    /** todo 라이브/캐스트 등을 합쳐놓았으며, 권한처리할때 주의한다 */
    @TestAnnotation
    @ApiOperation(value = "[신고/제재관리] 신고 이력")
    @GetMapping(value = ["/history/{reportUserId}"])
    fun getBansHistory(
        @PathVariable reportUserId: Long
    ): SimsResponseEntity<UsersBanEntity, ExtraDataEntity> {
        return defaultBanService.getBansHistory(reportUserId)
    }

    /** MAIN ******************************************************************/

    @ApiOperation(value = "[제재관리] 카테고리 메인 조회")
    @GetMapping(value = ["/category-main"])
    fun getBanMainCategory(
        @ModelAttribute baseDto: RequestBaseDto
    ): SimsResponseEntity<List<MainCategory>, ExtraDataEntity> {
        return defaultBanService.getBanMainCategory(baseDto)
    }


    @ApiOperation(value = "[제재관리] 카테고리 등록")
    @PostMapping(value = ["/category-main"])
    fun registBanMainCategory(
        @RequestBody registBanMainCategory: RequestRegistBanMainCategory
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.registBanMainCategory(registBanMainCategory)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }


    @ApiOperation(value = "[제재관리] 카테고리 상세조회")
    @GetMapping(value = ["/category-main/{categoryId}"])
    fun getBanCategoryDetail(
        @PathVariable categoryId: Int
    ): SimsResponseEntity<MainCategory?, ExtraDataEntity> {
        return defaultBanService.getBanMainCategoryDetail(categoryId)
    }


    @ApiOperation(value = "[제재관리] 카테고리 수정")
    @PutMapping(value = ["/category-main/{categoryId}"])
    fun updateBanMainCategory(
        @RequestBody requestRegistBanMainCategory: RequestRegistBanMainCategory,
        @PathVariable categoryId: Int
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.updateBanMainCategory(requestRegistBanMainCategory)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }


    /** SUB ******************************************************************/

    @ApiOperation(value = "[제재관리] 카테고리 서브")
    @GetMapping(value = ["/category-sub"])
    fun getBanSubCategory(
        @ModelAttribute baseDto: RequestBaseDto
    ): SimsResponseEntity<List<SubCategory>, ExtraDataEntity> {
        return defaultBanService.getBanSubCategory(baseDto)
    }


    @ApiOperation(value = "[제재관리] Sub 카테고리 등록")
    @PostMapping(value = ["/category-sub"])
    fun registBanSubCategory(
        @RequestBody requestRegistBanSubCategory: RequestRegistBanSubCategory
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.registBanSubCategory(requestRegistBanSubCategory)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }


    @ApiOperation(value = "[제재관리] Sub 카테고리 상세조회")
    @GetMapping(value = ["/category-sub/{subCategoryId}"])
    fun getBanSubCategoryDetail(
        @PathVariable subCategoryId: Int
    ): SimsResponseEntity<SubCategory?, ExtraDataEntity> {
        return defaultBanService.getBanSubCategoryDetail(subCategoryId)
    }


    @ApiOperation(value = "[제재관리] Sub 카테고리 수정")
    @PutMapping(value = ["/category-sub/{subCategoryId}"])
    fun updateBanSubCategory(
        @RequestBody requestRegistBanSubCategory: RequestRegistBanSubCategory,
        @PathVariable subCategoryId: Int
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.updateBanSubCategory(requestRegistBanSubCategory)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }


    /** CONTENT ******************************************************************/

    @ApiOperation(value = "[제재관리] 카테고리 컨텐츠")
    @GetMapping(value = ["/category-content"])
    fun getBanCategoryContent(
        @ModelAttribute baseDto: RequestBaseDto
    ): SimsResponseEntity<List<ContentCategory>, ExtraDataEntity> {
        return defaultBanService.getBanContentCategory(baseDto)
    }


    @ApiOperation(value = "[제재관리] Content 카테고리 등록")
    @PostMapping(value = ["/category-content"])
    fun registBanContentCategory(
        @RequestBody requestRegistBanContentCategory: RequestRegistBanContentCategory
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.registBanContentCategory(requestRegistBanContentCategory)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }


    @ApiOperation(value = "[제재관리] Content 카테고리 상세조회")
    @GetMapping(value = ["/category-content/{contentCategoryId}"])
    fun getBanContentCategoryDetail(
        @PathVariable contentCategoryId: Int
    ): SimsResponseEntity<ContentCategory?, ExtraDataEntity> {
        return defaultBanService.getBanContentCategoryDetail(contentCategoryId)
    }


    @ApiOperation(value = "[제재관리] Content 카테고리 수정")
    @PutMapping(value = ["/category-content/{contentCategoryId}"])
    fun updateBanContentCategory(
        @RequestBody requestRegistBanContentCategory: RequestRegistBanContentCategory,
        @PathVariable contentCategoryId: Int
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        defaultBanService.updateBanContentCategory(requestRegistBanContentCategory)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }

}