package co.spoonradio.sims.dto.response.voc.ban.category

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
data class MainCategory(
    val id:Int,
    val name:String,
    val is_use:Boolean,
    val created:ZonedDateTime?=null,
    @JsonIgnore
    val totalCount:Long
):Serializable
