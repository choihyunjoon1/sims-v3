package co.spoonradio.sims.service.cashout

import co.spoonradio.sims.dto.request.cashout.RequestDownloadExcelExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchangeHistories
import co.spoonradio.sims.dto.response.cashout.Amount
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.dotmoney.DotmoneyExchange
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity

interface DotmoneyExchangeService {
    fun getDotmoneyExchangeList(param: RequestExchange): SimsResponseEntity<List<DotmoneyExchange>, ExtraDataEntity>
    fun getDotmoneyExchangeAmountList(param: RequestExchangeHistories): SimsResponseEntity<List<Amount>, ExtraDataEntity>
    fun getDotmoneyExchangeHistories(param: RequestExchangeHistories): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity>
    fun createExchangeExcel(param: RequestExchange, body: RequestDownloadExcelExchange)
}
