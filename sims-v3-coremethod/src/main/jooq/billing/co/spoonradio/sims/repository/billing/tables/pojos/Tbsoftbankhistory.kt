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
data class Tbsoftbankhistory(
    val id: Int? = null, 
    val status: String? = null, 
    val txid: String? = null, 
    val paymethod: String? = null, 
    val orderid: String? = null, 
    val tax: Int? = null, 
    val paytype: Int? = null, 
    val limitsecond: Int? = null, 
    val spshashcode: String? = null, 
    val useragent: String? = null, 
    val errorcode: String? = null, 
    val resresult: String? = null, 
    val requestdate: String? = null, 
    val completed: LocalDateTime? = null, 
    val created: LocalDateTime? = null, 
    val productid: Int? = null, 
    val promotionid: Int? = null, 
    val userid: Int? = null, 
    val amount: Int? = null, 
    val quantity: Int? = null, 
    val updated: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbsoftbankhistory (")

        sb.append(id)
        sb.append(", ").append(status)
        sb.append(", ").append(txid)
        sb.append(", ").append(paymethod)
        sb.append(", ").append(orderid)
        sb.append(", ").append(tax)
        sb.append(", ").append(paytype)
        sb.append(", ").append(limitsecond)
        sb.append(", ").append(spshashcode)
        sb.append(", ").append(useragent)
        sb.append(", ").append(errorcode)
        sb.append(", ").append(resresult)
        sb.append(", ").append(requestdate)
        sb.append(", ").append(completed)
        sb.append(", ").append(created)
        sb.append(", ").append(productid)
        sb.append(", ").append(promotionid)
        sb.append(", ").append(userid)
        sb.append(", ").append(amount)
        sb.append(", ").append(quantity)
        sb.append(", ").append(updated)

        sb.append(")")
        return sb.toString()
    }
}
