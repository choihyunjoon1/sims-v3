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
data class UsersGrant(
    val id: Int? = null, 
    val login: Int? = null, 
    val cast: Int? = null, 
    val talk: Int? = null, 
    val live: Int? = null, 
    val adult: Int? = null, 
    val updated: OffsetDateTime? = null, 
    val phone: Int? = null, 
    val payment: Int? = null, 
    val auth: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersGrant (")

        sb.append(id)
        sb.append(", ").append(login)
        sb.append(", ").append(cast)
        sb.append(", ").append(talk)
        sb.append(", ").append(live)
        sb.append(", ").append(adult)
        sb.append(", ").append(updated)
        sb.append(", ").append(phone)
        sb.append(", ").append(payment)
        sb.append(", ").append(auth)

        sb.append(")")
        return sb.toString()
    }
}
