/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbexchangedeposit

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record16
import org.jooq.Row16
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbexchangedepositRecord() : UpdatableRecordImpl<TbexchangedepositRecord>(Tbexchangedeposit.TBEXCHANGEDEPOSIT), Record16<Long?, Long?, String?, String?, String?, String?, String?, String?, String?, String?, Boolean?, Boolean?, Boolean?, Boolean?, LocalDateTime?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var exchangeid: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var applicantname: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var email: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var phonenumber: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var residentfirstnumber: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var residentlastnumber: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var accountholder: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var exchangebank: String?
        set(value) = set(8, value)
        get() = get(8) as String?

    var accountnumber: String?
        set(value) = set(9, value)
        get() = get(9) as String?

    var isminor: Boolean?
        set(value) = set(10, value)
        get() = get(10) as Boolean?

    var isdifferentaccountholder: Boolean?
        set(value) = set(11, value)
        get() = get(11) as Boolean?

    var privacyconsent: Boolean?
        set(value) = set(12, value)
        get() = get(12) as Boolean?

    var residentcollectionconsent: Boolean?
        set(value) = set(13, value)
        get() = get(13) as Boolean?

    var created: LocalDateTime?
        set(value) = set(14, value)
        get() = get(14) as LocalDateTime?

    var updated: LocalDateTime?
        set(value) = set(15, value)
        get() = get(15) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row16<Long?, Long?, String?, String?, String?, String?, String?, String?, String?, String?, Boolean?, Boolean?, Boolean?, Boolean?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row16<Long?, Long?, String?, String?, String?, String?, String?, String?, String?, String?, Boolean?, Boolean?, Boolean?, Boolean?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row16<Long?, Long?, String?, String?, String?, String?, String?, String?, String?, String?, Boolean?, Boolean?, Boolean?, Boolean?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row16<Long?, Long?, String?, String?, String?, String?, String?, String?, String?, String?, Boolean?, Boolean?, Boolean?, Boolean?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Long?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.ID
    override fun field2(): Field<Long?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.EXCHANGEID
    override fun field3(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.APPLICANTNAME
    override fun field4(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.EMAIL
    override fun field5(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.PHONENUMBER
    override fun field6(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.RESIDENTFIRSTNUMBER
    override fun field7(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.RESIDENTLASTNUMBER
    override fun field8(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.ACCOUNTHOLDER
    override fun field9(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.EXCHANGEBANK
    override fun field10(): Field<String?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.ACCOUNTNUMBER
    override fun field11(): Field<Boolean?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.ISMINOR
    override fun field12(): Field<Boolean?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.ISDIFFERENTACCOUNTHOLDER
    override fun field13(): Field<Boolean?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.PRIVACYCONSENT
    override fun field14(): Field<Boolean?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.RESIDENTCOLLECTIONCONSENT
    override fun field15(): Field<LocalDateTime?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.CREATED
    override fun field16(): Field<LocalDateTime?> = Tbexchangedeposit.TBEXCHANGEDEPOSIT.UPDATED
    override fun component1(): Long? = id
    override fun component2(): Long? = exchangeid
    override fun component3(): String? = applicantname
    override fun component4(): String? = email
    override fun component5(): String? = phonenumber
    override fun component6(): String? = residentfirstnumber
    override fun component7(): String? = residentlastnumber
    override fun component8(): String? = accountholder
    override fun component9(): String? = exchangebank
    override fun component10(): String? = accountnumber
    override fun component11(): Boolean? = isminor
    override fun component12(): Boolean? = isdifferentaccountholder
    override fun component13(): Boolean? = privacyconsent
    override fun component14(): Boolean? = residentcollectionconsent
    override fun component15(): LocalDateTime? = created
    override fun component16(): LocalDateTime? = updated
    override fun value1(): Long? = id
    override fun value2(): Long? = exchangeid
    override fun value3(): String? = applicantname
    override fun value4(): String? = email
    override fun value5(): String? = phonenumber
    override fun value6(): String? = residentfirstnumber
    override fun value7(): String? = residentlastnumber
    override fun value8(): String? = accountholder
    override fun value9(): String? = exchangebank
    override fun value10(): String? = accountnumber
    override fun value11(): Boolean? = isminor
    override fun value12(): Boolean? = isdifferentaccountholder
    override fun value13(): Boolean? = privacyconsent
    override fun value14(): Boolean? = residentcollectionconsent
    override fun value15(): LocalDateTime? = created
    override fun value16(): LocalDateTime? = updated

    override fun value1(value: Long?): TbexchangedepositRecord {
        this.id = value
        return this
    }

    override fun value2(value: Long?): TbexchangedepositRecord {
        this.exchangeid = value
        return this
    }

    override fun value3(value: String?): TbexchangedepositRecord {
        this.applicantname = value
        return this
    }

    override fun value4(value: String?): TbexchangedepositRecord {
        this.email = value
        return this
    }

    override fun value5(value: String?): TbexchangedepositRecord {
        this.phonenumber = value
        return this
    }

    override fun value6(value: String?): TbexchangedepositRecord {
        this.residentfirstnumber = value
        return this
    }

    override fun value7(value: String?): TbexchangedepositRecord {
        this.residentlastnumber = value
        return this
    }

    override fun value8(value: String?): TbexchangedepositRecord {
        this.accountholder = value
        return this
    }

    override fun value9(value: String?): TbexchangedepositRecord {
        this.exchangebank = value
        return this
    }

    override fun value10(value: String?): TbexchangedepositRecord {
        this.accountnumber = value
        return this
    }

    override fun value11(value: Boolean?): TbexchangedepositRecord {
        this.isminor = value
        return this
    }

    override fun value12(value: Boolean?): TbexchangedepositRecord {
        this.isdifferentaccountholder = value
        return this
    }

    override fun value13(value: Boolean?): TbexchangedepositRecord {
        this.privacyconsent = value
        return this
    }

    override fun value14(value: Boolean?): TbexchangedepositRecord {
        this.residentcollectionconsent = value
        return this
    }

    override fun value15(value: LocalDateTime?): TbexchangedepositRecord {
        this.created = value
        return this
    }

    override fun value16(value: LocalDateTime?): TbexchangedepositRecord {
        this.updated = value
        return this
    }

    override fun values(value1: Long?, value2: Long?, value3: String?, value4: String?, value5: String?, value6: String?, value7: String?, value8: String?, value9: String?, value10: String?, value11: Boolean?, value12: Boolean?, value13: Boolean?, value14: Boolean?, value15: LocalDateTime?, value16: LocalDateTime?): TbexchangedepositRecord {
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
        this.value16(value16)
        return this
    }

    /**
     * Create a detached, initialised TbexchangedepositRecord
     */
    constructor(id: Long? = null, exchangeid: Long? = null, applicantname: String? = null, email: String? = null, phonenumber: String? = null, residentfirstnumber: String? = null, residentlastnumber: String? = null, accountholder: String? = null, exchangebank: String? = null, accountnumber: String? = null, isminor: Boolean? = null, isdifferentaccountholder: Boolean? = null, privacyconsent: Boolean? = null, residentcollectionconsent: Boolean? = null, created: LocalDateTime? = null, updated: LocalDateTime? = null): this() {
        this.id = id
        this.exchangeid = exchangeid
        this.applicantname = applicantname
        this.email = email
        this.phonenumber = phonenumber
        this.residentfirstnumber = residentfirstnumber
        this.residentlastnumber = residentlastnumber
        this.accountholder = accountholder
        this.exchangebank = exchangebank
        this.accountnumber = accountnumber
        this.isminor = isminor
        this.isdifferentaccountholder = isdifferentaccountholder
        this.privacyconsent = privacyconsent
        this.residentcollectionconsent = residentcollectionconsent
        this.created = created
        this.updated = updated
    }
}