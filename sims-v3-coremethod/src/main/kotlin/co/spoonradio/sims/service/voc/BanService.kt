package co.spoonradio.sims.service.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.ban.*
import co.spoonradio.sims.dto.request.voc.report.RequestReport
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.ban.Ban
import co.spoonradio.sims.dto.response.voc.ban.UsersBanEntity
import co.spoonradio.sims.dto.response.voc.ban.category.ContentCategory
import co.spoonradio.sims.dto.response.voc.ban.category.MainCategory
import co.spoonradio.sims.dto.response.voc.ban.category.SubCategory
import co.spoonradio.sims.type.event.EventType

/**
 * @author whale@spoonradio.co
 * @date   2021/11/29.
 * @Desc
 */
interface BanService {
    fun getBans(param: RequestBan): SimsResponseEntity<List<Ban>, ExtraDataEntity>
    fun getBansHistory(reportUserId: Long): SimsResponseEntity<UsersBanEntity, ExtraDataEntity>
    fun bundleRegistBan(requestRegistBan: RequestRegistBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity>
    fun registBan(requestRegistBan: RequestRegistBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity>
    fun updateBan(requestUpdateBan: RequestUpdateBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity>
    fun recovertyBan(requestRecoveryBan:RequestRecoveryBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity>


    fun executeBanEvent(userId:Int, eventType: EventType): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity>

    /** MAIN CATEGORY */
    fun getBanMainCategory(baseDto: RequestBaseDto): SimsResponseEntity<List<MainCategory>, ExtraDataEntity>
    fun registBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory)
    fun getBanMainCategoryDetail(categoryId:Int):  SimsResponseEntity<MainCategory?, ExtraDataEntity>
    fun updateBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory)

    /** SUB CATEGORY */
    fun getBanSubCategory(baseDto: RequestBaseDto): SimsResponseEntity<List<SubCategory>, ExtraDataEntity>
    fun registBanSubCategory(requestRegistBanSubCategory: RequestRegistBanSubCategory)
    fun getBanSubCategoryDetail(subCategoryId: Int):  SimsResponseEntity<SubCategory?, ExtraDataEntity>
    fun updateBanSubCategory(requestRegistBanSubCategory: RequestRegistBanSubCategory)

    /** CONTENT CATEGORY */
    fun getBanContentCategory(base: RequestBaseDto): SimsResponseEntity<List<ContentCategory>, ExtraDataEntity>
    fun registBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory)
    fun getBanContentCategoryDetail(contentCategoryId: Int):   SimsResponseEntity<ContentCategory?, ExtraDataEntity>
    fun updateBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory)



}