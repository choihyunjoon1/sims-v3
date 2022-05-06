package co.spoonradio.sims.dto.response.payment

data class PaymentUser(
    val id:Long,
    val tag:String,
    val nickname:String,
    val status:Int
)