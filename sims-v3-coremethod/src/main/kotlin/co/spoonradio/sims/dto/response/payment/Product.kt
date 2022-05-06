package co.spoonradio.sims.dto.response.payment

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class Product(
    val id:Long,
    val name:String,
    val price:Int,
    val amount:Int,
    val type:Int,
    val isUse:Boolean,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val createdDate:ZonedDateTime,
    val creator:Int,
    val store:Int
)