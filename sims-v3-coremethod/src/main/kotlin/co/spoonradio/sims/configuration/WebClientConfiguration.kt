package co.spoonradio.sims.configuration

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.web.reactive.function.client.*
import reactor.core.publisher.Mono
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient
import java.util.function.Consumer

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc reactive 처리 시 설정한다.
 */

class WebClientConfiguration {
  /*  companion object {
        private val READ_TIMEOUT_SECOND = 10
        private val WRITE_TIMEOUT_SECOND = 10
        private val CONNECT_TIMEOUT_SECOND = 10
        private val EXCHANGE_MEMORY = 1 * 1024 * 1024
    }

    fun balanceHttpClient(): WebClient {
        val httpClient: HttpClient? = this.getHttpClient()
        return this.setFilter(
            WebClient.builder()
                .baseUrl("http://kr-balance-api.devspoon.net/v1/balance")
                .clientConnector(httpClient?.let {
                    ReactorClientHttpConnector(it)
                }!!)
        )
    }

    fun setFilter(webClient: WebClient.Builder) =
        webClient.filter(ExchangeFilterFunction.ofRequestProcessor { clientRequest: ClientRequest ->
            println("Request: ${clientRequest.method()} ${clientRequest.url()}")
            clientRequest.headers().forEach { name: String?, values: List<String?> ->
                values.forEach(
                    Consumer { value: String? ->
                        println("$name : $value")
                    })
            }
            Mono.just(clientRequest)
        })
            .filter(
                ExchangeFilterFunction.ofResponseProcessor { clientResponse: ClientResponse ->
                    println(">>>>>>>>>> RESPONSE <<<<<<<<<<")
                    clientResponse.headers().asHttpHeaders()
                        .forEach { name: String?, values: List<String?> ->
                            values.forEach(
                                Consumer { value: String? ->
                                    println("$name : $value")
                                })
                        }
                    Mono.just(clientResponse)
                }
            ).exchangeStrategies(
                ExchangeStrategies.builder()
                    .codecs { configurer: ClientCodecConfigurer ->
                        configurer.defaultCodecs().maxInMemorySize(EXCHANGE_MEMORY)
                    }
                    .build()
            ).build()


    fun getHttpClient() = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECT_TIMEOUT_SECOND * 1000)
        .doOnConnected { conn: Connection ->
            conn.addHandlerLast(ReadTimeoutHandler(READ_TIMEOUT_SECOND))
                .addHandlerLast(WriteTimeoutHandler(WRITE_TIMEOUT_SECOND))
        }*/
}