package co.spoonradio.sims.controller.cashout

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.cashout.*
import co.spoonradio.sims.dto.response.cashout.Amount
import co.spoonradio.sims.dto.response.cashout.ExchangeHistory
import co.spoonradio.sims.dto.response.cashout.payoneer.PayoneerExchange
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.service.cashout.PayoneerExchangeService
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["CashOut"])
@RestController
@RequestMapping("/cash-out/history/payoneer")
class PayoneerExchangeController(val service:PayoneerExchangeService) {

    @GetMapping
    fun getExchangeList(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestExchange
    ): SimsResponseEntity<List<PayoneerExchange>, ExtraDataEntity> {
        param.base = baseDto
        param.requestType = "PAYONEER"
        return service.getPayoneerExchangeList(param)
    }

    @GetMapping("{exchangeId}/amounts")
    fun getExchangeAmountList(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<Amount>, ExtraDataEntity> {
        return service.getPayoneerExchangeAmountList(RequestExchangeHistories(baseDto, exchangeId))
    }

    @GetMapping("{exchangeId}/history")
    fun getExchangeHistories(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity> {
        return service.getPayoneerExchangeHistories(RequestExchangeHistories(baseDto, exchangeId))
    }

    @PostMapping("confirm")
    @ResponseStatus(HttpStatus.CREATED)
    fun confirmPayoneerExchange(@RequestBody requestExchangeMultiple: RequestExchangeMultiple
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.confirmPayoneerExchange(requestExchangeMultiple)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }


    @PostMapping("{exchangeId}/reject")
    fun rejectPayoneerExchange(
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long,
        @RequestBody requestExchangeReject: RequestExchangeReject
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        requestExchangeReject.id = exchangeId
        service.rejectExchange(requestExchangeReject)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }
    @PostMapping("multiple-reject")
    @ResponseStatus(HttpStatus.CREATED)
    fun rejectMultiplePayoneerExchange(
        @RequestBody requestExchangeMultipleReject: RequestExchangeMultipleReject
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.rejectMultipleExchange(requestExchangeMultipleReject)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("{amountId}/amounts/request-payout")
    @ResponseStatus(HttpStatus.CREATED)
    fun requestPayoutPayoneerExchange(
        @PathVariable(value = "amountId", required = true) amountId: Long,
        @RequestBody requestPayoneerExchangePayout: RequestPayoneerExchangePayout
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.requestPayoutPayoneerExchange(requestPayoneerExchangePayout)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("request-payout")
    @ResponseStatus(HttpStatus.CREATED)
    fun requestMultiplePayoutPayoneerExchange(
        @RequestBody requestExchangeMultiple: RequestExchangeMultiple
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.requestMultiplePayoutPayoneerExchange(requestExchangeMultiple)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }


    @PostMapping("{exchangeId}/amounts/accept")
    @ResponseStatus(HttpStatus.CREATED)
    fun acceptPayoneerExchange(@PathVariable(value = "exchangeId", required = true) exchangeId: Long,
                               @RequestBody requestPayoneerExchangePayout: RequestPayoneerExchangePayout
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.acceptPayoneerExchange(requestPayoneerExchangePayout.amount_id)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("accept")
    @ResponseStatus(HttpStatus.CREATED)
    fun acceptMultiplePayoneerExchange(@RequestBody requestExchangeMultiple: RequestExchangeMultiple
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.acceptMultiplePayoneerExchange(requestExchangeMultiple)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("download-excel")
    @ResponseStatus(HttpStatus.CREATED)
    fun downloadExcelExchange(@ModelAttribute baseDto: RequestBaseDto,
                              @ModelAttribute param: RequestExchange,
                              @RequestBody requestDownloadExcelExchange: RequestDownloadExcelExchange
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        param.base = baseDto
        param.requestType = "PAYONEER"
        service.createExchangeExcel(param, requestDownloadExcelExchange)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

}
