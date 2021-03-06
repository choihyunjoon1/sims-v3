/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.records


import co.spoonradio.sims.repository.postgresql.tables.FanboardFancomment

import java.time.OffsetDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record9
import org.jooq.Row9
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class FanboardFancommentRecord() : UpdatableRecordImpl<FanboardFancommentRecord>(FanboardFancomment.FANBOARD_FANCOMMENT), Record9<Int?, String?, Boolean?, OffsetDateTime?, Int?, Int?, Boolean?, Int?, Int?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var contents: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var isBlind: Boolean?
        set(value) = set(2, value)
        get() = get(2) as Boolean?

    var created: OffsetDateTime?
        set(value) = set(3, value)
        get() = get(3) as OffsetDateTime?

    var authorId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var fanBoardId: Int?
        set(value) = set(5, value)
        get() = get(5) as Int?

    var isNotice: Boolean?
        set(value) = set(6, value)
        get() = get(6) as Boolean?

    var toUserId: Int?
        set(value) = set(7, value)
        get() = get(7) as Int?

    var messageCount: Int?
        set(value) = set(8, value)
        get() = get(8) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row9<Int?, String?, Boolean?, OffsetDateTime?, Int?, Int?, Boolean?, Int?, Int?> = super.fieldsRow() as Row9<Int?, String?, Boolean?, OffsetDateTime?, Int?, Int?, Boolean?, Int?, Int?>
    override fun valuesRow(): Row9<Int?, String?, Boolean?, OffsetDateTime?, Int?, Int?, Boolean?, Int?, Int?> = super.valuesRow() as Row9<Int?, String?, Boolean?, OffsetDateTime?, Int?, Int?, Boolean?, Int?, Int?>
    override fun field1(): Field<Int?> = FanboardFancomment.FANBOARD_FANCOMMENT.ID
    override fun field2(): Field<String?> = FanboardFancomment.FANBOARD_FANCOMMENT.CONTENTS
    override fun field3(): Field<Boolean?> = FanboardFancomment.FANBOARD_FANCOMMENT.IS_BLIND
    override fun field4(): Field<OffsetDateTime?> = FanboardFancomment.FANBOARD_FANCOMMENT.CREATED
    override fun field5(): Field<Int?> = FanboardFancomment.FANBOARD_FANCOMMENT.AUTHOR_ID
    override fun field6(): Field<Int?> = FanboardFancomment.FANBOARD_FANCOMMENT.FAN_BOARD_ID
    override fun field7(): Field<Boolean?> = FanboardFancomment.FANBOARD_FANCOMMENT.IS_NOTICE
    override fun field8(): Field<Int?> = FanboardFancomment.FANBOARD_FANCOMMENT.TO_USER_ID
    override fun field9(): Field<Int?> = FanboardFancomment.FANBOARD_FANCOMMENT.MESSAGE_COUNT
    override fun component1(): Int? = id
    override fun component2(): String? = contents
    override fun component3(): Boolean? = isBlind
    override fun component4(): OffsetDateTime? = created
    override fun component5(): Int? = authorId
    override fun component6(): Int? = fanBoardId
    override fun component7(): Boolean? = isNotice
    override fun component8(): Int? = toUserId
    override fun component9(): Int? = messageCount
    override fun value1(): Int? = id
    override fun value2(): String? = contents
    override fun value3(): Boolean? = isBlind
    override fun value4(): OffsetDateTime? = created
    override fun value5(): Int? = authorId
    override fun value6(): Int? = fanBoardId
    override fun value7(): Boolean? = isNotice
    override fun value8(): Int? = toUserId
    override fun value9(): Int? = messageCount

    override fun value1(value: Int?): FanboardFancommentRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): FanboardFancommentRecord {
        this.contents = value
        return this
    }

    override fun value3(value: Boolean?): FanboardFancommentRecord {
        this.isBlind = value
        return this
    }

    override fun value4(value: OffsetDateTime?): FanboardFancommentRecord {
        this.created = value
        return this
    }

    override fun value5(value: Int?): FanboardFancommentRecord {
        this.authorId = value
        return this
    }

    override fun value6(value: Int?): FanboardFancommentRecord {
        this.fanBoardId = value
        return this
    }

    override fun value7(value: Boolean?): FanboardFancommentRecord {
        this.isNotice = value
        return this
    }

    override fun value8(value: Int?): FanboardFancommentRecord {
        this.toUserId = value
        return this
    }

    override fun value9(value: Int?): FanboardFancommentRecord {
        this.messageCount = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: Boolean?, value4: OffsetDateTime?, value5: Int?, value6: Int?, value7: Boolean?, value8: Int?, value9: Int?): FanboardFancommentRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        return this
    }

    /**
     * Create a detached, initialised FanboardFancommentRecord
     */
    constructor(id: Int? = null, contents: String? = null, isBlind: Boolean? = null, created: OffsetDateTime? = null, authorId: Int? = null, fanBoardId: Int? = null, isNotice: Boolean? = null, toUserId: Int? = null, messageCount: Int? = null): this() {
        this.id = id
        this.contents = contents
        this.isBlind = isBlind
        this.created = created
        this.authorId = authorId
        this.fanBoardId = fanBoardId
        this.isNotice = isNotice
        this.toUserId = toUserId
        this.messageCount = messageCount
    }
}
