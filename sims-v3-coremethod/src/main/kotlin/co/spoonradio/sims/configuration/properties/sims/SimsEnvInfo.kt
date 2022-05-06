package co.spoonradio.sims.configuration.properties.sims

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * @author whale@spoonradio.co
 * @date   2021/12/14.
 * @Desc
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "sims.env")
data class SimsEnvInfo(
    val balance: String,
    val spooncast: String,
    val oktaMetadataPath: String,
    val billingUrl: String,
    val billingApiKey: String,
    val downloadUrl:String,
    val payoneerUrl:String,
    val payoneerProgramId:String,
    val payoneerAuthToken:String,
    val billingAesCipherKey:String,
    val adminEmail: String
)
