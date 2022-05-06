package co.spoonradio.sims.repository.users

import co.spoonradio.sims.repository.postgresql.tables.references.USERS_FOLLOW
import co.spoonradio.sims.repository.postgresql.tables.references.USERS_PROFILE
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
@Repository
class UsersFollowRepository(val postgreSqlDslContext: DSLContext) : PostgresUsersFollowRepository {


    override fun decreaseFan(fromUserId: Int) {
        postgreSqlDslContext.update(USERS_PROFILE)
            .set(USERS_PROFILE.FAN_COUNT, USERS_PROFILE.FAN_COUNT - 1)
            .from(USERS_FOLLOW)
            .where(USERS_FOLLOW.TO_USER_ID.eq(USERS_PROFILE.USER_ID))
            .and(USERS_FOLLOW.FROM_USER_ID.eq(fromUserId))
            .execute()
    }

    override fun increseFan(fromUserId: Int) {
        postgreSqlDslContext.update(USERS_PROFILE)
            .set(USERS_PROFILE.FAN_COUNT, USERS_PROFILE.FAN_COUNT + 1)
            .from(USERS_FOLLOW)
            .where(USERS_FOLLOW.TO_USER_ID.eq(USERS_PROFILE.USER_ID))
            .and(USERS_FOLLOW.FROM_USER_ID.eq(fromUserId))
            .execute()
    }
}