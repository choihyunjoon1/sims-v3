package co.spoonradio.sims.controller

import co.spoonradio.sims.dto.request.account.RequestLogin
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.service.adminuser.DefaultAdminUserService
import io.swagger.annotations.ApiOperation
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken
import org.springframework.security.saml.SAMLCredential
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author whale@spoonradio.co
 * @date   2021/11/28.
 * @Desc https://www.baeldung.com/spring-security-saml
 */
@RestController
class SimsMainController(
    val adminUserService: DefaultAdminUserService
) {

    @ApiOperation(value = "MAIN", notes = "")
    @GetMapping(value = ["/"])
    fun main(userToken: ExpiringUsernameAuthenticationToken, model: Model): String? { //
        val credential: SAMLCredential = userToken.credentials as SAMLCredential
        val email: String = credential.getAttributeAsString("email")
        return adminUserService.generateAdminUserInfo(email)
    }

    @ApiOperation(value = "LOGIN", notes = "")
    @PostMapping(value = ["/login"])
    fun login(@RequestBody requestLogin: RequestLogin): String {
        return adminUserService.generateAdminUserInfo(requestLogin.email?: throw GeneralException("00034"))
    }

}