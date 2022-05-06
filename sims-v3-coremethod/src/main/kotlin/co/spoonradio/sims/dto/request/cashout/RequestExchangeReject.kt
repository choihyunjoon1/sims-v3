package co.spoonradio.sims.dto.request.cashout

data class RequestExchangeReject(
    var id:Long,
    val reason:String,
    val sms:String
) {
    var creator:Long?=0L
    var updater:Long?=0L
}
