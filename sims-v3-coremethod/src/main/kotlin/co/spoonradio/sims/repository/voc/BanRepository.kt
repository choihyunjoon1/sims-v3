package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.common.extension.zonedDateTime
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.ban.*
import co.spoonradio.sims.dto.response.voc.ban.Ban
import co.spoonradio.sims.dto.response.voc.ban.UsersBan
import co.spoonradio.sims.dto.response.voc.ban.category.ContentCategory
import co.spoonradio.sims.dto.response.voc.ban.category.MainCategory
import co.spoonradio.sims.dto.response.voc.ban.category.SubCategory
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.condition.CommonCondition
import co.spoonradio.sims.repository.postgresql.tables.references.*
import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.DatePart
import org.jooq.impl.DSL
import org.jooq.impl.DSL.inline
import org.jooq.impl.DSL.noCondition
import org.springframework.stereotype.Repository
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
@Repository
class BanRepository(val postgreSqlDslContext: DSLContext) : PostgresBanRepository, CommonCondition() {
    override fun getBans(param: RequestBan): Pair<List<Ban>, Long> {
        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = noCondition()

        if (base.field.equals("user_id")) baseSearhcCondition = DSL.and(USERS_PROFILE.USER_ID.eq(base.value?.toInt()))
        if (base.field.equals("tag")) baseSearhcCondition = DSL.and(USERS_PROFILE.TAG.eq(base.value))
        if (base.field.equals("nickname")) baseSearhcCondition = DSL.and(USERS_PROFILE.NICKNAME.eq(base.value))
        if (base.field.equals("memo")) baseSearhcCondition = DSL.and(USERS_BAN.MEMO.eq(base.value))


        var advenceSearhcCondition: Condition = noCondition();
        param.apply {
            category_main_id?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(USERS_BAN.CATEGORY_MAIN_ID.eq(category_main_id))
            }

            //TODO 아래 조건에 대해 조사 필요
            /*   ban_status?.let {
                   advenceSearhcCondition =
                       advenceSearhcCondition.and(VOC_HIST.CRITICALITY_TYPE_CD.eq(ban_status))
               }*/
            /*type?.let { advenceSearhcCondition = advenceSearhcCondition.and(VOC_HIST.CHANNEL_CD.eq(channel_cd)) }*/
        }

        val result = postgreSqlDslContext.select(
            USERS_BAN.ID,
            USERS_BAN.MEMO,
            USERS_PROFILE.USER_ID,
            USERS_PROFILE.NICKNAME,
            DSL.`when`(
                USERS_GRANT.LOGIN.eq(-1),
                DSL.concat(
                    DSL.extract(USERS_BAN.END_DATE - DSL.currentOffsetDateTime(), DatePart.DAY),
                    inline("days "),
                    DSL.extract(USERS_BAN.END_DATE - DSL.currentOffsetDateTime(), DatePart.HOUR),
                    inline("hours")
                )
            ).otherwise("Released").`as`("remain_time"),
            USERS_BAN.END_DATE.zonedDateTime.`as`("end_date"),
            DSL.`when`(USERS_GRANT.LOGIN.eq(-1).and(DSL.currentOffsetDateTime().gt(USERS_BAN.END_DATE)), "BS003")
                .`when`(USERS_GRANT.LOGIN.eq(-1), "BS001")
                .otherwise("BS002").`as`("ban_status"),

            USERS_PROFILE.TAG,
            USERS_BAN.ID,
            USERS_BAN.TYPE,
            USERS_BAN.DETAIL,
            USERS_BAN.DEVICE_UNIQUE_ID,
            USERS_BAN.CATEGORY_MAIN_ID,
            USERS_BAN.CATEGORY_SUB_ID,
            USERS_BAN.CATEGORY_CONTENT_ID,
            USERS_BANCATEGORYMAIN.NAME.`as`("main_category_name"),
            USERS_BANCATEGORYSUB.NAME.`as`("sub_category_name"),
            USERS_BANCATEGORYCONTENT.NAME.`as`("content_category_name"),
            USERS_BAN.CREATED.zonedDateTime.`as`("created"),
            DSL.count(USERS_BAN.ID).over().`as`("totalCount")
        ).from(USERS_BAN)
            .leftJoin(USERS_SPOONUSER).on(USERS_BAN.USER_ID.eq(USERS_SPOONUSER.ID))
            .leftJoin(USERS_PROFILE).on(USERS_SPOONUSER.ID.eq(USERS_PROFILE.USER_ID))
            .leftJoin(USERS_GRANT).on(USERS_SPOONUSER.GRANTS_ID.eq(USERS_GRANT.ID))
            .leftJoin(USERS_BANCATEGORYMAIN).on(USERS_BAN.CATEGORY_MAIN_ID.eq(USERS_BANCATEGORYMAIN.ID))
            .leftJoin(USERS_BANCATEGORYSUB).on(USERS_BAN.CATEGORY_SUB_ID.eq(USERS_BANCATEGORYSUB.ID))
            .leftJoin(USERS_BANCATEGORYCONTENT).on(USERS_BAN.CATEGORY_CONTENT_ID.eq(USERS_BANCATEGORYCONTENT.ID))
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(USERS_BAN.CREATED, base))
            .orderBy(USERS_BAN.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(Ban::class.java)

        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }

    override fun getBanUsers(banIds: List<Long?>): List<UsersBan> {
        return postgreSqlDslContext.select(
            USERS_BAN.ID,
            USERS_BAN.CREATED.zonedDateTime.`as`("created"),
            USERS_BAN.END_DATE.zonedDateTime.`as`("end_date"),
            DSL.`when`(USERS_GRANT.LOGIN.eq(-1).and(DSL.currentOffsetDateTime().gt(USERS_BAN.END_DATE)), "BS003")
                .`when`(USERS_GRANT.LOGIN.eq(-1), "BS001")
                .otherwise("BS002").`as`("ban_status"),
            DSL.`when`(
                USERS_GRANT.LOGIN.eq(-1),
                DSL.concat(
                    DSL.extract(USERS_BAN.END_DATE - DSL.currentOffsetDateTime(), DatePart.DAY),
                    inline("days"),
                    DSL.extract(USERS_BAN.END_DATE - DSL.currentOffsetDateTime(), DatePart.HOUR),
                    inline("hours")
                )
            ).otherwise("Released").`as`("remain_time")
        ).from(USERS_BAN).join(USERS_GRANT)
            .on(USERS_BAN.USER_ID.eq(USERS_GRANT.ID))
            .where(USERS_BAN.ID.`in`(banIds))
            .fetchInto(UsersBan::class.java)
    }


    override fun registBan(requestRegistBan: RequestRegistBan): Int? {
        return postgreSqlDslContext.insertInto(USERS_BAN)
            .set(USERS_BAN.USER_ID, requestRegistBan.user_id)
            .set(USERS_BAN.CATEGORY_CONTENT_ID, requestRegistBan.category_content_id)
            .set(USERS_BAN.CATEGORY_MAIN_ID, requestRegistBan.category_main_id)
            .set(USERS_BAN.CATEGORY_SUB_ID, requestRegistBan.category_sub_id)
            .set(USERS_BAN.DETAIL, requestRegistBan.detail)
            .set(USERS_BAN.MEMO, requestRegistBan.memo)
            .set(USERS_BAN.TYPE, requestRegistBan.type.toInt())
            .set(USERS_BAN.DEVICE_UNIQUE_ID, requestRegistBan.device_unique_id)
            .set(USERS_BAN.CREATED, requestRegistBan.created?.toOffsetDateTime())
            .set(USERS_BAN.END_DATE, requestRegistBan.end_date?.toOffsetDateTime())
            .returningResult(USERS_BAN.ID)
            .fetchOne()?.getValue(USERS_BAN.ID)
    }

    override fun updateBan(requestUpdateBan: RequestUpdateBan) {
        postgreSqlDslContext.update(USERS_BAN)
            .set(USERS_BAN.CATEGORY_MAIN_ID, requestUpdateBan.category_main_id)
            .set(USERS_BAN.CATEGORY_SUB_ID, requestUpdateBan.category_sub_id)
            .set(USERS_BAN.CATEGORY_CONTENT_ID, requestUpdateBan.category_content_id)
            .set(USERS_BAN.TYPE, requestUpdateBan.type.toInt())
            .set(USERS_BAN.END_DATE, requestUpdateBan.end_date_utc?.toOffsetDateTime())
            .set(USERS_BAN.DETAIL, requestUpdateBan.detail)
            .set(USERS_BAN.MEMO, requestUpdateBan.memo)
            .set(USERS_BAN.DEVICE_UNIQUE_ID, requestUpdateBan.device_unique_id)
            .where(USERS_BAN.ID.eq(requestUpdateBan.id))
            .execute()
    }

    override fun getUserDeviceInfo(userId: Int): String? {
        return postgreSqlDslContext.select(
            USERS_DEVICE.DEVICE_UNIQUE_ID
        ).from(USERS_DEVICE)
            .where(USERS_DEVICE.USER_ID.eq(userId))
            .orderBy(USERS_DEVICE.CREATED.desc())
            .limit(1)
            .fetchOne()?.getValue(USERS_DEVICE.DEVICE_UNIQUE_ID)
    }


    override fun updateUsersGrantStatus(userId: Int, status: Int): Int {
        return postgreSqlDslContext.update(USERS_GRANT)
            .set(USERS_GRANT.LOGIN, status)
            .where(
                USERS_GRANT.ID.eq(
                    DSL.select(USERS_SPOONUSER.GRANTS_ID)
                        .from(USERS_SPOONUSER)
                        .where(USERS_SPOONUSER.ID.eq(userId))
                )
            ).execute()
    }


    override fun updateUsersSpoonStatus(userId: Int, status: Int): Int {
        return postgreSqlDslContext.update(USERS_SPOONUSER)
            .set(USERS_SPOONUSER.STATUS, status)
            .where(USERS_SPOONUSER.ID.eq(userId))
            .execute()
    }


    /** MAIN */
    override fun getBanMainCategory(base: RequestBaseDto): Pair<List<MainCategory>, Long> {
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("name")) baseSearhcCondition =
            DSL.and(USERS_BANCATEGORYMAIN.NAME.like("%${base.value}%"))

        val mainCategoryList = postgreSqlDslContext.select(
            USERS_BANCATEGORYMAIN.ID,
            USERS_BANCATEGORYMAIN.NAME,
            USERS_BANCATEGORYMAIN.IS_USE,
            USERS_BANCATEGORYMAIN.CREATED.zonedDateTime.`as`("created"),
            DSL.count(USERS_BANCATEGORYMAIN.ID).over().`as`("totalCount")
        ).from(USERS_BANCATEGORYMAIN)
            .where(baseSearhcCondition)
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(MainCategory::class.java)

        return Pair(mainCategoryList, mainCategoryList.getOrNull(0)?.totalCount ?: 0L)
    }


    override fun registBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory) {
        postgreSqlDslContext.insertInto(USERS_BANCATEGORYMAIN)
            .set(USERS_BANCATEGORYMAIN.NAME, requestRegistBanMainCategory.name)
            .set(USERS_BANCATEGORYMAIN.IS_USE, requestRegistBanMainCategory.is_use)
            .set(USERS_BANCATEGORYMAIN.CREATED, ZonedDateTime.now(ZoneId.of("UTC")).toOffsetDateTime())
            .execute()
    }

    override fun getBanMainCategoryDetail(categoryId: Int): MainCategory? {
        return postgreSqlDslContext.select(
            USERS_BANCATEGORYMAIN.IS_USE,
            USERS_BANCATEGORYMAIN.CREATED.zonedDateTime.`as`("created"),
            USERS_BANCATEGORYMAIN.NAME,
            USERS_BANCATEGORYMAIN.ID
        )
            .from(USERS_BANCATEGORYMAIN)
            .where(USERS_BANCATEGORYMAIN.ID.eq(categoryId))
            .fetchOneInto(MainCategory::class.java)
    }

    override fun updateBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory) {
        postgreSqlDslContext.update(USERS_BANCATEGORYMAIN)
            .set(USERS_BANCATEGORYMAIN.NAME, requestRegistBanMainCategory.name)
            .set(USERS_BANCATEGORYMAIN.IS_USE, requestRegistBanMainCategory.is_use)
            .where(USERS_BANCATEGORYMAIN.ID.eq(requestRegistBanMainCategory.id))
            .execute()
    }


    /** SUB */
    override fun getBanSubCategory(base: RequestBaseDto): Pair<List<SubCategory>, Long> {
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("name")) baseSearhcCondition =
            DSL.and(USERS_BANCATEGORYSUB.NAME.like("%${base.value}%"))

        val subCategoryList = postgreSqlDslContext.select(
            USERS_BANCATEGORYSUB.ID,
            USERS_BANCATEGORYSUB.NAME,
            USERS_BANCATEGORYSUB.IS_USE,
            USERS_BANCATEGORYSUB.CATEGORY_MAIN_ID,
            USERS_BANCATEGORYSUB.CREATED.zonedDateTime.`as`("created"),
            DSL.count(USERS_BANCATEGORYSUB.ID).over().`as`("totalCount")
        ).from(USERS_BANCATEGORYSUB)
            .where(baseSearhcCondition)
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(SubCategory::class.java)

        return Pair(subCategoryList, subCategoryList.getOrNull(0)?.totalCount ?: 0L)
    }


    override fun getBanSubCategoryDetail(subCategoryId: Int): SubCategory? {
        return postgreSqlDslContext.select(
            USERS_BANCATEGORYSUB.CATEGORY_MAIN_ID,
            USERS_BANCATEGORYSUB.CREATED.zonedDateTime.`as`("created"),
            USERS_BANCATEGORYSUB.ID,
            USERS_BANCATEGORYSUB.IS_USE,
            USERS_BANCATEGORYSUB.NAME
        ).from(USERS_BANCATEGORYSUB)
            .where(USERS_BANCATEGORYSUB.ID.eq(subCategoryId))
            .fetchOneInto(SubCategory::class.java)

    }

    override fun registBanSubCategory(requestRegistBanSubCategory: RequestRegistBanSubCategory) {
        postgreSqlDslContext.insertInto(USERS_BANCATEGORYSUB)
            .set(USERS_BANCATEGORYSUB.NAME, requestRegistBanSubCategory.name)
            .set(USERS_BANCATEGORYSUB.IS_USE, requestRegistBanSubCategory.is_use)
            .set(USERS_BANCATEGORYSUB.CATEGORY_MAIN_ID, requestRegistBanSubCategory.category_main_id)
            .set(USERS_BANCATEGORYSUB.CREATED, ZonedDateTime.now(ZoneId.of("UTC")).toOffsetDateTime())
            .execute()
    }


    override fun updateBanSubCategory(requestRegistSubCategory: RequestRegistBanSubCategory) {
        postgreSqlDslContext.update(USERS_BANCATEGORYSUB)
            .set(USERS_BANCATEGORYSUB.NAME, requestRegistSubCategory.name)
            .set(USERS_BANCATEGORYSUB.IS_USE, requestRegistSubCategory.is_use)
            .set(USERS_BANCATEGORYSUB.CATEGORY_MAIN_ID, requestRegistSubCategory.category_main_id)
            .where(USERS_BANCATEGORYSUB.ID.eq(requestRegistSubCategory.id))
            .execute()
    }


    /** CONTENT */

    override fun getBanContentCategory(base: RequestBaseDto): Pair<List<ContentCategory>, Long> {
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("name")) baseSearhcCondition =
            DSL.and(USERS_BANCATEGORYCONTENT.NAME.like("%${base.value}%"))

        val mainCategoryList = postgreSqlDslContext.select(
            USERS_BANCATEGORYCONTENT.ID,
            USERS_BANCATEGORYCONTENT.NAME,
            USERS_BANCATEGORYCONTENT.IS_USE,
            USERS_BANCATEGORYCONTENT.CREATED.zonedDateTime.`as`("created"),
            DSL.count(USERS_BANCATEGORYCONTENT.ID).over().`as`("totalCount")
        ).from(USERS_BANCATEGORYCONTENT)
            .where(baseSearhcCondition)
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(ContentCategory::class.java)
        return Pair(mainCategoryList, mainCategoryList.getOrNull(0)?.totalCount ?: 0L)
    }

    override fun getBanContentCategoryDetail(contentCategoryId: Int): ContentCategory? {
        return postgreSqlDslContext.select(
            USERS_BANCATEGORYCONTENT.CREATED.zonedDateTime.`as`("created"),
            USERS_BANCATEGORYCONTENT.ID,
            USERS_BANCATEGORYCONTENT.IS_USE,
            USERS_BANCATEGORYCONTENT.NAME
        ).from(USERS_BANCATEGORYCONTENT)
            .where(USERS_BANCATEGORYCONTENT.ID.eq(contentCategoryId))
            .fetchOneInto(ContentCategory::class.java)
    }

    override fun registBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory) {
        postgreSqlDslContext.insertInto(USERS_BANCATEGORYCONTENT)
            .set(USERS_BANCATEGORYCONTENT.NAME, requestRegistBanContentCategory.name)
            .set(USERS_BANCATEGORYCONTENT.IS_USE, requestRegistBanContentCategory.is_use)
            .set(USERS_BANCATEGORYCONTENT.CREATED, ZonedDateTime.now(ZoneId.of("UTC")).toOffsetDateTime())
            .execute()
    }

    override fun updateBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory) {
        postgreSqlDslContext.update(USERS_BANCATEGORYCONTENT)
            .set(USERS_BANCATEGORYCONTENT.NAME, requestRegistBanContentCategory.name)
            .set(USERS_BANCATEGORYCONTENT.IS_USE, requestRegistBanContentCategory.is_use)
            .where(USERS_BANCATEGORYCONTENT.ID.eq(requestRegistBanContentCategory.id))
            .execute()
    }


}
