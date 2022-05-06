/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables


import co.spoonradio.sims.repository.billing.DefaultSchema
import co.spoonradio.sims.repository.billing.keys.PK_EXCHANGEREJECTREASON_ID
import co.spoonradio.sims.repository.billing.tables.records.TbexchangerejectreasonRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row7
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
open class Tbexchangerejectreason(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TbexchangerejectreasonRecord>?,
    aliased: Table<TbexchangerejectreasonRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TbexchangerejectreasonRecord>(
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
         * The reference instance of <code>tbExchangeRejectReason</code>
         */
        val TBEXCHANGEREJECTREASON = Tbexchangerejectreason()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TbexchangerejectreasonRecord> = TbexchangerejectreasonRecord::class.java

    /**
     * The column <code>tbExchangeRejectReason.id</code>.
     */
    val ID: TableField<TbexchangerejectreasonRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>tbExchangeRejectReason.exchangeId</code>.
     */
    val EXCHANGEID: TableField<TbexchangerejectreasonRecord, Long?> = createField(DSL.name("exchangeId"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>tbExchangeRejectReason.reason</code>.
     */
    val REASON: TableField<TbexchangerejectreasonRecord, String?> = createField(DSL.name("reason"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>tbExchangeRejectReason.created</code>.
     */
    val CREATED: TableField<TbexchangerejectreasonRecord, LocalDateTime?> = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(3).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP(3)", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbExchangeRejectReason.creator</code>.
     */
    val CREATOR: TableField<TbexchangerejectreasonRecord, Long?> = createField(DSL.name("creator"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>tbExchangeRejectReason.updated</code>.
     */
    val UPDATED: TableField<TbexchangerejectreasonRecord, LocalDateTime?> = createField(DSL.name("updated"), SQLDataType.LOCALDATETIME(3).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP(3)", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbExchangeRejectReason.updater</code>.
     */
    val UPDATER: TableField<TbexchangerejectreasonRecord, Long?> = createField(DSL.name("updater"), SQLDataType.BIGINT.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<TbexchangerejectreasonRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TbexchangerejectreasonRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>tbExchangeRejectReason</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>tbExchangeRejectReason</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>tbExchangeRejectReason</code> table reference
     */
    constructor(): this(DSL.name("tbExchangeRejectReason"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TbexchangerejectreasonRecord>): this(Internal.createPathAlias(child, key), child, key, TBEXCHANGEREJECTREASON, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TbexchangerejectreasonRecord, Long?> = super.getIdentity() as Identity<TbexchangerejectreasonRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<TbexchangerejectreasonRecord> = PK_EXCHANGEREJECTREASON_ID
    override fun getKeys(): List<UniqueKey<TbexchangerejectreasonRecord>> = listOf(PK_EXCHANGEREJECTREASON_ID)
    override fun `as`(alias: String): Tbexchangerejectreason = Tbexchangerejectreason(DSL.name(alias), this)
    override fun `as`(alias: Name): Tbexchangerejectreason = Tbexchangerejectreason(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Tbexchangerejectreason = Tbexchangerejectreason(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Tbexchangerejectreason = Tbexchangerejectreason(name, null)

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?> = super.fieldsRow() as Row7<Long?, Long?, String?, LocalDateTime?, Long?, LocalDateTime?, Long?>
}