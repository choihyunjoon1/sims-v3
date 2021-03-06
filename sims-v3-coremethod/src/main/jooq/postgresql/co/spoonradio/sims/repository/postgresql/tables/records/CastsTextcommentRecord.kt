/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.records


import co.spoonradio.sims.repository.postgresql.tables.CastsTextcomment

import java.time.OffsetDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record7
import org.jooq.Row7
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CastsTextcommentRecord() : UpdatableRecordImpl<CastsTextcommentRecord>(CastsTextcomment.CASTS_TEXTCOMMENT), Record7<Int?, String?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var contents: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var reporters: Array<Any?>?
        set(value) = set(2, value)
        get() = get(2) as Array<Any?>?

    var created: OffsetDateTime?
        set(value) = set(3, value)
        get() = get(3) as OffsetDateTime?

    var authorId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var castId: Int?
        set(value) = set(5, value)
        get() = get(5) as Int?

    var toUserId: Int?
        set(value) = set(6, value)
        get() = get(6) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row7<Int?, String?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?> = super.fieldsRow() as Row7<Int?, String?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?>
    override fun valuesRow(): Row7<Int?, String?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?> = super.valuesRow() as Row7<Int?, String?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?>
    override fun field1(): Field<Int?> = CastsTextcomment.CASTS_TEXTCOMMENT.ID
    override fun field2(): Field<String?> = CastsTextcomment.CASTS_TEXTCOMMENT.CONTENTS
    override fun field3(): Field<Array<Any?>?> = CastsTextcomment.CASTS_TEXTCOMMENT.REPORTERS
    override fun field4(): Field<OffsetDateTime?> = CastsTextcomment.CASTS_TEXTCOMMENT.CREATED
    override fun field5(): Field<Int?> = CastsTextcomment.CASTS_TEXTCOMMENT.AUTHOR_ID
    override fun field6(): Field<Int?> = CastsTextcomment.CASTS_TEXTCOMMENT.CAST_ID
    override fun field7(): Field<Int?> = CastsTextcomment.CASTS_TEXTCOMMENT.TO_USER_ID
    override fun component1(): Int? = id
    override fun component2(): String? = contents
    override fun component3(): Array<Any?>? = reporters
    override fun component4(): OffsetDateTime? = created
    override fun component5(): Int? = authorId
    override fun component6(): Int? = castId
    override fun component7(): Int? = toUserId
    override fun value1(): Int? = id
    override fun value2(): String? = contents
    override fun value3(): Array<Any?>? = reporters
    override fun value4(): OffsetDateTime? = created
    override fun value5(): Int? = authorId
    override fun value6(): Int? = castId
    override fun value7(): Int? = toUserId

    override fun value1(value: Int?): CastsTextcommentRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): CastsTextcommentRecord {
        this.contents = value
        return this
    }

    override fun value3(value: Array<Any?>?): CastsTextcommentRecord {
        this.reporters = value
        return this
    }

    override fun value4(value: OffsetDateTime?): CastsTextcommentRecord {
        this.created = value
        return this
    }

    override fun value5(value: Int?): CastsTextcommentRecord {
        this.authorId = value
        return this
    }

    override fun value6(value: Int?): CastsTextcommentRecord {
        this.castId = value
        return this
    }

    override fun value7(value: Int?): CastsTextcommentRecord {
        this.toUserId = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: Array<Any?>?, value4: OffsetDateTime?, value5: Int?, value6: Int?, value7: Int?): CastsTextcommentRecord {
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
     * Create a detached, initialised CastsTextcommentRecord
     */
    constructor(id: Int? = null, contents: String? = null, reporters: Array<Any?>? = null, created: OffsetDateTime? = null, authorId: Int? = null, castId: Int? = null, toUserId: Int? = null): this() {
        this.id = id
        this.contents = contents
        this.reporters = reporters
        this.created = created
        this.authorId = authorId
        this.castId = castId
        this.toUserId = toUserId
    }
}
