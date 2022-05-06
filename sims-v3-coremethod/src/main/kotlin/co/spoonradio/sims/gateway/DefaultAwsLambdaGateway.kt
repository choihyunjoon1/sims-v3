package co.spoonradio.sims.gateway;

import co.spoonradio.sims.gateway.client.AwsLambdaApi
import co.spoonradio.sims.dto.gateway.awsLambda.RequestSms
import co.spoonradio.sims.exception.GeneralException
import org.springframework.stereotype.Service

@Service
class DefaultAwsLambdaGateway(private val awsLambdaApi: AwsLambdaApi) : AwsLambdaGateway{
    override fun sendSms(resuestSms: RequestSms) {
        try {
            awsLambdaApi.sendSms(resuestSms)
        } catch (e: Exception) {
            throw GeneralException("00019")
        }
    }
}
