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
data class FanboardFancomment(
    val id: Int? = null, 
    val contents: String? = null, 
    val isBlind: Boolean? = null, 
    val created: OffsetDateTime? = null, 
    val authorId: Int? = null, 
    val fanBoardId: Int? = null, 
    val isNotice: Boolean? = null, 
    val toUserId: Int? = null, 
    val messageCount: Int? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("FanboardFancomment (")

        sb.append(id)
        sb.append(", ").append(contents)
        sb.append(", ").append(isBlind)
        sb.append(", ").append(created)
        sb.append(", ").append(authorId)
        sb.append(", ").append(fanBoardId)
        sb.append(", ").append(isNotice)
        sb.append(", ").append(toUserId)
        sb.append(", ").append(messageCount)

        sb.append(")")
        return sb.toString()
    }
}