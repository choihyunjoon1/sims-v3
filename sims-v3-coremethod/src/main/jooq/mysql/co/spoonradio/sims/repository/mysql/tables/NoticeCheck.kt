/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_1
import co.spoonradio.sims.repository.mysql.tables.records.NoticeCheckRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row4
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
open class NoticeCheck(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, NoticeCheckRecord>?,
    aliased: Table<NoticeCheckRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<NoticeCheckRecord>(
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
         * The reference instance of <code>notice_check</code>
         */
        val NOTICE_CHECK = NoticeCheck()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<NoticeCheckRecord> = NoticeCheckRecord::class.java

    /**
     * The column <code>notice_check.notice_check_id</code>.
     */
    val NOTICE_CHECK_ID: TableField<NoticeCheckRecord, Int?> = createField(DSL.name("notice_check_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>notice_check.user_id</code>.
     */
    val USER_ID: TableField<NoticeCheckRecord, Int?> = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>notice_check.create_dt</code>.
     */
    val CREATE_DT: TableField<NoticeCheckRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>notice_check.notice_id</code>.
     */
    val NOTICE_ID: TableField<NoticeCheckRecord, Int?> = createField(DSL.name("notice_id"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<NoticeCheckRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<NoticeCheckRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>notice_check</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>notice_check</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>notice_check</code> table reference
     */
    constructor(): this(DSL.name("notice_check"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, NoticeCheckRecord>): this(Internal.createPathAlias(child, key), child, key, NOTICE_CHECK, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<NoticeCheckRecord, Int?> = super.getIdentity() as Identity<NoticeCheckRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<NoticeCheckRecord> = CONSTRAINT_1
    override fun getKeys(): List<UniqueKey<NoticeCheckRecord>> = listOf(CONSTRAINT_1)
    override fun `as`(alias: String): NoticeCheck = NoticeCheck(DSL.name(alias), this)
    override fun `as`(alias: Name): NoticeCheck = NoticeCheck(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): NoticeCheck = NoticeCheck(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): NoticeCheck = NoticeCheck(name, null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<Int?, Int?, LocalDateTime?, Int?> = super.fieldsRow() as Row4<Int?, Int?, LocalDateTime?, Int?>
}
