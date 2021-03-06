/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.pojos


import java.io.Serializable
import java.time.OffsetDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class UsersDevice(
    val id: Int? = null, 
    val deviceToken: String? = null, 
    val osType: String? = null, 
    val modelName: String? = null, 
    val buildNo: Int? = null, 
    val created: OffsetDateTime? = null, 
    val userId: Int? = null, 
    val androidId: String? = null, 
    val deviceUniqueId: String? = null, 
    val oneSignalId: String? = null, 
    val updated: OffsetDateTime? = null, 
    val ipAddress: String? = null, 
    val status: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersDevice (")

        sb.append(id)
        sb.append(", ").append(deviceToken)
        sb.append(", ").append(osType)
        sb.append(", ").append(modelName)
        sb.append(", ").append(buildNo)
        sb.append(", ").append(created)
        sb.append(", ").append(userId)
        sb.append(", ").append(androidId)
        sb.append(", ").append(deviceUniqueId)
        sb.append(", ").append(oneSignalId)
        sb.append(", ").append(updated)
        sb.append(", ").append(ipAddress)
        sb.append(", ").append(status)

        sb.append(")")
        return sb.toString()
    }
}
