package co.spoonradio.sims.repository.users

import co.spoonradio.sims.common.extension.birthdayMasking
import co.spoonradio.sims.common.extension.nameMasking
import co.spoonradio.sims.common.extension.zonedDateTime
import co.spoonradio.sims.dto.response.users.UserProfileEntity
import co.spoonradio.sims.dto.response.users.UsersSnsInfo
import co.spoonradio.sims.repository.postgresql.tables.UsersAccount.Companion.USERS_ACCOUNT
import co.spoonradio.sims.repository.postgresql.tables.references.*
import org.jooq.DSLContext
import org.slf4j.MDC
import org.springframework.stereotype.Repository
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/11/26.
 * @Desc
 */
@Repository
class UserProfileRepository(val postgreSqlDslContext: DSLContext) : PostgresUserProfileRepository {

    override fun findUserIdByTag(tag: String): Int? {
        return postgreSqlDslContext.select(USERS_PROFILE.USER_ID)
            .from(USERS_PROFILE)
            .where(USERS_PROFILE.TAG.eq(tag))
            .fetchOne()?.getValue(USERS_PROFILE.USER_ID)
    }

    override fun findUserIdByNickname(nickname: String): List<Int> {
        return postgreSqlDslContext.select()
            .from(USERS_PROFILE)
            .where(USERS_PROFILE.NICKNAME.eq(nickname))
            .fetch(USERS_PROFILE.USER_ID, Int::class.java)
    }

    override fun decreaseMyCount(toUserId: Int) {
        postgreSqlDslContext.update(USERS_PROFILE)
            .set(USERS_PROFILE.MY_COUNT, USERS_PROFILE.MY_COUNT - 1)
            .from(USERS_FOLLOW)
            .where(USERS_FOLLOW.FROM_USER_ID.eq(USERS_PROFILE.USER_ID))
            .and(USERS_FOLLOW.TO_USER_ID.eq(toUserId))
            .execute()
    }

    override fun increseMyCount(toUserId: Int) {
        postgreSqlDslContext.update(USERS_PROFILE)
            .set(USERS_PROFILE.MY_COUNT, USERS_PROFILE.MY_COUNT + 1)
            .from(USERS_FOLLOW)
            .where(USERS_FOLLOW.FROM_USER_ID.eq(USERS_PROFILE.USER_ID))
            .and(USERS_FOLLOW.TO_USER_ID.eq(toUserId))
            .execute()
    }

    override fun getUserSnsInfo(spoonUserId: Int): UsersSnsInfo? {
        return postgreSqlDslContext.select(
            USERS_ACCOUNT.SNS_ID,
            USERS_ACCOUNT.SNS_TYPE,
            USERS_PROFILE.ID,
            USERS_PROFILE.TAG
        )
            .from(USERS_PROFILE).join(USERS_ACCOUNT)
            .on(USERS_PROFILE.ID.eq(USERS_ACCOUNT.USER_ID))
            .where(USERS_PROFILE.ID.eq(spoonUserId))
            .fetchOneInto(UsersSnsInfo::class.java)
    }
    override fun findUserProfileByTierId(tierId: Int): MutableMap<Int?, UserProfileEntity> {
        return postgreSqlDslContext.select(
            USERS_SPOONUSER.ID,
            USERS_PROFILE.TAG,
            USERS_PROFILE.NICKNAME,
            USERS_SPOONUSER.STATUS,
            USERS_AUTHORTIER.NAME.`as`("tierName"),
            NICE_NICEAUTHUSERINFO.ID.`as`("niceId"),
            NICE_NICEAUTHUSERINFO.NAME.`as`("niceName"),
            NICE_NICEAUTHUSERINFO.GENDER.`as`("niceGender"),
            NICE_NICEAUTHUSERINFO.BIRTH_DATE.`as`("niceBirthDate"),
            NICE_NICEAUTHUSERINFO.CREATED.zonedDateTime.`as`("niceCreated"),
        ).from(USERS_SPOONUSER)
            .join(USERS_PROFILE).on(USERS_SPOONUSER.ID.eq(USERS_PROFILE.USER_ID))
            .leftJoin(NICE_NICEAUTHUSERINFO).on(USERS_SPOONUSER.ID.eq(NICE_NICEAUTHUSERINFO.USER_ID))
            .leftJoin(USERS_AUTHORTIERUSER).on(USERS_PROFILE.USER_ID.eq(USERS_AUTHORTIERUSER.USER_ID))
            .leftJoin(USERS_AUTHORTIER).on(USERS_AUTHORTIERUSER.TIER_ID.eq(USERS_AUTHORTIER.ID))
            .where(USERS_AUTHORTIERUSER.TIER_ID.eq(tierId))
            .fetchMap(USERS_SPOONUSER.ID, UserProfileEntity::class.java)
    }

    override fun findUserProfileByNickname(nickName: String): MutableMap<Int?, UserProfileEntity> {
        return postgreSqlDslContext.select(
            USERS_SPOONUSER.ID,
            USERS_PROFILE.TAG,
            USERS_PROFILE.NICKNAME,
            USERS_SPOONUSER.STATUS,
            USERS_AUTHORTIER.NAME.`as`("tierName"),
            NICE_NICEAUTHUSERINFO.ID.`as`("niceId"),
            NICE_NICEAUTHUSERINFO.NAME.`as`("niceName"),
            NICE_NICEAUTHUSERINFO.GENDER.`as`("niceGender"),
            NICE_NICEAUTHUSERINFO.BIRTH_DATE.`as`("niceBirthDate"),
            NICE_NICEAUTHUSERINFO.CREATED.zonedDateTime.`as`("niceCreated"),
        ).from(USERS_SPOONUSER)
            .join(USERS_PROFILE).on(USERS_SPOONUSER.ID.eq(USERS_PROFILE.USER_ID))
            .leftJoin(NICE_NICEAUTHUSERINFO).on(USERS_SPOONUSER.ID.eq(NICE_NICEAUTHUSERINFO.USER_ID))
            .leftJoin(USERS_AUTHORTIERUSER).on(USERS_PROFILE.USER_ID.eq(USERS_AUTHORTIERUSER.USER_ID))
            .leftJoin(USERS_AUTHORTIER).on(USERS_AUTHORTIERUSER.TIER_ID.eq(USERS_AUTHORTIER.ID))
            .where(USERS_PROFILE.NICKNAME.eq(nickName))
            .fetchMap(USERS_SPOONUSER.ID, UserProfileEntity::class.java)
    }
    override fun findUserProfileByUserIds(userIds: List<Int>): MutableMap<Int?, UserProfileEntity> {
        val users = postgreSqlDslContext.select(
            USERS_SPOONUSER.ID,
            USERS_PROFILE.TAG,
            USERS_PROFILE.NICKNAME,
            USERS_SPOONUSER.STATUS,
            USERS_AUTHORTIER.NAME.`as`("tierName"),
            NICE_NICEAUTHUSERINFO.ID.`as`("niceId"),
            NICE_NICEAUTHUSERINFO.NAME.`as`("niceName"),
            NICE_NICEAUTHUSERINFO.GENDER.`as`("niceGender"),
            NICE_NICEAUTHUSERINFO.BIRTH_DATE.`as`("niceBirthDate"),
            NICE_NICEAUTHUSERINFO.CREATED.zonedDateTime.`as`("niceCreated"),
        ).from(USERS_SPOONUSER)
            .join(USERS_PROFILE).on(USERS_SPOONUSER.ID.eq(USERS_PROFILE.USER_ID))
            .leftJoin(NICE_NICEAUTHUSERINFO).on(USERS_SPOONUSER.ID.eq(NICE_NICEAUTHUSERINFO.USER_ID))
            .leftJoin(USERS_AUTHORTIERUSER).on(USERS_PROFILE.USER_ID.eq(USERS_AUTHORTIERUSER.USER_ID))
            .leftJoin(USERS_AUTHORTIER).on(USERS_AUTHORTIERUSER.TIER_ID.eq(USERS_AUTHORTIER.ID))
            .where(USERS_SPOONUSER.ID.`in`(userIds))
            .fetch()

       val result: MutableMap<Int?, UserProfileEntity> = mutableMapOf()
        if (MDC.get("UNMASKING").equals("true")) {
            users.map { record ->
                result.put(record.get(USERS_SPOONUSER.ID, Int::class.java), UserProfileEntity(
                    record.get(USERS_PROFILE.ID, Int::class.java),
                    record.get(USERS_PROFILE.TAG, String::class.java),
                    record.get(USERS_PROFILE.NICKNAME, String::class.java),
                    record.get(USERS_SPOONUSER.STATUS, Int::class.java),
                    record.get("tierName", String::class.java),
                    record.get("niceId", Long::class.java),
                    record.get("niceName", String::class.java)?.nameMasking,
                    record.get("niceGender", Int::class.java),
                    record.get("niceBirthDate", String::class.java)?.birthdayMasking,
                    record.get("niceCreated", ZonedDateTime::class.java),
                ))
            }
        } else {
            users.map { record ->
                result.put(record.get(USERS_SPOONUSER.ID, Int::class.java), UserProfileEntity(
                    record.get(USERS_PROFILE.ID, Int::class.java),
                    record.get(USERS_PROFILE.TAG, String::class.java),
                    record.get(USERS_PROFILE.NICKNAME, String::class.java),
                    record.get(USERS_SPOONUSER.STATUS, Int::class.java),
                    record.get("tierName", String::class.java),
                    record.get("niceId", Long::class.java),
                    record.get("niceName", String::class.java),
                    record.get("niceGender", Int::class.java),
                    record.get("niceBirthDate", String::class.java),
                    record.get("niceCreated", ZonedDateTime::class.java),
                ))
            }
        }

        return result
    }

    override fun findUserProfileByTag(tag: String): MutableMap<Int?, UserProfileEntity> {
        return postgreSqlDslContext.select(
            USERS_SPOONUSER.ID,
            USERS_PROFILE.TAG,
            USERS_PROFILE.NICKNAME,
            USERS_SPOONUSER.STATUS,
            USERS_AUTHORTIER.NAME.`as`("tierName"),
            NICE_NICEAUTHUSERINFO.ID.`as`("niceId"),
            NICE_NICEAUTHUSERINFO.NAME.`as`("niceName"),
            NICE_NICEAUTHUSERINFO.GENDER.`as`("niceGender"),
            NICE_NICEAUTHUSERINFO.BIRTH_DATE.`as`("niceBirthDate"),
            NICE_NICEAUTHUSERINFO.CREATED.zonedDateTime.`as`("niceCreated"),
        ).from(USERS_SPOONUSER)
            .join(USERS_PROFILE).on(USERS_SPOONUSER.ID.eq(USERS_PROFILE.USER_ID))
            .leftJoin(NICE_NICEAUTHUSERINFO).on(USERS_SPOONUSER.ID.eq(NICE_NICEAUTHUSERINFO.USER_ID))
            .leftJoin(USERS_AUTHORTIERUSER).on(USERS_PROFILE.USER_ID.eq(USERS_AUTHORTIERUSER.USER_ID))
            .leftJoin(USERS_AUTHORTIER).on(USERS_AUTHORTIERUSER.TIER_ID.eq(USERS_AUTHORTIER.ID))
            .where(USERS_PROFILE.TAG.eq(tag))
            .fetchMap(USERS_SPOONUSER.ID, UserProfileEntity::class.java)
    }
}