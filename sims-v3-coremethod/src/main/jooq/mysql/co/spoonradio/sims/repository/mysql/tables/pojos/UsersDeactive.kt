/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.pojos


import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class UsersDeactive(
    val userDeactiveId: Int? = null, 
    val userId: Int? = null, 
    val tag: String? = null, 
    val dateOfBirth: LocalDate? = null, 
    val firstName: String? = null, 
    val lastName: String? = null, 
    val withdrawDate: LocalDateTime? = null, 
    val deleteDate: LocalDateTime? = null, 
    val nickname: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersDeactive (")

        sb.append(userDeactiveId)
        sb.append(", ").append(userId)
        sb.append(", ").append(tag)
        sb.append(", ").append(dateOfBirth)
        sb.append(", ").append(firstName)
        sb.append(", ").append(lastName)
        sb.append(", ").append(withdrawDate)
        sb.append(", ").append(deleteDate)
        sb.append(", ").append(nickname)

        sb.append(")")
        return sb.toString()
    }
}
