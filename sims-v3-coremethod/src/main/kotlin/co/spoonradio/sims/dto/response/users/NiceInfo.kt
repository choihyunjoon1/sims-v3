package co.spoonradio.sims.dto.response.users;

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class NiceInfo(
    val id: Long? = null,
    val userId: Int? = null,
    val name: String? = null,
    val gender: Int? = null,
    val birthDate: String? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val created: ZonedDateTime? = null
)