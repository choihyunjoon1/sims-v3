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
data class Tbapplestorehistory(
    val id: Int? = null, 
    val txid: String? = null, 
    val transactionid: String? = null, 
    val transactiondate: LocalDateTime? = null, 
    val transactionstate: Int? = null, 
    val transactionerror: String? = null, 
    val receiptdata: String? = null, 
    val status: String? = null, 
    val modelname: String? = null, 
    val buildno: Int? = null, 
    val requesttime: LocalDateTime? = null, 
    val consumetime: LocalDateTime? = null, 
    val created: LocalDateTime? = null, 
    val productid: Int? = null, 
    val userid: Int? = null, 
    val updated: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbapplestorehistory (")

        sb.append(id)
        sb.append(", ").append(txid)
        sb.append(", ").append(transactionid)
        sb.append(", ").append(transactiondate)
        sb.append(", ").append(transactionstate)
        sb.append(", ").append(transactionerror)
        sb.append(", ").append(receiptdata)
        sb.append(", ").append(status)
        sb.append(", ").append(modelname)
        sb.append(", ").append(buildno)
        sb.append(", ").append(requesttime)
        sb.append(", ").append(consumetime)
        sb.append(", ").append(created)
        sb.append(", ").append(productid)
        sb.append(", ").append(userid)
        sb.append(", ").append(updated)

        sb.append(")")
        return sb.toString()
    }
}