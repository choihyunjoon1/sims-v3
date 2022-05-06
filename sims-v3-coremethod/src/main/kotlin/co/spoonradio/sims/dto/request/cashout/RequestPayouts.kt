package co.spoonradio.sims.dto.request.cashout

data class RequestPayouts(
    val payee_id: Int, // amount_entity.exchange.applicantId
    val amount: Int, // amount_entity.amount
    val client_reference_id: Long, // amount_entity.id
    val description: String, // 고정
    val currency: String, // 고정
    val payout_date: String, // 요청일
    val group_id: String, // 요청일
)