/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.pojos


import java.io.Serializable
import java.time.LocalDate


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class ReportsLivemessagereport(
    val id: Int? = null, 
    val reporter: String? = null, 
    val reported: LocalDate? = null, 
    val live: String? = null, 
    val liveAuthor: String? = null, 
    val liveCreated: LocalDate? = null, 
    val messageAuthor: String? = null, 
    val messageContents: String? = null, 
    val reportDescr: String? = null, 
    val reportType: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("ReportsLivemessagereport (")

        sb.append(id)
        sb.append(", ").append(reporter)
        sb.append(", ").append(reported)
        sb.append(", ").append(live)
        sb.append(", ").append(liveAuthor)
        sb.append(", ").append(liveCreated)
        sb.append(", ").append(messageAuthor)
        sb.append(", ").append(messageContents)
        sb.append(", ").append(reportDescr)
        sb.append(", ").append(reportType)

        sb.append(")")
        return sb.toString()
    }
}
