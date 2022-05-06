/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbexchangerejectreason

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record7
import org.jooq.Row7
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbexchangerejectreasonRecord() : UpdatableRecordImpl<TbexchangerejectreasonRecord>(Tbexchangerejectreason.TBEXCHANGEREJECTREASON), Record7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var exchangeid: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var reason: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var created: LocalDateTime?
        set(value) = set(3, value)
        get() = get(3) as LocalDateTime?

    var creator: Long?
        set(value) = set(4, value)
        get() = get(4) as Long?

    var updated: LocalDateTime?
        set(value) = set(5, value)
        get() = get(5) as LocalDateTime?

    var updater: Long?
        set(value) = set(6, value)
        get() = get(6) as Long?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> = super.fieldsRow() as Row7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?>
    override fun valuesRow(): Row7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> = super.valuesRow() as Row7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?>
    override fun field1(): Field<Long?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.ID
    override fun field2(): Field<Long?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.EXCHANGEID
    override fun field3(): Field<String?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.REASON
    override fun field4(): Field<LocalDateTime?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.CREATED
    override fun field5(): Field<Long?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.CREATOR
    override fun field6(): Field<LocalDateTime?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.UPDATED
    override fun field7(): Field<Long?> = Tbexchangerejectreason.TBEXCHANGEREJECTREASON.UPDATER
    override fun component1(): Long? = id
    override fun component2(): Long? = exchangeid
    override fun component3(): String? = reason
    override fun component4(): LocalDateTime? = created
    override fun component5(): Long? = creator
    override fun component6(): LocalDateTime? = updated
    override fun component7(): Long? = updater
    override fun value1(): Long? = id
    override fun value2(): Long? = exchangeid
    override fun value3(): String? = reason
    override fun value4(): LocalDateTime? = created
    override fun value5(): Long? = creator
    override fun value6(): LocalDateTime? = updated
    override fun value7(): Long? = updater

    override fun value1(value: Long?): TbexchangerejectreasonRecord {
        this.id = value
        return this
    }

    override fun value2(value: Long?): TbexchangerejectreasonRecord {
        this.exchangeid = value
        return this
    }

    override fun value3(value: String?): TbexchangerejectreasonRecord {
        this.reason = value
        return this
    }

    override fun value4(value: LocalDateTime?): TbexchangerejectreasonRecord {
        this.created = value
        return this
    }

    override fun value5(value: Long?): TbexchangerejectreasonRecord {
        this.creator = value
        return this
    }

    override fun value6(value: LocalDateTime?): TbexchangerejectreasonRecord {
        this.updated = value
        return this
    }

    override fun value7(value: Long?): TbexchangerejectreasonRecord {
        this.updater = value
        return this
    }

    override fun values(value1: Long?, value2: Long?, value3: String?, value4: LocalDateTime?, value5: Long?, value6: LocalDateTime?, value7: Long?): TbexchangerejectreasonRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        return this
    }

    /**
     * Create a detached, initialised TbexchangerejectreasonRecord
     */
    constructor(id: Long? = null, exchangeid: Long? = null, reason: String? = null, created: LocalDateTime? = null, creator: Long? = null, updated: LocalDateTime? = null, updater: Long? = null): this() {
        this.id = id
        this.exchangeid = exchangeid
        this.reason = reason
        this.created = created
        this.creator = creator
        this.updated = updated
        this.updater = updater
    }
}