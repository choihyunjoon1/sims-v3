package co.spoonradio.sims.service.adminuser

import co.spoonradio.sims.configuration.security.JwtTokenProvider
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.adminuser.AdminUserRepository
import org.slf4j.MDC
import org.springframework.stereotype.Service

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc
 */
@Service
class DefaultAdminUserService(
    val jwtTokenProvider: JwtTokenProvider,
    val mysqlAdminUserRepository: AdminUserRepository
) : AdminUserService {

    override fun generateAdminUserInfo(email: String): String {
        /** AccessToken 생성*/
        val adminUserInfo = mysqlAdminUserRepository.getAdminUser(email) ?: throw GeneralException("00001")
        val adminUserMenuGrantInfo = mysqlAdminUserRepository.getMenuForGrant(adminUserInfo.userId)

        val token = adminUserInfo.let { jwtTokenProvider.makeJwt(it) }

        /** AdminUser를 Redis에 등록*/
        token.let {
            AdminUserInfoManager.userInfoMap
                .forEach { entry ->
                    if(entry.value.email == email) {
                        AdminUserInfoManager.userInfoMap.remove(entry.key)
                        AdminUserInfoManager.userGrantMap.remove(entry.key)
                    }
                }

            AdminUserInfoManager.setUserInfo(it, adminUserInfo)
            AdminUserInfoManager.setMenuGrantInfo(it, adminUserMenuGrantInfo.groupBy { value -> value.api + value.api_method })
            MDC.put("TOKEN", it)
        }

        return token
    }


}