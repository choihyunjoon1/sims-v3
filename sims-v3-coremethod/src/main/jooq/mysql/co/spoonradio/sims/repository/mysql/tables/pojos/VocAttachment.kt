/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class VocAttachment(
    val attachmentId: Int? = null, 
    val vocHistId: Int? = null, 
    val attachmentPath: String? = null, 
    val createDt: LocalDateTime? = null, 
    val updateDt: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("VocAttachment (")

        sb.append(attachmentId)
        sb.append(", ").append(vocHistId)
        sb.append(", ").append(attachmentPath)
        sb.append(", ").append(createDt)
        sb.append(", ").append(updateDt)

        sb.append(")")
        return sb.toString()
    }
}
