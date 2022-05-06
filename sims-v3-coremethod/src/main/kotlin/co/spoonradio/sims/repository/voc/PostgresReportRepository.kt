package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.common.extension.*
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.report.RequestReport
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.condition.CommonCondition
import co.spoonradio.sims.repository.postgresql.tables.references.*
import co.spoonradio.sims.dto.response.voc.report.*
import co.spoonradio.sims.type.spoonuser.SpoonUserStatus
import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
@Repository
class PostgresReportRepository(val postgreSqlDslContext: DSLContext) : ReportRepository, CommonCondition() {

    /** LIVE
    신고자 번호 : reporter_id : reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname : reporter 뒷부분 라이크 검색

    라이브 DJ 번호 : live_author_id -> live_author 앞부분 라이크 검색
    라이브 DJ 닉네임 : live_author_nickname -> live_author 뒷 부분 라이크 검색

    라이브 번호 : live_id -> live 앞부분 라이크 검색
    라이브 제목 : live_title -> live 뒷부분 라이크 검색
     * */
    override fun getReportLive(param: RequestReport): Pair<List<LiveReport>, Long> {
        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEREPORT.REPORTER.like("%${base.value}"))

        if (base.field.equals("live_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEREPORT.LIVE_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("live_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEREPORT.LIVE_AUTHOR.like("%${base.value}"))

        if (base.field.equals("live_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEREPORT.LIVE.like("[${base.value}]%"))
        if (base.field.equals("live_title")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEREPORT.LIVE.like("%${base.value}"))


        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(REPORTS_LIVEREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }
        val result = postgreSqlDslContext.select(
            REPORTS_LIVEREPORT.ID,
            REPORTS_LIVEREPORT.REPORTER,
            REPORTS_LIVEREPORT.REPORT_TYPE,
            REPORTS_LIVEREPORT.REPORT_DESCR,
            REPORTS_LIVEREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_LIVEREPORT.LIVE,
            REPORTS_LIVEREPORT.LIVE_STREAM_NAME,
            REPORTS_LIVEREPORT.LIVE_AUTHOR,
            REPORTS_LIVEREPORT.LIVE_CREATED.zonedDateTime.`as`("live_created"),
            USERS_SPOONUSER.STATUS,
            DSL.count(REPORTS_LIVEREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_LIVEREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_LIVEREPORT.LIVE_AUTHOR
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_LIVEREPORT.REPORTED, base))
            .orderBy(REPORTS_LIVEREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(LiveReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }

    /** 라이브 채팅 신고
    신고자 번호 : reporter_id : reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname : reporter 뒷부분 라이크 검색
    라이브 DJ 번호 : live_author_id -> live_author
    라이브 DJ 닉네임 : live_author_nickname -> live_author
    라이브 번호 : live_id -> live
    라이브 제목 : live_title -> live
    라이브 채팅 유저 번호 : message_author_id -> message_author
    라이브 채팅 유저 닉네임 : message_author_nickname -> message_author
    라이브 채팅 내용 : message_contents -> message_contents
     * */
    override fun getReportMessage(param: RequestReport): Pair<List<MessageReport>, Long> {

        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.REPORTER.like("%${base.value}"))
        if (base.field.equals("live_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.LIVE_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("live_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.LIVE_AUTHOR.like("%${base.value}"))
        if (base.field.equals("live_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.LIVE.like("[${base.value}]%"))
        if (base.field.equals("live_title")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.LIVE.like("%${base.value}"))
        if (base.field.equals("message_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.MESSAGE_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("message_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.MESSAGE_AUTHOR.like("%${base.value}"))
        if (base.field.equals("message_contents")) baseSearhcCondition =
            DSL.and(REPORTS_LIVEMESSAGEREPORT.MESSAGE_CONTENTS.like("%${base.value}%"))

        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(REPORTS_LIVEMESSAGEREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }


        val result = postgreSqlDslContext.select(
            REPORTS_LIVEMESSAGEREPORT.ID,
            REPORTS_LIVEMESSAGEREPORT.REPORTER,
            REPORTS_LIVEMESSAGEREPORT.REPORT_TYPE,
            REPORTS_LIVEMESSAGEREPORT.REPORT_DESCR,
            REPORTS_LIVEMESSAGEREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_LIVEMESSAGEREPORT.LIVE,
            REPORTS_LIVEMESSAGEREPORT.LIVE_AUTHOR,
            REPORTS_LIVEMESSAGEREPORT.LIVE_CREATED.zonedDateTime.`as`("live_created"),
            REPORTS_LIVEMESSAGEREPORT.MESSAGE_CONTENTS,
            REPORTS_LIVEMESSAGEREPORT.MESSAGE_AUTHOR,
            USERS_SPOONUSER.STATUS,
            DSL.count(REPORTS_LIVEMESSAGEREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_LIVEMESSAGEREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_LIVEMESSAGEREPORT.MESSAGE_AUTHOR
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_LIVEMESSAGEREPORT.REPORTED, base))
            .orderBy(REPORTS_LIVEMESSAGEREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(MessageReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }

    /** 캐스트 신고

    신고자 번호 : reporter_id -> reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname -> reporter 뒷부분 라이크 검색
    캐스트 DJ 번호 :  cast_author_id -> cast_author
    캐스트 DJ 닉네임 : cast_author_nickname -> cast_author
    캐스트 번호 : cast_id -> cast
    캐스트 제목 : cast_title -> cast

     * */
    override fun getReportCast(param: RequestReport): Pair<List<CastReport>, Long> {

        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_CASTREPORT.REPORTER.like("%${base.value}"))
        if (base.field.equals("cast_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTREPORT.CAST_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("cast_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_CASTREPORT.CAST_AUTHOR.like("%${base.value}"))
        if (base.field.equals("cast_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTREPORT.CAST.like("[${base.value}]%"))
        if (base.field.equals("cast_title")) baseSearhcCondition =
            DSL.and(REPORTS_CASTREPORT.CAST.like("%${base.value}"))


        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(REPORTS_CASTREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }


        val result = postgreSqlDslContext.select(
            REPORTS_CASTREPORT.ID,
            REPORTS_CASTREPORT.REPORTER,
            REPORTS_CASTREPORT.REPORT_TYPE,
            REPORTS_CASTREPORT.REPORT_DESCR,
            REPORTS_CASTREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_CASTREPORT.CAST,
            REPORTS_CASTREPORT.CAST_URL,
            REPORTS_CASTREPORT.CAST_CREATED.zonedDateTime.`as`("cast_created"),
            REPORTS_CASTREPORT.CAST_AUTHOR,
            USERS_SPOONUSER.STATUS,
            DSL.count(REPORTS_CASTREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_CASTREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_CASTREPORT.CAST_AUTHOR
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_CASTREPORT.REPORTED, base))
            .orderBy(REPORTS_CASTREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(CastReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }

    /** 캐스트 댓글 신고
    신고자 번호 : reporter_id -> reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname -> reporter 뒷부분 라이크 검색
    캐스트 DJ 번호 : cast_author_id -> cast_author
    캐스트 DJ 닉네임 : cast_author_nickname ->  cast_author
    캐스트 번호 : cast_id ->  cast
    캐스트 제목 :cast_title ->  cast
    캐스트 코멘트 작성 유저 번호 : comment_author_id ->  comment_author
    캐스트 코멘트 작성 유저 닉네임 : comment_author_nickname ->  comment_author
    캐스트 코멘트 내용 : comment_contents ->  comment_contents

     * */
    override fun getReportCastComment(param: RequestReport): Pair<List<CastCommentReport>, Long> {
        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.REPORTER.like("%${base.value}"))
        if (base.field.equals("cast_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.CAST_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("cast_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.CAST_AUTHOR.like("%${base.value}"))
        if (base.field.equals("cast_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.CAST.like("[${base.value}]%"))
        if (base.field.equals("cast_title")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.CAST.like("%${base.value}"))
        if (base.field.equals("comment_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.COMMENT_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("comment_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.COMMENT_AUTHOR.like("%${base.value}"))
        if (base.field.equals("comment_contents")) baseSearhcCondition =
            DSL.and(REPORTS_CASTCOMMENTREPORT.COMMENT_CONTENTS.like("%${base.value}%"))

        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(REPORTS_CASTCOMMENTREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }


        val result = postgreSqlDslContext.select(
            REPORTS_CASTCOMMENTREPORT.ID,
            REPORTS_CASTCOMMENTREPORT.REPORTER,
            REPORTS_CASTCOMMENTREPORT.REPORT_TYPE,
            REPORTS_CASTCOMMENTREPORT.REPORT_DESCR,
            REPORTS_CASTCOMMENTREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_CASTCOMMENTREPORT.CAST,
            REPORTS_CASTCOMMENTREPORT.CAST_CREATED.zonedDateTime.`as`("cast_created"),
            REPORTS_CASTCOMMENTREPORT.CAST_AUTHOR,
            REPORTS_CASTCOMMENTREPORT.COMMENT_CONTENTS,
            REPORTS_CASTCOMMENTREPORT.COMMENT_AUTHOR,
            REPORTS_CASTCOMMENTREPORT.COMMENT_CREATED.zonedDateTime.`as`("comment_created"),
            USERS_SPOONUSER.STATUS,
            DSL.count(REPORTS_CASTCOMMENTREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_CASTCOMMENTREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_CASTCOMMENTREPORT.COMMENT_AUTHOR
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_CASTCOMMENTREPORT.REPORTED, base))
            .orderBy(REPORTS_CASTCOMMENTREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(CastCommentReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }


    /** 톡 신고
    신고자 번호 : reporter_id -> reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname -> reporter 뒷부분 라이크 검색
    톡 DJ 번호 : talk_author_id -> talk_author
    톡 DJ 닉네임 : talk_author_nickname -> talk_author
    톡 번호 :talk_id -> talk
    톡 제목 :talk_title -> talk
     * */
    override fun getReportTalk(param: RequestReport): Pair<List<TalkReport>, Long> {

        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_TALKREPORT.REPORTER.like("%${base.value}"))

        if (base.field.equals("cast_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKREPORT.TALK_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("cast_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_TALKREPORT.TALK_AUTHOR.like("%${base.value}"))

        if (base.field.equals("cast_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKREPORT.TALK.like("[${base.value}]%"))
        if (base.field.equals("cast_title")) baseSearhcCondition =
            DSL.and(REPORTS_TALKREPORT.TALK.like("%${base.value}"))


        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(REPORTS_TALKREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }



        val result = postgreSqlDslContext.select(
            REPORTS_TALKREPORT.ID,
            REPORTS_TALKREPORT.REPORTER,
            REPORTS_TALKREPORT.REPORT_TYPE,
            REPORTS_TALKREPORT.REPORT_DESCR,
            REPORTS_TALKREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_TALKREPORT.TALK,
            REPORTS_TALKREPORT.TALK_CREATED.zonedDateTime.`as`("talk_created"),
            REPORTS_TALKREPORT.TALK_AUTHOR,
            USERS_SPOONUSER.STATUS,
            DSL.count(REPORTS_TALKREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_TALKREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_TALKREPORT.TALK_AUTHOR
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_TALKREPORT.REPORTED, base))
            .orderBy(REPORTS_TALKREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(TalkReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }


    /** 톡 댓글 신고
    신고자 번호 : reporter_id -> reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname -> reporter 뒷부분 라이크 검색
    톡 DJ 번호 : talk_author_id -> talk_author
    톡 DJ 닉네임 : talk_author_nickname -> talk_author
    톡 번호 :talk_id -> talk
    톡 제목 :talk_title -> talk
    톡 코멘트 작성 유저 번호 : comment_author_id -> comment_author
    톡 코멘트 작성 유저 제목 : comment_author_nickname -> comment_author
     * */
    override fun getReportTalkComment(param: RequestReport): Pair<List<TalkCommentReport>, Long> {

        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.REPORTER.like("%${base.value}"))

        if (base.field.equals("cast_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.TALK_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("cast_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.TALK_AUTHOR.like("%${base.value}"))

        if (base.field.equals("cast_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.TALK.like("[${base.value}]%"))
        if (base.field.equals("cast_title")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.TALK.like("%${base.value}"))

        if (base.field.equals("comment_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.COMMENT_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("comment_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_TALKCOMMENTREPORT.COMMENT_AUTHOR.like("%${base.value}"))

        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(REPORTS_TALKCOMMENTREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }


        val result = postgreSqlDslContext.select(
            REPORTS_TALKCOMMENTREPORT.ID,
            REPORTS_TALKCOMMENTREPORT.REPORTER,
            REPORTS_TALKCOMMENTREPORT.REPORT_TYPE,
            REPORTS_TALKCOMMENTREPORT.REPORT_DESCR,
            REPORTS_TALKCOMMENTREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_TALKCOMMENTREPORT.TALK,
            REPORTS_TALKCOMMENTREPORT.TALK_CREATED.zonedDateTime.`as`("talk_created"),
            REPORTS_TALKCOMMENTREPORT.TALK_AUTHOR,
            REPORTS_TALKCOMMENTREPORT.COMMENT_URL,
            REPORTS_TALKCOMMENTREPORT.COMMENT_CREATED.zonedDateTime.`as`("comment_created"),
            REPORTS_TALKCOMMENTREPORT.COMMENT_AUTHOR,
            USERS_SPOONUSER.STATUS,
            DSL.count(REPORTS_TALKCOMMENTREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_TALKCOMMENTREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_TALKCOMMENTREPORT.COMMENT_AUTHOR
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_TALKCOMMENTREPORT.REPORTED, base))
            .orderBy(REPORTS_TALKCOMMENTREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(TalkCommentReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }


    /** 이용자 신고
    신고자 번호 : reporter_id -> reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname -> reporter 뒷부분 라이크 검색
    어뷰저 번호 : abuser_id -> abuser
    어뷰저 닉네임 : abuser_nickname -> abuser
    어뷰저 태그 : abuser_tag -> abuser_tag
     * */
    override fun getReportUser(param: RequestReport): Pair<List<UserReport>, Long> {


        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.REPORTER.like("%${base.value}"))

        if (base.field.equals("abuser_id")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.ABUSER.like("[${base.value}]%"))
        if (base.field.equals("abuser_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.ABUSER.like("%${base.value}"))
        if (base.field.equals("abuser_tag")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.ABUSER_TAG.like("[${base.value}]%"))


        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition = advenceSearhcCondition.and(REPORTS_USERREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(USERS_SPOONUSER.STATUS.eq(SpoonUserStatus.BANNED.code))
            }
        }


        val result = postgreSqlDslContext.select(
            REPORTS_USERREPORT.ID,
            REPORTS_USERREPORT.REPORTER,
            REPORTS_USERREPORT.REPORT_TYPE,
            REPORTS_USERREPORT.REPORT_DESCR,
            REPORTS_USERREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_USERREPORT.ABUSER,
            REPORTS_USERREPORT.ABUSER_SNS_ID,
            REPORTS_USERREPORT.ABUSER_TAG,
            REPORTS_USERREPORT.ABUSER_SNS_TYPE,
            USERS_SPOONUSER.STATUS,
            DSL.count(USERS_SPOONUSER.ID).over().`as`("totalCount")
        ).from(REPORTS_USERREPORT)
            .leftJoin(USERS_SPOONUSER)
            .on(
                DSL.field(
                    "split_part(split_part({0}, ']', 1) , '[', 2)::integer",
                    Int::class.java,
                    REPORTS_USERREPORT.ABUSER
                ).eq(USERS_SPOONUSER.ID)
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_USERREPORT.REPORTED, base))
            .orderBy(REPORTS_USERREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(UserReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }


    /** 메일함 신고
    신고자 번호 : reporter_id -> reporter 앞부분 라이크 검색
    신고자 닉네임 : reporter_nickname -> reporter 뒷부분 라이크 검색
    편지함 메시지 작성 유저 번호 : message_author_id -> message_author
    편지함 메시지 작성 유저 닉네임 : message_author_nickname -> message_author
     * */
    override fun getReportMailBoxMessage(param: RequestReport): Pair<List<MailBoxMessageReport>, Long> {


        val MAUS = USERS_SPOONUSER.asTable("MAUS")
        val MAUP = USERS_PROFILE.asTable("MAUP")
        val RUP = USERS_PROFILE.asTable("RUP")

        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")
        var baseSearhcCondition: Condition = DSL.noCondition()

        if (base.field.equals("reporter_id")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.REPORTER.like("[${base.value}]%"))
        if (base.field.equals("reporter_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_USERREPORT.REPORTER.like("%${base.value}"))

        if (base.field.equals("message_author_id")) baseSearhcCondition =
            DSL.and(REPORTS_MAILBOXMESSAGEREPORT.MESSAGE_AUTHOR.like("[${base.value}]%"))
        if (base.field.equals("message_author_nickname")) baseSearhcCondition =
            DSL.and(REPORTS_MAILBOXMESSAGEREPORT.MESSAGE_AUTHOR.like("%${base.value}"))


        var advenceSearhcCondition: Condition = DSL.noCondition();
        param.apply {
            report_type?.let {
                advenceSearhcCondition =
                    advenceSearhcCondition.and(REPORTS_MAILBOXMESSAGEREPORT.REPORT_TYPE.eq(report_type))
            }
            is_ban?.let {
                if (it)
                    advenceSearhcCondition = advenceSearhcCondition.and(
                        MAUS.field("status")!!.cast(Integer::class.java)
                            .eq(DSL.`val`(SpoonUserStatus.BANNED.code).cast(Integer::class.java))
                    )
                else
                    advenceSearhcCondition = advenceSearhcCondition.and(
                        MAUS.field("status")!!.cast(Integer::class.java)
                            .ne(DSL.`val`(SpoonUserStatus.BANNED.code).cast(Integer::class.java))
                    )
            }
        }

        val result = postgreSqlDslContext.select(
            REPORTS_MAILBOXMESSAGEREPORT.REPORT_DESCR,
            REPORTS_MAILBOXMESSAGEREPORT.ID,
            REPORTS_MAILBOXMESSAGEREPORT.MESSAGE_AUTHOR.`as`("message_author_id"),
            REPORTS_MAILBOXMESSAGEREPORT.LIVE,
            REPORTS_MAILBOXMESSAGEREPORT.MAILBOX,
            REPORTS_MAILBOXMESSAGEREPORT.LIVE_CREATED.zonedDateTime.`as`("live_created"),
            REPORTS_MAILBOXMESSAGEREPORT.REPORT_TYPE,
            REPORTS_MAILBOXMESSAGEREPORT.MESSAGE_CONTENTS,
            REPORTS_MAILBOXMESSAGEREPORT.REPORTED.zonedDateTime.`as`("reported"),
            REPORTS_MAILBOXMESSAGEREPORT.LIVE_AUTHOR,
            REPORTS_MAILBOXMESSAGEREPORT.REPORTER.`as`("reporter_id"),
            MAUP.field("nickname")?.`as`("message_author_nickname"),
            RUP.field("nickname")?.`as`("reporter_nickname"),
            MAUS.field("status")?.`as`("message_author_status"),
            DSL.count(REPORTS_MAILBOXMESSAGEREPORT.ID).over().`as`("totalCount")
        ).from(REPORTS_MAILBOXMESSAGEREPORT)
            .leftJoin(MAUS).on(
                REPORTS_MAILBOXMESSAGEREPORT.MESSAGE_AUTHOR.cast(Integer::class.java)
                    .eq(MAUS.field("id")?.cast(Integer::class.java))
            )
            .leftJoin(MAUP)
            .on(MAUS.field("id")?.cast(Integer::class.java)!!.eq(MAUP.field("user_id")?.cast(Integer::class.java)))
            .leftJoin(RUP).on(
                REPORTS_MAILBOXMESSAGEREPORT.REPORTER.cast(Integer::class.java)
                    .eq(RUP.field("user_id")?.cast(Integer::class.java))
            )
            .where(baseSearhcCondition)
            .and(advenceSearhcCondition)
            .and(this.getDateConditional(REPORTS_MAILBOXMESSAGEREPORT.REPORTED, base))
            .orderBy(REPORTS_MAILBOXMESSAGEREPORT.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(MailBoxMessageReport::class.java)
        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }

}
