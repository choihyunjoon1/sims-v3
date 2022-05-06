package co.spoonradio.sims.dto.response.users

import java.time.ZonedDateTime

data class UserProfileEntity(
    val id:Int,
    val tag:String,
    val nickname:String,
    val status:Int,
    val tierName:String?,
    val niceId:Long?,
    var niceName:String?,
    val niceGender:Int?,
    var niceBirthDate:String?,
    val niceCreated: ZonedDateTime?,
)