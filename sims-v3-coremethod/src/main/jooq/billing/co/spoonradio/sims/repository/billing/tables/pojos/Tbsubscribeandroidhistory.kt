/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Tbsubscribeandroidhistory(
    val id: Int? = null, 
    val subscribeid: Int? = null, 
    val txid: String? = null, 
    val orderid: String? = null, 
    val status: String? = null, 
    val createddate: LocalDateTime? = null, 
    val startdate: LocalDateTime? = null, 
    val expiredate: LocalDateTime? = null, 
    val updateddate: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbsubscribeandroidhistory (")

        sb.append(id)
        sb.append(", ").append(subscribeid)
        sb.append(", ").append(txid)
        sb.append(", ").append(orderid)
        sb.append(", ").append(status)
        sb.append(", ").append(createddate)
        sb.append(", ").append(startdate)
        sb.append(", ").append(expiredate)
        sb.append(", ").append(updateddate)

        sb.append(")")
        return sb.toString()
    }
}
