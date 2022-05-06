package co.spoonradio.sims.gateway;

import co.spoonradio.sims.gateway.client.BalanceApi
import co.spoonradio.sims.dto.request.balance.RequestBalanceAccept
import co.spoonradio.sims.dto.request.balance.RequestBalanceReject
import co.spoonradio.sims.dto.response.clientapi.BalanceExchange
import co.spoonradio.sims.exception.GeneralException
import org.springframework.stereotype.Service

@Service
class DefaultBalanceApiGateway(private val balanceApi: BalanceApi) : BalanceApiGateway {
    override fun rejectExchange(requestBalanceReject: RequestBalanceReject): BalanceExchange {
        try {
            return balanceApi.rejectExchange(requestBalanceReject)
        } catch (e: Exception) {
            //모니터링용 슬랙 보내자
            e.printStackTrace()
            throw GeneralException("00021")
        }
    }

    override fun acceptExchange(requestBalanceAccept: RequestBalanceAccept): BalanceExchange {
        return try {
            balanceApi.acceptExchange(requestBalanceAccept)
        } catch (e: Exception) {
            //모니터링용 슬랙 보내자
            throw GeneralException("00021")
        }
    }
}
