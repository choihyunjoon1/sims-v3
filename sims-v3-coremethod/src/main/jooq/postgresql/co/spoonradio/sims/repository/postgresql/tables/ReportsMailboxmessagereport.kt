/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.PK_REPORTS_MAILBOXMESSAGEREPORT_ID
import co.spoonradio.sims.repository.postgresql.tables.records.ReportsMailboxmessagereportRecord

import java.time.LocalDate

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row11
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
open class ReportsMailboxmessagereport(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, ReportsMailboxmessagereportRecord>?,
    aliased: Table<ReportsMailboxmessagereportRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<ReportsMailboxmessagereportRecord>(
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
         * The reference instance of <code>reports_mailboxmessagereport</code>
         */
        val REPORTS_MAILBOXMESSAGEREPORT = ReportsMailboxmessagereport()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ReportsMailboxmessagereportRecord> = ReportsMailboxmessagereportRecord::class.java

    /**
     * The column <code>reports_mailboxmessagereport.id</code>.
     */
    val ID: TableField<ReportsMailboxmessagereportRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.report_type</code>.
     */
    val REPORT_TYPE: TableField<ReportsMailboxmessagereportRecord, Int?> = createField(DSL.name("report_type"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.report_descr</code>.
     */
    val REPORT_DESCR: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("report_descr"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.reporter</code>.
     */
    val REPORTER: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("reporter"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.reported</code>.
     */
    val REPORTED: TableField<ReportsMailboxmessagereportRecord, LocalDate?> = createField(DSL.name("reported"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.mailbox</code>.
     */
    val MAILBOX: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("mailbox"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.live</code>.
     */
    val LIVE: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("live"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.live_author</code>.
     */
    val LIVE_AUTHOR: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("live_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.live_created</code>.
     */
    val LIVE_CREATED: TableField<ReportsMailboxmessagereportRecord, LocalDate?> = createField(DSL.name("live_created"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.message_author</code>.
     */
    val MESSAGE_AUTHOR: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("message_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_mailboxmessagereport.message_contents</code>.
     */
    val MESSAGE_CONTENTS: TableField<ReportsMailboxmessagereportRecord, String?> = createField(DSL.name("message_contents"), SQLDataType.VARCHAR(1024).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<ReportsMailboxmessagereportRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<ReportsMailboxmessagereportRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>reports_mailboxmessagereport</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>reports_mailboxmessagereport</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>reports_mailboxmessagereport</code> table reference
     */
    constructor(): this(DSL.name("reports_mailboxmessagereport"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, ReportsMailboxmessagereportRecord>): this(Internal.createPathAlias(child, key), child, key, REPORTS_MAILBOXMESSAGEREPORT, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<ReportsMailboxmessagereportRecord, Int?> = super.getIdentity() as Identity<ReportsMailboxmessagereportRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<ReportsMailboxmessagereportRecord> = PK_REPORTS_MAILBOXMESSAGEREPORT_ID
    override fun getKeys(): List<UniqueKey<ReportsMailboxmessagereportRecord>> = listOf(PK_REPORTS_MAILBOXMESSAGEREPORT_ID)
    override fun `as`(alias: String): ReportsMailboxmessagereport = ReportsMailboxmessagereport(DSL.name(alias), this)
    override fun `as`(alias: Name): ReportsMailboxmessagereport = ReportsMailboxmessagereport(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ReportsMailboxmessagereport = ReportsMailboxmessagereport(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ReportsMailboxmessagereport = ReportsMailboxmessagereport(name, null)

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row11<Int?, Int?, String?, String?, LocalDate?, String?, String?, String?, LocalDate?, String?, String?> = super.fieldsRow() as Row11<Int?, Int?, String?, String?, LocalDate?, String?, String?, String?, LocalDate?, String?, String?>
}
