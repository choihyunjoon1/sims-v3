/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbitemproduct

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
open class TbitemproductRecord() : UpdatableRecordImpl<TbitemproductRecord>(Tbitemproduct.TBITEMPRODUCT), Record12<Int?, Int?, String?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, Byte?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var promotionid: Int?
        set(value) = set(1, value)
        get() = get(1) as Int?

    var name: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var price: Int?
        set(value) = set(3, value)
        get() = get(3) as Int?

    var amount: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var type: Byte?
        set(value) = set(5, value)
        get() = get(5) as Byte?

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

    var store: Byte?
        set(value) = set(11, value)
        get() = get(11) as Byte?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row12<Int?, Int?, String?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, Byte?> = super.fieldsRow() as Row12<Int?, Int?, String?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, Byte?>
    override fun valuesRow(): Row12<Int?, Int?, String?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, Byte?> = super.valuesRow() as Row12<Int?, Int?, String?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, Int?, Int?, Byte?>
    override fun field1(): Field<Int?> = Tbitemproduct.TBITEMPRODUCT.ID
    override fun field2(): Field<Int?> = Tbitemproduct.TBITEMPRODUCT.PROMOTIONID
    override fun field3(): Field<String?> = Tbitemproduct.TBITEMPRODUCT.NAME
    override fun field4(): Field<Int?> = Tbitemproduct.TBITEMPRODUCT.PRICE
    override fun field5(): Field<Int?> = Tbitemproduct.TBITEMPRODUCT.AMOUNT
    override fun field6(): Field<Byte?> = Tbitemproduct.TBITEMPRODUCT.TYPE
    override fun field7(): Field<Boolean?> = Tbitemproduct.TBITEMPRODUCT.ISUSE
    override fun field8(): Field<LocalDateTime?> = Tbitemproduct.TBITEMPRODUCT.CREATEDDATE
    override fun field9(): Field<LocalDateTime?> = Tbitemproduct.TBITEMPRODUCT.UPDATEDDATE
    override fun field10(): Field<Int?> = Tbitemproduct.TBITEMPRODUCT.CREATOR
    override fun field11(): Field<Int?> = Tbitemproduct.TBITEMPRODUCT.UPDATER
    override fun field12(): Field<Byte?> = Tbitemproduct.TBITEMPRODUCT.STORE
    override fun component1(): Int? = id
    override fun component2(): Int? = promotionid
    override fun component3(): String? = name
    override fun component4(): Int? = price
    override fun component5(): Int? = amount
    override fun component6(): Byte? = type
    override fun component7(): Boolean? = isuse
    override fun component8(): LocalDateTime? = createddate
    override fun component9(): LocalDateTime? = updateddate
    override fun component10(): Int? = creator
    override fun component11(): Int? = updater
    override fun component12(): Byte? = store
    override fun value1(): Int? = id
    override fun value2(): Int? = promotionid
    override fun value3(): String? = name
    override fun value4(): Int? = price
    override fun value5(): Int? = amount
    override fun value6(): Byte? = type
    override fun value7(): Boolean? = isuse
    override fun value8(): LocalDateTime? = createddate
    override fun value9(): LocalDateTime? = updateddate
    override fun value10(): Int? = creator
    override fun value11(): Int? = updater
    override fun value12(): Byte? = store

    override fun value1(value: Int?): TbitemproductRecord {
        this.id = value
        return this
    }

    override fun value2(value: Int?): TbitemproductRecord {
        this.promotionid = value
        return this
    }

    override fun value3(value: String?): TbitemproductRecord {
        this.name = value
        return this
    }

    override fun value4(value: Int?): TbitemproductRecord {
        this.price = value
        return this
    }

    override fun value5(value: Int?): TbitemproductRecord {
        this.amount = value
        return this
    }

    override fun value6(value: Byte?): TbitemproductRecord {
        this.type = value
        return this
    }

    override fun value7(value: Boolean?): TbitemproductRecord {
        this.isuse = value
        return this
    }

    override fun value8(value: LocalDateTime?): TbitemproductRecord {
        this.createddate = value
        return this
    }

    override fun value9(value: LocalDateTime?): TbitemproductRecord {
        this.updateddate = value
        return this
    }

    override fun value10(value: Int?): TbitemproductRecord {
        this.creator = value
        return this
    }

    override fun value11(value: Int?): TbitemproductRecord {
        this.updater = value
        return this
    }

    override fun value12(value: Byte?): TbitemproductRecord {
        this.store = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: String?, value4: Int?, value5: Int?, value6: Byte?, value7: Boolean?, value8: LocalDateTime?, value9: LocalDateTime?, value10: Int?, value11: Int?, value12: Byte?): TbitemproductRecord {
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
     * Create a detached, initialised TbitemproductRecord
     */
    constructor(id: Int? = null, promotionid: Int? = null, name: String? = null, price: Int? = null, amount: Int? = null, type: Byte? = null, isuse: Boolean? = null, createddate: LocalDateTime? = null, updateddate: LocalDateTime? = null, creator: Int? = null, updater: Int? = null, store: Byte? = null): this() {
        this.id = id
        this.promotionid = promotionid
        this.name = name
        this.price = price
        this.amount = amount
        this.type = type
        this.isuse = isuse
        this.createddate = createddate
        this.updateddate = updateddate
        this.creator = creator
        this.updater = updater
        this.store = store
    }
}
