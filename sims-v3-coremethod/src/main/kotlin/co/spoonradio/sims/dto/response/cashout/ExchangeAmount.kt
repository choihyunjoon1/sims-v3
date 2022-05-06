package co.spoonradio.sims.dto.response.cashout

data class ExchangeAmount (
    val exchangeId:Long,
    val applicantId:Int,
    val expectedExchangedDate: String,
    val amountId: Long,
    val balanceLockId:String,
    val currency:String,
    val amount:Int,
    val status:String
)
