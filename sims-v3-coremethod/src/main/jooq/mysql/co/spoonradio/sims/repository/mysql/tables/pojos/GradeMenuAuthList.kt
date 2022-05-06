/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class GradeMenuAuthList(
    val id: Int? = null, 
    val userAuthCd: String? = null, 
    val createDt: LocalDateTime? = null, 
    val updateDt: LocalDateTime? = null, 
    val subMenuId: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("GradeMenuAuthList (")

        sb.append(id)
        sb.append(", ").append(userAuthCd)
        sb.append(", ").append(createDt)
        sb.append(", ").append(updateDt)
        sb.append(", ").append(subMenuId)

        sb.append(")")
        return sb.toString()
    }
}
