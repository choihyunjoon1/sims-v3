package co.spoonradio.sims.repository.adminuser

import co.spoonradio.sims.dto.response.adminuser.AdminUserMenuGrant
import co.spoonradio.sims.dto.response.adminuser.AdminUserInfo

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
interface AdminUserRepository {
    fun getAdminUser(email:String):AdminUserInfo?
    fun getMenuForGrant(userId:Int):List<AdminUserMenuGrant>
}