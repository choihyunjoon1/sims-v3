package co.spoonradio.sims.configuration.aws;

import co.spoonradio.arch.aws.credentials.autoconfigure.AwsCredentialsAutoConfiguration
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ses.SesClient

@Configuration
@AutoConfigureAfter(AwsCredentialsAutoConfiguration::class)
@ConditionalOnMissingBean(SesClient::class)
@ConditionalOnProperty(prefix = "aws.ses", name=["enabled"], havingValue = "true", matchIfMissing = true)
class AwsSesConfiguration {
    companion object {
        private val logger = LoggerFactory.getLogger(AwsSesConfiguration::class.java)
    }

    @Bean
    @ConditionalOnMissingBean
    fun amazonSimpleEmailService(awsCredentialsProvider: AwsCredentialsProvider): SesClient {
        logger.info("Creating amazon simple email service (-> ${Region.US_EAST_1})")
        return SesClient.builder()
            .region(Region.US_EAST_1)
            .credentialsProvider(awsCredentialsProvider)
            .build()
    }
}