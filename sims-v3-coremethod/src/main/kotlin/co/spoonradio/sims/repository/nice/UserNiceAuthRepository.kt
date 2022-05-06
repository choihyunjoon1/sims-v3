package co.spoonradio.sims.repository.nice

import co.spoonradio.sims.dto.response.users.NiceInfo
import co.spoonradio.sims.repository.postgresql.tables.references.NICE_NICEAUTHUSERINFO
import org.jooq.DSLContext
import org.springframework.stereotype.Repository


@Repository
class UserNiceAuthRepository(val postgreSqlDslContext: DSLContext) : PostgresUserNiceAuthRepository {
    override fun findNiceAuthByUserIds(userIds: List<Int>): MutableMap<Int?, NiceInfo>? {
        return postgreSqlDslContext.select(
            NICE_NICEAUTHUSERINFO.ID,
            NICE_NICEAUTHUSERINFO.USER_ID,
            NICE_NICEAUTHUSERINFO.NAME,
            NICE_NICEAUTHUSERINFO.GENDER,
            NICE_NICEAUTHUSERINFO.BIRTH_DATE,
            NICE_NICEAUTHUSERINFO.CREATED
        ).from(NICE_NICEAUTHUSERINFO)
            .where(NICE_NICEAUTHUSERINFO.USER_ID.`in`(userIds))
            .fetchMap(NICE_NICEAUTHUSERINFO.USER_ID, NiceInfo::class.java)
    }
}