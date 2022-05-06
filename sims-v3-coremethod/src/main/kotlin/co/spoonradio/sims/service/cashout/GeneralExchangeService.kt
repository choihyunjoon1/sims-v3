package co.spoonradio.sims.service.cashout

import co.spoonradio.sims.controller.cashout.RequestChangeExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchangeApplyManually
import co.spoonradio.sims.dto.request.cashout.*
import co.spoonradio.sims.dto.response.cashout.*
import co.spoonradio.sims.dto.response.cashout.general.ExchangeApplyManually
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDocument
import co.spoonradio.sims.dto.response.cashout.general.GeneralExchange
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity

interface GeneralExchangeService {
    fun getGeneralExchangeList(param: RequestExchange): SimsResponseEntity<List<GeneralExchange>, ExtraDataEntity>
    fun getGeneralExchangeAmountList(param: RequestExchangeHistories): SimsResponseEntity<List<Amount>, ExtraDataEntity>
    fun getGeneralExchangeHistories(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity>
    fun getGeneralExchangeSubmitDocuments(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeDocument>, ExtraDataEntity>
    fun rejectGeneralExchange(requestExchangeReject: RequestExchangeReject)
    fun confirmGeneralExchange(requestExchangeMultiple: RequestExchangeMultiple)
    fun acceptExchange(requestExchangeMultiple: RequestExchangeMultiple)
    fun rejectMultipleGeneralExchange(requestExchangeMultipleReject: RequestExchangeMultipleReject)
    fun applyManuallyGeneralExchange(exchangeApplyManually: RequestExchangeApplyManually) : ExchangeApplyManually
    fun changeExpectedExchangeDate(param: RequestChangeExchange) :SimsResponseEntity<Exchange, ExtraDataEntity>
    fun createExchangeExcel(param: RequestExchange, body: RequestDownloadExcelExchange)
}
