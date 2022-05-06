/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.pojos


import java.io.Serializable
import java.time.OffsetDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class UsersBan(
    val id: Int? = null, 
    val detail: String? = null, 
    val memo: String? = null, 
    val deviceUniqueId: String? = null, 
    val type: Int? = null, 
    val endDate: OffsetDateTime? = null, 
    val created: OffsetDateTime? = null, 
    val categoryContentId: Int? = null, 
    val categoryMainId: Int? = null, 
    val categorySubId: Int? = null, 
    val userId: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersBan (")

        sb.append(id)
        sb.append(", ").append(detail)
        sb.append(", ").append(memo)
        sb.append(", ").append(deviceUniqueId)
        sb.append(", ").append(type)
        sb.append(", ").append(endDate)
        sb.append(", ").append(created)
        sb.append(", ").append(categoryContentId)
        sb.append(", ").append(categoryMainId)
        sb.append(", ").append(categorySubId)
        sb.append(", ").append(userId)

        sb.append(")")
        return sb.toString()
    }
}
