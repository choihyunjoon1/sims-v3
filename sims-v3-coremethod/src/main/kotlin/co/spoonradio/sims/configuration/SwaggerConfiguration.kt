package co.spoonradio.sims.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun swaggerApi(): Docket{
        return Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(true)
            .groupName("SIMS-V3")
            .select()
            .apis(RequestHandlerSelectors.basePackage("co.spoonradio.sims.controller"))
            .build()
            .apiInfo(
                ApiInfo(
                    "SPOON SIMS-V3 API",
                    "SPOON SIMS-V3 Doc",
                    "3.0",
                    "localhost:8080/v3/sims",
                    Contact("BPT:whale", "https://spoonradio.slack.com/archives/G0101K726TA", "whale@spoonradio.co"),
                    null,
                    null,
                    ArrayList()
                )
            )
    }
}