package co.spoonradio.sims.dto.response.adminuser

/**
 * @author whale@spoonradio.co
 * @date   2021/12/13.
 * @Desc
 */
data class AdminUserMenuGrant(
    val sub_menu_id:Int,
    val en_name:String,
    val api: String,
    val api_method: String,
    val is_ns: Int,
    val is_used: Int,
    val unmasking: Boolean
)
