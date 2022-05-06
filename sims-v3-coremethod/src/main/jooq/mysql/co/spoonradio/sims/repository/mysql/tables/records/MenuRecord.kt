/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.Menu

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record8
import org.jooq.Row8
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class MenuRecord() : UpdatableRecordImpl<MenuRecord>(Menu.MENU), Record8<Int?, String?, String?, Int?, LocalDateTime?, LocalDateTime?, String?, Byte?> {

    var menuId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var name: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var enName: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var ord: Int?
        set(value) = set(3, value)
        get() = get(3) as Int?

    var createDt: LocalDateTime?
        set(value) = set(4, value)
        get() = get(4) as LocalDateTime?

    var updateDt: LocalDateTime?
        set(value) = set(5, value)
        get() = get(5) as LocalDateTime?

    var icon: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var isUsed: Byte?
        set(value) = set(7, value)
        get() = get(7) as Byte?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row8<Int?, String?, String?, Int?, LocalDateTime?, LocalDateTime?, String?, Byte?> = super.fieldsRow() as Row8<Int?, String?, String?, Int?, LocalDateTime?, LocalDateTime?, String?, Byte?>
    override fun valuesRow(): Row8<Int?, String?, String?, Int?, LocalDateTime?, LocalDateTime?, String?, Byte?> = super.valuesRow() as Row8<Int?, String?, String?, Int?, LocalDateTime?, LocalDateTime?, String?, Byte?>
    override fun field1(): Field<Int?> = Menu.MENU.MENU_ID
    override fun field2(): Field<String?> = Menu.MENU.NAME
    override fun field3(): Field<String?> = Menu.MENU.EN_NAME
    override fun field4(): Field<Int?> = Menu.MENU.ORD
    override fun field5(): Field<LocalDateTime?> = Menu.MENU.CREATE_DT
    override fun field6(): Field<LocalDateTime?> = Menu.MENU.UPDATE_DT
    override fun field7(): Field<String?> = Menu.MENU.ICON
    override fun field8(): Field<Byte?> = Menu.MENU.IS_USED
    override fun component1(): Int? = menuId
    override fun component2(): String? = name
    override fun component3(): String? = enName
    override fun component4(): Int? = ord
    override fun component5(): LocalDateTime? = createDt
    override fun component6(): LocalDateTime? = updateDt
    override fun component7(): String? = icon
    override fun component8(): Byte? = isUsed
    override fun value1(): Int? = menuId
    override fun value2(): String? = name
    override fun value3(): String? = enName
    override fun value4(): Int? = ord
    override fun value5(): LocalDateTime? = createDt
    override fun value6(): LocalDateTime? = updateDt
    override fun value7(): String? = icon
    override fun value8(): Byte? = isUsed

    override fun value1(value: Int?): MenuRecord {
        this.menuId = value
        return this
    }

    override fun value2(value: String?): MenuRecord {
        this.name = value
        return this
    }

    override fun value3(value: String?): MenuRecord {
        this.enName = value
        return this
    }

    override fun value4(value: Int?): MenuRecord {
        this.ord = value
        return this
    }

    override fun value5(value: LocalDateTime?): MenuRecord {
        this.createDt = value
        return this
    }

    override fun value6(value: LocalDateTime?): MenuRecord {
        this.updateDt = value
        return this
    }

    override fun value7(value: String?): MenuRecord {
        this.icon = value
        return this
    }

    override fun value8(value: Byte?): MenuRecord {
        this.isUsed = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: String?, value4: Int?, value5: LocalDateTime?, value6: LocalDateTime?, value7: String?, value8: Byte?): MenuRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        return this
    }

    /**
     * Create a detached, initialised MenuRecord
     */
    constructor(menuId: Int? = null, name: String? = null, enName: String? = null, ord: Int? = null, createDt: LocalDateTime? = null, updateDt: LocalDateTime? = null, icon: String? = null, isUsed: Byte? = null): this() {
        this.menuId = menuId
        this.name = name
        this.enName = enName
        this.ord = ord
        this.createDt = createDt
        this.updateDt = updateDt
        this.icon = icon
        this.isUsed = isUsed
    }
}