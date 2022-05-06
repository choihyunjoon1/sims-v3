package co.spoonradio.sims.dto.request.cashout

import co.spoonradio.sims.dto.request.base.RequestBaseDto

data class RequestExchangeHistories(
    var base: RequestBaseDto?,
    val exchangeId:Long
)