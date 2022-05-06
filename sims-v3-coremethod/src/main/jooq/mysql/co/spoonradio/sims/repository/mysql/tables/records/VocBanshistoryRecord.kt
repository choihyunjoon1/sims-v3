/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.VocBanshistory

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record6
import org.jooq.Row6
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class VocBanshistoryRecord() : UpdatableRecordImpl<VocBanshistoryRecord>(VocBanshistory.VOC_BANSHISTORY), Record6<Int?, Long?, Long?, Long?, String?, LocalDateTime?> {

    var bansHistoryId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var bansId: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var bansUserId: Long?
        set(value) = set(2, value)
        get() = get(2) as Long?

    var handlerUserId: Long?
        set(value) = set(3, value)
        get() = get(3) as Long?

    var handlerUserName: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var createDt: LocalDateTime?
        set(value) = set(5, value)
        get() = get(5) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row6<Int?, Long?, Long?, Long?, String?, LocalDateTime?> = super.fieldsRow() as Row6<Int?, Long?, Long?, Long?, String?, LocalDateTime?>
    override fun valuesRow(): Row6<Int?, Long?, Long?, Long?, String?, LocalDateTime?> = super.valuesRow() as Row6<Int?, Long?, Long?, Long?, String?, LocalDateTime?>
    override fun field1(): Field<Int?> = VocBanshistory.VOC_BANSHISTORY.BANS_HISTORY_ID
    override fun field2(): Field<Long?> = VocBanshistory.VOC_BANSHISTORY.BANS_ID
    override fun field3(): Field<Long?> = VocBanshistory.VOC_BANSHISTORY.BANS_USER_ID
    override fun field4(): Field<Long?> = VocBanshistory.VOC_BANSHISTORY.HANDLER_USER_ID
    override fun field5(): Field<String?> = VocBanshistory.VOC_BANSHISTORY.HANDLER_USER_NAME
    override fun field6(): Field<LocalDateTime?> = VocBanshistory.VOC_BANSHISTORY.CREATE_DT
    override fun component1(): Int? = bansHistoryId
    override fun component2(): Long? = bansId
    override fun component3(): Long? = bansUserId
    override fun component4(): Long? = handlerUserId
    override fun component5(): String? = handlerUserName
    override fun component6(): LocalDateTime? = createDt
    override fun value1(): Int? = bansHistoryId
    override fun value2(): Long? = bansId
    override fun value3(): Long? = bansUserId
    override fun value4(): Long? = handlerUserId
    override fun value5(): String? = handlerUserName
    override fun value6(): LocalDateTime? = createDt

    override fun value1(value: Int?): VocBanshistoryRecord {
        this.bansHistoryId = value
        return this
    }

    override fun value2(value: Long?): VocBanshistoryRecord {
        this.bansId = value
        return this
    }

    override fun value3(value: Long?): VocBanshistoryRecord {
        this.bansUserId = value
        return this
    }

    override fun value4(value: Long?): VocBanshistoryRecord {
        this.handlerUserId = value
        return this
    }

    override fun value5(value: String?): VocBanshistoryRecord {
        this.handlerUserName = value
        return this
    }

    override fun value6(value: LocalDateTime?): VocBanshistoryRecord {
        this.createDt = value
        return this
    }

    override fun values(value1: Int?, value2: Long?, value3: Long?, value4: Long?, value5: String?, value6: LocalDateTime?): VocBanshistoryRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        return this
    }

    /**
     * Create a detached, initialised VocBanshistoryRecord
     */
    constructor(bansHistoryId: Int? = null, bansId: Long? = null, bansUserId: Long? = null, handlerUserId: Long? = null, handlerUserName: String? = null, createDt: LocalDateTime? = null): this() {
        this.bansHistoryId = bansHistoryId
        this.bansId = bansId
        this.bansUserId = bansUserId
        this.handlerUserId = handlerUserId
        this.handlerUserName = handlerUserName
        this.createDt = createDt
    }
}
