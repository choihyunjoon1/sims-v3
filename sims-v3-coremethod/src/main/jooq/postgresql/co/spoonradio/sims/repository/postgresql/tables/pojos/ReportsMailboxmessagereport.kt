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
data class ReportsMailboxmessagereport(
    val id: Int? = null, 
    val reportType: Int? = null, 
    val reportDescr: String? = null, 
    val reporter: String? = null, 
    val reported: LocalDate? = null, 
    val mailbox: String? = null, 
    val live: String? = null, 
    val liveAuthor: String? = null, 
    val liveCreated: LocalDate? = null, 
    val messageAuthor: String? = null, 
    val messageContents: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("ReportsMailboxmessagereport (")

        sb.append(id)
        sb.append(", ").append(reportType)
        sb.append(", ").append(reportDescr)
        sb.append(", ").append(reporter)
        sb.append(", ").append(reported)
        sb.append(", ").append(mailbox)
        sb.append(", ").append(live)
        sb.append(", ").append(liveAuthor)
        sb.append(", ").append(liveCreated)
        sb.append(", ").append(messageAuthor)
        sb.append(", ").append(messageContents)

        sb.append(")")
        return sb.toString()
    }
}
