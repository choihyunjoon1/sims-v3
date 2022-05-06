package co.spoonradio.sims.gateway;

import co.spoonradio.sims.dto.request.balance.RequestBalanceAccept
import co.spoonradio.sims.dto.request.balance.RequestBalanceReject
import co.spoonradio.sims.dto.response.clientapi.BalanceExchange

interface BalanceApiGateway {
    fun rejectExchange(requestBalanceReject: RequestBalanceReject): BalanceExchange
    fun acceptExchange(requestBalanceAccept: RequestBalanceAccept): BalanceExchange
}