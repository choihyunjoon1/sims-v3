package co.spoonradio.sims.dto.request.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import java.time.LocalDateTime

data class RequestUnfitWord(
    var base: RequestBaseDto?,
    val to_contents: Boolean?,
    val to_nickname: Boolean?,
    val is_used: Boolean?,
)
