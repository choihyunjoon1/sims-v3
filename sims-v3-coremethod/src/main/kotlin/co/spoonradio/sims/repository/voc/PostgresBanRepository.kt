package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.ban.*
import co.spoonradio.sims.dto.response.voc.ban.Ban
import co.spoonradio.sims.dto.response.voc.ban.UsersBan
import co.spoonradio.sims.dto.response.voc.ban.category.ContentCategory
import co.spoonradio.sims.dto.response.voc.ban.category.MainCategory
import co.spoonradio.sims.dto.response.voc.ban.category.SubCategory

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
interface PostgresBanRepository {
    fun getBans(param: RequestBan): Pair<List<Ban>, Long>
    fun getBanUsers(banIds: List<Long?>): List<UsersBan>

    fun registBan(requestRegistBan: RequestRegistBan): Int?
    fun getUserDeviceInfo(userId: Int): String?
    fun updateUsersGrantStatus(userId: Int, status: Int): Int
    fun updateUsersSpoonStatus(userId: Int, status: Int): Int

    fun getBanMainCategory(base: RequestBaseDto): Pair<List<MainCategory>, Long>
    fun registBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory)
    fun getBanMainCategoryDetail(categoryId: Int): MainCategory?
    fun updateBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory)


    fun getBanSubCategory(base: RequestBaseDto): Pair<List<SubCategory>, Long>
    fun updateBanSubCategory(requestRegistSubCategory: RequestRegistBanSubCategory)
    fun getBanSubCategoryDetail(subCategoryId: Int): SubCategory?
    fun registBanSubCategory(requestRegistBanSubCategory: RequestRegistBanSubCategory)

    fun getBanContentCategory(base: RequestBaseDto): Pair<List<ContentCategory>, Long>
    fun getBanContentCategoryDetail(contentCategoryId: Int): ContentCategory?
    fun registBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory)
    fun updateBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory)
    fun updateBan(requestUpdateBan: RequestUpdateBan)

}