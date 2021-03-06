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
data class UsersSpoonuser(
    val id: Int? = null, 
    val password: String? = null, 
    val lastLogin: OffsetDateTime? = null, 
    val isSuperuser: Boolean? = null, 
    val username: String? = null, 
    val firstName: String? = null, 
    val lastName: String? = null, 
    val email: String? = null, 
    val isStaff: Boolean? = null, 
    val isActive: Boolean? = null, 
    val dateJoined: OffsetDateTime? = null, 
    val companyId: Int? = null, 
    val budgetId: Int? = null, 
    val grantsId: Int? = null, 
    val leaved: OffsetDateTime? = null, 
    val status: Int? = null, 
    val isDormant: Boolean? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersSpoonuser (")

        sb.append(id)
        sb.append(", ").append(password)
        sb.append(", ").append(lastLogin)
        sb.append(", ").append(isSuperuser)
        sb.append(", ").append(username)
        sb.append(", ").append(firstName)
        sb.append(", ").append(lastName)
        sb.append(", ").append(email)
        sb.append(", ").append(isStaff)
        sb.append(", ").append(isActive)
        sb.append(", ").append(dateJoined)
        sb.append(", ").append(companyId)
        sb.append(", ").append(budgetId)
        sb.append(", ").append(grantsId)
        sb.append(", ").append(leaved)
        sb.append(", ").append(status)
        sb.append(", ").append(isDormant)

        sb.append(")")
        return sb.toString()
    }
}
