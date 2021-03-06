/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.pojos


import java.io.Serializable
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Arrays


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class UsersProfile(
    val id: Int? = null, 
    val nickname: String? = null, 
    val tag: String? = null, 
    val description: String? = null, 
    val gender: Int? = null, 
    val dateOfBirth: LocalDate? = null, 
    val profileUrl: String? = null, 
    val profileKey: String? = null, 
    val reporters: Array<Any?>? = null, 
    val topImpressions: Array<Any?>? = null, 
    val isLive: Boolean? = null, 
    val fanCount: Int? = null, 
    val myCount: Int? = null, 
    val currentLiveId: Int? = null, 
    val lastLiveCreated: OffsetDateTime? = null, 
    val created: OffsetDateTime? = null, 
    val userId: Int? = null, 
    val country: String? = null, 
    val isPublicCastStorage: Boolean? = null, 
    val isPublicLike: Boolean? = null, 
    val isVip: Boolean? = null, 
    val verifyStatus: Short? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("UsersProfile (")

        sb.append(id)
        sb.append(", ").append(nickname)
        sb.append(", ").append(tag)
        sb.append(", ").append(description)
        sb.append(", ").append(gender)
        sb.append(", ").append(dateOfBirth)
        sb.append(", ").append(profileUrl)
        sb.append(", ").append(profileKey)
        sb.append(", ").append(Arrays.toString(reporters))
        sb.append(", ").append(Arrays.toString(topImpressions))
        sb.append(", ").append(isLive)
        sb.append(", ").append(fanCount)
        sb.append(", ").append(myCount)
        sb.append(", ").append(currentLiveId)
        sb.append(", ").append(lastLiveCreated)
        sb.append(", ").append(created)
        sb.append(", ").append(userId)
        sb.append(", ").append(country)
        sb.append(", ").append(isPublicCastStorage)
        sb.append(", ").append(isPublicLike)
        sb.append(", ").append(isVip)
        sb.append(", ").append(verifyStatus)

        sb.append(")")
        return sb.toString()
    }
}
