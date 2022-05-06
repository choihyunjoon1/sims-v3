package co.spoonradio.sims.configuration.properties.database

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "sims.jdbc.mysql")
data class MySqlInfo(
    val url:String,
    val username:String,
    val password:String,
    val driverClassName:String
)
