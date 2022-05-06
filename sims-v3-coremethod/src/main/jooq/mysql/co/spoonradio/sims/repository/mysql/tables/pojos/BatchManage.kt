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
data class BatchManage(
    val batchManageId: Int? = null, 
    val batchTypeCd: String? = null, 
    val batchDescription: String? = null, 
    val isRun: Byte? = null, 
    val updateDt: LocalDateTime? = null, 
    val createDt: LocalDateTime? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("BatchManage (")

        sb.append(batchManageId)
        sb.append(", ").append(batchTypeCd)
        sb.append(", ").append(batchDescription)
        sb.append(", ").append(isRun)
        sb.append(", ").append(updateDt)
        sb.append(", ").append(createDt)

        sb.append(")")
        return sb.toString()
    }
}