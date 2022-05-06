/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.NoticeCheck

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
open class NoticeCheckRecord() : UpdatableRecordImpl<NoticeCheckRecord>(NoticeCheck.NOTICE_CHECK), Record4<Int?, Int?, LocalDateTime?, Int?> {

    var noticeCheckId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var userId: Int?
        set(value) = set(1, value)
        get() = get(1) as Int?

    var createDt: LocalDateTime?
        set(value) = set(2, value)
        get() = get(2) as LocalDateTime?

    var noticeId: Int?
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
    override fun field1(): Field<Int?> = NoticeCheck.NOTICE_CHECK.NOTICE_CHECK_ID
    override fun field2(): Field<Int?> = NoticeCheck.NOTICE_CHECK.USER_ID
    override fun field3(): Field<LocalDateTime?> = NoticeCheck.NOTICE_CHECK.CREATE_DT
    override fun field4(): Field<Int?> = NoticeCheck.NOTICE_CHECK.NOTICE_ID
    override fun component1(): Int? = noticeCheckId
    override fun component2(): Int? = userId
    override fun component3(): LocalDateTime? = createDt
    override fun component4(): Int? = noticeId
    override fun value1(): Int? = noticeCheckId
    override fun value2(): Int? = userId
    override fun value3(): LocalDateTime? = createDt
    override fun value4(): Int? = noticeId

    override fun value1(value: Int?): NoticeCheckRecord {
        this.noticeCheckId = value
        return this
    }

    override fun value2(value: Int?): NoticeCheckRecord {
        this.userId = value
        return this
    }

    override fun value3(value: LocalDateTime?): NoticeCheckRecord {
        this.createDt = value
        return this
    }

    override fun value4(value: Int?): NoticeCheckRecord {
        this.noticeId = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: LocalDateTime?, value4: Int?): NoticeCheckRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        return this
    }

    /**
     * Create a detached, initialised NoticeCheckRecord
     */
    constructor(noticeCheckId: Int? = null, userId: Int? = null, createDt: LocalDateTime? = null, noticeId: Int? = null): this() {
        this.noticeCheckId = noticeCheckId
        this.userId = userId
        this.createDt = createDt
        this.noticeId = noticeId
    }
}