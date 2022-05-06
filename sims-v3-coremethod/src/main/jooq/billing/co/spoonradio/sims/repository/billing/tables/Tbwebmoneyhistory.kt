/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables


import co.spoonradio.sims.repository.billing.DefaultSchema
import co.spoonradio.sims.repository.billing.keys.PK_WEBMONEY_HISTORY_ID
import co.spoonradio.sims.repository.billing.keys.UIDX_ORDER_CODE
import co.spoonradio.sims.repository.billing.tables.records.TbwebmoneyhistoryRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row20
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
open class Tbwebmoneyhistory(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TbwebmoneyhistoryRecord>?,
    aliased: Table<TbwebmoneyhistoryRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TbwebmoneyhistoryRecord>(
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
         * The reference instance of <code>tbWebMoneyHistory</code>
         */
        val TBWEBMONEYHISTORY = Tbwebmoneyhistory()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TbwebmoneyhistoryRecord> = TbwebmoneyhistoryRecord::class.java

    /**
     * The column <code>tbWebMoneyHistory.id</code>.
     */
    val ID: TableField<TbwebmoneyhistoryRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>tbWebMoneyHistory.txId</code>.
     */
    val TXID: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("txId"), SQLDataType.VARCHAR(64).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.quantity</code>.
     */
    val QUANTITY: TableField<TbwebmoneyhistoryRecord, Int?> = createField(DSL.name("quantity"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.status</code>.
     */
    val STATUS: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("status"), SQLDataType.VARCHAR(10).nullable(false), this, "")

    /**
     * The column <code>tbWebMoneyHistory.userAgent</code>.
     */
    val USERAGENT: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("userAgent"), SQLDataType.VARCHAR(32).nullable(false), this, "")

    /**
     * The column <code>tbWebMoneyHistory.updated</code>.
     */
    val UPDATED: TableField<TbwebmoneyhistoryRecord, LocalDateTime?> = createField(DSL.name("updated"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.completed</code>.
     */
    val COMPLETED: TableField<TbwebmoneyhistoryRecord, LocalDateTime?> = createField(DSL.name("completed"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.created</code>.
     */
    val CREATED: TableField<TbwebmoneyhistoryRecord, LocalDateTime?> = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.amount</code>.
     */
    val AMOUNT: TableField<TbwebmoneyhistoryRecord, Int?> = createField(DSL.name("amount"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbWebMoneyHistory.itemCode</code>.
     */
    val ITEMCODE: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("itemCode"), SQLDataType.VARCHAR(25).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.itemName</code>.
     */
    val ITEMNAME: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("itemName"), SQLDataType.VARCHAR(80).nullable(false), this, "")

    /**
     * The column <code>tbWebMoneyHistory.orderCode</code>.
     */
    val ORDERCODE: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("orderCode"), SQLDataType.VARCHAR(128).nullable(false), this, "")

    /**
     * The column <code>tbWebMoneyHistory.settlementVersion</code>.
     */
    val SETTLEMENTVERSION: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("settlementVersion"), SQLDataType.VARCHAR(3).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.settlementCode</code>.
     */
    val SETTLEMENTCODE: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("settlementCode"), SQLDataType.VARCHAR(25).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.settlementDate</code>.
     */
    val SETTLEMENTDATE: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("settlementDate"), SQLDataType.VARCHAR(14).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.serialNumber</code>.
     */
    val SERIALNUMBER: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("serialNumber"), SQLDataType.VARCHAR(26).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.errorMessage</code>.
     */
    val ERRORMESSAGE: TableField<TbwebmoneyhistoryRecord, String?> = createField(DSL.name("errorMessage"), SQLDataType.VARCHAR(126).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.productId</code>.
     */
    val PRODUCTID: TableField<TbwebmoneyhistoryRecord, Int?> = createField(DSL.name("productId"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.promotionId</code>.
     */
    val PROMOTIONID: TableField<TbwebmoneyhistoryRecord, Long?> = createField(DSL.name("promotionId"), SQLDataType.BIGINT.defaultValue(DSL.field("NULL", SQLDataType.BIGINT)), this, "")

    /**
     * The column <code>tbWebMoneyHistory.userId</code>.
     */
    val USERID: TableField<TbwebmoneyhistoryRecord, Int?> = createField(DSL.name("userId"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    private constructor(alias: Name, aliased: Table<TbwebmoneyhistoryRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TbwebmoneyhistoryRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>tbWebMoneyHistory</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>tbWebMoneyHistory</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>tbWebMoneyHistory</code> table reference
     */
    constructor(): this(DSL.name("tbWebMoneyHistory"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TbwebmoneyhistoryRecord>): this(Internal.createPathAlias(child, key), child, key, TBWEBMONEYHISTORY, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TbwebmoneyhistoryRecord, Int?> = super.getIdentity() as Identity<TbwebmoneyhistoryRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<TbwebmoneyhistoryRecord> = PK_WEBMONEY_HISTORY_ID
    override fun getKeys(): List<UniqueKey<TbwebmoneyhistoryRecord>> = listOf(PK_WEBMONEY_HISTORY_ID, UIDX_ORDER_CODE)
    override fun `as`(alias: String): Tbwebmoneyhistory = Tbwebmoneyhistory(DSL.name(alias), this)
    override fun `as`(alias: Name): Tbwebmoneyhistory = Tbwebmoneyhistory(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Tbwebmoneyhistory = Tbwebmoneyhistory(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Tbwebmoneyhistory = Tbwebmoneyhistory(name, null)

    // -------------------------------------------------------------------------
    // Row20 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row20<Int?, String?, Int?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, Int?, Long?, Int?> = super.fieldsRow() as Row20<Int?, String?, Int?, String?, String?, LocalDateTime?, LocalDateTime?, LocalDateTime?, Int?, String?, String?, String?, String?, String?, String?, String?, String?, Int?, Long?, Int?>
}