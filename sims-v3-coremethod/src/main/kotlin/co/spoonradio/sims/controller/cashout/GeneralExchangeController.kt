package co.spoonradio.sims.controller.cashout

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.cashout.*
import co.spoonradio.sims.dto.response.cashout.*
import co.spoonradio.sims.dto.response.cashout.general.ExchangeApplyManually
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDocument
import co.spoonradio.sims.dto.response.cashout.general.GeneralExchange
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.service.cashout.GeneralExchangeService
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Api(tags = ["CashOut"])
@RestController
@RequestMapping("/cash-out/history/general")
class GeneralExchangeController(val service:GeneralExchangeService) {

    @GetMapping
    fun getGeneralExchangeList(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestExchange
    ): SimsResponseEntity<List<GeneralExchange>, ExtraDataEntity> {
        param.base = baseDto
        return service.getGeneralExchangeList(param)
    }

    @GetMapping("{exchangeId}/amounts")
    fun getGeneralExchangeAmountList(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<Amount>, ExtraDataEntity> {
        return service.getGeneralExchangeAmountList(RequestExchangeHistories(baseDto, exchangeId))
    }

    @GetMapping("{exchangeId}/history")
    fun getGeneralExchangeHistories(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<ExchangeHistory>, ExtraDataEntity> {
        return service.getGeneralExchangeHistories(RequestExchangeHistories(baseDto, exchangeId))
    }

    @GetMapping("{exchangeId}/submit-documents")
    fun getGeneralExchangeSubmitDocument(
        @ModelAttribute baseDto: RequestBaseDto,
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long
    ): SimsResponseEntity<List<ExchangeDocument>, ExtraDataEntity> {
        return service.getGeneralExchangeSubmitDocuments(RequestExchangeHistories(baseDto, exchangeId))
    }


    @PostMapping("{exchangeId}/reject")
    fun rejectGeneralExchange(
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long,
        @RequestBody requestExchangeReject: RequestExchangeReject
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        requestExchangeReject.id = exchangeId
        service.rejectGeneralExchange(requestExchangeReject)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("confirm")
    @ResponseStatus(HttpStatus.CREATED)
    fun confirmGeneralExchange(@RequestBody requestExchangeMultiple: RequestExchangeMultiple
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.confirmGeneralExchange(requestExchangeMultiple)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("accept")
    @ResponseStatus(HttpStatus.CREATED)
    fun acceptGeneralExchange(@RequestBody requestExchangeMultiple: RequestExchangeMultiple
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.acceptExchange(requestExchangeMultiple)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("multiple-reject")
    @ResponseStatus(HttpStatus.CREATED)
    fun rejectMultipleGeneralExchange(
        @RequestBody requestExchangeMultipleReject: RequestExchangeMultipleReject
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.rejectMultipleGeneralExchange(requestExchangeMultipleReject)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PostMapping("apply-manually", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun applyManuallyGeneralExchange(
        @ModelAttribute param: RequestExchangeApplyManually,
    ): SimsResponseEntity<ExchangeApplyManually, ExtraDataEntity> {
        val responseDepositExchange = service.applyManuallyGeneralExchange(param)
        return SimsResponseEntity(responseDepositExchange, ExtraDataEntity())
    }

    @PatchMapping("{exchangeId}")
    fun changeExpectedExchangeDate(
        @PathVariable(value = "exchangeId", required = true) exchangeId: Long,
        @RequestBody requestChangeExchange: RequestChangeExchange
    ): SimsResponseEntity<Exchange, ExtraDataEntity> {
        requestChangeExchange.id = exchangeId
        return service.changeExpectedExchangeDate(requestChangeExchange)
    }

    @PostMapping("download-excel")
    @ResponseStatus(HttpStatus.CREATED)
    fun downloadExcelGeneralExchange(@ModelAttribute baseDto: RequestBaseDto,
                                     @ModelAttribute param: RequestExchange,
                                     @RequestBody requestDownloadExcelExchange: RequestDownloadExcelExchange
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        param.base = baseDto
        service.createExchangeExcel(param, requestDownloadExcelExchange)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

}
