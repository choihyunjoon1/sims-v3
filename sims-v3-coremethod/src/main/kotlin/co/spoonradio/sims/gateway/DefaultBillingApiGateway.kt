package co.spoonradio.sims.gateway;

import co.spoonradio.sims.gateway.client.BillingApi
import co.spoonradio.sims.dto.request.cashout.RequestDepositExchange
import co.spoonradio.sims.dto.response.cashout.general.ExchangeApplyManually
import co.spoonradio.sims.exception.GeneralException
import org.springframework.stereotype.Service

@Service
class DefaultBillingApiGateway(private val billingApi: BillingApi) : BillingApiGateway{
    override fun depositExchanges(userId: Int, requestDepositExchange: RequestDepositExchange) : ExchangeApplyManually {
        return try {
             billingApi.depositExchanges(
                 userId,
                 requestDepositExchange.exchangeSpoon,
                 requestDepositExchange.applicantName,
                 requestDepositExchange.email,
                 requestDepositExchange.phoneNumber,
                 requestDepositExchange.residentFirstNumber,
                 requestDepositExchange.residentLastNumber,
                 requestDepositExchange.accountHolder,
                 requestDepositExchange.exchangeBank,
                 requestDepositExchange.accountNumber,
                 requestDepositExchange.privacyConsent,
                 requestDepositExchange.residentCollectionConsent,
                 requestDepositExchange.familyRelationCertificates,
                 requestDepositExchange.legalRepresentativeAgreement
             )
        } catch (e: Exception) {
            e.printStackTrace()
            throw GeneralException("00022")
        }
    }
}
