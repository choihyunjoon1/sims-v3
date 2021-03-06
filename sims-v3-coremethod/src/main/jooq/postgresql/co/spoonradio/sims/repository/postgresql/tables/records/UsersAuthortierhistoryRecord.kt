/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.records


import co.spoonradio.sims.repository.postgresql.tables.UsersAuthortierhistory

import java.time.OffsetDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record6
import org.jooq.Row6
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UsersAuthortierhistoryRecord() : UpdatableRecordImpl<UsersAuthortierhistoryRecord>(UsersAuthortierhistory.USERS_AUTHORTIERHISTORY), Record6<Int?, String?, Array<Any?>?, Boolean?, OffsetDateTime?, Int?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var title: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var userIds: Array<Any?>?
        set(value) = set(2, value)
        get() = get(2) as Array<Any?>?

    var isUsed: Boolean?
        set(value) = set(3, value)
        get() = get(3) as Boolean?

    var created: OffsetDateTime?
        set(value) = set(4, value)
        get() = get(4) as OffsetDateTime?

    var tierId: Int?
        set(value) = set(5, value)
        get() = get(5) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row6<Int?, String?, Array<Any?>?, Boolean?, OffsetDateTime?, Int?> = super.fieldsRow() as Row6<Int?, String?, Array<Any?>?, Boolean?, OffsetDateTime?, Int?>
    override fun valuesRow(): Row6<Int?, String?, Array<Any?>?, Boolean?, OffsetDateTime?, Int?> = super.valuesRow() as Row6<Int?, String?, Array<Any?>?, Boolean?, OffsetDateTime?, Int?>
    override fun field1(): Field<Int?> = UsersAuthortierhistory.USERS_AUTHORTIERHISTORY.ID
    override fun field2(): Field<String?> = UsersAuthortierhistory.USERS_AUTHORTIERHISTORY.TITLE
    override fun field3(): Field<Array<Any?>?> = UsersAuthortierhistory.USERS_AUTHORTIERHISTORY.USER_IDS
    override fun field4(): Field<Boolean?> = UsersAuthortierhistory.USERS_AUTHORTIERHISTORY.IS_USED
    override fun field5(): Field<OffsetDateTime?> = UsersAuthortierhistory.USERS_AUTHORTIERHISTORY.CREATED
    override fun field6(): Field<Int?> = UsersAuthortierhistory.USERS_AUTHORTIERHISTORY.TIER_ID
    override fun component1(): Int? = id
    override fun component2(): String? = title
    override fun component3(): Array<Any?>? = userIds
    override fun component4(): Boolean? = isUsed
    override fun component5(): OffsetDateTime? = created
    override fun component6(): Int? = tierId
    override fun value1(): Int? = id
    override fun value2(): String? = title
    override fun value3(): Array<Any?>? = userIds
    override fun value4(): Boolean? = isUsed
    override fun value5(): OffsetDateTime? = created
    override fun value6(): Int? = tierId

    override fun value1(value: Int?): UsersAuthortierhistoryRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): UsersAuthortierhistoryRecord {
        this.title = value
        return this
    }

    override fun value3(value: Array<Any?>?): UsersAuthortierhistoryRecord {
        this.userIds = value
        return this
    }

    override fun value4(value: Boolean?): UsersAuthortierhistoryRecord {
        this.isUsed = value
        return this
    }

    override fun value5(value: OffsetDateTime?): UsersAuthortierhistoryRecord {
        this.created = value
        return this
    }

    override fun value6(value: Int?): UsersAuthortierhistoryRecord {
        this.tierId = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: Array<Any?>?, value4: Boolean?, value5: OffsetDateTime?, value6: Int?): UsersAuthortierhistoryRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        return this
    }

    /**
     * Create a detached, initialised UsersAuthortierhistoryRecord
     */
    constructor(id: Int? = null, title: String? = null, userIds: Array<Any?>? = null, isUsed: Boolean? = null, created: OffsetDateTime? = null, tierId: Int? = null): this() {
        this.id = id
        this.title = title
        this.userIds = userIds
        this.isUsed = isUsed
        this.created = created
        this.tierId = tierId
    }
}
