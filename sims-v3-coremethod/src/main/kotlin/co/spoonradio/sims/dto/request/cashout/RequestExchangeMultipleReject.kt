package co.spoonradio.sims.dto.request.cashout

data class RequestExchangeMultipleReject(
    val exchange_ids:List<Long>,
    val reason:String,
    val sms:String
)