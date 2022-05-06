package co.spoonradio.sims.configuration.aws

import co.spoonradio.arch.aws.credentials.autoconfigure.AwsCredentialsAutoConfiguration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.presigner.S3Presigner


/**
 * @author whale@spoonradio.co
 * @date   2021/11/16.
 * @Desc https://leoheo.github.io/AWS-SES/
 */
@Configuration
@AutoConfigureAfter(AwsCredentialsAutoConfiguration::class)
@ConditionalOnMissingBean(S3Client::class, S3Presigner::class)
@ConditionalOnProperty(prefix = "aws.s3", name=["enabled"], havingValue = "true", matchIfMissing = true)
class AwsS3Configuration {
    companion object {
        private val logger = LoggerFactory.getLogger(AwsS3Configuration::class.java)
    }
    @Value("\${aws.region}")
    var AWS_REGION: String = "region"

    @Bean
    @ConditionalOnMissingBean
    fun amazonS3(awsCredentialsProvider: AwsCredentialsProvider): S3Client {
        logger.info("Creating amazon S3 Client (-> ${AWS_REGION})")
        return S3Client.builder()
            .region(Region.of(AWS_REGION))
            .credentialsProvider(awsCredentialsProvider)
            .build()
    }
    @Bean
    @ConditionalOnMissingBean
    fun amazonS3Presigner(awsCredentialsProvider: AwsCredentialsProvider): S3Presigner {
        logger.info("Creating amazon S3 Presigner (-> ${AWS_REGION})")
        return S3Presigner.builder()
            .region(Region.of(AWS_REGION))
            .credentialsProvider(awsCredentialsProvider)
            .build()
    }

}
