package co.spoonradio.sims.dto.response.payment

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class PaymentMethod(
    val id:Long,
    val name:String,
    val pgId:Long,
    val type:Int,
    val fee:Int,
    val description:String,
    val isUse:Boolean,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val createdDate:ZonedDateTime,
    val creator:Int
)