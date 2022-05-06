package co.spoonradio.sims.dto.request.voc

data class RequestRegistUnfitWord(
    val id: Int? = null,
    val word: String,
    val to_contents: Boolean,
    val to_nickname: Boolean,
    val is_used: Boolean,
    val reword: String?=null
)
