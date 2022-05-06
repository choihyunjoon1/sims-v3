package co.spoonradio.sims.configuration

import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import co.spoonradio.sims.configuration.security.JwtRequestFilter
import co.spoonradio.sims.configuration.security.ServletExceptionHandlerFilter
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.AuthenticationException
import org.springframework.security.extensions.saml2.config.SAMLConfigurer.saml
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @author whale@spoonradio.co
 * @date   2021/11/11.
 * @Desc JWT 관련 : https://bcp0109.tistory.com/301
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfiguration(
    val apiAccessDeniedHandler: ApiAccessDeniedHandler,
    val apiAuthenticationEntryPoint: ApiAuthenticationEntryPoint,
    val servletExceptionHandlerFilter: ServletExceptionHandlerFilter,
    val jwtRequestFilter:JwtRequestFilter,
    val simsEnvInfo: SimsEnvInfo
) : WebSecurityConfigurerAdapter() {

    /** OKTA */
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .cors().and()
            .httpBasic().disable()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/saml*").permitAll()
                .anyRequest().permitAll()
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(servletExceptionHandlerFilter, JwtRequestFilter::class.java)
            .exceptionHandling()
                .authenticationEntryPoint(apiAuthenticationEntryPoint)
                .accessDeniedHandler(apiAccessDeniedHandler)
            .and()
            .apply(saml())
                .serviceProvider()
                    /** TODO : SSL통신을 ELB를 통해할것이기 때문에 굳이 필요하진 않다, 없으면 에러 발생. 추후에 수정해야할것. */
                    .keyStore()
                        .storeFilePath("classpath:saml/keystore.jks")
                        .password("secret")
                        .keyname("spring")
                        .keyPassword("secret")
                        .and()
                    .protocol("http")
                        .hostname(String.format("%s:%s", "localhost", 8080)) //TODO DEV / STG / PROD 별로 설정
                        .basePath("/v3/sims")
                        .and()
            .identityProvider()
            .metadataFilePath(simsEnvInfo.oktaMetadataPath) //TODO DEV / STG / PROD 별로 설정
    }

}



@Component
class ApiAccessDeniedHandler : AccessDeniedHandler {

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: org.springframework.security.access.AccessDeniedException?
    ) {
        val om = ObjectMapper()
        response.apply {
            characterEncoding = StandardCharsets.UTF_8.name()
            contentType = MediaType.APPLICATION_JSON_VALUE
            status = HttpStatus.UNAUTHORIZED.value()
            writer?.write(
                om.writeValueAsString("ERROR")
            )
        }
    }
}

@Component
class ApiAuthenticationEntryPoint : AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException?
    ) {
        response.apply {
            characterEncoding = StandardCharsets.UTF_8.name()
            contentType = MediaType.APPLICATION_JSON_VALUE
            status = HttpStatus.UNAUTHORIZED.value()
            writer?.write("ERROR")
        }
    }
}
