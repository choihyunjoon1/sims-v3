package co.spoonradio.sims.repository.adminuser

import co.spoonradio.sims.dto.response.adminuser.AdminUserMenuGrant
import co.spoonradio.sims.dto.response.adminuser.AdminUserInfo
import co.spoonradio.sims.repository.mysql.tables.references.ADMIN_USER
import co.spoonradio.sims.repository.mysql.tables.references.SUB_MENU
import co.spoonradio.sims.repository.mysql.tables.references.USER_MENU_AUTH
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
@Repository
class MysqlAdminUserRepository(val mysqlDslContext: DSLContext) : AdminUserRepository {

    override fun getAdminUser(email: String): AdminUserInfo? {
        return mysqlDslContext
            .select(
                ADMIN_USER.USER_ID.`as`("userId"),
                ADMIN_USER.USERNAME.`as`("userName"),
                ADMIN_USER.EMAIL
            )
            .from(ADMIN_USER)
            .where(ADMIN_USER.EMAIL.eq(email))
            .fetchOneInto(AdminUserInfo::class.java)

    }
    override fun getMenuForGrant(userId: Int): List<AdminUserMenuGrant> {
        return mysqlDslContext
            .select(
                SUB_MENU.SUB_MENU_ID,
                SUB_MENU.EN_NAME,
                SUB_MENU.API,
                SUB_MENU.API_METHOD,
                SUB_MENU.IS_NS,
                SUB_MENU.IS_USED,
                USER_MENU_AUTH.UNMASKING
            )
            .from(SUB_MENU).join(USER_MENU_AUTH)
            .on(SUB_MENU.SUB_MENU_ID.eq(USER_MENU_AUTH.SUB_MENU_ID))
            .where(USER_MENU_AUTH.USER_ID.eq(userId))
            .fetchInto(AdminUserMenuGrant::class.java)
    }

}