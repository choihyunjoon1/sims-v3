/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbsubscribeioshistory

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record14
import org.jooq.Row14
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbsubscribeioshistoryRecord() : UpdatableRecordImpl<TbsubscribeioshistoryRecord>(Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY), Record14<Int?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var subscribeid: Int?
        set(value) = set(1, value)
        get() = get(1) as Int?

    var status: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var txid: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var receiptdata: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var transactionid: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var weborderlineitemid: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var trialperiod: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var inintroofferperiod: String?
        set(value) = set(8, value)
        get() = get(8) as String?

    var subscriptiongroupidentifier: String?
        set(value) = set(9, value)
        get() = get(9) as String?

    var createddate: LocalDateTime?
        set(value) = set(10, value)
        get() = get(10) as LocalDateTime?

    var startdate: LocalDateTime?
        set(value) = set(11, value)
        get() = get(11) as LocalDateTime?

    var expiredate: LocalDateTime?
        set(value) = set(12, value)
        get() = get(12) as LocalDateTime?

    var updateddate: LocalDateTime?
        set(value) = set(13, value)
        get() = get(13) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row14<Int?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row14<Int?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row14<Int?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row14<Int?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Int?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.ID
    override fun field2(): Field<Int?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.SUBSCRIBEID
    override fun field3(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.STATUS
    override fun field4(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.TXID
    override fun field5(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.RECEIPTDATA
    override fun field6(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.TRANSACTIONID
    override fun field7(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.WEBORDERLINEITEMID
    override fun field8(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.TRIALPERIOD
    override fun field9(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.ININTROOFFERPERIOD
    override fun field10(): Field<String?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.SUBSCRIPTIONGROUPIDENTIFIER
    override fun field11(): Field<LocalDateTime?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.CREATEDDATE
    override fun field12(): Field<LocalDateTime?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.STARTDATE
    override fun field13(): Field<LocalDateTime?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.EXPIREDATE
    override fun field14(): Field<LocalDateTime?> = Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.UPDATEDDATE
    override fun component1(): Int? = id
    override fun component2(): Int? = subscribeid
    override fun component3(): String? = status
    override fun component4(): String? = txid
    override fun component5(): String? = receiptdata
    override fun component6(): String? = transactionid
    override fun component7(): String? = weborderlineitemid
    override fun component8(): String? = trialperiod
    override fun component9(): String? = inintroofferperiod
    override fun component10(): String? = subscriptiongroupidentifier
    override fun component11(): LocalDateTime? = createddate
    override fun component12(): LocalDateTime? = startdate
    override fun component13(): LocalDateTime? = expiredate
    override fun component14(): LocalDateTime? = updateddate
    override fun value1(): Int? = id
    override fun value2(): Int? = subscribeid
    override fun value3(): String? = status
    override fun value4(): String? = txid
    override fun value5(): String? = receiptdata
    override fun value6(): String? = transactionid
    override fun value7(): String? = weborderlineitemid
    override fun value8(): String? = trialperiod
    override fun value9(): String? = inintroofferperiod
    override fun value10(): String? = subscriptiongroupidentifier
    override fun value11(): LocalDateTime? = createddate
    override fun value12(): LocalDateTime? = startdate
    override fun value13(): LocalDateTime? = expiredate
    override fun value14(): LocalDateTime? = updateddate

    override fun value1(value: Int?): TbsubscribeioshistoryRecord {
        this.id = value
        return this
    }

    override fun value2(value: Int?): TbsubscribeioshistoryRecord {
        this.subscribeid = value
        return this
    }

    override fun value3(value: String?): TbsubscribeioshistoryRecord {
        this.status = value
        return this
    }

    override fun value4(value: String?): TbsubscribeioshistoryRecord {
        this.txid = value
        return this
    }

    override fun value5(value: String?): TbsubscribeioshistoryRecord {
        this.receiptdata = value
        return this
    }

    override fun value6(value: String?): TbsubscribeioshistoryRecord {
        this.transactionid = value
        return this
    }

    override fun value7(value: String?): TbsubscribeioshistoryRecord {
        this.weborderlineitemid = value
        return this
    }

    override fun value8(value: String?): TbsubscribeioshistoryRecord {
        this.trialperiod = value
        return this
    }

    override fun value9(value: String?): TbsubscribeioshistoryRecord {
        this.inintroofferperiod = value
        return this
    }

    override fun value10(value: String?): TbsubscribeioshistoryRecord {
        this.subscriptiongroupidentifier = value
        return this
    }

    override fun value11(value: LocalDateTime?): TbsubscribeioshistoryRecord {
        this.createddate = value
        return this
    }

    override fun value12(value: LocalDateTime?): TbsubscribeioshistoryRecord {
        this.startdate = value
        return this
    }

    override fun value13(value: LocalDateTime?): TbsubscribeioshistoryRecord {
        this.expiredate = value
        return this
    }

    override fun value14(value: LocalDateTime?): TbsubscribeioshistoryRecord {
        this.updateddate = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: String?, value4: String?, value5: String?, value6: String?, value7: String?, value8: String?, value9: String?, value10: String?, value11: LocalDateTime?, value12: LocalDateTime?, value13: LocalDateTime?, value14: LocalDateTime?): TbsubscribeioshistoryRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        this.value10(value10)
        this.value11(value11)
        this.value12(value12)
        this.value13(value13)
        this.value14(value14)
        return this
    }

    /**
     * Create a detached, initialised TbsubscribeioshistoryRecord
     */
    constructor(id: Int? = null, subscribeid: Int? = null, status: String? = null, txid: String? = null, receiptdata: String? = null, transactionid: String? = null, weborderlineitemid: String? = null, trialperiod: String? = null, inintroofferperiod: String? = null, subscriptiongroupidentifier: String? = null, createddate: LocalDateTime? = null, startdate: LocalDateTime? = null, expiredate: LocalDateTime? = null, updateddate: LocalDateTime? = null): this() {
        this.id = id
        this.subscribeid = subscribeid
        this.status = status
        this.txid = txid
        this.receiptdata = receiptdata
        this.transactionid = transactionid
        this.weborderlineitemid = weborderlineitemid
        this.trialperiod = trialperiod
        this.inintroofferperiod = inintroofferperiod
        this.subscriptiongroupidentifier = subscriptiongroupidentifier
        this.createddate = createddate
        this.startdate = startdate
        this.expiredate = expiredate
        this.updateddate = updateddate
    }
}