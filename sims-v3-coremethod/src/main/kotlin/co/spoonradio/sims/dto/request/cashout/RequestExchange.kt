package co.spoonradio.sims.dto.request.cashout

import co.spoonradio.sims.dto.request.base.RequestBaseDto

data class RequestExchange(
    var base: RequestBaseDto?,
    val status:String?,
    val amount_status:String?,
    val is_minor:Boolean?,
    val tier_id:Int?,
    val limit: String?
) {
    var user_Ids: MutableSet<Int?>? = null
    var requestType: String? = null
}