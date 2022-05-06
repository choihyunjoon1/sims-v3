package co.spoonradio.sims.dto.response.payment

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.ZonedDateTime

data class Payment(
    val id:Long,
    val paymentUser:PaymentUser,
    val paymentMethod:PaymentMethod,
    val userId:Long,
    val productId:Long,
    val status:String,
    val amount:Long,
    val spoonAmount:Int,
    val quantity:Int,
    val displayName:String,
    val orderId:String,
    val txId:String,
    val platform:String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val completed:ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val createdDate:ZonedDateTime,
    val type:Int,
    val paymentMethodId:Int
)

