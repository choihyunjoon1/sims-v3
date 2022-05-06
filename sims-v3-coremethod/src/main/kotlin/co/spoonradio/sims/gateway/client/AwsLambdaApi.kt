package co.spoonradio.sims.gateway.client;

import co.spoonradio.sims.dto.gateway.awsLambda.RequestSms
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface AwsLambdaApi {

    @PostMapping(value = ["/send-sms"], consumes = ["application/json"], produces = ["application/json"])
    fun sendSms(@RequestBody request: RequestSms)

    @PostMapping(value = ["/send-slack"], consumes = ["application/json"], produces = ["application/json"])
    fun sendSlack(@RequestBody request: RequestSms)
}