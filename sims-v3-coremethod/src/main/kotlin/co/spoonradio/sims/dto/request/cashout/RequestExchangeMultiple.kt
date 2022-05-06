package co.spoonradio.sims.dto.request.cashout

data class RequestExchangeMultiple(
    val exchange_ids:List<Long>
) {
    var actionType:List<String>? = null
}
