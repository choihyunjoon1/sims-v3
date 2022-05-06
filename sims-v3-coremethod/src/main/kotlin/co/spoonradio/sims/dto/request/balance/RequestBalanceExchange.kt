package co.spoonradio.sims.dto.request.balance

data class RequestBalanceExchange(
    var txId: String,
    val userId: Int,
    val exchangeId: Int,
    val itemCount: Long,
    val exchangeType: String
)

