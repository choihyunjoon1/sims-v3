package co.spoonradio.sims.gateway.client

import co.spoonradio.sims.dto.request.cashout.RequestPayouts
import co.spoonradio.sims.dto.response.cashout.payoneer.PayeesStatusReports
import co.spoonradio.sims.dto.response.cashout.payoneer.Payouts
import org.springframework.web.bind.annotation.*

interface PayoneerApi {
    @PostMapping(value = ["{programId}/payouts"], consumes = ["application/json"], produces = ["application/json"])
    fun payouts(
        @PathVariable("programId") programId: String,
        @RequestBody request: RequestPayouts
    )

    @GetMapping(value = ["{programId}/payouts/{amountId}"])
    fun getPayouts(
        @PathVariable("programId") programId: String,
        @PathVariable("amountId") amountId: Long
    ) : Payouts

    @GetMapping(value = ["{programId}/reports/payees_status"])
    fun getPayeesStatus(
        @PathVariable("programId") programId: String,
        @RequestParam("start_date") startDate: String,
        @RequestParam("end_date") endDate: String,
    ) : PayeesStatusReports
}
