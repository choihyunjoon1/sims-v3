package co.spoonradio.sims.dto.response.payment

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.ZonedDateTime

data class Promotion(
    val id:Long,
    val name:String,
    val code:String,
    val value:Int,
    val isUse:Boolean,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val startDate:ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val endDate:ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val createdDate:ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val updatedDate:ZonedDateTime,
    val creator:Int,
    val updater:Int
): Serializable