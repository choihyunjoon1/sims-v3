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
data class Tbadpopcornhistory(
    val id: Long? = null, 
    val rewardkey: String? = null, 
    val userid: Int? = null, 
    val campaignkey: String? = null, 
    val quantity: Int? = null, 
    val signedvalue: String? = null, 
    val txid: String? = null, 
    val created: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbadpopcornhistory (")

        sb.append(id)
        sb.append(", ").append(rewardkey)
        sb.append(", ").append(userid)
        sb.append(", ").append(campaignkey)
        sb.append(", ").append(quantity)
        sb.append(", ").append(signedvalue)
        sb.append(", ").append(txid)
        sb.append(", ").append(created)

        sb.append(")")
        return sb.toString()
    }
}
