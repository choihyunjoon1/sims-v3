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
data class BatchLog(
    val batchLogId: Int? = null, 
    val batchTypeCd: String? = null, 
    val batchDetail: String? = null, 
    val batchParameter: String? = null, 
    val createDt: LocalDateTime? = null, 
    val isSuccess: Byte? = null, 
    val cnt: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("BatchLog (")

        sb.append(batchLogId)
        sb.append(", ").append(batchTypeCd)
        sb.append(", ").append(batchDetail)
        sb.append(", ").append(batchParameter)
        sb.append(", ").append(createDt)
        sb.append(", ").append(isSuccess)
        sb.append(", ").append(cnt)

        sb.append(")")
        return sb.toString()
    }
}
