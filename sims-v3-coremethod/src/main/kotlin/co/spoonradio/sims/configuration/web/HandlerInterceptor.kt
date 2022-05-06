package co.spoonradio.sims.configuration.web

import co.spoonradio.arch.logger.Logger
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@Component
class HandlerInterceptor : HandlerInterceptor {

    companion object : Logger

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        //logger.info("================ Before Method")
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        //logger.info("================ Method Executed")
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        //logger.info("================ Method Completed")
    }


}