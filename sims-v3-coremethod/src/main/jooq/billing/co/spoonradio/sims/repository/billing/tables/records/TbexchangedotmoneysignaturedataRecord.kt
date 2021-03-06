/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbexchangedotmoneysignaturedata

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
open class TbexchangedotmoneysignaturedataRecord() : UpdatableRecordImpl<TbexchangedotmoneysignaturedataRecord>(Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA), Record7<Long?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?> {

    var userid: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var signature: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var exchangeddotmoneypoint: Long?
        set(value) = set(2, value)
        get() = get(2) as Long?

    var exchangedspoon: Long?
        set(value) = set(3, value)
        get() = get(3) as Long?

    var username: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var expireat: LocalDateTime?
        set(value) = set(5, value)
        get() = get(5) as LocalDateTime?

    var created: LocalDateTime?
        set(value) = set(6, value)
        get() = get(6) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row7<Long?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row7<Long?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row7<Long?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row7<Long?, String?, Long?, Long?, String?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Long?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.USERID
    override fun field2(): Field<String?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.SIGNATURE
    override fun field3(): Field<Long?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.EXCHANGEDDOTMONEYPOINT
    override fun field4(): Field<Long?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.EXCHANGEDSPOON
    override fun field5(): Field<String?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.USERNAME
    override fun field6(): Field<LocalDateTime?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.EXPIREAT
    override fun field7(): Field<LocalDateTime?> = Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.CREATED
    override fun component1(): Long? = userid
    override fun component2(): String? = signature
    override fun component3(): Long? = exchangeddotmoneypoint
    override fun component4(): Long? = exchangedspoon
    override fun component5(): String? = username
    override fun component6(): LocalDateTime? = expireat
    override fun component7(): LocalDateTime? = created
    override fun value1(): Long? = userid
    override fun value2(): String? = signature
    override fun value3(): Long? = exchangeddotmoneypoint
    override fun value4(): Long? = exchangedspoon
    override fun value5(): String? = username
    override fun value6(): LocalDateTime? = expireat
    override fun value7(): LocalDateTime? = created

    override fun value1(value: Long?): TbexchangedotmoneysignaturedataRecord {
        this.userid = value
        return this
    }

    override fun value2(value: String?): TbexchangedotmoneysignaturedataRecord {
        this.signature = value
        return this
    }

    override fun value3(value: Long?): TbexchangedotmoneysignaturedataRecord {
        this.exchangeddotmoneypoint = value
        return this
    }

    override fun value4(value: Long?): TbexchangedotmoneysignaturedataRecord {
        this.exchangedspoon = value
        return this
    }

    override fun value5(value: String?): TbexchangedotmoneysignaturedataRecord {
        this.username = value
        return this
    }

    override fun value6(value: LocalDateTime?): TbexchangedotmoneysignaturedataRecord {
        this.expireat = value
        return this
    }

    override fun value7(value: LocalDateTime?): TbexchangedotmoneysignaturedataRecord {
        this.created = value
        return this
    }

    override fun values(value1: Long?, value2: String?, value3: Long?, value4: Long?, value5: String?, value6: LocalDateTime?, value7: LocalDateTime?): TbexchangedotmoneysignaturedataRecord {
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
     * Create a detached, initialised TbexchangedotmoneysignaturedataRecord
     */
    constructor(userid: Long? = null, signature: String? = null, exchangeddotmoneypoint: Long? = null, exchangedspoon: Long? = null, username: String? = null, expireat: LocalDateTime? = null, created: LocalDateTime? = null): this() {
        this.userid = userid
        this.signature = signature
        this.exchangeddotmoneypoint = exchangeddotmoneypoint
        this.exchangedspoon = exchangedspoon
        this.username = username
        this.expireat = expireat
        this.created = created
    }
}
