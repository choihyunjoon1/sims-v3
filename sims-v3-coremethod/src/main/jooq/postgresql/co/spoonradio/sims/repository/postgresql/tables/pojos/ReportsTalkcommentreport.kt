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
data class ReportsTalkcommentreport(
    val id: Int? = null, 
    val reporter: String? = null, 
    val reported: LocalDate? = null, 
    val talk: String? = null, 
    val talkAuthor: String? = null, 
    val talkCreated: LocalDate? = null, 
    val commentAuthor: String? = null, 
    val commentUrl: String? = null, 
    val commentCreated: LocalDate? = null, 
    val reportDescr: String? = null, 
    val reportType: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("ReportsTalkcommentreport (")

        sb.append(id)
        sb.append(", ").append(reporter)
        sb.append(", ").append(reported)
        sb.append(", ").append(talk)
        sb.append(", ").append(talkAuthor)
        sb.append(", ").append(talkCreated)
        sb.append(", ").append(commentAuthor)
        sb.append(", ").append(commentUrl)
        sb.append(", ").append(commentCreated)
        sb.append(", ").append(reportDescr)
        sb.append(", ").append(reportType)

        sb.append(")")
        return sb.toString()
    }
}
