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
data class UsersAuthortieruser(
    val id: Int? = null, 
    val created: OffsetDateTime? = null, 
    val tierId: Int? = null, 
    val userId: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersAuthortieruser (")

        sb.append(id)
        sb.append(", ").append(created)
        sb.append(", ").append(tierId)
        sb.append(", ").append(userId)

        sb.append(")")
        return sb.toString()
    }
}
