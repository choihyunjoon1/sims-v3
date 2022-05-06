/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.records


import co.spoonradio.sims.repository.postgresql.tables.UsersFollow

import java.time.OffsetDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record5
import org.jooq.Row5
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UsersFollowRecord() : UpdatableRecordImpl<UsersFollowRecord>(UsersFollow.USERS_FOLLOW), Record5<Int?, Int?, OffsetDateTime?, Int?, Int?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var pushLevel: Int?
        set(value) = set(1, value)
        get() = get(1) as Int?

    var created: OffsetDateTime?
        set(value) = set(2, value)
        get() = get(2) as OffsetDateTime?

    var fromUserId: Int?
        set(value) = set(3, value)
        get() = get(3) as Int?

    var toUserId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row5<Int?, Int?, OffsetDateTime?, Int?, Int?> = super.fieldsRow() as Row5<Int?, Int?, OffsetDateTime?, Int?, Int?>
    override fun valuesRow(): Row5<Int?, Int?, OffsetDateTime?, Int?, Int?> = super.valuesRow() as Row5<Int?, Int?, OffsetDateTime?, Int?, Int?>
    override fun field1(): Field<Int?> = UsersFollow.USERS_FOLLOW.ID
    override fun field2(): Field<Int?> = UsersFollow.USERS_FOLLOW.PUSH_LEVEL
    override fun field3(): Field<OffsetDateTime?> = UsersFollow.USERS_FOLLOW.CREATED
    override fun field4(): Field<Int?> = UsersFollow.USERS_FOLLOW.FROM_USER_ID
    override fun field5(): Field<Int?> = UsersFollow.USERS_FOLLOW.TO_USER_ID
    override fun component1(): Int? = id
    override fun component2(): Int? = pushLevel
    override fun component3(): OffsetDateTime? = created
    override fun component4(): Int? = fromUserId
    override fun component5(): Int? = toUserId
    override fun value1(): Int? = id
    override fun value2(): Int? = pushLevel
    override fun value3(): OffsetDateTime? = created
    override fun value4(): Int? = fromUserId
    override fun value5(): Int? = toUserId

    override fun value1(value: Int?): UsersFollowRecord {
        this.id = value
        return this
    }

    override fun value2(value: Int?): UsersFollowRecord {
        this.pushLevel = value
        return this
    }

    override fun value3(value: OffsetDateTime?): UsersFollowRecord {
        this.created = value
        return this
    }

    override fun value4(value: Int?): UsersFollowRecord {
        this.fromUserId = value
        return this
    }

    override fun value5(value: Int?): UsersFollowRecord {
        this.toUserId = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: OffsetDateTime?, value4: Int?, value5: Int?): UsersFollowRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        return this
    }

    /**
     * Create a detached, initialised UsersFollowRecord
     */
    constructor(id: Int? = null, pushLevel: Int? = null, created: OffsetDateTime? = null, fromUserId: Int? = null, toUserId: Int? = null): this() {
        this.id = id
        this.pushLevel = pushLevel
        this.created = created
        this.fromUserId = fromUserId
        this.toUserId = toUserId
    }
}
