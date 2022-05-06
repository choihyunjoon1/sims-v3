/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.REPORTS_LIVEMESSAGEREPORT_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.ReportsLivemessagereportRecord

import java.time.LocalDate

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row10
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
open class ReportsLivemessagereport(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, ReportsLivemessagereportRecord>?,
    aliased: Table<ReportsLivemessagereportRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<ReportsLivemessagereportRecord>(
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
         * The reference instance of <code>reports_livemessagereport</code>
         */
        val REPORTS_LIVEMESSAGEREPORT = ReportsLivemessagereport()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ReportsLivemessagereportRecord> = ReportsLivemessagereportRecord::class.java

    /**
     * The column <code>reports_livemessagereport.id</code>.
     */
    val ID: TableField<ReportsLivemessagereportRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>reports_livemessagereport.reporter</code>.
     */
    val REPORTER: TableField<ReportsLivemessagereportRecord, String?> = createField(DSL.name("reporter"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.reported</code>.
     */
    val REPORTED: TableField<ReportsLivemessagereportRecord, LocalDate?> = createField(DSL.name("reported"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.live</code>.
     */
    val LIVE: TableField<ReportsLivemessagereportRecord, String?> = createField(DSL.name("live"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.live_author</code>.
     */
    val LIVE_AUTHOR: TableField<ReportsLivemessagereportRecord, String?> = createField(DSL.name("live_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.live_created</code>.
     */
    val LIVE_CREATED: TableField<ReportsLivemessagereportRecord, LocalDate?> = createField(DSL.name("live_created"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.message_author</code>.
     */
    val MESSAGE_AUTHOR: TableField<ReportsLivemessagereportRecord, String?> = createField(DSL.name("message_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.message_contents</code>.
     */
    val MESSAGE_CONTENTS: TableField<ReportsLivemessagereportRecord, String?> = createField(DSL.name("message_contents"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_livemessagereport.report_descr</code>.
     */
    val REPORT_DESCR: TableField<ReportsLivemessagereportRecord, String?> = createField(DSL.name("report_descr"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>reports_livemessagereport.report_type</code>.
     */
    val REPORT_TYPE: TableField<ReportsLivemessagereportRecord, Int?> = createField(DSL.name("report_type"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<ReportsLivemessagereportRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<ReportsLivemessagereportRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>reports_livemessagereport</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>reports_livemessagereport</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>reports_livemessagereport</code> table reference
     */
    constructor(): this(DSL.name("reports_livemessagereport"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, ReportsLivemessagereportRecord>): this(Internal.createPathAlias(child, key), child, key, REPORTS_LIVEMESSAGEREPORT, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<ReportsLivemessagereportRecord, Int?> = super.getIdentity() as Identity<ReportsLivemessagereportRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<ReportsLivemessagereportRecord> = REPORTS_LIVEMESSAGEREPORT_PKEY
    override fun getKeys(): List<UniqueKey<ReportsLivemessagereportRecord>> = listOf(REPORTS_LIVEMESSAGEREPORT_PKEY)
    override fun `as`(alias: String): ReportsLivemessagereport = ReportsLivemessagereport(DSL.name(alias), this)
    override fun `as`(alias: Name): ReportsLivemessagereport = ReportsLivemessagereport(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ReportsLivemessagereport = ReportsLivemessagereport(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ReportsLivemessagereport = ReportsLivemessagereport(name, null)

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row10<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, String?, Int?> = super.fieldsRow() as Row10<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, String?, Int?>
}