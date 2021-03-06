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
data class VocBanshistory(
    val bansHistoryId: Int? = null, 
    val bansId: Long? = null, 
    val bansUserId: Long? = null, 
    val handlerUserId: Long? = null, 
    val handlerUserName: String? = null, 
    val createDt: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("VocBanshistory (")

        sb.append(bansHistoryId)
        sb.append(", ").append(bansId)
        sb.append(", ").append(bansUserId)
        sb.append(", ").append(handlerUserId)
        sb.append(", ").append(handlerUserName)
        sb.append(", ").append(createDt)

        sb.append(")")
        return sb.toString()
    }
}
