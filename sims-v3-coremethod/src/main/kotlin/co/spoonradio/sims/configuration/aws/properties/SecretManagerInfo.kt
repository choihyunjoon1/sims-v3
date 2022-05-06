package co.spoonradio.sims.configuration.aws.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cloud.aws.secret-manager")
data class SecretManagerInfo(
    val billingSecretStore:String
)
