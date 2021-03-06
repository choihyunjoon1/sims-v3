/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_F
import co.spoonradio.sims.repository.mysql.tables.records.BatchManageRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row6
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class BatchManage(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, BatchManageRecord>?,
    aliased: Table<BatchManageRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<BatchManageRecord>(
    alias,
    DefaultSchema.DEFAULT_SCHEMA,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>batch_manage</code>
         */
        val BATCH_MANAGE = BatchManage()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<BatchManageRecord> = BatchManageRecord::class.java

    /**
     * The column <code>batch_manage.batch_manage_id</code>.
     */
    val BATCH_MANAGE_ID: TableField<BatchManageRecord, Int?> = createField(DSL.name("batch_manage_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>batch_manage.batch_type_cd</code>.
     */
    val BATCH_TYPE_CD: TableField<BatchManageRecord, String?> = createField(DSL.name("batch_type_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>batch_manage.batch_description</code>.
     */
    val BATCH_DESCRIPTION: TableField<BatchManageRecord, String?> = createField(DSL.name("batch_description"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>batch_manage.is_run</code>.
     */
    val IS_RUN: TableField<BatchManageRecord, Byte?> = createField(DSL.name("is_run"), SQLDataType.TINYINT.nullable(false), this, "")

    /**
     * The column <code>batch_manage.update_dt</code>.
     */
    val UPDATE_DT: TableField<BatchManageRecord, LocalDateTime?> = createField(DSL.name("update_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>batch_manage.create_dt</code>.
     */
    val CREATE_DT: TableField<BatchManageRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<BatchManageRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<BatchManageRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>batch_manage</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>batch_manage</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>batch_manage</code> table reference
     */
    constructor(): this(DSL.name("batch_manage"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, BatchManageRecord>): this(Internal.createPathAlias(child, key), child, key, BATCH_MANAGE, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<BatchManageRecord, Int?> = super.getIdentity() as Identity<BatchManageRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<BatchManageRecord> = CONSTRAINT_F
    override fun getKeys(): List<UniqueKey<BatchManageRecord>> = listOf(CONSTRAINT_F)
    override fun `as`(alias: String): BatchManage = BatchManage(DSL.name(alias), this)
    override fun `as`(alias: Name): BatchManage = BatchManage(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): BatchManage = BatchManage(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): BatchManage = BatchManage(name, null)

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row6<Int?, String?, String?, Byte?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row6<Int?, String?, String?, Byte?, LocalDateTime?, LocalDateTime?>
}
