package co.spoonradio.sims.configuration.database.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "sims.jdbc.billing")
data class BillingInfo(
    val url:String,
    val username:String,
    val password:String,
    val driverClassName:String
)
