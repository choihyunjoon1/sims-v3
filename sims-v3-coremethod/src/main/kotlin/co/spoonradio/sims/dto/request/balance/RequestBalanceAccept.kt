package co.spoonradio.sims.dto.request.balance

data class RequestBalanceAccept(
    val txId:String,
    val targetLockId:String
)