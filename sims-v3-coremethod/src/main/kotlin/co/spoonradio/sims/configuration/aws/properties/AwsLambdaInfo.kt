package co.spoonradio.sims.configuration.aws.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cloud.aws.lambda")
data class AwsLambdaInfo(
    val baseUrl:String,
    val apiKey:String
)
