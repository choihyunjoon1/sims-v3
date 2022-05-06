package co.spoonradio.sims.dto.response.voc.unfit
import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.ZonedDateTime

data class UnfitWord (
    val id: Int,
    val word: String,
    val to_contents: Boolean,
    val to_nickname: Boolean,
    val is_used: Boolean,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val created: ZonedDateTime,
    val reword: String? = null,
    val totalCount: Long
) : Serializable