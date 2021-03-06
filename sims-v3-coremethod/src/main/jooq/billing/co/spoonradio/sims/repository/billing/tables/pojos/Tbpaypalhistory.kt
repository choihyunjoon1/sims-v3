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
data class Tbpaypalhistory(
    val id: Int? = null, 
    val txid: String? = null, 
    val quantity: Int? = null, 
    val status: String? = null, 
    val useragent: String? = null, 
    val updated: LocalDateTime? = null, 
    val completed: LocalDateTime? = null, 
    val created: LocalDateTime? = null, 
    val errormessage: String? = null, 
    val amount: Double? = null, 
    val itemname: String? = null, 
    val countrycode: String? = null, 
    val detailcountrycode: String? = null, 
    val linkcapture: String? = null, 
    val linkapprove: String? = null, 
    val payerid: String? = null, 
    val grossamount: Double? = null, 
    val feesamount: Double? = null, 
    val netamount: Double? = null, 
    val productid: Int? = null, 
    val promotionid: Int? = null, 
    val userid: Int? = null, 
    val paymentstatus: String? = null, 
    val currency: String? = null, 
    val paypalcaptureid: String? = null, 
    val orderid: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbpaypalhistory (")

        sb.append(id)
        sb.append(", ").append(txid)
        sb.append(", ").append(quantity)
        sb.append(", ").append(status)
        sb.append(", ").append(useragent)
        sb.append(", ").append(updated)
        sb.append(", ").append(completed)
        sb.append(", ").append(created)
        sb.append(", ").append(errormessage)
        sb.append(", ").append(amount)
        sb.append(", ").append(itemname)
        sb.append(", ").append(countrycode)
        sb.append(", ").append(detailcountrycode)
        sb.append(", ").append(linkcapture)
        sb.append(", ").append(linkapprove)
        sb.append(", ").append(payerid)
        sb.append(", ").append(grossamount)
        sb.append(", ").append(feesamount)
        sb.append(", ").append(netamount)
        sb.append(", ").append(productid)
        sb.append(", ").append(promotionid)
        sb.append(", ").append(userid)
        sb.append(", ").append(paymentstatus)
        sb.append(", ").append(currency)
        sb.append(", ").append(paypalcaptureid)
        sb.append(", ").append(orderid)

        sb.append(")")
        return sb.toString()
    }
}
