package co.spoonradio.sims.filter

import co.spoonradio.arch.logger.Logger
import org.apache.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

/**
 * @author whale@spoonradio.co
 * @date   2021/08/11.
 * @Desc
 * @Ref https://newbedev.com/how-to-log-request-and-response-bodies-in-spring-webflux
 */

@Component
class WebLogging (val requestLogger: RequestLogger) : WebFilter {
    companion object : Logger

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        logger.info(requestLogger.getRequestMessage(exchange))
        val filter = chain.filter(exchange)
        exchange.response.beforeCommit {
           // logger.info(requestLogger.getResponseMessage(exchange))
            Mono.empty()
        }
        return filter
    }
}

@Component
class RequestLogger {
    fun getRequestMessage(exchange: ServerWebExchange): String {
        val request = exchange.request
        val method = request.method
        val path = request.uri.path
        val acceptableMediaTypes = request.headers.accept
        val contentType = request.headers.contentType
        return ">>> $method $path ${HttpHeaders.ACCEPT}: $acceptableMediaTypes ${HttpHeaders.CONTENT_TYPE}: $contentType"
    }
}