package co.spoonradio.sims.configuration

import co.spoonradio.sims.configuration.aws.properties.AwsLambdaInfo
import co.spoonradio.sims.configuration.feign.encoder.MultipartEncoderConfiguration
import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import co.spoonradio.sims.gateway.client.*
import feign.*
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.okhttp.OkHttpClient
import feign.slf4j.Slf4jLogger
import org.springframework.cloud.openfeign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import java.util.concurrent.TimeUnit

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@Configuration
class FeignConfiguration(
    val simsEnvInfo: SimsEnvInfo,
    val awsLambdaInfo: AwsLambdaInfo
) {
    companion object {
        private const val CONNECT_TIMEOUT_MILLIS: Long = 10000
        private const val READ_TIMEOUT_MILLIS: Long = 10000
    }

    @Bean
    fun balanceApi(): BalanceApi {
        return Feign.builder()
            .contract(SpringMvcContract())
            .client(OkHttpClient())
            .options(
                Request.Options(
                    CONNECT_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    READ_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    true
                )
            )
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            //.errorDecoder(FeignErrorDecoderException())
            .logger(Slf4jLogger())
            .logLevel(Logger.Level.FULL) //.requestInterceptor(testInterceptor)
            .target(BalanceApi::class.java, simsEnvInfo.balance)
    }


    @Bean
    fun spoonApi() = Feign.builder().apply {
        contract(SpringMvcContract())
        client(OkHttpClient())
            .options(
                Request.Options(
                    CONNECT_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    READ_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    true
                )
            )
        encoder(JacksonEncoder())
        decoder(JacksonDecoder())
        logger(Slf4jLogger())
        logLevel(Logger.Level.FULL)
        requestInterceptor(object : RequestInterceptor {
            override fun apply(template: RequestTemplate) {
                template.apply {
                    header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    header("X-Forwarded-Host", "https://kr-sims.devspoon.net/")
                }
            }
        })
    }.target(SpooncastApi::class.java, simsEnvInfo.spooncast)


    @Bean
    fun awsApiGateway(): AwsLambdaApi {
        return Feign.builder()
            .contract(SpringMvcContract())
            .client(OkHttpClient())
            .options(
                Request.Options(
                    CONNECT_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    READ_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    true
                )
            )
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            //.errorDecoder(FeignErrorDecoderException())
            .logger(Slf4jLogger("API GATEWAY"))
            .logLevel(Logger.Level.FULL) //.requestInterceptor(testInterceptor)
            .requestInterceptor(headerInterceptor())
            .target(AwsLambdaApi::class.java, awsLambdaInfo.baseUrl)
    }

    private fun headerInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header(
                "x-api-key",
                awsLambdaInfo.apiKey
            )
        }
    }

    @Bean
    fun billingApi(): BillingApi {
        return Feign.builder()
            .contract(SpringMvcContract())
            .client(OkHttpClient())
            .options(
                Request.Options(
                    CONNECT_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    READ_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    true
                )
            )
            .encoder(MultipartEncoderConfiguration().feignFormEncoder()) //multipart 용
            .decoder(JacksonDecoder())
            //.errorDecoder(FeignErrorDecoderException())
            .logger(Slf4jLogger("Billing-API"))
            .logLevel(Logger.Level.FULL)
            .requestInterceptor(billingHeaderInterceptor())
            .target(BillingApi::class.java, simsEnvInfo.billingUrl)
    }

    private fun billingHeaderInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header(
                "x-api-key",
                simsEnvInfo.billingApiKey
            )
        }
    }

    @Bean
    fun payoneerApi(): PayoneerApi {
        return Feign.builder()
            .contract(SpringMvcContract())
            .client(OkHttpClient())
            .options(
                Request.Options(
                    CONNECT_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    READ_TIMEOUT_MILLIS,
                    TimeUnit.MILLISECONDS,
                    true
                )
            )
            .encoder(JacksonEncoder()) //multipart 용
            .decoder(JacksonDecoder())
            //.errorDecoder(FeignErrorDecoderException())
            .logger(Slf4jLogger("Payoneer-api"))
            .logLevel(Logger.Level.FULL)
            .requestInterceptor(payoneerHeaderInterceptor())
            .target(PayoneerApi::class.java, simsEnvInfo.payoneerUrl)
    }

    private fun payoneerHeaderInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header(
                "Authorization",
                simsEnvInfo.payoneerAuthToken
            )
        }
    }

}
