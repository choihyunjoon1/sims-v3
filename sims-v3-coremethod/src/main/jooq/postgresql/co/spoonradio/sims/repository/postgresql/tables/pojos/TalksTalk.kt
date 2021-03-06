/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.pojos


import java.io.Serializable
import java.time.OffsetDateTime
import java.util.Arrays


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class TalksTalk(
    val id: Int? = null, 
    val title: String? = null, 
    val imgKey: String? = null, 
    val imgUrl: String? = null, 
    val voiceCommentCount: Int? = null, 
    val reporters: Array<Any?>? = null, 
    val memberCount: Int? = null, 
    val likeCount: Int? = null, 
    val created: OffsetDateTime? = null, 
    val authorId: Int? = null, 
    val blockUsers: Array<Any?>? = null, 
    val bannerImgKey: String? = null, 
    val bannerImgUrl: String? = null, 
    val eventEnd: OffsetDateTime? = null, 
    val isEvent: Boolean? = null, 
    val commentLikeCount: Int? = null, 
    val expired: OffsetDateTime? = null, 
    val isPrivate: Boolean? = null, 
    val isVolatile: Boolean? = null, 
    val text: String? = null, 
    val isComposited: Boolean? = null, 
    val commentPlayCount: Int? = null, 
    val enterCount: Int? = null, 
    val tags: Array<Any?>? = null, 
    val status: Short? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("TalksTalk (")

        sb.append(id)
        sb.append(", ").append(title)
        sb.append(", ").append(imgKey)
        sb.append(", ").append(imgUrl)
        sb.append(", ").append(voiceCommentCount)
        sb.append(", ").append(Arrays.toString(reporters))
        sb.append(", ").append(memberCount)
        sb.append(", ").append(likeCount)
        sb.append(", ").append(created)
        sb.append(", ").append(authorId)
        sb.append(", ").append(Arrays.toString(blockUsers))
        sb.append(", ").append(bannerImgKey)
        sb.append(", ").append(bannerImgUrl)
        sb.append(", ").append(eventEnd)
        sb.append(", ").append(isEvent)
        sb.append(", ").append(commentLikeCount)
        sb.append(", ").append(expired)
        sb.append(", ").append(isPrivate)
        sb.append(", ").append(isVolatile)
        sb.append(", ").append(text)
        sb.append(", ").append(isComposited)
        sb.append(", ").append(commentPlayCount)
        sb.append(", ").append(enterCount)
        sb.append(", ").append(Arrays.toString(tags))
        sb.append(", ").append(status)

        sb.append(")")
        return sb.toString()
    }
}
