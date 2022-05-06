package co.spoonradio.sims.dto.gateway.awsLambda

data class RequestSms (
    val user_id: String,
    val to_tel_num: String,
    val sms_type:Int = 1,
    val message: String,
    val is_test: Boolean = false,
)
