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
data class AuditLog(
    val auditLogId: Int? = null, 
    val accessIp: String? = null, 
    val accessAgent: String? = null, 
    val apiUrl: String? = null, 
    val apiMethod: String? = null, 
    val apiDetail: String? = null, 
    val reqParameter: String? = null, 
    val subMenuId: Int? = null, 
    val subMenuName: String? = null, 
    val userId: Int? = null, 
    val userName: String? = null, 
    val resultCd: String? = null, 
    val createDt: LocalDateTime? = null, 
    val downloadReason: String? = null, 
    val enApiDetail: String? = null, 
    val enSubMenuName: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("AuditLog (")

        sb.append(auditLogId)
        sb.append(", ").append(accessIp)
        sb.append(", ").append(accessAgent)
        sb.append(", ").append(apiUrl)
        sb.append(", ").append(apiMethod)
        sb.append(", ").append(apiDetail)
        sb.append(", ").append(reqParameter)
        sb.append(", ").append(subMenuId)
        sb.append(", ").append(subMenuName)
        sb.append(", ").append(userId)
        sb.append(", ").append(userName)
        sb.append(", ").append(resultCd)
        sb.append(", ").append(createDt)
        sb.append(", ").append(downloadReason)
        sb.append(", ").append(enApiDetail)
        sb.append(", ").append(enSubMenuName)

        sb.append(")")
        return sb.toString()
    }
}