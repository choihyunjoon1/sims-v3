package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.common.extension.emailMasking
import co.spoonradio.sims.common.extension.zonedDateTime
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.*
import co.spoonradio.sims.dto.response.voc.ban.BanHistory
import co.spoonradio.sims.dto.response.voc.history.Attachment
import co.spoonradio.sims.dto.response.voc.history.Reply
import co.spoonradio.sims.dto.response.voc.history.VocHistory
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.condition.CommonCondition
import co.spoonradio.sims.repository.mysql.tables.references.*
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import co.spoonradio.sims.type.voc.VocDestroyType
import org.jooq.*
import org.jooq.impl.DSL
import org.jooq.impl.DSL.*
import org.jooq.impl.SQLDataType
import org.slf4j.MDC
import org.springframework.stereotype.Repository
import java.time.ZoneId
import java.time.ZonedDateTime


/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */
@Repository
class DefaultVocHistoryRepository(val mysqlDslContext: DSLContext) : VocHistoryRepository, CommonCondition() {

    companion object {
        val REPLY_ADMIN = ADMIN_USER.asTable("REPLY_ADMIN")
        val MEMBER_ADMIN = ADMIN_USER.asTable("MEMBER_ADMIN")
    }

    override fun getVocHistoryDetail(histId: Int): VocHistory? {
        return mysqlDslContext
            .select(
                VOC_HIST.VOC_HIST_ID,
                VOC_HIST.STATUS_CD,
                VOC_HIST.SPOON_USER_ID,
                VOC_HIST.REGISTER_TYPE_CD,
                VOC_HIST.BOUND_TYPE_CD,
                VOC_HIST.CRITICALITY_TYPE_CD,
                VOC_HIST.CHANNEL_CD,
                VOC_HIST.TYPE_CD,
                VOC_HIST.CATEGORY_CD,
                VOC_HIST.DIVISION_CD,
                VOC_HIST.SECTION_CD,
                VOC_HIST.COMMENT,
                VOC_HIST.REPLY,
                VOC_HIST.CREATE_DT.zonedDateTime.`as`("create_dt"),
                VOC_HIST.UPDATE_DT.zonedDateTime.`as`("update_dt"),
                VOC_HIST.REPLY_DT.zonedDateTime.`as`("reply_dt"),
                VOC_HIST.NON_SPOON_MEMBER_EMAIL,
                VOC_HIST.OS,
                VOC_HIST.CARRIER,
                VOC_HIST.APP_VERSION,
                VOC_HIST.DEVICE_MODEL,
                MEMBER_ADMIN.field("username")?.`as`("username"),
                DSL.field(selectCount().from(VOC_ATTACHMENT).where(VOC_ATTACHMENT.VOC_HIST_ID.eq(VOC_HIST.VOC_HIST_ID)))
                    .`as`("attachments_count")
            ).from(VOC_HIST)
            .innerJoin(MEMBER_ADMIN)
            .on(VOC_HIST.MEMBER_USER_ID.eq(MEMBER_ADMIN.field(ADMIN_USER.USER_ID)))
            .leftJoin(REPLY_ADMIN)
            .on(VOC_HIST.REPLY_USER_ID.eq(REPLY_ADMIN.field(ADMIN_USER.USER_ID)))
            .where(VOC_HIST.VOC_HIST_ID.eq(histId))
            .and(VOC_HIST.IS_DES.eq(VocDestroyType.NO.code.toByte())) //파기여부
            .fetchOneInto(VocHistory::class.java)
    }


    override fun getVocHistory(param: RequestVoc): Pair<MutableList<VocHistory>, Long> {


        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = noCondition()

        if (base.field.equals("user_id")) baseSearhcCondition = DSL.and(VOC_HIST.SPOON_USER_ID.eq(base.value?.toLong()))
        if (base.field.equals("sims_user_email")) baseSearhcCondition =
            DSL.and(MEMBER_ADMIN.field(ADMIN_USER.EMAIL)?.like(base.value))
        if (base.field.equals("section_cd")) baseSearhcCondition = DSL.and(VOC_HIST.SECTION_CD.eq(base.value))
        if (base.field.equals("comment")) baseSearhcCondition = DSL.and(VOC_HIST.COMMENT.like("%${base.value}%"))
        if (base.field.equals("reply")) baseSearhcCondition = DSL.and(VOC_HIST.REPLY.eq(base.value))
        if (base.field.equals("id")) baseSearhcCondition = DSL.and(VOC_HIST.VOC_HIST_ID.eq(base.value?.toInt()))
        if (base.field.equals("tag")) baseSearhcCondition = DSL.and(VOC_HIST.SPOON_USER_ID.eq(base.value?.toLong()))
        if (base.field.equals("nickname")) baseSearhcCondition =
            DSL.and(VOC_HIST.SPOON_USER_ID.`in`(base.value?.split(",")?.toList()))


        var advenceSearhcCondition: Condition = noCondition();
        param.apply {
            bound_type_cd?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(VOC_HIST.BOUND_TYPE_CD.eq(bound_type_cd))
            }
            criticality_type_cd?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(VOC_HIST.CRITICALITY_TYPE_CD.eq(criticality_type_cd))
            }
            channel_cd?.let { advenceSearhcCondition = advenceSearhcCondition.and(VOC_HIST.CHANNEL_CD.eq(channel_cd)) }
            category_cd?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(VOC_HIST.CATEGORY_CD.eq(category_cd))
            }
            division_cd?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(VOC_HIST.DIVISION_CD.eq(division_cd))
            }
        }


        val list = mysqlDslContext
            .select(
                VOC_HIST.VOC_HIST_ID,
                VOC_HIST.STATUS_CD,
                VOC_HIST.SPOON_USER_ID,
                VOC_HIST.REGISTER_TYPE_CD,
                VOC_HIST.BOUND_TYPE_CD,
                VOC_HIST.CRITICALITY_TYPE_CD,
                VOC_HIST.CHANNEL_CD,
                VOC_HIST.TYPE_CD,
                VOC_HIST.CATEGORY_CD,
                VOC_HIST.DIVISION_CD,
                VOC_HIST.SECTION_CD,
                VOC_HIST.COMMENT,
                VOC_HIST.REPLY,
                VOC_HIST.CREATE_DT.zonedDateTime.`as`("create_dt"),
                VOC_HIST.UPDATE_DT.zonedDateTime.`as`("update_dt"),
                VOC_HIST.REPLY_DT.zonedDateTime.`as`("reply_dt"),
                VOC_HIST.NON_SPOON_MEMBER_EMAIL,
                VOC_HIST.OS,
                VOC_HIST.CARRIER,
                VOC_HIST.APP_VERSION,
                VOC_HIST.DEVICE_MODEL,
                MEMBER_ADMIN.field("username")?.`as`("username"),
                DSL.field(selectCount().from(VOC_ATTACHMENT).where(VOC_ATTACHMENT.VOC_HIST_ID.eq(VOC_HIST.VOC_HIST_ID)))
                    .`as`("attachments_count")
            ).hint("SQL_CALC_FOUND_ROWS")
            .from(VOC_HIST)
            .innerJoin(MEMBER_ADMIN)
            .on(VOC_HIST.MEMBER_USER_ID.eq(MEMBER_ADMIN.field(ADMIN_USER.USER_ID)))
            .leftJoin(REPLY_ADMIN)
            .on(VOC_HIST.REPLY_USER_ID.eq(REPLY_ADMIN.field(ADMIN_USER.USER_ID)))
            .where(VOC_HIST.REGISTER_TYPE_CD.eq(param.register_type_cd)) //회원 or 비회원 구분
            .and(VOC_HIST.IS_DES.eq(VocDestroyType.NO.code.toByte())) //파기여부
            .and(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(VOC_HIST.CREATE_DT, base))
            .orderBy(VOC_HIST.VOC_HIST_ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(VocHistory::class.java)

        /** MASKING */
        if(MDC.get("UNMASKING").equals("true")) list.forEach { item -> item.username = item.username?.emailMasking }

        return Pair<MutableList<VocHistory>, Long>(list, this.getTotalCount(mysqlDslContext))
    }

    override fun registVoc(registVoc: RequestRegistVocHistory): Int? {

        return mysqlDslContext.insertInto(VOC_HIST)
            .set(VOC_HIST.BOUND_TYPE_CD, registVoc.bound_type_cd)
            .set(VOC_HIST.CATEGORY_CD, registVoc.category_cd)
            .set(VOC_HIST.CHANNEL_CD, registVoc.channel_cd)
            .set(VOC_HIST.REGISTER_TYPE_CD, registVoc.register_type_cd)
            .set(VOC_HIST.CRITICALITY_TYPE_CD, registVoc.criticality_type_cd)
            .set(VOC_HIST.DIVISION_CD, registVoc.division_cd)
            .set(VOC_HIST.SECTION_CD, registVoc.section_cd)
            .set(VOC_HIST.STATUS_CD, registVoc.status_cd)
            .set(VOC_HIST.TYPE_CD, registVoc.type_cd)
            .set(VOC_HIST.COMMENT, registVoc.comment)
            .set(VOC_HIST.MEMBER_USER_ID, registVoc.member_user_id)
            .set(VOC_HIST.SPOON_USER_ID, registVoc.spoon_user_id?.toLong())
            .set(VOC_HIST.NON_SPOON_MEMBER_EMAIL, registVoc.non_spoon_member_email)
            .set(VOC_HIST.UPDATE_DT, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .set(VOC_HIST.CREATE_DT, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .set(VOC_HIST.IS_DES, VocDestroyType.NO.code.toByte())
            .set(VOC_HIST.REPLY, registVoc.reply)
            .set(VOC_HIST.SPOON_USER_NICKNAME, registVoc.spoon_user_nickname)
            .returningResult(VOC_HIST.VOC_HIST_ID)
            .fetchOne()?.getValue(VOC_HIST.VOC_HIST_ID)

        //return mysqlDslContext.newRecord(VOC_HIST, registVoc).insert()
    }

    override fun registVocBan(banHistory: BanHistory): Int? {
        return mysqlDslContext.insertInto(VOC_BANSHISTORY)
            .set(VOC_BANSHISTORY.BANS_ID, banHistory.bans_id)
            .set(VOC_BANSHISTORY.BANS_USER_ID, banHistory.bans_user_id)
            .set(VOC_BANSHISTORY.HANDLER_USER_NAME, banHistory.handler_user_name)
            .set(VOC_BANSHISTORY.HANDLER_USER_ID, banHistory.handler_user_id)
            .set(VOC_BANSHISTORY.CREATE_DT, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .execute()
    }

    override fun deleteVoc(histId: Int): Int {
        return mysqlDslContext
            .update(VOC_HIST)
            .set(VOC_HIST.IS_DES, 1)
            .where(VOC_HIST.VOC_HIST_ID.eq(histId))
            .execute()
    }

    override fun updateVoc(updateVoc: RequestRegistVocHistory): Int? {
        return mysqlDslContext.update(VOC_HIST)
            .set(VOC_HIST.BOUND_TYPE_CD, updateVoc.bound_type_cd)
            .set(VOC_HIST.CATEGORY_CD, updateVoc.category_cd)
            .set(VOC_HIST.CHANNEL_CD, updateVoc.channel_cd)
            .set(VOC_HIST.REGISTER_TYPE_CD, updateVoc.register_type_cd)
            .set(VOC_HIST.CRITICALITY_TYPE_CD, updateVoc.criticality_type_cd)
            .set(VOC_HIST.DIVISION_CD, updateVoc.division_cd)
            .set(VOC_HIST.SECTION_CD, updateVoc.section_cd)
            .set(VOC_HIST.STATUS_CD, updateVoc.status_cd)
            .set(VOC_HIST.TYPE_CD, updateVoc.type_cd)
            .set(VOC_HIST.COMMENT, updateVoc.comment)
            .set(VOC_HIST.UPDATE_DT, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .where(VOC_HIST.VOC_HIST_ID.eq(updateVoc.voc_hist_id))
            .execute()
    }

    override fun updateReply(requestReply: RequestReply): Int? {
        return mysqlDslContext.update(VOC_HIST)
            .set(VOC_HIST.REPLY, requestReply.reply)
            .set(VOC_HIST.REPLY_DT, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .where(VOC_HIST.VOC_HIST_ID.eq(requestReply.vocHistId))
            .execute()
    }

    override fun getAttachments(histId: Int): Pair<List<Attachment>, Long> {
        val list = mysqlDslContext
            .select(
                VOC_ATTACHMENT.ATTACHMENT_ID,
                VOC_ATTACHMENT.VOC_HIST_ID,
                VOC_ATTACHMENT.ATTACHMENT_PATH,
                VOC_ATTACHMENT.CREATE_DT.cast(
                    SQLDataType.LOCALDATETIME.asConvertedDataType(
                        localDateTimeToZonedDateTime
                    )
                ).`as`("create_dt"),
                VOC_ATTACHMENT.UPDATE_DT.cast(
                    SQLDataType.LOCALDATETIME.asConvertedDataType(
                        localDateTimeToZonedDateTime
                    )
                ).`as`("update_dt")
            ).hint("SQL_CALC_FOUND_ROWS")
            .from(VOC_ATTACHMENT)
            .where(VOC_ATTACHMENT.VOC_HIST_ID.eq(histId))
            .fetchInto(Attachment::class.java)


        return Pair<List<Attachment>, Long>(list, this.getTotalCount(mysqlDslContext))
    }

    override fun getSpoonSupportReplies(histId: Int): Pair<List<Reply>, Long> {
        val list = mysqlDslContext
            .select(
                VOC_REPLY.REPLY_ID,
                VOC_REPLY.VOC_HIST_ID,
                VOC_REPLY.REPLY,
                VOC_REPLY.CREATE_DT.zonedDateTime.`as`("create_dt"),
                VOC_REPLY.UPDATE_DT.zonedDateTime.`as`("update_dt"),
                VOC_REPLY.MEMBER_USER_ID
            ).hint("SQL_CALC_FOUND_ROWS")
            .from(VOC_REPLY)
            .where(VOC_REPLY.VOC_HIST_ID.eq(histId))
            .fetchInto(Reply::class.java)


        return Pair<List<Reply>, Long>(list, this.getTotalCount(mysqlDslContext))
    }

    override fun registSpoonSupportReply(requestReply: RequestReply): Int? {
        return mysqlDslContext.insertInto(VOC_REPLY)
            .set(VOC_REPLY.VOC_HIST_ID, requestReply.vocHistId)
            .set(VOC_REPLY.REPLY, requestReply.reply)
            .set(VOC_REPLY.CREATE_DT, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .set(VOC_REPLY.MEMBER_USER_ID, requestReply.member_user_id)
            .returningResult(VOC_REPLY.REPLY_ID)
            .fetchOne()?.getValue(VOC_REPLY.REPLY_ID)
    }

    override fun updateMultipleStatus(multipleParam: RequestMultipleAction): Int {
        return mysqlDslContext
            .update(VOC_HIST)
            .set(VOC_HIST.STATUS_CD, multipleParam.code)
            .where(VOC_HIST.VOC_HIST_ID.`in`(multipleParam.voc_hist_ids))
            .execute()
    }

    override fun updateMultipleUpdateCriticalityType(multipleParam: RequestMultipleAction): Int {
        return mysqlDslContext
            .update(VOC_HIST)
            .set(VOC_HIST.CRITICALITY_TYPE_CD, multipleParam.code)
            .where(VOC_HIST.VOC_HIST_ID.`in`(multipleParam.voc_hist_ids))
            .execute()
    }

    override fun updateMultipleUpdateMemberUser(multipleParam: RequestMultipleMemberUpdateAction): Int {
        return mysqlDslContext
            .update(VOC_HIST)
            .set(VOC_HIST.MEMBER_USER_ID, multipleParam.member_user_id)
            .where(VOC_HIST.VOC_HIST_ID.`in`(multipleParam.voc_hist_ids))
            .execute()
    }

    override fun getBansHistory(reportUserId: Long): MutableMap<Long?, String?> {
        return mysqlDslContext.select(
            VOC_BANSHISTORY.BANS_ID,
            VOC_BANSHISTORY.HANDLER_USER_NAME
        ).from(VOC_BANSHISTORY)
            .where(VOC_BANSHISTORY.BANS_USER_ID.eq(reportUserId))
            .fetchMap(VOC_BANSHISTORY.BANS_ID, VOC_BANSHISTORY.HANDLER_USER_NAME)
    }


    fun getTotalCount(mysqlDslContext: DSLContext) =
        mysqlDslContext.fetchOne("SELECT FOUND_ROWS() as totalCount")?.getValue("totalCount") as Long
}







