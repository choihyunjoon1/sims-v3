package co.spoonradio.sims.dto.request.voc.ban

/**
 * @author whale@spoonradio.co
 * @date   2021/12/08.
 * @Desc
 */
data class RequestRecoveryBan(
    var ban_id:Int,
    var type:String,
    val user_id:Int
)
