package co.spoonradio.sims.dto.response.init.Menu

/**
 * @author whale@spoonradio.co
 * @date   2021/12/11.
 * @Desc
 */
data class MainMenu(
    val menu_id: Int,
    val icon: String,
    val menu_key: String,
    val name: String,
    val sub_menus: List<SubMenu>
)
