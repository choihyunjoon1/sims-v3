package co.spoonradio.sims.dto.request.cashout

data class RequestExchangeActionHistory(
    val txId:String,
    val targetLockId:String,
    val type:String,
    val creator:Long
)