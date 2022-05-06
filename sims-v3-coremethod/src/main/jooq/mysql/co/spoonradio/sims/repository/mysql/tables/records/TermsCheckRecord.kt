/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.TermsCheck

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record4
import org.jooq.Row4
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TermsCheckRecord() : UpdatableRecordImpl<TermsCheckRecord>(TermsCheck.TERMS_CHECK), Record4<Int?, Int?, LocalDateTime?, Int?> {

    var termsCheckId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var userId: Int?
        set(value) = set(1, value)
        get() = get(1) as Int?

    var createDt: LocalDateTime?
        set(value) = set(2, value)
        get() = get(2) as LocalDateTime?

    var termsId: Int?
        set(value) = set(3, value)
        get() = get(3) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row4<Int?, Int?, LocalDateTime?, Int?> = super.fieldsRow() as Row4<Int?, Int?, LocalDateTime?, Int?>
    override fun valuesRow(): Row4<Int?, Int?, LocalDateTime?, Int?> = super.valuesRow() as Row4<Int?, Int?, LocalDateTime?, Int?>
    override fun field1(): Field<Int?> = TermsCheck.TERMS_CHECK.TERMS_CHECK_ID
    override fun field2(): Field<Int?> = TermsCheck.TERMS_CHECK.USER_ID
    override fun field3(): Field<LocalDateTime?> = TermsCheck.TERMS_CHECK.CREATE_DT
    override fun field4(): Field<Int?> = TermsCheck.TERMS_CHECK.TERMS_ID
    override fun component1(): Int? = termsCheckId
    override fun component2(): Int? = userId
    override fun component3(): LocalDateTime? = createDt
    override fun component4(): Int? = termsId
    override fun value1(): Int? = termsCheckId
    override fun value2(): Int? = userId
    override fun value3(): LocalDateTime? = createDt
    override fun value4(): Int? = termsId

    override fun value1(value: Int?): TermsCheckRecord {
        this.termsCheckId = value
        return this
    }

    override fun value2(value: Int?): TermsCheckRecord {
        this.userId = value
        return this
    }

    override fun value3(value: LocalDateTime?): TermsCheckRecord {
        this.createDt = value
        return this
    }

    override fun value4(value: Int?): TermsCheckRecord {
        this.termsId = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: LocalDateTime?, value4: Int?): TermsCheckRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        return this
    }

    /**
     * Create a detached, initialised TermsCheckRecord
     */
    constructor(termsCheckId: Int? = null, userId: Int? = null, createDt: LocalDateTime? = null, termsId: Int? = null): this() {
        this.termsCheckId = termsCheckId
        this.userId = userId
        this.createDt = createDt
        this.termsId = termsId
    }
}
