package co.spoonradio.sims.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.*
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor


/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@Configuration
class WebConfiguration(val HandlerInterceptor: HandlerInterceptor) : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
    }


    override fun addInterceptors(reg: InterceptorRegistry) {
        reg.addInterceptor(HandlerInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns(
                "/", "/error" //스웨거
                , "/swagger-ui.html" //스웨거
                , "/swagger-resources/**" //스웨거
                , "/v2/api-docs" //스웨거
                , "/webjars/**" //스웨거
            )
    }

}