package co.spoonradio.sims.configuration.security

import co.spoonradio.arch.extension.toJson
import co.spoonradio.sims.exception.ErrorMessage
import co.spoonradio.sims.exception.UnauthorizedException
import org.opensaml.common.SAMLException
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.stereotype.Component

import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.reactive.HandlerMapping

import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @author whale@spoonradio.co
 * @date   2021/11/15.
 * @Desc
 */
@Component
class ServletExceptionHandlerFilter(val messageSource: MessageSource) : OncePerRequestFilter() {


    private fun setErrorResponse(response: HttpServletResponse, code: String = "00002") {
        val errorMessage = ErrorMessage(
            status = HttpStatus.UNAUTHORIZED.value().toString(),
            code = code,
            message = messageSource.getMessage(code, null, Locale.getDefault()),
            errorData = "",
            trace = ""
        )
        try {
            val json: String = errorMessage.toJson()
            println(json)
            response.getWriter().write(json)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

/*
        println("request > ${request.pathInfo}")
        println("request > ${request.servletPath}")
        println("request > ${request.contextPath}")

        println("HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE ${HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE}")
        println("request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE)  ${request.getAttribute(
            HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE) }")
        val map: Map<String,String>? =
            request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE) as Map<String, String>?
        println("map ${map}")

        println("request.pathTranslated ${request.pathTranslated}")
        val mp2=request.trailerFields
        println(mp2)

        println("request.method ${request.method}")*/


        try {
            filterChain.doFilter(request, response)
        } catch (ex: UnauthorizedException) {
            this.setErrorResponse(response, ex.code)
        } catch (ex: RuntimeException) {
            this.setErrorResponse(response)
        } catch (ex: SAMLException) {
        } catch (ex: CredentialsExpiredException) {
        }
    }
}