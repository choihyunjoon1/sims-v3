package co.spoonradio.sims.dto.response.payment

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class AppleStoreHistory(
    val id:Long,
    val payment: Payment,
    val product: Product,
    val promotion: Promotion?,
    val refundHistory:RefundHistory?,
    val status:String,
    val userId:Long,
    val productId:Long,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val created:ZonedDateTime,
    val transactionId:String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val transactionDate:ZonedDateTime,
    val transactionState:Int,
    val modelName:String,
    val buildNo:Int,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val consumeTime:ZonedDateTime
)
