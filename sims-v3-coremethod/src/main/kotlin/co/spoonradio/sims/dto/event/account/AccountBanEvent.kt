package co.spoonradio.sims.dto.event.account

/**
 * @author whale@spoonradio.co
 * @date   2021/12/06.
 * @Desc
 */
data class AccountBanEvent(
    val eventType: String,
    val snsType: String,
    val snsId: String,
    val userId: Long,
    val userTag: String
)
