package co.spoonradio.sims.service.cashout

import co.spoonradio.sims.dto.request.cashout.RequestPayoneerExchangePayout
import co.spoonradio.sims.dto.request.cashout.*
import co.spoonradio.sims.dto.response.cashout.Amount
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.payoneer.PayoneerExchange
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity

interface PayoneerExchangeService {
    fun getPayoneerExchangeList(param: RequestExchange): SimsResponseEntity<List<PayoneerExchange>, ExtraDataEntity>
    fun getPayoneerExchangeAmountList(param: RequestExchangeHistories): SimsResponseEntity<List<Amount>, ExtraDataEntity>
    fun getPayoneerExchangeHistories(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity>
    fun confirmPayoneerExchange(requestExchangeMultiple: RequestExchangeMultiple)
    fun rejectExchange(requestExchangeReject: RequestExchangeReject)
    fun rejectMultipleExchange(requestExchangeMultipleReject: RequestExchangeMultipleReject)
    fun requestPayoutPayoneerExchange(requestPayoneerExchangePayout: RequestPayoneerExchangePayout)
    fun requestMultiplePayoutPayoneerExchange(requestExchangeMultiple: RequestExchangeMultiple)
    fun acceptPayoneerExchange(amountId: Long)
    fun acceptMultiplePayoneerExchange(requestExchangeMultiple: RequestExchangeMultiple)
    fun createExchangeExcel(param: RequestExchange, body: RequestDownloadExcelExchange)

}
