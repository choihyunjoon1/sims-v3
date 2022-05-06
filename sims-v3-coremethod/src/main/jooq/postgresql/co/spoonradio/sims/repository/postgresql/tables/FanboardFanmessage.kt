/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.FANBOARD_FANMESSAGE_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.FanboardFanmessageRecord

import java.time.OffsetDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row5
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
open class FanboardFanmessage(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, FanboardFanmessageRecord>?,
    aliased: Table<FanboardFanmessageRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<FanboardFanmessageRecord>(
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
         * The reference instance of <code>fanboard_fanmessage</code>
         */
        val FANBOARD_FANMESSAGE = FanboardFanmessage()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<FanboardFanmessageRecord> = FanboardFanmessageRecord::class.java

    /**
     * The column <code>fanboard_fanmessage.id</code>.
     */
    val ID: TableField<FanboardFanmessageRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>fanboard_fanmessage.contents</code>.
     */
    val CONTENTS: TableField<FanboardFanmessageRecord, String?> = createField(DSL.name("contents"), SQLDataType.VARCHAR(2048).nullable(false), this, "")

    /**
     * The column <code>fanboard_fanmessage.created</code>.
     */
    val CREATED: TableField<FanboardFanmessageRecord, OffsetDateTime?> = createField(DSL.name("created"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>fanboard_fanmessage.author_id</code>.
     */
    val AUTHOR_ID: TableField<FanboardFanmessageRecord, Int?> = createField(DSL.name("author_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>fanboard_fanmessage.comment_id</code>.
     */
    val COMMENT_ID: TableField<FanboardFanmessageRecord, Int?> = createField(DSL.name("comment_id"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<FanboardFanmessageRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<FanboardFanmessageRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>fanboard_fanmessage</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>fanboard_fanmessage</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>fanboard_fanmessage</code> table reference
     */
    constructor(): this(DSL.name("fanboard_fanmessage"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, FanboardFanmessageRecord>): this(Internal.createPathAlias(child, key), child, key, FANBOARD_FANMESSAGE, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<FanboardFanmessageRecord, Int?> = super.getIdentity() as Identity<FanboardFanmessageRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<FanboardFanmessageRecord> = FANBOARD_FANMESSAGE_PKEY
    override fun getKeys(): List<UniqueKey<FanboardFanmessageRecord>> = listOf(FANBOARD_FANMESSAGE_PKEY)
    override fun `as`(alias: String): FanboardFanmessage = FanboardFanmessage(DSL.name(alias), this)
    override fun `as`(alias: Name): FanboardFanmessage = FanboardFanmessage(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): FanboardFanmessage = FanboardFanmessage(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): FanboardFanmessage = FanboardFanmessage(name, null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Int?, String?, OffsetDateTime?, Int?, Int?> = super.fieldsRow() as Row5<Int?, String?, OffsetDateTime?, Int?, Int?>
}