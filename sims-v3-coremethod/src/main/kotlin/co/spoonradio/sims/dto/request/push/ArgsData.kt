package co.spoonradio.sims.dto.request.push

data class ArgsData(
    val locArgs:List<String>? = emptyList(),
    val msgArgs:List<String>? = emptyList()
)
