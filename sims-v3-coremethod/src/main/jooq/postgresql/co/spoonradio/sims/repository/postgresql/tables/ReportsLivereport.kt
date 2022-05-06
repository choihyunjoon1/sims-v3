/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.REPORTS_LIVEREPORT_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.ReportsLivereportRecord

import java.time.LocalDate

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row9
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
open class ReportsLivereport(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, ReportsLivereportRecord>?,
    aliased: Table<ReportsLivereportRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<ReportsLivereportRecord>(
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
         * The reference instance of <code>reports_livereport</code>
         */
        val REPORTS_LIVEREPORT = ReportsLivereport()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ReportsLivereportRecord> = ReportsLivereportRecord::class.java

    /**
     * The column <code>reports_livereport.id</code>.
     */
    val ID: TableField<ReportsLivereportRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>reports_livereport.report_type</code>.
     */
    val REPORT_TYPE: TableField<ReportsLivereportRecord, Int?> = createField(DSL.name("report_type"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>reports_livereport.report_descr</code>.
     */
    val REPORT_DESCR: TableField<ReportsLivereportRecord, String?> = createField(DSL.name("report_descr"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>reports_livereport.reporter</code>.
     */
    val REPORTER: TableField<ReportsLivereportRecord, String?> = createField(DSL.name("reporter"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livereport.reported</code>.
     */
    val REPORTED: TableField<ReportsLivereportRecord, LocalDate?> = createField(DSL.name("reported"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_livereport.live</code>.
     */
    val LIVE: TableField<ReportsLivereportRecord, String?> = createField(DSL.name("live"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livereport.live_author</code>.
     */
    val LIVE_AUTHOR: TableField<ReportsLivereportRecord, String?> = createField(DSL.name("live_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livereport.live_stream_name</code>.
     */
    val LIVE_STREAM_NAME: TableField<ReportsLivereportRecord, String?> = createField(DSL.name("live_stream_name"), SQLDataType.VARCHAR(20).nullable(false), this, "")

    /**
     * The column <code>reports_livereport.live_created</code>.
     */
    val LIVE_CREATED: TableField<ReportsLivereportRecord, LocalDate?> = createField(DSL.name("live_created"), SQLDataType.LOCALDATE.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<ReportsLivereportRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<ReportsLivereportRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>reports_livereport</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>reports_livereport</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>reports_livereport</code> table reference
     */
    constructor(): this(DSL.name("reports_livereport"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, ReportsLivereportRecord>): this(Internal.createPathAlias(child, key), child, key, REPORTS_LIVEREPORT, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<ReportsLivereportRecord, Int?> = super.getIdentity() as Identity<ReportsLivereportRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<ReportsLivereportRecord> = REPORTS_LIVEREPORT_PKEY
    override fun getKeys(): List<UniqueKey<ReportsLivereportRecord>> = listOf(REPORTS_LIVEREPORT_PKEY)
    override fun `as`(alias: String): ReportsLivereport = ReportsLivereport(DSL.name(alias), this)
    override fun `as`(alias: Name): ReportsLivereport = ReportsLivereport(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ReportsLivereport = ReportsLivereport(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ReportsLivereport = ReportsLivereport(name, null)

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row9<Int?, Int?, String?, String?, LocalDate?, String?, String?, String?, LocalDate?> = super.fieldsRow() as Row9<Int?, Int?, String?, String?, LocalDate?, String?, String?, String?, LocalDate?>
}
