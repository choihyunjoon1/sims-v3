package co.spoonradio.sims.repository.talk

import co.spoonradio.sims.repository.postgresql.tables.references.TALKS_TALK
import co.spoonradio.sims.repository.postgresql.tables.references.TALKS_TALKVOICECOMMENT
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.jooq.impl.DSL.count
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
@Repository
class TalkRepository(val postgreSqlDslContext: DSLContext) : PostgresTalkRepository {

    override fun decreaseVoiceCommentCount(authorId: Int) {
        val TALK_COMMENT = DSL.select(TALKS_TALKVOICECOMMENT.TALK_ID, count().`as`("count"))
            .from(TALKS_TALKVOICECOMMENT)
            .where(TALKS_TALKVOICECOMMENT.AUTHOR_ID.eq(authorId))
            .groupBy(TALKS_TALKVOICECOMMENT.TALK_ID)
            .asTable("TALK_COMMENT")
        postgreSqlDslContext.update(TALKS_TALK)
            .set(TALKS_TALK.VOICE_COMMENT_COUNT, TALKS_TALK.VOICE_COMMENT_COUNT - TALK_COMMENT.field("count"))
            .from(
                TALK_COMMENT
            ).where(TALKS_TALK.ID.eq(TALK_COMMENT.field(TALKS_TALKVOICECOMMENT.TALK_ID)))
            .execute()

    }

    override fun increseVoiceCommentCount(authorId: Int) {
        val TALK_COMMENT = DSL.select(TALKS_TALKVOICECOMMENT.TALK_ID, count().`as`("count"))
            .from(TALKS_TALKVOICECOMMENT)
            .where(TALKS_TALKVOICECOMMENT.AUTHOR_ID.eq(authorId))
            .groupBy(TALKS_TALKVOICECOMMENT.TALK_ID)
            .asTable("TALK_COMMENT")
        postgreSqlDslContext.update(TALKS_TALK)
            .set(TALKS_TALK.VOICE_COMMENT_COUNT, TALKS_TALK.VOICE_COMMENT_COUNT + TALK_COMMENT.field("count"))
            .from(
                TALK_COMMENT
            ).where(TALKS_TALK.ID.eq(TALK_COMMENT.field(TALKS_TALKVOICECOMMENT.TALK_ID)))
            .execute()

    }
}