/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbexchangeamount

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record9
import org.jooq.Row9
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbexchangeamountRecord() : UpdatableRecordImpl<TbexchangeamountRecord>(Tbexchangeamount.TBEXCHANGEAMOUNT), Record9<Long?, Long?, String?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var exchangeid: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var balancelockid: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var currency: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var exchangespoon: Long?
        set(value) = set(4, value)
        get() = get(4) as Long?

    var amount: Long?
        set(value) = set(5, value)
        get() = get(5) as Long?

    var status: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var created: LocalDateTime?
        set(value) = set(7, value)
        get() = get(7) as LocalDateTime?

    var updated: LocalDateTime?
        set(value) = set(8, value)
        get() = get(8) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row9<Long?, Long?, String?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row9<Long?, Long?, String?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row9<Long?, Long?, String?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row9<Long?, Long?, String?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Long?> = Tbexchangeamount.TBEXCHANGEAMOUNT.ID
    override fun field2(): Field<Long?> = Tbexchangeamount.TBEXCHANGEAMOUNT.EXCHANGEID
    override fun field3(): Field<String?> = Tbexchangeamount.TBEXCHANGEAMOUNT.BALANCELOCKID
    override fun field4(): Field<String?> = Tbexchangeamount.TBEXCHANGEAMOUNT.CURRENCY
    override fun field5(): Field<Long?> = Tbexchangeamount.TBEXCHANGEAMOUNT.EXCHANGESPOON
    override fun field6(): Field<Long?> = Tbexchangeamount.TBEXCHANGEAMOUNT.AMOUNT
    override fun field7(): Field<String?> = Tbexchangeamount.TBEXCHANGEAMOUNT.STATUS
    override fun field8(): Field<LocalDateTime?> = Tbexchangeamount.TBEXCHANGEAMOUNT.CREATED
    override fun field9(): Field<LocalDateTime?> = Tbexchangeamount.TBEXCHANGEAMOUNT.UPDATED
    override fun component1(): Long? = id
    override fun component2(): Long? = exchangeid
    override fun component3(): String? = balancelockid
    override fun component4(): String? = currency
    override fun component5(): Long? = exchangespoon
    override fun component6(): Long? = amount
    override fun component7(): String? = status
    override fun component8(): LocalDateTime? = created
    override fun component9(): LocalDateTime? = updated
    override fun value1(): Long? = id
    override fun value2(): Long? = exchangeid
    override fun value3(): String? = balancelockid
    override fun value4(): String? = currency
    override fun value5(): Long? = exchangespoon
    override fun value6(): Long? = amount
    override fun value7(): String? = status
    override fun value8(): LocalDateTime? = created
    override fun value9(): LocalDateTime? = updated

    override fun value1(value: Long?): TbexchangeamountRecord {
        this.id = value
        return this
    }

    override fun value2(value: Long?): TbexchangeamountRecord {
        this.exchangeid = value
        return this
    }

    override fun value3(value: String?): TbexchangeamountRecord {
        this.balancelockid = value
        return this
    }

    override fun value4(value: String?): TbexchangeamountRecord {
        this.currency = value
        return this
    }

    override fun value5(value: Long?): TbexchangeamountRecord {
        this.exchangespoon = value
        return this
    }

    override fun value6(value: Long?): TbexchangeamountRecord {
        this.amount = value
        return this
    }

    override fun value7(value: String?): TbexchangeamountRecord {
        this.status = value
        return this
    }

    override fun value8(value: LocalDateTime?): TbexchangeamountRecord {
        this.created = value
        return this
    }

    override fun value9(value: LocalDateTime?): TbexchangeamountRecord {
        this.updated = value
        return this
    }

    override fun values(value1: Long?, value2: Long?, value3: String?, value4: String?, value5: Long?, value6: Long?, value7: String?, value8: LocalDateTime?, value9: LocalDateTime?): TbexchangeamountRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        return this
    }

    /**
     * Create a detached, initialised TbexchangeamountRecord
     */
    constructor(id: Long? = null, exchangeid: Long? = null, balancelockid: String? = null, currency: String? = null, exchangespoon: Long? = null, amount: Long? = null, status: String? = null, created: LocalDateTime? = null, updated: LocalDateTime? = null): this() {
        this.id = id
        this.exchangeid = exchangeid
        this.balancelockid = balancelockid
        this.currency = currency
        this.exchangespoon = exchangespoon
        this.amount = amount
        this.status = status
        this.created = created
        this.updated = updated
    }
}
