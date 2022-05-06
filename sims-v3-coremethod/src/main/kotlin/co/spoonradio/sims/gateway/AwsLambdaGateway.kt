package co.spoonradio.sims.gateway;

import co.spoonradio.sims.dto.gateway.awsLambda.RequestSms

interface AwsLambdaGateway {
    fun sendSms(resuestSms: RequestSms)
}
