package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.common.extension.zonedDateTime
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.RequestRegistUnfitWord
import co.spoonradio.sims.dto.request.voc.RequestUnfitWord
import co.spoonradio.sims.dto.response.voc.unfit.UnfitWord
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.condition.CommonCondition
import co.spoonradio.sims.repository.postgresql.tables.references.COMMONS_UNFITWORD
import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.jooq.impl.DSL
import org.jooq.impl.DSL.noCondition
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

@Repository
class PostgresUnfitWordRepository(val postgreSqlDslContext: DSLContext) : UnfitWordRepository, CommonCondition() {
    override fun getUnfitWord(param: RequestUnfitWord): Pair<List<UnfitWord>, Long> {
        val base: RequestBaseDto = param.base ?: throw GeneralException("00005")

        val baseSearchCondition = if (base.field.equals("word"))
            COMMONS_UNFITWORD.field(base.field)!!.like("%" + base.value+"%")
        else
            noCondition()

        var advanceSearchCondition : Condition = noCondition()
        if(param.to_nickname != null) advanceSearchCondition = advanceSearchCondition.and(COMMONS_UNFITWORD.TO_NICKNAME.eq(param.to_nickname))
        if(param.to_contents != null) advanceSearchCondition = advanceSearchCondition.and(COMMONS_UNFITWORD.TO_CONTENTS.eq(param.to_contents))
        if(param.is_used != null) advanceSearchCondition = advanceSearchCondition.and(COMMONS_UNFITWORD.IS_USED.eq(param.is_used))

        val result =  postgreSqlDslContext
            .select(
                COMMONS_UNFITWORD.ID,
                COMMONS_UNFITWORD.WORD,
                COMMONS_UNFITWORD.TO_CONTENTS,
                COMMONS_UNFITWORD.TO_NICKNAME,
                COMMONS_UNFITWORD.IS_USED,
                COMMONS_UNFITWORD.CREATED.zonedDateTime.`as`("created"),
                COMMONS_UNFITWORD.REWORD,
                DSL.count(COMMONS_UNFITWORD.ID).over().`as`("totalCount")
            )
            .from(COMMONS_UNFITWORD)
            .where(baseSearchCondition)
            .and(advanceSearchCondition)
            .and(this.getDateConditional(COMMONS_UNFITWORD.CREATED, base))
            .orderBy(COMMONS_UNFITWORD.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(UnfitWord::class.java)

        return Pair(result, result.getOrNull(0)?.totalCount ?: 0L)
    }

    override fun getUnfitWordById(unfitWordId: Int): UnfitWord? {
        return postgreSqlDslContext
            .select(
                COMMONS_UNFITWORD.ID,
                COMMONS_UNFITWORD.WORD,
                COMMONS_UNFITWORD.TO_CONTENTS,
                COMMONS_UNFITWORD.TO_NICKNAME,
                COMMONS_UNFITWORD.IS_USED,
                COMMONS_UNFITWORD.CREATED.zonedDateTime.`as`("created"),
                COMMONS_UNFITWORD.REWORD
            )
            .from(COMMONS_UNFITWORD)
            .where(COMMONS_UNFITWORD.ID.eq(unfitWordId))
            .fetchOneInto(UnfitWord::class.java)
    }

    override fun createUnfitWord(param: RequestRegistUnfitWord): Int {
        val now = OffsetDateTime.now(ZoneId.of("UTC")).truncatedTo(ChronoUnit.MILLIS)
        try {
            return postgreSqlDslContext
                .insertInto(COMMONS_UNFITWORD)
                .columns(
                    COMMONS_UNFITWORD.WORD,
                    COMMONS_UNFITWORD.TO_CONTENTS,
                    COMMONS_UNFITWORD.TO_NICKNAME,
                    COMMONS_UNFITWORD.IS_USED,
                    COMMONS_UNFITWORD.CREATED,
                    COMMONS_UNFITWORD.REWORD
                )
                .values(param.word, param.to_contents, param.to_nickname, param.is_used, now, param.reword)
                .execute()
        } catch (e: DataAccessException) {
            throw GeneralException("00006")
        }
    }

    override fun getUnfitWordByWord(word: String): UnfitWord? {
        return postgreSqlDslContext
            .select(
                COMMONS_UNFITWORD.ID,
                COMMONS_UNFITWORD.WORD,
                COMMONS_UNFITWORD.TO_CONTENTS,
                COMMONS_UNFITWORD.TO_NICKNAME,
                COMMONS_UNFITWORD.IS_USED,
                COMMONS_UNFITWORD.CREATED.zonedDateTime.`as`("created"),
                COMMONS_UNFITWORD.REWORD
            )
            .from(COMMONS_UNFITWORD)
            .where(COMMONS_UNFITWORD.WORD.eq(word))
            .fetchOneInto(UnfitWord::class.java)
    }

    override fun modifyUnfitWord(param: RequestRegistUnfitWord): Int {
        val affectedRow = postgreSqlDslContext
            .update(COMMONS_UNFITWORD)
            .set(COMMONS_UNFITWORD.WORD, param.word)
            .set(COMMONS_UNFITWORD.TO_CONTENTS, param.to_contents)
            .set(COMMONS_UNFITWORD.TO_NICKNAME, param.to_nickname)
            .set(COMMONS_UNFITWORD.IS_USED, param.is_used)
            .set(COMMONS_UNFITWORD.REWORD, param.reword)
            .where(COMMONS_UNFITWORD.ID.eq(param.id))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00008")
    }

    override fun deleteUnfitWord(unfitWordId: Int): Int {
        val affectedRow = postgreSqlDslContext
            .delete(COMMONS_UNFITWORD)
            .where(COMMONS_UNFITWORD.ID.eq(unfitWordId))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00009")
    }
}