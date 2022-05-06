/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.TeamMenuAuthList

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record5
import org.jooq.Row5
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TeamMenuAuthListRecord() : UpdatableRecordImpl<TeamMenuAuthListRecord>(TeamMenuAuthList.TEAM_MENU_AUTH_LIST), Record5<Int?, String?, LocalDateTime?, LocalDateTime?, Int?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var userGrpCd: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var createDt: LocalDateTime?
        set(value) = set(2, value)
        get() = get(2) as LocalDateTime?

    var updateDt: LocalDateTime?
        set(value) = set(3, value)
        get() = get(3) as LocalDateTime?

    var subMenuId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row5<Int?, String?, LocalDateTime?, LocalDateTime?, Int?> = super.fieldsRow() as Row5<Int?, String?, LocalDateTime?, LocalDateTime?, Int?>
    override fun valuesRow(): Row5<Int?, String?, LocalDateTime?, LocalDateTime?, Int?> = super.valuesRow() as Row5<Int?, String?, LocalDateTime?, LocalDateTime?, Int?>
    override fun field1(): Field<Int?> = TeamMenuAuthList.TEAM_MENU_AUTH_LIST.ID
    override fun field2(): Field<String?> = TeamMenuAuthList.TEAM_MENU_AUTH_LIST.USER_GRP_CD
    override fun field3(): Field<LocalDateTime?> = TeamMenuAuthList.TEAM_MENU_AUTH_LIST.CREATE_DT
    override fun field4(): Field<LocalDateTime?> = TeamMenuAuthList.TEAM_MENU_AUTH_LIST.UPDATE_DT
    override fun field5(): Field<Int?> = TeamMenuAuthList.TEAM_MENU_AUTH_LIST.SUB_MENU_ID
    override fun component1(): Int? = id
    override fun component2(): String? = userGrpCd
    override fun component3(): LocalDateTime? = createDt
    override fun component4(): LocalDateTime? = updateDt
    override fun component5(): Int? = subMenuId
    override fun value1(): Int? = id
    override fun value2(): String? = userGrpCd
    override fun value3(): LocalDateTime? = createDt
    override fun value4(): LocalDateTime? = updateDt
    override fun value5(): Int? = subMenuId

    override fun value1(value: Int?): TeamMenuAuthListRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): TeamMenuAuthListRecord {
        this.userGrpCd = value
        return this
    }

    override fun value3(value: LocalDateTime?): TeamMenuAuthListRecord {
        this.createDt = value
        return this
    }

    override fun value4(value: LocalDateTime?): TeamMenuAuthListRecord {
        this.updateDt = value
        return this
    }

    override fun value5(value: Int?): TeamMenuAuthListRecord {
        this.subMenuId = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: LocalDateTime?, value4: LocalDateTime?, value5: Int?): TeamMenuAuthListRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        return this
    }

    /**
     * Create a detached, initialised TeamMenuAuthListRecord
     */
    constructor(id: Int? = null, userGrpCd: String? = null, createDt: LocalDateTime? = null, updateDt: LocalDateTime? = null, subMenuId: Int? = null): this() {
        this.id = id
        this.userGrpCd = userGrpCd
        this.createDt = createDt
        this.updateDt = updateDt
        this.subMenuId = subMenuId
    }
}
