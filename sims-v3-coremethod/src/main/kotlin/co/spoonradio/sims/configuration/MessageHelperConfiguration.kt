package co.spoonradio.sims.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@Configuration
class MessageHelperConfiguration {
    @Bean
    fun messageSource() = ReloadableResourceBundleMessageSource().apply {
        setBasename("classpath:message/messages")
        setDefaultEncoding("UTF-8")
        setCacheSeconds(60)
    }

    /**
     * 변경된 언어 정보를 기억할 로케일 리졸버 생성.
     */
    /*@Bean
    fun localeResolver() = SessionLocaleResolver().apply { setDefaultLocale(Locale.US) }*/
}