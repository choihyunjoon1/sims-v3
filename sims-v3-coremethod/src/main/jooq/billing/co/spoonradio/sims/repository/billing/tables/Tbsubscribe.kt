/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables


import co.spoonradio.sims.repository.billing.DefaultSchema
import co.spoonradio.sims.repository.billing.keys.PK_SUBSCRIBE_ID
import co.spoonradio.sims.repository.billing.keys.UIDX_ORIGINAL_TRANSACTION_ID
import co.spoonradio.sims.repository.billing.tables.records.TbsubscribeRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row13
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
open class Tbsubscribe(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TbsubscribeRecord>?,
    aliased: Table<TbsubscribeRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TbsubscribeRecord>(
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
         * The reference instance of <code>tbSubscribe</code>
         */
        val TBSUBSCRIBE = Tbsubscribe()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TbsubscribeRecord> = TbsubscribeRecord::class.java

    /**
     * The column <code>tbSubscribe.id</code>.
     */
    val ID: TableField<TbsubscribeRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>tbSubscribe.originalTransactionId</code>.
     */
    val ORIGINALTRANSACTIONID: TableField<TbsubscribeRecord, String?> = createField(DSL.name("originalTransactionId"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.status</code>.
     */
    val STATUS: TableField<TbsubscribeRecord, Byte?> = createField(DSL.name("status"), SQLDataType.TINYINT.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.productId</code>.
     */
    val PRODUCTID: TableField<TbsubscribeRecord, Int?> = createField(DSL.name("productId"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.userId</code>.
     */
    val USERID: TableField<TbsubscribeRecord, Int?> = createField(DSL.name("userId"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.price</code>.
     */
    val PRICE: TableField<TbsubscribeRecord, Int?> = createField(DSL.name("price"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.spoonAmount</code>.
     */
    val SPOONAMOUNT: TableField<TbsubscribeRecord, Int?> = createField(DSL.name("spoonAmount"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.platform</code>.
     */
    val PLATFORM: TableField<TbsubscribeRecord, Byte?> = createField(DSL.name("platform"), SQLDataType.TINYINT.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.isAutoRenew</code>.
     */
    val ISAUTORENEW: TableField<TbsubscribeRecord, Boolean?> = createField(DSL.name("isAutoRenew"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.createdDate</code>.
     */
    val CREATEDDATE: TableField<TbsubscribeRecord, LocalDateTime?> = createField(DSL.name("createdDate"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbSubscribe.updatedDate</code>.
     */
    val UPDATEDDATE: TableField<TbsubscribeRecord, LocalDateTime?> = createField(DSL.name("updatedDate"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>tbSubscribe.startDate</code>.
     */
    val STARTDATE: TableField<TbsubscribeRecord, LocalDateTime?> = createField(DSL.name("startDate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>tbSubscribe.expireDate</code>.
     */
    val EXPIREDATE: TableField<TbsubscribeRecord, LocalDateTime?> = createField(DSL.name("expireDate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<TbsubscribeRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TbsubscribeRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>tbSubscribe</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>tbSubscribe</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>tbSubscribe</code> table reference
     */
    constructor(): this(DSL.name("tbSubscribe"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TbsubscribeRecord>): this(Internal.createPathAlias(child, key), child, key, TBSUBSCRIBE, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TbsubscribeRecord, Int?> = super.getIdentity() as Identity<TbsubscribeRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<TbsubscribeRecord> = PK_SUBSCRIBE_ID
    override fun getKeys(): List<UniqueKey<TbsubscribeRecord>> = listOf(PK_SUBSCRIBE_ID, UIDX_ORIGINAL_TRANSACTION_ID)
    override fun `as`(alias: String): Tbsubscribe = Tbsubscribe(DSL.name(alias), this)
    override fun `as`(alias: Name): Tbsubscribe = Tbsubscribe(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Tbsubscribe = Tbsubscribe(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Tbsubscribe = Tbsubscribe(name, null)

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row13<Int?, String?, Byte?, Int?, Int?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row13<Int?, String?, Byte?, Int?, Int?, Int?, Int?, Byte?, Boolean?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?>
}
