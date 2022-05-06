package co.spoonradio.sims.dto.response.users

/**
 * @author whale@spoonradio.co
 * @date   2021/12/06.
 * @Desc
 */
data class UsersSnsInfo(
    val sns_type: String,
    val sns_id: String,
    val id: Long,
    val tag: String
)
