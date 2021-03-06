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
data class UsersAccount(
    val id: Int? = null, 
    val snsId: String? = null, 
    val snsType: String? = null, 
    val facebook: String? = null, 
    val google: String? = null, 
    val email: String? = null, 
    val phone: String? = null, 
    val countryPrefix: String? = null, 
    val nationalNumber: String? = null, 
    val created: OffsetDateTime? = null, 
    val userId: Int? = null, 
    val twitter: String? = null, 
    val password: String? = null, 
    val apple: String? = null, 
    val updated: OffsetDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersAccount (")

        sb.append(id)
        sb.append(", ").append(snsId)
        sb.append(", ").append(snsType)
        sb.append(", ").append(facebook)
        sb.append(", ").append(google)
        sb.append(", ").append(email)
        sb.append(", ").append(phone)
        sb.append(", ").append(countryPrefix)
        sb.append(", ").append(nationalNumber)
        sb.append(", ").append(created)
        sb.append(", ").append(userId)
        sb.append(", ").append(twitter)
        sb.append(", ").append(password)
        sb.append(", ").append(apple)
        sb.append(", ").append(updated)

        sb.append(")")
        return sb.toString()
    }
}
