/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbadpopcornhistory

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record8
import org.jooq.Row8
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbadpopcornhistoryRecord() : UpdatableRecordImpl<TbadpopcornhistoryRecord>(Tbadpopcornhistory.TBADPOPCORNHISTORY), Record8<Long?, String?, Int?, String?, Int?, String?, String?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var rewardkey: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var userid: Int?
        set(value) = set(2, value)
        get() = get(2) as Int?

    var campaignkey: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var quantity: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var signedvalue: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var txid: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var created: LocalDateTime?
        set(value) = set(7, value)
        get() = get(7) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row8<Long?, String?, Int?, String?, Int?, String?, String?, LocalDateTime?> = super.fieldsRow() as Row8<Long?, String?, Int?, String?, Int?, String?, String?, LocalDateTime?>
    override fun valuesRow(): Row8<Long?, String?, Int?, String?, Int?, String?, String?, LocalDateTime?> = super.valuesRow() as Row8<Long?, String?, Int?, String?, Int?, String?, String?, LocalDateTime?>
    override fun field1(): Field<Long?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.ID
    override fun field2(): Field<String?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.REWARDKEY
    override fun field3(): Field<Int?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.USERID
    override fun field4(): Field<String?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.CAMPAIGNKEY
    override fun field5(): Field<Int?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.QUANTITY
    override fun field6(): Field<String?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.SIGNEDVALUE
    override fun field7(): Field<String?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.TXID
    override fun field8(): Field<LocalDateTime?> = Tbadpopcornhistory.TBADPOPCORNHISTORY.CREATED
    override fun component1(): Long? = id
    override fun component2(): String? = rewardkey
    override fun component3(): Int? = userid
    override fun component4(): String? = campaignkey
    override fun component5(): Int? = quantity
    override fun component6(): String? = signedvalue
    override fun component7(): String? = txid
    override fun component8(): LocalDateTime? = created
    override fun value1(): Long? = id
    override fun value2(): String? = rewardkey
    override fun value3(): Int? = userid
    override fun value4(): String? = campaignkey
    override fun value5(): Int? = quantity
    override fun value6(): String? = signedvalue
    override fun value7(): String? = txid
    override fun value8(): LocalDateTime? = created

    override fun value1(value: Long?): TbadpopcornhistoryRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): TbadpopcornhistoryRecord {
        this.rewardkey = value
        return this
    }

    override fun value3(value: Int?): TbadpopcornhistoryRecord {
        this.userid = value
        return this
    }

    override fun value4(value: String?): TbadpopcornhistoryRecord {
        this.campaignkey = value
        return this
    }

    override fun value5(value: Int?): TbadpopcornhistoryRecord {
        this.quantity = value
        return this
    }

    override fun value6(value: String?): TbadpopcornhistoryRecord {
        this.signedvalue = value
        return this
    }

    override fun value7(value: String?): TbadpopcornhistoryRecord {
        this.txid = value
        return this
    }

    override fun value8(value: LocalDateTime?): TbadpopcornhistoryRecord {
        this.created = value
        return this
    }

    override fun values(value1: Long?, value2: String?, value3: Int?, value4: String?, value5: Int?, value6: String?, value7: String?, value8: LocalDateTime?): TbadpopcornhistoryRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        return this
    }

    /**
     * Create a detached, initialised TbadpopcornhistoryRecord
     */
    constructor(id: Long? = null, rewardkey: String? = null, userid: Int? = null, campaignkey: String? = null, quantity: Int? = null, signedvalue: String? = null, txid: String? = null, created: LocalDateTime? = null): this() {
        this.id = id
        this.rewardkey = rewardkey
        this.userid = userid
        this.campaignkey = campaignkey
        this.quantity = quantity
        this.signedvalue = signedvalue
        this.txid = txid
        this.created = created
    }
}