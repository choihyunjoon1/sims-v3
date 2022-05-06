package co.spoonradio.sims.dto.response.cashout.general

data class Deposit (
    val id:Long,
    val accountHolder:String,
    val applicantName:String,
    var residentFirstNumber:String,
    var residentLastNumber:String,
    var accountNumber:String,
    val email:String,
    val phoneNumber:String,
    val exchangeBank:String,
    val isMinor:Boolean,
    val isDifferentAccountHolder:Boolean,
    val privacyConsent:Boolean,
    val residentCollectionConsent:Boolean,
    val exchange:Long
)
