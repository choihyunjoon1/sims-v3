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
data class BatchLogDeail(
    val batchLogDetailId: Int? = null, 
    val description: String? = null, 
    val userId: Int? = null, 
    val resultCd: Int? = null, 
    val createDt: LocalDateTime? = null, 
    val batchLogId: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("BatchLogDeail (")

        sb.append(batchLogDetailId)
        sb.append(", ").append(description)
        sb.append(", ").append(userId)
        sb.append(", ").append(resultCd)
        sb.append(", ").append(createDt)
        sb.append(", ").append(batchLogId)

        sb.append(")")
        return sb.toString()
    }
}
