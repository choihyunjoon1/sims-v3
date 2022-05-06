/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables


import co.spoonradio.sims.repository.billing.DefaultSchema
import co.spoonradio.sims.repository.billing.keys.PK_PROMOTIONHISTORY_ID
import co.spoonradio.sims.repository.billing.tables.records.TbpromotionhistoryRecord

import java.time.LocalDateTime

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
open class Tbpromotionhistory(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TbpromotionhistoryRecord>?,
    aliased: Table<TbpromotionhistoryRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TbpromotionhistoryRecord>(
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
         * The reference instance of <code>tbPromotionHistory</code>
         */
        val TBPROMOTIONHISTORY = Tbpromotionhistory()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TbpromotionhistoryRecord> = TbpromotionhistoryRecord::class.java

    /**
     * The column <code>tbPromotionHistory.id</code>.
     */
    val ID: TableField<TbpromotionhistoryRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>tbPromotionHistory.promotionId</code>.
     */
    val PROMOTIONID: TableField<TbpromotionhistoryRecord, Int?> = createField(DSL.name("promotionId"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>tbPromotionHistory.orderId</code>.
     */
    val ORDERID: TableField<TbpromotionhistoryRecord, String?> = createField(DSL.name("orderId"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>tbPromotionHistory.txId</code>.
     */
    val TXID: TableField<TbpromotionhistoryRecord, String?> = createField(DSL.name("txId"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>tbPromotionHistory.createdDate</code>.
     */
    val CREATEDDATE: TableField<TbpromotionhistoryRecord, LocalDateTime?> = createField(DSL.name("createdDate"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    private constructor(alias: Name, aliased: Table<TbpromotionhistoryRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TbpromotionhistoryRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>tbPromotionHistory</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>tbPromotionHistory</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>tbPromotionHistory</code> table reference
     */
    constructor(): this(DSL.name("tbPromotionHistory"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TbpromotionhistoryRecord>): this(Internal.createPathAlias(child, key), child, key, TBPROMOTIONHISTORY, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TbpromotionhistoryRecord, Long?> = super.getIdentity() as Identity<TbpromotionhistoryRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<TbpromotionhistoryRecord> = PK_PROMOTIONHISTORY_ID
    override fun getKeys(): List<UniqueKey<TbpromotionhistoryRecord>> = listOf(PK_PROMOTIONHISTORY_ID)
    override fun `as`(alias: String): Tbpromotionhistory = Tbpromotionhistory(DSL.name(alias), this)
    override fun `as`(alias: Name): Tbpromotionhistory = Tbpromotionhistory(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Tbpromotionhistory = Tbpromotionhistory(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Tbpromotionhistory = Tbpromotionhistory(name, null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Long?, Int?, String?, String?, LocalDateTime?> = super.fieldsRow() as Row5<Long?, Int?, String?, String?, LocalDateTime?>
}
