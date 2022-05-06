package co.spoonradio.sims.dto.response.init.Menu

import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * @author whale@spoonradio.co
 * @date   2021/12/11.
 * @Desc
 */
data class SubMenu(
    val sub_menu_id: Int,
    val menu_key: String,
    val name: String,
    val path: String,
    @JsonIgnore
    val menu_id:Int
)
