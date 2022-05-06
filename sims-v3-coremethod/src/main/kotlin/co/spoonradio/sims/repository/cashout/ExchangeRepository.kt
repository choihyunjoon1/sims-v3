package co.spoonradio.sims.repository.cashout

import co.spoonradio.arch.extension.addWhen
import co.spoonradio.sims.common.cipher.AESCipher
import co.spoonradio.sims.common.extension.*
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.cashout.RequestExchange
import co.spoonradio.sims.dto.request.cashout.RequestExchangeHistories
import co.spoonradio.sims.dto.request.cashout.RequestExchangeMultiple
import co.spoonradio.sims.dto.request.cashout.RequestExchangeReject
import co.spoonradio.sims.dto.response.cashout.*
import co.spoonradio.sims.dto.response.cashout.general.Deposit
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDeposit
import co.spoonradio.sims.dto.response.cashout.general.ExchangeDocument
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.billing.tables.references.*
import co.spoonradio.sims.repository.condition.CommonCondition
import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.jooq.impl.DSL
import org.jooq.impl.DSL.*
import org.slf4j.MDC
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime

@Repository
class ExchangeRepository(val billingDslContext: DSLContext, val aesCipher: AESCipher) : BillingExchangeRepository, CommonCondition() {

    override fun getGeneralExchangeDepositList(param: RequestExchange): Pair<List<ExchangeDeposit>, Long> {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        var searchCondition = this.setSearchCondition(base, param)

        val result = billingDslContext
            .select(
                TBEXCHANGE.ID,
                DSL.field(
                    DSL.selectCount().from(TBEXCHANGESUBMITDOCUMENT).where(
                        TBEXCHANGESUBMITDOCUMENT.EXCHANGEID.eq(
                            TBEXCHANGE.ID)))
                    .`as`("submitDocumentCount"),
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.METHODTYPE,
                TBEXCHANGE.TOTALEXCHANGESPOON,
                TBEXCHANGE.CURRENCY,
                TBEXCHANGE.TOTALEXCHANGEAMOUNT,
                TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.STATUS,
                TBEXCHANGE.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGE.UPDATED.zonedDateTime.`as`("updated"),
                TBEXCHANGEDEPOSIT.ID,
                TBEXCHANGEDEPOSIT.ACCOUNTHOLDER,
                TBEXCHANGEDEPOSIT.APPLICANTNAME,
                TBEXCHANGEDEPOSIT.RESIDENTFIRSTNUMBER,
                TBEXCHANGEDEPOSIT.RESIDENTLASTNUMBER,
                TBEXCHANGEDEPOSIT.ACCOUNTNUMBER,
                TBEXCHANGEDEPOSIT.EMAIL,
                TBEXCHANGEDEPOSIT.PHONENUMBER,
                TBEXCHANGEDEPOSIT.EXCHANGEBANK,
                TBEXCHANGEDEPOSIT.ISMINOR,
                TBEXCHANGEDEPOSIT.ISDIFFERENTACCOUNTHOLDER,
                TBEXCHANGEDEPOSIT.PRIVACYCONSENT,
                TBEXCHANGEDEPOSIT.RESIDENTCOLLECTIONCONSENT,
                TBEXCHANGEDEPOSIT.EXCHANGEID,
                TBEXCHANGEREJECTREASON.ID,
                TBEXCHANGEREJECTREASON.REASON,
                TBEXCHANGEREJECTREASON.CREATED.zonedDateTime.`as`("rejectReasonCreated"),
                TBEXCHANGEREJECTREASON.CREATOR,
                TBEXCHANGEREJECTREASON.UPDATED.zonedDateTime.`as`("rejectReasonUpdated"),
                TBEXCHANGEREJECTREASON.UPDATER,
                TBEXCHANGEREJECTREASON.EXCHANGEID
            )
            .hint("SQL_CALC_FOUND_ROWS")
            .from(TBEXCHANGE)
            .join(TBEXCHANGEDEPOSIT).on(TBEXCHANGE.ID.eq(TBEXCHANGEDEPOSIT.EXCHANGEID))
            .join(TBEXCHANGEAMOUNT).on(TBEXCHANGE.ID.eq(TBEXCHANGEAMOUNT.EXCHANGEID))
            .leftJoin(TBEXCHANGEREJECTREASON).on(TBEXCHANGE.ID.eq(TBEXCHANGEREJECTREASON.EXCHANGEID))
            .where(TBEXCHANGE.METHODTYPE.eq("DEPOSIT"))
            .and(searchCondition)
            .orderBy(TBEXCHANGE.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetch()

        val totalCount = this.getTotalCount(billingDslContext)
        val data = result.map { record ->
            ExchangeDeposit(
                record.get(TBEXCHANGE.ID, Long::class.java),
                if (MDC.get("UNMASKING").equals("true")) {
                    Deposit(
                        record.get(TBEXCHANGEDEPOSIT.ID, Long::class.java),
                        record.get(TBEXCHANGEDEPOSIT.ACCOUNTHOLDER, String::class.java).nameMasking,
                        record.get(TBEXCHANGEDEPOSIT.APPLICANTNAME, String::class.java).nameMasking,
                        aesCipher.decrypt(record.get(TBEXCHANGEDEPOSIT.RESIDENTFIRSTNUMBER, String::class.java)).residentFirstNumberMasking,
                        aesCipher.decrypt(record.get(TBEXCHANGEDEPOSIT.RESIDENTLASTNUMBER, String::class.java)).residentLastNumberMasking,
                        aesCipher.decrypt(record.get(TBEXCHANGEDEPOSIT.ACCOUNTNUMBER, String::class.java)).accountNumberMasking,
                        record.get(TBEXCHANGEDEPOSIT.EMAIL, String::class.java).emailMasking,
                        record.get(TBEXCHANGEDEPOSIT.PHONENUMBER, String::class.java).phoneNumMasking,
                        record.get(TBEXCHANGEDEPOSIT.EXCHANGEBANK, String::class.java),
                        record.get(TBEXCHANGEDEPOSIT.ISMINOR, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.ISDIFFERENTACCOUNTHOLDER, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.PRIVACYCONSENT, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.RESIDENTCOLLECTIONCONSENT, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.EXCHANGEID, Long::class.java)
                    )
                } else {
                    Deposit(
                        record.get(TBEXCHANGEDEPOSIT.ID, Long::class.java),
                        record.get(TBEXCHANGEDEPOSIT.ACCOUNTHOLDER, String::class.java),
                        record.get(TBEXCHANGEDEPOSIT.APPLICANTNAME, String::class.java),
                        aesCipher.decrypt(record.get(TBEXCHANGEDEPOSIT.RESIDENTFIRSTNUMBER, String::class.java)),
                        aesCipher.decrypt(record.get(TBEXCHANGEDEPOSIT.RESIDENTLASTNUMBER, String::class.java)),
                        aesCipher.decrypt(record.get(TBEXCHANGEDEPOSIT.ACCOUNTNUMBER, String::class.java)),
                        record.get(TBEXCHANGEDEPOSIT.EMAIL, String::class.java),
                        record.get(TBEXCHANGEDEPOSIT.PHONENUMBER, String::class.java),
                        record.get(TBEXCHANGEDEPOSIT.EXCHANGEBANK, String::class.java),
                        record.get(TBEXCHANGEDEPOSIT.ISMINOR, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.ISDIFFERENTACCOUNTHOLDER, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.PRIVACYCONSENT, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.RESIDENTCOLLECTIONCONSENT, Boolean::class.java),
                        record.get(TBEXCHANGEDEPOSIT.EXCHANGEID, Long::class.java)
                    )
                },
                RejectReason(
                    record.get(TBEXCHANGEREJECTREASON.ID, Long::class.java),
                    record.get(TBEXCHANGEREJECTREASON.REASON, String::class.java),
                    record.get("rejectReasonCreated", ZonedDateTime::class.java),
                    record.get(TBEXCHANGEREJECTREASON.CREATOR, Int::class.java),
                    record.get("rejectReasonUpdated", ZonedDateTime::class.java),
                    record.get(TBEXCHANGEREJECTREASON.UPDATER, Int::class.java),
                    record.get(TBEXCHANGEREJECTREASON.EXCHANGEID, Long::class.java)
                ),
                record.get("submitDocumentCount", Int::class.java),
                record.get(TBEXCHANGE.APPLICANTID, Int::class.java),
                record.get(TBEXCHANGE.METHODTYPE, String::class.java),
                record.get(TBEXCHANGE.TOTALEXCHANGESPOON, Int::class.java),
                record.get(TBEXCHANGE.CURRENCY, String::class.java),
                record.get(TBEXCHANGE.TOTALEXCHANGEAMOUNT, Long::class.java),
                record.get(TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT, Long::class.java),
                record.get(TBEXCHANGE.EXPECTEDEXCHANGEDDATE, String::class.java),
                record.get(TBEXCHANGE.STATUS, String::class.java),
                record.get("created", ZonedDateTime::class.java),
                record.get("updated", ZonedDateTime::class.java),
                totalCount)}
        return Pair(data, totalCount)
    }

    override fun getGeneralExchangeDepositSummary(param: RequestExchange): ExchangeSummary {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        var searchCondition: Condition = noCondition()
        param.apply {
            status?.let {
                searchCondition = searchCondition.and(TBEXCHANGE.STATUS.eq(status))
            }
            amount_status?.let {
                searchCondition =
                    searchCondition.and(TBEXCHANGEAMOUNT.STATUS.eq(amount_status))
            }
            is_minor?.let { searchCondition = searchCondition.and(TBEXCHANGEDEPOSIT.ISMINOR.eq(is_minor)) }


            user_Ids?.let {
                if (it.isNotEmpty()) searchCondition = searchCondition.and(TBEXCHANGE.APPLICANTID.`in`(user_Ids))
            }

            base.from_date?.let {
                if (it.isNotEmpty()) searchCondition = searchCondition.and(TBEXCHANGE.EXPECTEDEXCHANGEDDATE.ge(LocalDate.parse(base.from_date)))
            }

            base.to_date?.let {
                if (it.isNotEmpty()) searchCondition = searchCondition.and(TBEXCHANGE.EXPECTEDEXCHANGEDDATE.le(LocalDate.parse(base.to_date)))
            }
        }

        val result = billingDslContext
            .select(
                sum(nullif(TBEXCHANGE.TOTALEXCHANGEAMOUNT, 0L)).`as`("totalExchangedAmount"),
                sum(nullif(TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT, 0L)).`as`("totalExpectedAmount")
            )
            .from(TBEXCHANGE)
            .join(TBEXCHANGEDEPOSIT).on(TBEXCHANGE.ID.eq(TBEXCHANGEDEPOSIT.EXCHANGEID))
            .join(TBEXCHANGEAMOUNT).on(TBEXCHANGE.ID.eq(TBEXCHANGEAMOUNT.EXCHANGEID))
            .where(TBEXCHANGE.METHODTYPE.eq("DEPOSIT"))
            .and(searchCondition)

            .fetchOneInto(ExchangeSummary::class.java)
        return result!!
    }

    override fun getGeneralExchangeSubmitDocuments(param: RequestExchangeHistories): Pair<List<ExchangeDocument>, Long> {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        val result = billingDslContext
            .select(TBEXCHANGESUBMITDOCUMENT.ID,
                TBEXCHANGESUBMITDOCUMENT.EXCHANGEID.`as`("exchange"),
                TBEXCHANGESUBMITDOCUMENT.TYPE,
                TBEXCHANGESUBMITDOCUMENT.URL,
                TBEXCHANGESUBMITDOCUMENT.CREATED.zonedDateTime.`as`("created")
            )
            .hint("SQL_CALC_FOUND_ROWS")
            .from(TBEXCHANGESUBMITDOCUMENT)
            .where(TBEXCHANGESUBMITDOCUMENT.EXCHANGEID.eq(param.exchangeId))
            .orderBy(TBEXCHANGESUBMITDOCUMENT.ID.asc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(ExchangeDocument::class.java)

        return Pair<List<ExchangeDocument>, Long>(result,  this.getTotalCount(billingDslContext))
    }

    override fun getGeneralExchangeListByIdsAndStatus(param: RequestExchangeMultiple): List<ProceedExchange> {
        return billingDslContext
            .select(TBEXCHANGE.ID,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGEDEPOSIT.PHONENUMBER)
            .from(TBEXCHANGE)
            .join(TBEXCHANGEDEPOSIT).on(TBEXCHANGE.ID.eq(TBEXCHANGEDEPOSIT.EXCHANGEID))
            .where(TBEXCHANGE.ID.`in`(param.exchange_ids))
            .and(TBEXCHANGE.STATUS.`in`(param.actionType))
            .fetchInto(ProceedExchange::class.java)
    }

    override fun getGeneralExchangeByIdAndStatus(exchangeId: Long, actionType:List<String>): ProceedExchange {
        return billingDslContext
            .select(TBEXCHANGE.ID,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGEDEPOSIT.PHONENUMBER
            )
            .from(TBEXCHANGE)
            .join(TBEXCHANGEDEPOSIT).on(TBEXCHANGE.ID.eq(TBEXCHANGEDEPOSIT.EXCHANGEID))
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .addWhen(actionType.isNotEmpty()) { and(TBEXCHANGE.STATUS.`in`(actionType)) }
            .fetchOneInto(ProceedExchange::class.java) ?: throw GeneralException("00010")
    }

    override fun getExchangeAmountListByExchangeIdAndStatus(exchangeId: Long, status: String): List<Amount> {
        return billingDslContext
            .select(TBEXCHANGEAMOUNT.ID,
                TBEXCHANGEAMOUNT.EXCHANGEID.`as`("exchange"),
                TBEXCHANGEAMOUNT.BALANCELOCKID,
                TBEXCHANGEAMOUNT.CURRENCY,
                TBEXCHANGEAMOUNT.AMOUNT,
                TBEXCHANGEAMOUNT.STATUS,
                TBEXCHANGEAMOUNT.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGEAMOUNT.UPDATED.zonedDateTime.`as`("updated"),
            )
            .from(TBEXCHANGEAMOUNT)
            .where(TBEXCHANGEAMOUNT.EXCHANGEID.eq(exchangeId))
            .and(TBEXCHANGEAMOUNT.STATUS.eq(status))
            .fetchInto(Amount::class.java)
    }

    override fun getExchangeList(param: RequestExchange): Pair<List<Exchange>, Long> {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        var searchCondition = this.setSearchCondition(base, param)

        val result = billingDslContext
            .select(
                TBEXCHANGE.ID,
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.METHODTYPE,
                TBEXCHANGE.TOTALEXCHANGESPOON,
                TBEXCHANGE.CURRENCY,
                TBEXCHANGE.TOTALEXCHANGEAMOUNT,
                TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.STATUS,
                TBEXCHANGE.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGE.UPDATED.zonedDateTime.`as`("updated"),
                max(TBEXCHANGEREJECTREASON.ID).`as`("rejectReasonId"),
                max(TBEXCHANGEREJECTREASON.REASON).`as`("rejectReason"),
                max(TBEXCHANGEREJECTREASON.CREATED.zonedDateTime).`as`("rejectReasonCreated"),
                max(TBEXCHANGEREJECTREASON.CREATOR).`as`("rejectReasonCreator"),
                max(TBEXCHANGEREJECTREASON.UPDATED.zonedDateTime).`as`("rejectReasonUpdated"),
                max(TBEXCHANGEREJECTREASON.UPDATER).`as`("rejectReasonUpdater"),
                max(TBEXCHANGEREJECTREASON.EXCHANGEID).`as`("rejectReasonExchangeId")
            )
            .hint("SQL_CALC_FOUND_ROWS")
            .from(TBEXCHANGE)
            .join(TBEXCHANGEAMOUNT).on(TBEXCHANGE.ID.eq(TBEXCHANGEAMOUNT.EXCHANGEID))
            .leftJoin(TBEXCHANGEREJECTREASON).on(TBEXCHANGE.ID.eq(TBEXCHANGEREJECTREASON.EXCHANGEID))
            .where(TBEXCHANGE.METHODTYPE.eq(param.requestType))
            .and(searchCondition)
            .groupBy(TBEXCHANGE.ID)
            .orderBy(TBEXCHANGE.ID.desc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetch()

        val totalCount = this.getTotalCount(billingDslContext)
        val data = result.map { record -> Exchange(
            record.get(TBEXCHANGE.ID, Long::class.java),
            RejectReason(
                record.get("rejectReasonId", Long::class.java),
                record.get("rejectReason", String::class.java),
                record.get("rejectReasonCreated", ZonedDateTime::class.java),
                record.get("rejectReasonCreator", Int::class.java),
                record.get("rejectReasonUpdated", ZonedDateTime::class.java),
                record.get("rejectReasonUpdater", Int::class.java),
                record.get("rejectReasonExchangeId", Long::class.java)
            ),
            record.get(TBEXCHANGE.APPLICANTID, Int::class.java),
            record.get(TBEXCHANGE.METHODTYPE, String::class.java),
            record.get(TBEXCHANGE.TOTALEXCHANGESPOON, Int::class.java),
            record.get(TBEXCHANGE.CURRENCY, String::class.java),
            record.get(TBEXCHANGE.TOTALEXCHANGEAMOUNT, Long::class.java),
            record.get(TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT, Long::class.java),
            record.get(TBEXCHANGE.EXPECTEDEXCHANGEDDATE, String::class.java),
            record.get(TBEXCHANGE.STATUS, String::class.java),
            record.get("created", ZonedDateTime::class.java),
            record.get("updated", ZonedDateTime::class.java),
            totalCount)}
        return Pair(data, totalCount)
    }

    override fun getExchangeSummary(param: RequestExchange): ExchangeSummary {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        var searchCondition = this.setSearchCondition(base, param)

        val result = billingDslContext
            .select(
                sum(nullif(TBEXCHANGE.TOTALEXCHANGEAMOUNT, 0L)).`as`("totalExchangedAmount"),
                sum(nullif(TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT, 0L)).`as`("totalExpectedAmount")
            )
            .from(TBEXCHANGE)
            .join(TBEXCHANGEAMOUNT).on(TBEXCHANGE.ID.eq(TBEXCHANGEAMOUNT.EXCHANGEID))
            .where(TBEXCHANGE.METHODTYPE.eq(param.requestType))
            .and(searchCondition)

            .fetchOneInto(ExchangeSummary::class.java)
        return result!!
    }

    override fun getExchangeAmountList(param: RequestExchangeHistories): Pair<List<Amount>, Long> {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        val result = billingDslContext
            .select(TBEXCHANGEAMOUNT.ID,
                TBEXCHANGEAMOUNT.EXCHANGEID.`as`("exchange"),
                TBEXCHANGEAMOUNT.BALANCELOCKID,
                TBEXCHANGEAMOUNT.CURRENCY,
                TBEXCHANGEAMOUNT.AMOUNT,
                TBEXCHANGEAMOUNT.STATUS,
                TBEXCHANGEAMOUNT.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGEAMOUNT.UPDATED.zonedDateTime.`as`("updated"),
            )
            .hint("SQL_CALC_FOUND_ROWS")
            .from(TBEXCHANGEAMOUNT)
            .where(TBEXCHANGEAMOUNT.EXCHANGEID.eq(param.exchangeId))
            .orderBy(TBEXCHANGEAMOUNT.ID.asc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(Amount::class.java)

        return Pair<List<Amount>, Long>(result,  this.getTotalCount(billingDslContext))
    }

    override fun getExchangeHistories(param: RequestExchangeHistories): Pair<List<ExchangeHistory>, Long> {
        val base: RequestBaseDto = param.base  ?: throw GeneralException("00005")

        val result = billingDslContext
            .select(TBEXCHANGEHISTORY.ID,
                TBEXCHANGEHISTORY.EXCHANGEID.`as`("exchange"),
                TBEXCHANGEHISTORY.STATUS,
                TBEXCHANGEHISTORY.CREATED.zonedDateTime.`as`("created")
            )
            .hint("SQL_CALC_FOUND_ROWS")
            .from(TBEXCHANGEHISTORY)
            .where(TBEXCHANGEHISTORY.EXCHANGEID.eq(param.exchangeId))
            .orderBy(TBEXCHANGEHISTORY.ID.asc())
            .limit(this.getOffset(base.page, base.page_size), this.getLimitCondition(base.page_size))
            .fetchInto(ExchangeHistory::class.java)

        return Pair<List<ExchangeHistory>, Long>(result,  this.getTotalCount(billingDslContext))
    }

    override fun getExchangeAmountListByExchangeId(exchangeId: Long): List<Amount> {
        return billingDslContext
            .select(TBEXCHANGEAMOUNT.ID,
                TBEXCHANGEAMOUNT.EXCHANGEID.`as`("exchange"),
                TBEXCHANGEAMOUNT.BALANCELOCKID,
                TBEXCHANGEAMOUNT.CURRENCY,
                TBEXCHANGEAMOUNT.AMOUNT,
                TBEXCHANGEAMOUNT.STATUS,
                TBEXCHANGEAMOUNT.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGEAMOUNT.UPDATED.zonedDateTime.`as`("updated")
            )
            .from(TBEXCHANGEAMOUNT)
            .where(TBEXCHANGEAMOUNT.EXCHANGEID.eq(exchangeId))
            .fetchInto(Amount::class.java)
    }

    override fun getExchangeById(exchangeId: Long): Exchange {
        return billingDslContext
            .select(TBEXCHANGE.ID,
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.METHODTYPE,
                TBEXCHANGE.TOTALEXCHANGESPOON,
                TBEXCHANGE.CURRENCY,
                TBEXCHANGE.TOTALEXCHANGEAMOUNT,
                TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.STATUS,
                TBEXCHANGE.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGE.UPDATED.zonedDateTime.`as`("updated")
            )
            .from(TBEXCHANGE)
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .fetchOneInto(Exchange::class.java) ?: throw GeneralException("00010")
    }

    override fun getExchangeListByIdsAndStatus(requestExchangeMultiple: RequestExchangeMultiple): List<Exchange> {
        return billingDslContext
            .select(
                TBEXCHANGE.ID,
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.METHODTYPE,
                TBEXCHANGE.TOTALEXCHANGESPOON,
                TBEXCHANGE.CURRENCY,
                TBEXCHANGE.TOTALEXCHANGEAMOUNT,
                TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.STATUS,
                TBEXCHANGE.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGE.UPDATED.zonedDateTime.`as`("updated")
            )
            .from(TBEXCHANGE)
            .where(TBEXCHANGE.ID.`in`(requestExchangeMultiple.exchange_ids))
            .and(TBEXCHANGE.STATUS.`in`(requestExchangeMultiple.actionType))
            .fetchInto(Exchange::class.java)
    }

    override fun getExchangeByIdAndStatus(exchangeId: Long, actionType:List<String>): Exchange {
        return billingDslContext
            .select(
                TBEXCHANGE.ID,
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.METHODTYPE,
                TBEXCHANGE.TOTALEXCHANGESPOON,
                TBEXCHANGE.CURRENCY,
                TBEXCHANGE.TOTALEXCHANGEAMOUNT,
                TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGE.STATUS,
                TBEXCHANGE.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGE.UPDATED.zonedDateTime.`as`("updated")
            )
            .from(TBEXCHANGE)
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .and(TBEXCHANGE.STATUS.`in`(actionType))
            .fetchOneInto(Exchange::class.java) ?: throw GeneralException("00010")
    }

    override fun getExchangeAmountByIdAndStatus(
        amountId: Long,
        actionType: String
    ): Amount {
        val actionLogType: String = when (actionType) {
            "DEPOSIT_WAITING" -> {
                "accept"
            }
            "DEPOSIT_PENDING" -> {
                "payout"
            }
            else -> {
                "unknown"
            }
        }

        return billingDslContext
            .select(TBEXCHANGEAMOUNT.ID,
                TBEXCHANGEAMOUNT.EXCHANGEID.`as`("exchange"),
                TBEXCHANGEAMOUNT.BALANCELOCKID,
                TBEXCHANGEAMOUNT.CURRENCY,
                TBEXCHANGEAMOUNT.AMOUNT,
                TBEXCHANGEAMOUNT.STATUS,
                TBEXCHANGEAMOUNT.CREATED.zonedDateTime.`as`("created"),
                TBEXCHANGEAMOUNT.UPDATED.zonedDateTime.`as`("updated")
            )
            .from(TBEXCHANGEAMOUNT)
            .where(TBEXCHANGEAMOUNT.ID.eq(amountId))
            .and(TBEXCHANGEAMOUNT.STATUS.`in`(actionType))
            .fetchOneInto(Amount::class.java) ?: throw GeneralException("00029", arrayOf(actionLogType))
    }

    override fun getLatestExchangeAmountListByExchangeId(
        exchangeId: List<Long>,
        actionType: List<String>
    ): List<ExchangeAmount> {
        return billingDslContext
            .select(
                TBEXCHANGE.ID.`as`("exchangeId"),
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                max(TBEXCHANGEAMOUNT.ID).`as`("amountId"),
                max(TBEXCHANGEAMOUNT.BALANCELOCKID).`as`("balanceLockId"),
                max(TBEXCHANGEAMOUNT.CURRENCY).`as`("currency"),
                max(TBEXCHANGEAMOUNT.AMOUNT).`as`("amount"),
                max(TBEXCHANGEAMOUNT.STATUS).`as`("status"),
            )
            .from(TBEXCHANGE)
            .join(TBEXCHANGEAMOUNT).on(TBEXCHANGE.ID.eq(TBEXCHANGEAMOUNT.EXCHANGEID))
            .where(TBEXCHANGE.ID.`in`(exchangeId))
            .and(TBEXCHANGEAMOUNT.STATUS.`in`(actionType))
            .groupBy(TBEXCHANGE.ID, TBEXCHANGE.APPLICANTID)
            .fetchInto(ExchangeAmount::class.java)
    }

    override fun getExchangeAmountCountByExchangeIdAndStatusAndIdNot(
        amountId: Long,
        exchangeId: Long,
        actionType: List<String>
    ): Int {
        return billingDslContext
            .selectCount()
            .from(TBEXCHANGEAMOUNT)
            .where(TBEXCHANGEAMOUNT.ID.ne(amountId))
            .and(TBEXCHANGEAMOUNT.EXCHANGEID.eq(exchangeId))
            .and(TBEXCHANGEAMOUNT.STATUS.`in`(actionType))
            .fetchOne(0, Int::class.java) ?: 0
    }

    override fun getExchangeAmountListByExchangeIdsAndStatus(
        exchangeIds: List<Long>,
        actionType: List<String>
    ): List<ExchangeAmount> {
        return billingDslContext
            .select(
                TBEXCHANGE.ID.`as`("exchangeId"),
                TBEXCHANGE.APPLICANTID,
                TBEXCHANGE.EXPECTEDEXCHANGEDDATE,
                TBEXCHANGEAMOUNT.ID.`as`("amountId"),
                TBEXCHANGEAMOUNT.EXCHANGEID,
                TBEXCHANGEAMOUNT.BALANCELOCKID,
                TBEXCHANGEAMOUNT.CURRENCY,
                TBEXCHANGEAMOUNT.AMOUNT,
                TBEXCHANGEAMOUNT.STATUS
            )
            .from(TBEXCHANGE)
            .join(TBEXCHANGEAMOUNT).on(TBEXCHANGE.ID.eq(TBEXCHANGEAMOUNT.EXCHANGEID))
            .where(TBEXCHANGEAMOUNT.EXCHANGEID.`in`(exchangeIds))
            .and(TBEXCHANGEAMOUNT.STATUS.`in`(actionType))
            .fetchInto(ExchangeAmount::class.java)
    }


    override fun updateExchangeAcceptComplete(exchangeId: Long, status: String, amount: Int): Int {
        val affectedRow = billingDslContext
            .update(TBEXCHANGE)
            .set(TBEXCHANGE.STATUS, status)
            .set(TBEXCHANGE.UPDATED, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .set(TBEXCHANGE.TOTALEXCHANGEAMOUNT, TBEXCHANGE.TOTALEXCHANGEAMOUNT + amount)
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00008")
    }

    override fun updateExchangeAmount(exchangeAmountId: Long, status:String): Int {
        val affectedRow = billingDslContext
            .update(TBEXCHANGEAMOUNT)
            .set(TBEXCHANGEAMOUNT.STATUS, status)
            .set(TBEXCHANGEAMOUNT.UPDATED, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .where(TBEXCHANGEAMOUNT.ID.eq(exchangeAmountId))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00008")
    }

    override fun updateExchange(exchangeId: Long, status: String): Int {
        val affectedRow = billingDslContext
            .update(TBEXCHANGE)
            .set(TBEXCHANGE.STATUS, status)
            .set(TBEXCHANGE.UPDATED, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00008")
    }

    override fun updateExchangeAccept(exchangeId: Long, amount: Int, expectedExchangeDate: LocalDate): Int {
        val affectedRow = billingDslContext
            .update(TBEXCHANGE)
            .set(TBEXCHANGE.UPDATED, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
            .set(TBEXCHANGE.TOTALEXCHANGEAMOUNT, TBEXCHANGE.TOTALEXCHANGEAMOUNT + amount)
            .set(TBEXCHANGE.EXPECTEDEXCHANGEDDATE, expectedExchangeDate)
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00008")
    }

    override fun updateExchangeExpectedExchangedDateById(exchangeId: Long, expectedExchangeDate:LocalDate): Int {
        val affectedRow = billingDslContext
            .update(TBEXCHANGE)
            .set(TBEXCHANGE.EXPECTEDEXCHANGEDDATE, expectedExchangeDate)
            .where(TBEXCHANGE.ID.eq(exchangeId))
            .execute()

        if (affectedRow > 0)
            return affectedRow
        else
            throw GeneralException("00008")
    }

    override fun insertExchangeRejectReason(requestExchangeReject: RequestExchangeReject): Int {
        try {
            return billingDslContext
                .insertInto(TBEXCHANGEREJECTREASON)
                .columns(
                    TBEXCHANGEREJECTREASON.EXCHANGEID,
                    TBEXCHANGEREJECTREASON.REASON,
                    TBEXCHANGEREJECTREASON.CREATED,
                    TBEXCHANGEREJECTREASON.CREATOR,
                    TBEXCHANGEREJECTREASON.UPDATED,
                    TBEXCHANGEREJECTREASON.UPDATER
                )
                .values(requestExchangeReject.id,requestExchangeReject.reason, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime(), requestExchangeReject.creator, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime(), requestExchangeReject.creator)
                .execute()

        } catch (e: DataAccessException) {
            throw GeneralException("00006")
        }
    }

    override fun insertExchangeHistory(exchangeId: Long, status: String): Int {
        try {
            return billingDslContext
                .insertInto(TBEXCHANGEHISTORY)
                .columns(
                    TBEXCHANGEHISTORY.EXCHANGEID,
                    TBEXCHANGEHISTORY.STATUS,
                    TBEXCHANGEHISTORY.CREATED
                )
                .values(exchangeId, status, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())
                .execute()

        } catch (e: DataAccessException) {
            throw GeneralException("00006")
        }
    }

    fun getTotalCount(mysqlDslContext: DSLContext) =
        mysqlDslContext.fetchOne("SELECT FOUND_ROWS() as totalCount")?.getValue("totalCount") as Long

    private fun setSearchCondition(base: RequestBaseDto, param: RequestExchange) : Condition {
        var searchCondition: Condition = DSL.noCondition()
        param.apply {
            status?.let {
                searchCondition = searchCondition.and(TBEXCHANGE.STATUS.eq(status))
            }
            amount_status?.let {
                searchCondition =
                    searchCondition.and(TBEXCHANGEAMOUNT.STATUS.eq(amount_status))
            }

            user_Ids?.let {
                if (it.isNotEmpty()) searchCondition = searchCondition.and(TBEXCHANGE.APPLICANTID.`in`(user_Ids))
            }

            base.from_date?.let {
                if (it.isNotEmpty()) searchCondition = searchCondition.and(TBEXCHANGE.EXPECTEDEXCHANGEDDATE.ge(LocalDate.parse(base.from_date)))
            }

            base.to_date?.let {
                if (it.isNotEmpty()) searchCondition = searchCondition.and(TBEXCHANGE.EXPECTEDEXCHANGEDDATE.le(LocalDate.parse(base.to_date)))
            }
        }

        return searchCondition
    }

}
