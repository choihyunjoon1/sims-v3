package co.spoonradio.sims.controller.cashout

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.cashout.RequestDownloadExcelExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchangeHistories
import co.spoonradio.sims.dto.response.cashout.Amount
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.dotmoney.DotmoneyExchange
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.service.cashout.DotmoneyExchangeService
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["CashOut"])
@RestController
@RequestMapping("/cash-out/history/dot-money")
class DotmoneyExchangeController(val service:DotmoneyExchangeService) {

    @GetMapping
    fun getExchangeList(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestExchange
    ): SimsResponseEntity<List<DotmoneyExchange>, ExtraDataEntity> {
        param.base = baseDto
        param.requestType = "DOTMONEY"
        return service.getDotmoneyExchangeList(param)
    }

    @GetMapping("{exchangeId}/amounts")
    fun getExchangeAmountList(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<Amount>, ExtraDataEntity> {
        return service.getDotmoneyExchangeAmountList(RequestExchangeHistories(baseDto, exchangeId))
    }

    @GetMapping("{exchangeId}/history")
    fun getExchangeHistories(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity> {
        return service.getDotmoneyExchangeHistories(RequestExchangeHistories(baseDto, exchangeId))
    }

    @PostMapping("download-excel")
    @ResponseStatus(HttpStatus.CREATED)
    fun downloadExcelGeneralExchange(@ModelAttribute baseDto: RequestBaseDto,
                                     @ModelAttribute param: RequestExchange,
                                     @RequestBody requestDownloadExcelExchange: RequestDownloadExcelExchange
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        param.base = baseDto
        param.requestType = "DOTMONEY"
        service.createExchangeExcel(param, requestDownloadExcelExchange)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

}
