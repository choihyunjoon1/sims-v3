/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_A
import co.spoonradio.sims.repository.mysql.tables.records.ExternalLinkLogRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row8
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
open class ExternalLinkLog(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, ExternalLinkLogRecord>?,
    aliased: Table<ExternalLinkLogRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<ExternalLinkLogRecord>(
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
         * The reference instance of <code>external_link_log</code>
         */
        val EXTERNAL_LINK_LOG = ExternalLinkLog()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ExternalLinkLogRecord> = ExternalLinkLogRecord::class.java

    /**
     * The column <code>external_link_log.external_link_log_id</code>.
     */
    val EXTERNAL_LINK_LOG_ID: TableField<ExternalLinkLogRecord, Int?> = createField(DSL.name("external_link_log_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>external_link_log.billing_id</code>.
     */
    val BILLING_ID: TableField<ExternalLinkLogRecord, Int?> = createField(DSL.name("billing_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>external_link_log.external_link_type_cd</code>.
     */
    val EXTERNAL_LINK_TYPE_CD: TableField<ExternalLinkLogRecord, String?> = createField(DSL.name("external_link_type_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>external_link_log.external_link_detail</code>.
     */
    val EXTERNAL_LINK_DETAIL: TableField<ExternalLinkLogRecord, String?> = createField(DSL.name("external_link_detail"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>external_link_log.external_link_parameter</code>.
     */
    val EXTERNAL_LINK_PARAMETER: TableField<ExternalLinkLogRecord, String?> = createField(DSL.name("external_link_parameter"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>external_link_log.result_cd</code>.
     */
    val RESULT_CD: TableField<ExternalLinkLogRecord, Int?> = createField(DSL.name("result_cd"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>external_link_log.external_link_response</code>.
     */
    val EXTERNAL_LINK_RESPONSE: TableField<ExternalLinkLogRecord, String?> = createField(DSL.name("external_link_response"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>external_link_log.create_dt</code>.
     */
    val CREATE_DT: TableField<ExternalLinkLogRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<ExternalLinkLogRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<ExternalLinkLogRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>external_link_log</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>external_link_log</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>external_link_log</code> table reference
     */
    constructor(): this(DSL.name("external_link_log"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, ExternalLinkLogRecord>): this(Internal.createPathAlias(child, key), child, key, EXTERNAL_LINK_LOG, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<ExternalLinkLogRecord, Int?> = super.getIdentity() as Identity<ExternalLinkLogRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<ExternalLinkLogRecord> = CONSTRAINT_A
    override fun getKeys(): List<UniqueKey<ExternalLinkLogRecord>> = listOf(CONSTRAINT_A)
    override fun `as`(alias: String): ExternalLinkLog = ExternalLinkLog(DSL.name(alias), this)
    override fun `as`(alias: Name): ExternalLinkLog = ExternalLinkLog(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ExternalLinkLog = ExternalLinkLog(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ExternalLinkLog = ExternalLinkLog(name, null)

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row8<Int?, Int?, String?, String?, String?, Int?, String?, LocalDateTime?> = super.fieldsRow() as Row8<Int?, Int?, String?, String?, String?, Int?, String?, LocalDateTime?>
}