/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbpaymentmethod

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record12
import org.jooq.Row12
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbpaymentmethodRecord() : UpdatableRecordImpl<TbpaymentmethodRecord>(Tbpaymentmethod.TBPAYMENTMETHOD), Record12<Int?, String?, Int?, Byte?, Int?, String?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, String?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var name: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var pgid: Int?
        set(value) = set(2, value)
        get() = get(2) as Int?

    var type: Byte?
        set(value) = set(3, value)
        get() = get(3) as Byte?

    var fee: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var description: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var isuse: Boolean?
        set(value) = set(6, value)
        get() = get(6) as Boolean?

    var createddate: LocalDateTime?
        set(value) = set(7, value)
        get() = get(7) as LocalDateTime?

    var updateddate: LocalDateTime?
        set(value) = set(8, value)
        get() = get(8) as LocalDateTime?

    var creator: Int?
        set(value) = set(9, value)
        get() = get(9) as Int?

    var updater: Int?
        set(value) = set(10, value)
        get() = get(10) as Int?

    var country: String?
        set(value) = set(11, value)
        get() = get(11) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row12<Int?, String?, Int?, Byte?, Int?, String?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, String?> = super.fieldsRow() as Row12<Int?, String?, Int?, Byte?, Int?, String?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, String?>
    override fun valuesRow(): Row12<Int?, String?, Int?, Byte?, Int?, String?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, String?> = super.valuesRow() as Row12<Int?, String?, Int?, Byte?, Int?, String?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, String?>
    override fun field1(): Field<Int?> = Tbpaymentmethod.TBPAYMENTMETHOD.ID
    override fun field2(): Field<String?> = Tbpaymentmethod.TBPAYMENTMETHOD.NAME
    override fun field3(): Field<Int?> = Tbpaymentmethod.TBPAYMENTMETHOD.PGID
    override fun field4(): Field<Byte?> = Tbpaymentmethod.TBPAYMENTMETHOD.TYPE
    override fun field5(): Field<Int?> = Tbpaymentmethod.TBPAYMENTMETHOD.FEE
    override fun field6(): Field<String?> = Tbpaymentmethod.TBPAYMENTMETHOD.DESCRIPTION
    override fun field7(): Field<Boolean?> = Tbpaymentmethod.TBPAYMENTMETHOD.ISUSE
    override fun field8(): Field<LocalDateTime?> = Tbpaymentmethod.TBPAYMENTMETHOD.CREATEDDATE
    override fun field9(): Field<LocalDateTime?> = Tbpaymentmethod.TBPAYMENTMETHOD.UPDATEDDATE
    override fun field10(): Field<Int?> = Tbpaymentmethod.TBPAYMENTMETHOD.CREATOR
    override fun field11(): Field<Int?> = Tbpaymentmethod.TBPAYMENTMETHOD.UPDATER
    override fun field12(): Field<String?> = Tbpaymentmethod.TBPAYMENTMETHOD.COUNTRY
    override fun component1(): Int? = id
    override fun component2(): String? = name
    override fun component3(): Int? = pgid
    override fun component4(): Byte? = type
    override fun component5(): Int? = fee
    override fun component6(): String? = description
    override fun component7(): Boolean? = isuse
    override fun component8(): LocalDateTime? = createddate
    override fun component9(): LocalDateTime? = updateddate
    override fun component10(): Int? = creator
    override fun component11(): Int? = updater
    override fun component12(): String? = country
    override fun value1(): Int? = id
    override fun value2(): String? = name
    override fun value3(): Int? = pgid
    override fun value4(): Byte? = type
    override fun value5(): Int? = fee
    override fun value6(): String? = description
    override fun value7(): Boolean? = isuse
    override fun value8(): LocalDateTime? = createddate
    override fun value9(): LocalDateTime? = updateddate
    override fun value10(): Int? = creator
    override fun value11(): Int? = updater
    override fun value12(): String? = country

    override fun value1(value: Int?): TbpaymentmethodRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): TbpaymentmethodRecord {
        this.name = value
        return this
    }

    override fun value3(value: Int?): TbpaymentmethodRecord {
        this.pgid = value
        return this
    }

    override fun value4(value: Byte?): TbpaymentmethodRecord {
        this.type = value
        return this
    }

    override fun value5(value: Int?): TbpaymentmethodRecord {
        this.fee = value
        return this
    }

    override fun value6(value: String?): TbpaymentmethodRecord {
        this.description = value
        return this
    }

    override fun value7(value: Boolean?): TbpaymentmethodRecord {
        this.isuse = value
        return this
    }

    override fun value8(value: LocalDateTime?): TbpaymentmethodRecord {
        this.createddate = value
        return this
    }

    override fun value9(value: LocalDateTime?): TbpaymentmethodRecord {
        this.updateddate = value
        return this
    }

    override fun value10(value: Int?): TbpaymentmethodRecord {
        this.creator = value
        return this
    }

    override fun value11(value: Int?): TbpaymentmethodRecord {
        this.updater = value
        return this
    }

    override fun value12(value: String?): TbpaymentmethodRecord {
        this.country = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: Int?, value4: Byte?, value5: Int?, value6: String?, value7: Boolean?, value8: LocalDateTime?, value9: LocalDateTime?, value10: Int?, value11: Int?, value12: String?): TbpaymentmethodRecord {
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
        return this
    }

    /**
     * Create a detached, initialised TbpaymentmethodRecord
     */
    constructor(id: Int? = null, name: String? = null, pgid: Int? = null, type: Byte? = null, fee: Int? = null, description: String? = null, isuse: Boolean? = null, createddate: LocalDateTime? = null, updateddate: LocalDateTime? = null, creator: Int? = null, updater: Int? = null, country: String? = null): this() {
        this.id = id
        this.name = name
        this.pgid = pgid
        this.type = type
        this.fee = fee
        this.description = description
        this.isuse = isuse
        this.createddate = createddate
        this.updateddate = updateddate
        this.creator = creator
        this.updater = updater
        this.country = country
    }
}
