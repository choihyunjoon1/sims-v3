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
data class Notice(
    val noticeId: Int? = null, 
    val name: String? = null, 
    val contents: String? = null, 
    val noticeImage: String? = null, 
    val noticeTypeCd: String? = null, 
    val isPopup: Byte? = null, 
    val isAvailable: Byte? = null, 
    val startDt: LocalDateTime? = null, 
    val endDt: LocalDateTime? = null, 
    val createDt: LocalDateTime? = null, 
    val updateDt: LocalDateTime? = null, 
    val userName: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Notice (")

        sb.append(noticeId)
        sb.append(", ").append(name)
        sb.append(", ").append(contents)
        sb.append(", ").append(noticeImage)
        sb.append(", ").append(noticeTypeCd)
        sb.append(", ").append(isPopup)
        sb.append(", ").append(isAvailable)
        sb.append(", ").append(startDt)
        sb.append(", ").append(endDt)
        sb.append(", ").append(createDt)
        sb.append(", ").append(updateDt)
        sb.append(", ").append(userName)

        sb.append(")")
        return sb.toString()
    }
}
