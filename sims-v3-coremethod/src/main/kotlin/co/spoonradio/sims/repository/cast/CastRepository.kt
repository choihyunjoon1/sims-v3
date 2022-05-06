package co.spoonradio.sims.repository.cast

import co.spoonradio.sims.repository.postgresql.tables.references.CASTS_CAST
import co.spoonradio.sims.repository.postgresql.tables.references.CASTS_TEXTCOMMENT
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
@Repository
class CastRepository(val postgreSqlDslContext: DSLContext): PostgresCastRepository {
    override fun decreaseTextCommentCount(authorId: Int) {
        val CAST_COMMENT = DSL.select(CASTS_TEXTCOMMENT.CAST_ID, DSL.count().`as`("count"))
            .from(CASTS_TEXTCOMMENT)
            .where(CASTS_TEXTCOMMENT.AUTHOR_ID.eq(authorId))
            .groupBy(CASTS_TEXTCOMMENT.CAST_ID)
            .asTable("CAST_COMMENT")

        postgreSqlDslContext.update(CASTS_CAST)
            .set(CASTS_CAST.TEXT_COMMENT_COUNT, CASTS_CAST.TEXT_COMMENT_COUNT - CAST_COMMENT.field("count"))
            .from(
                CAST_COMMENT
            ).where(CASTS_CAST.ID.eq(CAST_COMMENT.field(CASTS_TEXTCOMMENT.CAST_ID)))
            .execute()
    }

    override fun increseTextCommentCount(authorId: Int) {
        val CAST_COMMENT = DSL.select(CASTS_TEXTCOMMENT.CAST_ID, DSL.count().`as`("count"))
            .from(CASTS_TEXTCOMMENT)
            .where(CASTS_TEXTCOMMENT.AUTHOR_ID.eq(authorId))
            .groupBy(CASTS_TEXTCOMMENT.CAST_ID)
            .asTable("CAST_COMMENT")

        postgreSqlDslContext.update(CASTS_CAST)
            .set(CASTS_CAST.TEXT_COMMENT_COUNT, CASTS_CAST.TEXT_COMMENT_COUNT + CAST_COMMENT.field("count"))
            .from(
                CAST_COMMENT
            ).where(CASTS_CAST.ID.eq(CAST_COMMENT.field(CASTS_TEXTCOMMENT.CAST_ID)))
            .execute()
    }
}