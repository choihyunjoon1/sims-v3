package co.spoonradio.sims.gateway.client

import co.spoonradio.sims.dto.request.balance.RequestBalanceAccept
import co.spoonradio.sims.dto.request.balance.RequestBalanceExchange
import co.spoonradio.sims.dto.request.balance.RequestBalanceReject
import co.spoonradio.sims.dto.response.clientapi.BalanceExchange
import co.spoonradio.sims.dto.response.clientapi.BalanceInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
//@FeignClient(name = "example", url = "http://kr-balance-api.devspoon.net/v1/balance", configuration = [FeignConfiguration::class])
interface BalanceApi {
    @GetMapping(value = ["/users/{userId}"])
    fun getUserBalance(
        @PathVariable("userId") userId: Int
    ): BalanceInfo

    @PostMapping(value = ["/exchange/accept"], consumes = ["application/json"], produces = ["application/json"])
    fun acceptExchange(@RequestBody request: RequestBalanceAccept): BalanceExchange

    @PostMapping(value = ["/exchange/reject"], consumes = ["application/json"], produces = ["application/json"])
    fun rejectExchange(@RequestBody request: RequestBalanceReject): BalanceExchange

    @PostMapping(value = ["/exchange/request"], consumes = ["application/json"], produces = ["application/json"])
    fun requestExchange(@RequestBody request: RequestBalanceExchange): BalanceExchange


}