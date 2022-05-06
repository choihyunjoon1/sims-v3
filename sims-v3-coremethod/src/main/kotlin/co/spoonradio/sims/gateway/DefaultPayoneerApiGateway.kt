package co.spoonradio.sims.gateway;

import co.spoonradio.sims.gateway.client.PayoneerApi
import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import co.spoonradio.sims.dto.request.cashout.RequestPayouts
import co.spoonradio.sims.dto.response.cashout.payoneer.PayeesStatusReports
import co.spoonradio.sims.dto.response.cashout.payoneer.Payouts
import co.spoonradio.sims.exception.GeneralException
import org.springframework.stereotype.Service

@Service
class DefaultPayoneerApiGateway(private val payoneerApi: PayoneerApi, private val simsEnvInfo: SimsEnvInfo) : PayoneerApiGateway {
    override fun payouts(requestPayouts: RequestPayouts) {
        try {
            payoneerApi.payouts(simsEnvInfo.payoneerProgramId, requestPayouts)
        } catch (e: Exception) {
            e.printStackTrace()
            throw GeneralException("00030")
        }
    }

    override fun getPayouts(amountId: Long): Payouts {
        val result = try {
            payoneerApi.getPayouts(simsEnvInfo.payoneerProgramId, amountId)
        } catch (e: Exception) {
            e.printStackTrace()
            throw GeneralException("00031")
        }

        return result
    }

    override fun getPayeesStatus(startDate: String, endDate: String): PayeesStatusReports {
        val result = try {
            payoneerApi.getPayeesStatus(simsEnvInfo.payoneerProgramId, startDate, endDate)
        } catch (e: Exception) {
            e.printStackTrace()
            throw GeneralException("00032")
        }

        return result
    }
}
