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
data class Tbexchangeactionhistory(
    val id: Long? = null, 
    val txid: String? = null, 
    val targetlockid: String? = null, 
    val type: String? = null, 
    val created: LocalDateTime? = null, 
    val creator: Long? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbexchangeactionhistory (")

        sb.append(id)
        sb.append(", ").append(txid)
        sb.append(", ").append(targetlockid)
        sb.append(", ").append(type)
        sb.append(", ").append(created)
        sb.append(", ").append(creator)

        sb.append(")")
        return sb.toString()
    }
}
