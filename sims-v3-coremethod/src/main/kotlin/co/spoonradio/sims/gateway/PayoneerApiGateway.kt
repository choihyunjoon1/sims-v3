package co.spoonradio.sims.gateway;

import co.spoonradio.sims.dto.request.cashout.RequestPayouts
import co.spoonradio.sims.dto.response.cashout.payoneer.PayeesStatusReports
import co.spoonradio.sims.dto.response.cashout.payoneer.Payouts

interface PayoneerApiGateway {
    fun payouts(requestPayouts: RequestPayouts)
    fun getPayouts(amountId: Long): Payouts
    fun getPayeesStatus(startDate: String, endDate: String): PayeesStatusReports
}