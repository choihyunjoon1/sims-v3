package co.spoonradio.sims.service.adminuser

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
interface AdminUserService {
    fun generateAdminUserInfo(email: String): String
}