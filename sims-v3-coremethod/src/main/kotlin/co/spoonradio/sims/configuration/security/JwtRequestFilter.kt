package co.spoonradio.sims.configuration.security

import co.spoonradio.sims.common.`object`.ExcludeUrl
import co.spoonradio.sims.exception.UnauthorizedException
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @author whale@spoonradio.co
 * @date   2021/11/15.
 * @Desc
 */
@Component
class JwtRequestFilter(
    val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        //true : filter를 타지 않음.
       // return true
       return ExcludeUrl.isMatch(request.servletPath)
    }

    override fun doFilterInternal(
        req: HttpServletRequest,
        res: HttpServletResponse,
        filterChain: FilterChain
    ) {
        //TOKEN VALIDATION
        //todo : [COREMETHOD] token validation은 해제하며, 존재유무만 판단한다.@whale:2022.05.04
        /*val token: String = jwtTokenProvider.resolveToken(req) ?: throw UnauthorizedException("00002")
        if (jwtTokenProvider.isTokenExpired(token)) throw UnauthorizedException("00003")*/
        val token = req.getHeader("X-TOKEN")?: throw UnauthorizedException("00002")

        MDC.put("TOKEN", token)
        filterChain.doFilter(req, res)
    }
}