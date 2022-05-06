package co.spoonradio.sims.repository.fanboard

import co.spoonradio.sims.repository.postgresql.tables.references.FANBOARD_FANCOMMENT
import co.spoonradio.sims.repository.postgresql.tables.references.FANBOARD_FANMESSAGE
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
@Repository
class FanboardRepository(val postgreSqlDslContext: DSLContext) : PostgresFanboardRepository {
    override fun decreaseMessageCount(authorId: Int) {
        val FANMESSAGE = DSL.select(FANBOARD_FANMESSAGE.COMMENT_ID, DSL.count().`as`("count"))
            .from(FANBOARD_FANMESSAGE)
            .where(FANBOARD_FANMESSAGE.AUTHOR_ID.eq(authorId))
            .groupBy(FANBOARD_FANMESSAGE.COMMENT_ID)
            .asTable("FANMESSAGE")

        postgreSqlDslContext.update(FANBOARD_FANCOMMENT)
            .set(FANBOARD_FANCOMMENT.MESSAGE_COUNT, FANBOARD_FANCOMMENT.MESSAGE_COUNT - FANMESSAGE.field("count"))
            .from(
                FANMESSAGE
            ).where(FANBOARD_FANCOMMENT.ID.eq(FANMESSAGE.field(FANBOARD_FANMESSAGE.COMMENT_ID)))
            .execute()
    }

    override fun increseMessageCount(authorId: Int) {
        val FANMESSAGE = DSL.select(FANBOARD_FANMESSAGE.COMMENT_ID, DSL.count().`as`("count"))
            .from(FANBOARD_FANMESSAGE)
            .where(FANBOARD_FANMESSAGE.AUTHOR_ID.eq(authorId))
            .groupBy(FANBOARD_FANMESSAGE.COMMENT_ID)
            .asTable("FANMESSAGE")

        postgreSqlDslContext.update(FANBOARD_FANCOMMENT)
            .set(FANBOARD_FANCOMMENT.MESSAGE_COUNT, FANBOARD_FANCOMMENT.MESSAGE_COUNT + FANMESSAGE.field("count"))
            .from(
                FANMESSAGE
            ).where(FANBOARD_FANCOMMENT.ID.eq(FANMESSAGE.field(FANBOARD_FANMESSAGE.COMMENT_ID)))
            .execute()
    }
}