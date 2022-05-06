package co.spoonradio.sims.dto.request.balance

data class RequestBalanceReject(
    val txId:String,
    val targetLockId:String
)