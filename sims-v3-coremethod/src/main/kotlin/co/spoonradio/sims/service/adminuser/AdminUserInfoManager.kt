package co.spoonradio.sims.service.adminuser

import co.spoonradio.sims.dto.response.adminuser.AdminUserInfo
import co.spoonradio.sims.dto.response.adminuser.AdminUserMenuGrant
import co.spoonradio.sims.exception.GeneralException
import org.slf4j.MDC

/**
 * @author whale@spoonradio.co
 * @date   2021/12/02.
 * @Desc
 */
object AdminUserInfoManager {
    val userInfoMap = mutableMapOf<String, AdminUserInfo>()
    val userGrantMap = mutableMapOf<String, Map<String, List<AdminUserMenuGrant>>>()


    fun setUserInfo(token: String, userInfo: AdminUserInfo) {
        userInfoMap.put(token, userInfo)
    }

    fun setMenuGrantInfo(token: String, userGrantInfo: Map<String, List<AdminUserMenuGrant>>) {
        userGrantMap.put(token, userGrantInfo)
    }

    fun getUserInfo(): AdminUserInfo {
        return userInfoMap.get(MDC.get("TOKEN")) ?: AdminUserInfo(
            userId=1,
            userName = "whale",
            email = "whale@spoonradio.co"
        )//throw GeneralException("00004")
    }

    fun getGrantInfo(): Map<String, List<AdminUserMenuGrant>> {
        return userGrantMap.get(MDC.get("TOKEN")) ?: throw GeneralException("00004")
    }
}