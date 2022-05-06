package co.spoonradio.sims.dto.response.cashout

import java.time.ZonedDateTime

data class RejectReason(
    val id:Long?=null,
    val reason:String?=null,
    val created:ZonedDateTime?=null,
    val creator:Int?=null,
    val updated:ZonedDateTime?=null,
    val updater:Int?=null,
    val exchange:Long?=null,
)