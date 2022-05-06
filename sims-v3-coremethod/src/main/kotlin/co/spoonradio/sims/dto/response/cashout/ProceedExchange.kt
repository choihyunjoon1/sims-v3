package co.spoonradio.sims.dto.response.cashout

data class ProceedExchange(
    val id: Long,
    val expectedExchangedDate: String,
    val applicantId: Int,
    val phoneNumber:String = ""
)
