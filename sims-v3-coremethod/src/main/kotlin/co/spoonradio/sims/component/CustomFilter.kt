package co.spoonradio.sims.component

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author whale@spoonradio.co
 * @date   2021/11/22.
 * @Desc  로그인 할 때 JWT 생성하여 REDIS로 관리하도록 한다.
 */
@Component
class CustomFilter {

    /*
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, filter: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        try {
            val authentication: Authentication = this.getAuthentication(httpRequest)
            SecurityContextHolder.getContext().authentication = authentication
            filter.doFilter(httpRequest, httpResponse)
        } catch (e: RuntimeException) {
            e.printStackTrace()
        }
    }

    fun getAuthentication(httpRequest: HttpServletRequest): UsernamePasswordAuthenticationToken {
        //var token = httpRequest.getHeader("X-TOKEN")
        val userInfo = UserInfo(
            userId = 126,
            userEmail = "whale@spoonradio.co",
            userName = "whale"
        )

        return UsernamePasswordAuthenticationToken(
            userInfo,
            null,
            ArrayList()
        )
    }
*/

}