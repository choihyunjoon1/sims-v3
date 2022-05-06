package co.spoonradio.sims.repository.cashout

import co.spoonradio.sims.dto.request.cashout.RequestExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchangeMultiple
import co.spoonradio.sims.dto.request.cashout.RequestExchangeHistories
import co.spoonradio.sims.dto.request.cashout.RequestExchangeReject
import co.spoonradio.sims.dto.response.cashout.*
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDeposit
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDocument
import java.time.LocalDate


interface BillingExchangeRepository {
    //General(KR)
    fun getGeneralExchangeDepositList(param: RequestExchange): Pair<List<ExchangeDeposit>, Long>
    fun getGeneralExchangeDepositSummary(param: RequestExchange): ExchangeSummary
    fun getGeneralExchangeSubmitDocuments(param: RequestExchangeHistories): Pair<List<ExchangeDocument>, Long>
    fun getGeneralExchangeListByIdsAndStatus(param: RequestExchangeMultiple): List<ProceedExchange>
    fun getGeneralExchangeByIdAndStatus(exchangeId: Long, actionType: List<String>): ProceedExchange
    fun getExchangeAmountListByExchangeIdAndStatus(exchangeId: Long, status: String): List<Amount>

    // Payoneer(AR/US), Dotmoney(JP)
    fun getExchangeList(param: RequestExchange): Pair<List<Exchange>, Long>

    // 공통
    fun getExchangeSummary(param: RequestExchange): ExchangeSummary
    fun getExchangeAmountList(param: RequestExchangeHistories): Pair<List<Amount>, Long>
    fun getExchangeHistories(param: RequestExchangeHistories): Pair<List<ExchangeHistory>, Long>
    fun getExchangeAmountListByExchangeId(exchangeId: Long) :List<Amount>
    fun getExchangeById(exchangeId: Long): Exchange

    // Payoneer(AR/US)
    fun getExchangeListByIdsAndStatus(requestExchangeMultiple: RequestExchangeMultiple): List<Exchange>
    fun getExchangeByIdAndStatus(exchangeId: Long, actionType:List<String>): Exchange
    fun getExchangeAmountByIdAndStatus(amountId: Long, actionType: String): Amount
    fun getLatestExchangeAmountListByExchangeId(exchangeId: List<Long>, actionType: List<String>) : List<ExchangeAmount>
    fun getExchangeAmountCountByExchangeIdAndStatusAndIdNot(amountId: Long, exchangeId: Long, actionType: List<String>) : Int
    fun getExchangeAmountListByExchangeIdsAndStatus(exchangeIds: List<Long>, actionType: List<String>) : List<ExchangeAmount>

    //General(KR), Payoneer(AR/US)
    fun updateExchangeAcceptComplete(exchangeId: Long, status: String, amount: Int): Int
    fun updateExchangeAmount(exchangeAmountId: Long, status: String): Int
    fun updateExchange(exchangeId: Long, status: String): Int
    fun updateExchangeAccept(exchangeId: Long, amount: Int, expectedExchangeDate: LocalDate): Int
    fun updateExchangeExpectedExchangedDateById(exchangeId: Long, expectedExchangeDate: LocalDate): Int
    fun insertExchangeRejectReason(requestExchangeReject: RequestExchangeReject): Int
    fun insertExchangeHistory(exchangeId: Long, status: String): Int
}
