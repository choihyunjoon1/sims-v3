package co.spoonradio.sims.dto.response.payment

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class RefundHistory(
    val id:Long,
    val paymentMethodId:Long,
    val historyId:Long,
    val txId:String,
    val description:String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val createdDate:ZonedDateTime,
    val creator:Int,
    val orderId:String
)