/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.UserMenuAuth

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
open class UserMenuAuthRecord() : UpdatableRecordImpl<UserMenuAuthRecord>(UserMenuAuth.USER_MENU_AUTH), Record6<Int?, Byte?, LocalDateTime?, LocalDateTime?, Int?, Int?> {

    var userMenuAuthId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var unmasking: Byte?
        set(value) = set(1, value)
        get() = get(1) as Byte?

    var createDt: LocalDateTime?
        set(value) = set(2, value)
        get() = get(2) as LocalDateTime?

    var updateDt: LocalDateTime?
        set(value) = set(3, value)
        get() = get(3) as LocalDateTime?

    var subMenuId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var userId: Int?
        set(value) = set(5, value)
        get() = get(5) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row6<Int?, Byte?, LocalDateTime?, LocalDateTime?, Int?, Int?> = super.fieldsRow() as Row6<Int?, Byte?, LocalDateTime?, LocalDateTime?, Int?, Int?>
    override fun valuesRow(): Row6<Int?, Byte?, LocalDateTime?, LocalDateTime?, Int?, Int?> = super.valuesRow() as Row6<Int?, Byte?, LocalDateTime?, LocalDateTime?, Int?, Int?>
    override fun field1(): Field<Int?> = UserMenuAuth.USER_MENU_AUTH.USER_MENU_AUTH_ID
    override fun field2(): Field<Byte?> = UserMenuAuth.USER_MENU_AUTH.UNMASKING
    override fun field3(): Field<LocalDateTime?> = UserMenuAuth.USER_MENU_AUTH.CREATE_DT
    override fun field4(): Field<LocalDateTime?> = UserMenuAuth.USER_MENU_AUTH.UPDATE_DT
    override fun field5(): Field<Int?> = UserMenuAuth.USER_MENU_AUTH.SUB_MENU_ID
    override fun field6(): Field<Int?> = UserMenuAuth.USER_MENU_AUTH.USER_ID
    override fun component1(): Int? = userMenuAuthId
    override fun component2(): Byte? = unmasking
    override fun component3(): LocalDateTime? = createDt
    override fun component4(): LocalDateTime? = updateDt
    override fun component5(): Int? = subMenuId
    override fun component6(): Int? = userId
    override fun value1(): Int? = userMenuAuthId
    override fun value2(): Byte? = unmasking
    override fun value3(): LocalDateTime? = createDt
    override fun value4(): LocalDateTime? = updateDt
    override fun value5(): Int? = subMenuId
    override fun value6(): Int? = userId

    override fun value1(value: Int?): UserMenuAuthRecord {
        this.userMenuAuthId = value
        return this
    }

    override fun value2(value: Byte?): UserMenuAuthRecord {
        this.unmasking = value
        return this
    }

    override fun value3(value: LocalDateTime?): UserMenuAuthRecord {
        this.createDt = value
        return this
    }

    override fun value4(value: LocalDateTime?): UserMenuAuthRecord {
        this.updateDt = value
        return this
    }

    override fun value5(value: Int?): UserMenuAuthRecord {
        this.subMenuId = value
        return this
    }

    override fun value6(value: Int?): UserMenuAuthRecord {
        this.userId = value
        return this
    }

    override fun values(value1: Int?, value2: Byte?, value3: LocalDateTime?, value4: LocalDateTime?, value5: Int?, value6: Int?): UserMenuAuthRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        return this
    }

    /**
     * Create a detached, initialised UserMenuAuthRecord
     */
    constructor(userMenuAuthId: Int? = null, unmasking: Byte? = null, createDt: LocalDateTime? = null, updateDt: LocalDateTime? = null, subMenuId: Int? = null, userId: Int? = null): this() {
        this.userMenuAuthId = userMenuAuthId
        this.unmasking = unmasking
        this.createDt = createDt
        this.updateDt = updateDt
        this.subMenuId = subMenuId
        this.userId = userId
    }
}
