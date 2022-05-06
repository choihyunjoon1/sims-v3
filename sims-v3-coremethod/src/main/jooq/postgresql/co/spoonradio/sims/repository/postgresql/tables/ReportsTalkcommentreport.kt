/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.REPORTS_TALKCOMMENTREPORT_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.ReportsTalkcommentreportRecord

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
open class ReportsTalkcommentreport(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, ReportsTalkcommentreportRecord>?,
    aliased: Table<ReportsTalkcommentreportRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<ReportsTalkcommentreportRecord>(
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
         * The reference instance of <code>reports_talkcommentreport</code>
         */
        val REPORTS_TALKCOMMENTREPORT = ReportsTalkcommentreport()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ReportsTalkcommentreportRecord> = ReportsTalkcommentreportRecord::class.java

    /**
     * The column <code>reports_talkcommentreport.id</code>.
     */
    val ID: TableField<ReportsTalkcommentreportRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>reports_talkcommentreport.reporter</code>.
     */
    val REPORTER: TableField<ReportsTalkcommentreportRecord, String?> = createField(DSL.name("reporter"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.reported</code>.
     */
    val REPORTED: TableField<ReportsTalkcommentreportRecord, LocalDate?> = createField(DSL.name("reported"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.talk</code>.
     */
    val TALK: TableField<ReportsTalkcommentreportRecord, String?> = createField(DSL.name("talk"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.talk_author</code>.
     */
    val TALK_AUTHOR: TableField<ReportsTalkcommentreportRecord, String?> = createField(DSL.name("talk_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.talk_created</code>.
     */
    val TALK_CREATED: TableField<ReportsTalkcommentreportRecord, LocalDate?> = createField(DSL.name("talk_created"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.comment_author</code>.
     */
    val COMMENT_AUTHOR: TableField<ReportsTalkcommentreportRecord, String?> = createField(DSL.name("comment_author"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.comment_url</code>.
     */
    val COMMENT_URL: TableField<ReportsTalkcommentreportRecord, String?> = createField(DSL.name("comment_url"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.comment_created</code>.
     */
    val COMMENT_CREATED: TableField<ReportsTalkcommentreportRecord, LocalDate?> = createField(DSL.name("comment_created"), SQLDataType.LOCALDATE.nullable(false), this, "")

    /**
     * The column <code>reports_talkcommentreport.report_descr</code>.
     */
    val REPORT_DESCR: TableField<ReportsTalkcommentreportRecord, String?> = createField(DSL.name("report_descr"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>reports_talkcommentreport.report_type</code>.
     */
    val REPORT_TYPE: TableField<ReportsTalkcommentreportRecord, Int?> = createField(DSL.name("report_type"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<ReportsTalkcommentreportRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<ReportsTalkcommentreportRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>reports_talkcommentreport</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>reports_talkcommentreport</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>reports_talkcommentreport</code> table reference
     */
    constructor(): this(DSL.name("reports_talkcommentreport"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, ReportsTalkcommentreportRecord>): this(Internal.createPathAlias(child, key), child, key, REPORTS_TALKCOMMENTREPORT, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<ReportsTalkcommentreportRecord, Int?> = super.getIdentity() as Identity<ReportsTalkcommentreportRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<ReportsTalkcommentreportRecord> = REPORTS_TALKCOMMENTREPORT_PKEY
    override fun getKeys(): List<UniqueKey<ReportsTalkcommentreportRecord>> = listOf(REPORTS_TALKCOMMENTREPORT_PKEY)
    override fun `as`(alias: String): ReportsTalkcommentreport = ReportsTalkcommentreport(DSL.name(alias), this)
    override fun `as`(alias: Name): ReportsTalkcommentreport = ReportsTalkcommentreport(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ReportsTalkcommentreport = ReportsTalkcommentreport(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ReportsTalkcommentreport = ReportsTalkcommentreport(name, null)

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?> = super.fieldsRow() as Row11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?>
}
