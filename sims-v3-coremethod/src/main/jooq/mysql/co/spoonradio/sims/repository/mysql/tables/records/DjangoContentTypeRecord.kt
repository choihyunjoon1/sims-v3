/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.DjangoContentType

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record3
import org.jooq.Row3
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class DjangoContentTypeRecord() : UpdatableRecordImpl<DjangoContentTypeRecord>(DjangoContentType.DJANGO_CONTENT_TYPE), Record3<Int?, String?, String?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var appLabel: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var model: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row3<Int?, String?, String?> = super.fieldsRow() as Row3<Int?, String?, String?>
    override fun valuesRow(): Row3<Int?, String?, String?> = super.valuesRow() as Row3<Int?, String?, String?>
    override fun field1(): Field<Int?> = DjangoContentType.DJANGO_CONTENT_TYPE.ID
    override fun field2(): Field<String?> = DjangoContentType.DJANGO_CONTENT_TYPE.APP_LABEL
    override fun field3(): Field<String?> = DjangoContentType.DJANGO_CONTENT_TYPE.MODEL
    override fun component1(): Int? = id
    override fun component2(): String? = appLabel
    override fun component3(): String? = model
    override fun value1(): Int? = id
    override fun value2(): String? = appLabel
    override fun value3(): String? = model

    override fun value1(value: Int?): DjangoContentTypeRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): DjangoContentTypeRecord {
        this.appLabel = value
        return this
    }

    override fun value3(value: String?): DjangoContentTypeRecord {
        this.model = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: String?): DjangoContentTypeRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        return this
    }

    /**
     * Create a detached, initialised DjangoContentTypeRecord
     */
    constructor(id: Int? = null, appLabel: String? = null, model: String? = null): this() {
        this.id = id
        this.appLabel = appLabel
        this.model = model
    }
}
