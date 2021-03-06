/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbexchange

import java.time.LocalDate
import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record11
import org.jooq.Row11
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbexchangeRecord() : UpdatableRecordImpl<TbexchangeRecord>(Tbexchange.TBEXCHANGE), Record11<Long?, Long?, String?, Long?, String?, Long?, Long?, LocalDate?, String?, LocalDateTime?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var applicantid: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var methodtype: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var totalexchangespoon: Long?
        set(value) = set(3, value)
        get() = get(3) as Long?

    var currency: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var totalexchangeamount: Long?
        set(value) = set(5, value)
        get() = get(5) as Long?

    var estimatedexchangeamount: Long?
        set(value) = set(6, value)
        get() = get(6) as Long?

    var expectedexchangeddate: LocalDate?
        set(value) = set(7, value)
        get() = get(7) as LocalDate?

    var status: String?
        set(value) = set(8, value)
        get() = get(8) as String?

    var created: LocalDateTime?
        set(value) = set(9, value)
        get() = get(9) as LocalDateTime?

    var updated: LocalDateTime?
        set(value) = set(10, value)
        get() = get(10) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row11<Long?, Long?, String?, Long?, String?, Long?, Long?, LocalDate?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row11<Long?, Long?, String?, Long?, String?, Long?, Long?, LocalDate?, String?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row11<Long?, Long?, String?, Long?, String?, Long?, Long?, LocalDate?, String?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row11<Long?, Long?, String?, Long?, String?, Long?, Long?, LocalDate?, String?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Long?> = Tbexchange.TBEXCHANGE.ID
    override fun field2(): Field<Long?> = Tbexchange.TBEXCHANGE.APPLICANTID
    override fun field3(): Field<String?> = Tbexchange.TBEXCHANGE.METHODTYPE
    override fun field4(): Field<Long?> = Tbexchange.TBEXCHANGE.TOTALEXCHANGESPOON
    override fun field5(): Field<String?> = Tbexchange.TBEXCHANGE.CURRENCY
    override fun field6(): Field<Long?> = Tbexchange.TBEXCHANGE.TOTALEXCHANGEAMOUNT
    override fun field7(): Field<Long?> = Tbexchange.TBEXCHANGE.ESTIMATEDEXCHANGEAMOUNT
    override fun field8(): Field<LocalDate?> = Tbexchange.TBEXCHANGE.EXPECTEDEXCHANGEDDATE
    override fun field9(): Field<String?> = Tbexchange.TBEXCHANGE.STATUS
    override fun field10(): Field<LocalDateTime?> = Tbexchange.TBEXCHANGE.CREATED
    override fun field11(): Field<LocalDateTime?> = Tbexchange.TBEXCHANGE.UPDATED
    override fun component1(): Long? = id
    override fun component2(): Long? = applicantid
    override fun component3(): String? = methodtype
    override fun component4(): Long? = totalexchangespoon
    override fun component5(): String? = currency
    override fun component6(): Long? = totalexchangeamount
    override fun component7(): Long? = estimatedexchangeamount
    override fun component8(): LocalDate? = expectedexchangeddate
    override fun component9(): String? = status
    override fun component10(): LocalDateTime? = created
    override fun component11(): LocalDateTime? = updated
    override fun value1(): Long? = id
    override fun value2(): Long? = applicantid
    override fun value3(): String? = methodtype
    override fun value4(): Long? = totalexchangespoon
    override fun value5(): String? = currency
    override fun value6(): Long? = totalexchangeamount
    override fun value7(): Long? = estimatedexchangeamount
    override fun value8(): LocalDate? = expectedexchangeddate
    override fun value9(): String? = status
    override fun value10(): LocalDateTime? = created
    override fun value11(): LocalDateTime? = updated

    override fun value1(value: Long?): TbexchangeRecord {
        this.id = value
        return this
    }

    override fun value2(value: Long?): TbexchangeRecord {
        this.applicantid = value
        return this
    }

    override fun value3(value: String?): TbexchangeRecord {
        this.methodtype = value
        return this
    }

    override fun value4(value: Long?): TbexchangeRecord {
        this.totalexchangespoon = value
        return this
    }

    override fun value5(value: String?): TbexchangeRecord {
        this.currency = value
        return this
    }

    override fun value6(value: Long?): TbexchangeRecord {
        this.totalexchangeamount = value
        return this
    }

    override fun value7(value: Long?): TbexchangeRecord {
        this.estimatedexchangeamount = value
        return this
    }

    override fun value8(value: LocalDate?): TbexchangeRecord {
        this.expectedexchangeddate = value
        return this
    }

    override fun value9(value: String?): TbexchangeRecord {
        this.status = value
        return this
    }

    override fun value10(value: LocalDateTime?): TbexchangeRecord {
        this.created = value
        return this
    }

    override fun value11(value: LocalDateTime?): TbexchangeRecord {
        this.updated = value
        return this
    }

    override fun values(value1: Long?, value2: Long?, value3: String?, value4: Long?, value5: String?, value6: Long?, value7: Long?, value8: LocalDate?, value9: String?, value10: LocalDateTime?, value11: LocalDateTime?): TbexchangeRecord {
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
        return this
    }

    /**
     * Create a detached, initialised TbexchangeRecord
     */
    constructor(id: Long? = null, applicantid: Long? = null, methodtype: String? = null, totalexchangespoon: Long? = null, currency: String? = null, totalexchangeamount: Long? = null, estimatedexchangeamount: Long? = null, expectedexchangeddate: LocalDate? = null, status: String? = null, created: LocalDateTime? = null, updated: LocalDateTime? = null): this() {
        this.id = id
        this.applicantid = applicantid
        this.methodtype = methodtype
        this.totalexchangespoon = totalexchangespoon
        this.currency = currency
        this.totalexchangeamount = totalexchangeamount
        this.estimatedexchangeamount = estimatedexchangeamount
        this.expectedexchangeddate = expectedexchangeddate
        this.status = status
        this.created = created
        this.updated = updated
    }
}
