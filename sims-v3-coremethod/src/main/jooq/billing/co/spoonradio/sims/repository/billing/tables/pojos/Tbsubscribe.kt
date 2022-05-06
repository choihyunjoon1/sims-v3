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
data class Tbsubscribe(
    val id: Int? = null, 
    val originaltransactionid: String? = null, 
    val status: Byte? = null, 
    val productid: Int? = null, 
    val userid: Int? = null, 
    val price: Int? = null, 
    val spoonamount: Int? = null, 
    val platform: Byte? = null, 
    val isautorenew: Boolean? = null, 
    val createddate: LocalDateTime? = null, 
    val updateddate: LocalDateTime? = null, 
    val startdate: LocalDateTime? = null, 
    val expiredate: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbsubscribe (")

        sb.append(id)
        sb.append(", ").append(originaltransactionid)
        sb.append(", ").append(status)
        sb.append(", ").append(productid)
        sb.append(", ").append(userid)
        sb.append(", ").append(price)
        sb.append(", ").append(spoonamount)
        sb.append(", ").append(platform)
        sb.append(", ").append(isautorenew)
        sb.append(", ").append(createddate)
        sb.append(", ").append(updateddate)
        sb.append(", ").append(startdate)
        sb.append(", ").append(expiredate)

        sb.append(")")
        return sb.toString()
    }
}
