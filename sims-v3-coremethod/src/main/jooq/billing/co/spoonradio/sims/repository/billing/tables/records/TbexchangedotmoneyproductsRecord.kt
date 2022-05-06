/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbexchangedotmoneyproducts

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record15
import org.jooq.Row15
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbexchangedotmoneyproductsRecord() : UpdatableRecordImpl<TbexchangedotmoneyproductsRecord>(Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS), Record15<Long?, String?, String?, String?, Long?, String?, String?, Long?, Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var title: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var description: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var thumbnailurl: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var withdrawalproductid: Long?
        set(value) = set(4, value)
        get() = get(4) as Long?

    var withdrawalproducttype: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var withdrawalproductunit: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var spoonunit: Long?
        set(value) = set(7, value)
        get() = get(7) as Long?

    var targetamountunit: Long?
        set(value) = set(8, value)
        get() = get(8) as Long?

    var displayindex: Long?
        set(value) = set(9, value)
        get() = get(9) as Long?

    var status: String?
        set(value) = set(10, value)
        get() = get(10) as String?

    var created: LocalDateTime?
        set(value) = set(11, value)
        get() = get(11) as LocalDateTime?

    var creator: Long?
        set(value) = set(12, value)
        get() = get(12) as Long?

    var updated: LocalDateTime?
        set(value) = set(13, value)
        get() = get(13) as LocalDateTime?

    var updater: Long?
        set(value) = set(14, value)
        get() = get(14) as Long?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row15<Long?, String?, String?, String?, Long?, String?, String?, Long?, Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> = super.fieldsRow() as Row15<Long?, String?, String?, String?, Long?, String?, String?, Long?, Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?>
    override fun valuesRow(): Row15<Long?, String?, String?, String?, Long?, String?, String?, Long?, Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> = super.valuesRow() as Row15<Long?, String?, String?, String?, Long?, String?, String?, Long?, Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?>
    override fun field1(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.ID
    override fun field2(): Field<String?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.TITLE
    override fun field3(): Field<String?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.DESCRIPTION
    override fun field4(): Field<String?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.THUMBNAILURL
    override fun field5(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.WITHDRAWALPRODUCTID
    override fun field6(): Field<String?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.WITHDRAWALPRODUCTTYPE
    override fun field7(): Field<String?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.WITHDRAWALPRODUCTUNIT
    override fun field8(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.SPOONUNIT
    override fun field9(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.TARGETAMOUNTUNIT
    override fun field10(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.DISPLAYINDEX
    override fun field11(): Field<String?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.STATUS
    override fun field12(): Field<LocalDateTime?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.CREATED
    override fun field13(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.CREATOR
    override fun field14(): Field<LocalDateTime?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.UPDATED
    override fun field15(): Field<Long?> = Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.UPDATER
    override fun component1(): Long? = id
    override fun component2(): String? = title
    override fun component3(): String? = description
    override fun component4(): String? = thumbnailurl
    override fun component5(): Long? = withdrawalproductid
    override fun component6(): String? = withdrawalproducttype
    override fun component7(): String? = withdrawalproductunit
    override fun component8(): Long? = spoonunit
    override fun component9(): Long? = targetamountunit
    override fun component10(): Long? = displayindex
    override fun component11(): String? = status
    override fun component12(): LocalDateTime? = created
    override fun component13(): Long? = creator
    override fun component14(): LocalDateTime? = updated
    override fun component15(): Long? = updater
    override fun value1(): Long? = id
    override fun value2(): String? = title
    override fun value3(): String? = description
    override fun value4(): String? = thumbnailurl
    override fun value5(): Long? = withdrawalproductid
    override fun value6(): String? = withdrawalproducttype
    override fun value7(): String? = withdrawalproductunit
    override fun value8(): Long? = spoonunit
    override fun value9(): Long? = targetamountunit
    override fun value10(): Long? = displayindex
    override fun value11(): String? = status
    override fun value12(): LocalDateTime? = created
    override fun value13(): Long? = creator
    override fun value14(): LocalDateTime? = updated
    override fun value15(): Long? = updater

    override fun value1(value: Long?): TbexchangedotmoneyproductsRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): TbexchangedotmoneyproductsRecord {
        this.title = value
        return this
    }

    override fun value3(value: String?): TbexchangedotmoneyproductsRecord {
        this.description = value
        return this
    }

    override fun value4(value: String?): TbexchangedotmoneyproductsRecord {
        this.thumbnailurl = value
        return this
    }

    override fun value5(value: Long?): TbexchangedotmoneyproductsRecord {
        this.withdrawalproductid = value
        return this
    }

    override fun value6(value: String?): TbexchangedotmoneyproductsRecord {
        this.withdrawalproducttype = value
        return this
    }

    override fun value7(value: String?): TbexchangedotmoneyproductsRecord {
        this.withdrawalproductunit = value
        return this
    }

    override fun value8(value: Long?): TbexchangedotmoneyproductsRecord {
        this.spoonunit = value
        return this
    }

    override fun value9(value: Long?): TbexchangedotmoneyproductsRecord {
        this.targetamountunit = value
        return this
    }

    override fun value10(value: Long?): TbexchangedotmoneyproductsRecord {
        this.displayindex = value
        return this
    }

    override fun value11(value: String?): TbexchangedotmoneyproductsRecord {
        this.status = value
        return this
    }

    override fun value12(value: LocalDateTime?): TbexchangedotmoneyproductsRecord {
        this.created = value
        return this
    }

    override fun value13(value: Long?): TbexchangedotmoneyproductsRecord {
        this.creator = value
        return this
    }

    override fun value14(value: LocalDateTime?): TbexchangedotmoneyproductsRecord {
        this.updated = value
        return this
    }

    override fun value15(value: Long?): TbexchangedotmoneyproductsRecord {
        this.updater = value
        return this
    }

    override fun values(value1: Long?, value2: String?, value3: String?, value4: String?, value5: Long?, value6: String?, value7: String?, value8: Long?, value9: Long?, value10: Long?, value11: String?, value12: LocalDateTime?, value13: Long?, value14: LocalDateTime?, value15: Long?): TbexchangedotmoneyproductsRecord {
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
        this.value15(value15)
        return this
    }

    /**
     * Create a detached, initialised TbexchangedotmoneyproductsRecord
     */
    constructor(id: Long? = null, title: String? = null, description: String? = null, thumbnailurl: String? = null, withdrawalproductid: Long? = null, withdrawalproducttype: String? = null, withdrawalproductunit: String? = null, spoonunit: Long? = null, targetamountunit: Long? = null, displayindex: Long? = null, status: String? = null, created: LocalDateTime? = null, creator: Long? = null, updated: LocalDateTime? = null, updater: Long? = null): this() {
        this.id = id
        this.title = title
        this.description = description
        this.thumbnailurl = thumbnailurl
        this.withdrawalproductid = withdrawalproductid
        this.withdrawalproducttype = withdrawalproducttype
        this.withdrawalproductunit = withdrawalproductunit
        this.spoonunit = spoonunit
        this.targetamountunit = targetamountunit
        this.displayindex = displayindex
        this.status = status
        this.created = created
        this.creator = creator
        this.updated = updated
        this.updater = updater
    }
}