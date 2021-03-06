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
data class VocHist(
    val vocHistId: Int? = null, 
    val statusCd: String? = null, 
    val spoonUserId: Long? = null, 
    val registerTypeCd: String? = null, 
    val boundTypeCd: String? = null, 
    val criticalityTypeCd: String? = null, 
    val channelCd: String? = null, 
    val typeCd: String? = null, 
    val categoryCd: String? = null, 
    val divisionCd: String? = null, 
    val sectionCd: String? = null, 
    val comment: String? = null, 
    val reply: String? = null, 
    val createDt: LocalDateTime? = null, 
    val updateDt: LocalDateTime? = null, 
    val memberUserId: Int? = null, 
    val replyUserId: Int? = null, 
    val spoonUserNickname: String? = null, 
    val nonSpoonMemberEmail: String? = null, 
    val replyDt: LocalDateTime? = null, 
    val desDt: LocalDateTime? = null, 
    val isDes: Byte? = null, 
    val uploadDt: LocalDateTime? = null, 
    val os: String? = null, 
    val carrier: String? = null, 
    val appVersion: String? = null, 
    val deviceModel: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("VocHist (")

        sb.append(vocHistId)
        sb.append(", ").append(statusCd)
        sb.append(", ").append(spoonUserId)
        sb.append(", ").append(registerTypeCd)
        sb.append(", ").append(boundTypeCd)
        sb.append(", ").append(criticalityTypeCd)
        sb.append(", ").append(channelCd)
        sb.append(", ").append(typeCd)
        sb.append(", ").append(categoryCd)
        sb.append(", ").append(divisionCd)
        sb.append(", ").append(sectionCd)
        sb.append(", ").append(comment)
        sb.append(", ").append(reply)
        sb.append(", ").append(createDt)
        sb.append(", ").append(updateDt)
        sb.append(", ").append(memberUserId)
        sb.append(", ").append(replyUserId)
        sb.append(", ").append(spoonUserNickname)
        sb.append(", ").append(nonSpoonMemberEmail)
        sb.append(", ").append(replyDt)
        sb.append(", ").append(desDt)
        sb.append(", ").append(isDes)
        sb.append(", ").append(uploadDt)
        sb.append(", ").append(os)
        sb.append(", ").append(carrier)
        sb.append(", ").append(appVersion)
        sb.append(", ").append(deviceModel)

        sb.append(")")
        return sb.toString()
    }
}
