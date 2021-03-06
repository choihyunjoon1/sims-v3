/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.AllowEqui

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
open class AllowEquiRecord() : UpdatableRecordImpl<AllowEquiRecord>(AllowEqui.ALLOW_EQUI), Record7<Int?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> {

    var allowEquiId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var allowEquiTypeCd: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var allowEquiInfo: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var etc1: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var etc2: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var updateDt: LocalDateTime?
        set(value) = set(5, value)
        get() = get(5) as LocalDateTime?

    var createDt: LocalDateTime?
        set(value) = set(6, value)
        get() = get(6) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row7<Int?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row7<Int?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row7<Int?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row7<Int?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Int?> = AllowEqui.ALLOW_EQUI.ALLOW_EQUI_ID
    override fun field2(): Field<String?> = AllowEqui.ALLOW_EQUI.ALLOW_EQUI_TYPE_CD
    override fun field3(): Field<String?> = AllowEqui.ALLOW_EQUI.ALLOW_EQUI_INFO
    override fun field4(): Field<String?> = AllowEqui.ALLOW_EQUI.ETC1
    override fun field5(): Field<String?> = AllowEqui.ALLOW_EQUI.ETC2
    override fun field6(): Field<LocalDateTime?> = AllowEqui.ALLOW_EQUI.UPDATE_DT
    override fun field7(): Field<LocalDateTime?> = AllowEqui.ALLOW_EQUI.CREATE_DT
    override fun component1(): Int? = allowEquiId
    override fun component2(): String? = allowEquiTypeCd
    override fun component3(): String? = allowEquiInfo
    override fun component4(): String? = etc1
    override fun component5(): String? = etc2
    override fun component6(): LocalDateTime? = updateDt
    override fun component7(): LocalDateTime? = createDt
    override fun value1(): Int? = allowEquiId
    override fun value2(): String? = allowEquiTypeCd
    override fun value3(): String? = allowEquiInfo
    override fun value4(): String? = etc1
    override fun value5(): String? = etc2
    override fun value6(): LocalDateTime? = updateDt
    override fun value7(): LocalDateTime? = createDt

    override fun value1(value: Int?): AllowEquiRecord {
        this.allowEquiId = value
        return this
    }

    override fun value2(value: String?): AllowEquiRecord {
        this.allowEquiTypeCd = value
        return this
    }

    override fun value3(value: String?): AllowEquiRecord {
        this.allowEquiInfo = value
        return this
    }

    override fun value4(value: String?): AllowEquiRecord {
        this.etc1 = value
        return this
    }

    override fun value5(value: String?): AllowEquiRecord {
        this.etc2 = value
        return this
    }

    override fun value6(value: LocalDateTime?): AllowEquiRecord {
        this.updateDt = value
        return this
    }

    override fun value7(value: LocalDateTime?): AllowEquiRecord {
        this.createDt = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: String?, value4: String?, value5: String?, value6: LocalDateTime?, value7: LocalDateTime?): AllowEquiRecord {
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
     * Create a detached, initialised AllowEquiRecord
     */
    constructor(allowEquiId: Int? = null, allowEquiTypeCd: String? = null, allowEquiInfo: String? = null, etc1: String? = null, etc2: String? = null, updateDt: LocalDateTime? = null, createDt: LocalDateTime? = null): this() {
        this.allowEquiId = allowEquiId
        this.allowEquiTypeCd = allowEquiTypeCd
        this.allowEquiInfo = allowEquiInfo
        this.etc1 = etc1
        this.etc2 = etc2
        this.updateDt = updateDt
        this.createDt = createDt
    }
}
