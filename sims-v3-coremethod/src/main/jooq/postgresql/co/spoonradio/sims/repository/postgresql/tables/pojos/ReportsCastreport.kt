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
data class ReportsCastreport(
    val id: Int? = null, 
    val reporter: String? = null, 
    val reported: LocalDate? = null, 
    val cast: String? = null, 
    val castAuthor: String? = null, 
    val castCreated: LocalDate? = null, 
    val castUrl: String? = null, 
    val reportDescr: String? = null, 
    val reportType: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("ReportsCastreport (")

        sb.append(id)
        sb.append(", ").append(reporter)
        sb.append(", ").append(reported)
        sb.append(", ").append(cast)
        sb.append(", ").append(castAuthor)
        sb.append(", ").append(castCreated)
        sb.append(", ").append(castUrl)
        sb.append(", ").append(reportDescr)
        sb.append(", ").append(reportType)

        sb.append(")")
        return sb.toString()
    }
}