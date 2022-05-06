package co.spoonradio.sims.configuration.feign.encoder;

import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MultipartEncoderConfiguration {
    @Autowired
    private val messageConverters: ObjectFactory<HttpMessageConverters>? = null
    @Bean
    fun feignFormEncoder(): Encoder {
        return SpringFormEncoder(
            SpringEncoder(messageConverters)
        )
    }
}