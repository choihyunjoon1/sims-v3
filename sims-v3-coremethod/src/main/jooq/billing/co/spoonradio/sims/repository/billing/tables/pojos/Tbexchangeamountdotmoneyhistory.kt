/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.pojos


import java.io.Serializable
import java.math.BigDecimal


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Tbexchangeamountdotmoneyhistory(
    val exchangeamountid: Long? = null, 
    val dotmoneyhistoryid: BigDecimal? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Tbexchangeamountdotmoneyhistory (")

        sb.append(exchangeamountid)
        sb.append(", ").append(dotmoneyhistoryid)

        sb.append(")")
        return sb.toString()
    }
}
