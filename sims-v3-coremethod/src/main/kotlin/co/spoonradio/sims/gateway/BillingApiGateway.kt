package co.spoonradio.sims.gateway;

import co.spoonradio.sims.dto.request.cashout.RequestDepositExchange
import co.spoonradio.sims.dto.response.cashout.general.ExchangeApplyManually

interface BillingApiGateway {
    fun depositExchanges(userId:Int,
                         requestDepositExchange: RequestDepositExchange) : ExchangeApplyManually
}
