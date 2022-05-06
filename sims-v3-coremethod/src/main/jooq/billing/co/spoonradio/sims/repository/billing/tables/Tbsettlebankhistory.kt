/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables


import co.spoonradio.sims.repository.billing.DefaultSchema
import co.spoonradio.sims.repository.billing.keys.PK_SETTLEBANK_HISTORY_ID
import co.spoonradio.sims.repository.billing.keys.UIDX_POID
import co.spoonradio.sims.repository.billing.tables.records.TbsettlebankhistoryRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
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
open class Tbsettlebankhistory(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TbsettlebankhistoryRecord>?,
    aliased: Table<TbsettlebankhistoryRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TbsettlebankhistoryRecord>(
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
         * The reference instance of <code>tbSettleBankHistory</code>
         */
        val TBSETTLEBANKHISTORY = Tbsettlebankhistory()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TbsettlebankhistoryRecord> = TbsettlebankhistoryRecord::class.java

    /**
     * The column <code>tbSettleBankHistory.id</code>.
     */
    val ID: TableField<TbsettlebankhistoryRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>tbSettleBankHistory.userAgent</code>.
     */
    val USERAGENT: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("userAgent"), SQLDataType.VARCHAR(32).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.status</code>.
     */
    val STATUS: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("status"), SQLDataType.VARCHAR(10).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.vbankStatus</code>.
     */
    val VBANKSTATUS: TableField<TbsettlebankhistoryRecord, Int?> = createField(DSL.name("vbankStatus"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbSettleBankHistory.txId</code>.
     */
    val TXID: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("txId"), SQLDataType.VARCHAR(64).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pStateCd</code>.
     */
    val PSTATECD: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pStateCd"), SQLDataType.VARCHAR(4).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pTrno</code>.
     */
    val PTRNO: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pTrno"), SQLDataType.VARCHAR(100).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pType</code>.
     */
    val PTYPE: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pType"), SQLDataType.VARCHAR(100).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pMid</code>.
     */
    val PMID: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pMid"), SQLDataType.VARCHAR(10).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pOid</code>.
     */
    val POID: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pOid"), SQLDataType.VARCHAR(100).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pMname</code>.
     */
    val PMNAME: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pMname"), SQLDataType.VARCHAR(100).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pEname</code>.
     */
    val PENAME: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pEname"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pGoods</code>.
     */
    val PGOODS: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pGoods"), SQLDataType.VARCHAR(200).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pHash</code>.
     */
    val PHASH: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pHash"), SQLDataType.VARCHAR(100).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pFnCd1</code>.
     */
    val PFNCD1: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pFnCd1"), SQLDataType.VARCHAR(10).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pFnCd2</code>.
     */
    val PFNCD2: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pFnCd2"), SQLDataType.VARCHAR(10).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pFnNm</code>.
     */
    val PFNNM: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pFnNm"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pAmt</code>.
     */
    val PAMT: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pAmt"), SQLDataType.VARCHAR(8).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pAuthNo</code>.
     */
    val PAUTHNO: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pAuthNo"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pAuthDt</code>.
     */
    val PAUTHDT: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pAuthDt"), SQLDataType.VARCHAR(14).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pNoti</code>.
     */
    val PNOTI: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pNoti"), SQLDataType.VARCHAR(1024).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pRmesg1</code>.
     */
    val PRMESG1: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pRmesg1"), SQLDataType.VARCHAR(500).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pRmesg2</code>.
     */
    val PRMESG2: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pRmesg2"), SQLDataType.VARCHAR(500).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.refundName</code>.
     */
    val REFUNDNAME: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("refundName"), SQLDataType.VARCHAR(200).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.refundAccount</code>.
     */
    val REFUNDACCOUNT: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("refundAccount"), SQLDataType.VARCHAR(200).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.refundBank</code>.
     */
    val REFUNDBANK: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("refundBank"), SQLDataType.VARCHAR(200).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.payDueDate</code>.
     */
    val PAYDUEDATE: TableField<TbsettlebankhistoryRecord, LocalDateTime?> = createField(DSL.name("payDueDate"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbSettleBankHistory.created</code>.
     */
    val CREATED: TableField<TbsettlebankhistoryRecord, LocalDateTime?> = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbSettleBankHistory.productId</code>.
     */
    val PRODUCTID: TableField<TbsettlebankhistoryRecord, Int?> = createField(DSL.name("productId"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbSettleBankHistory.promotionId</code>.
     */
    val PROMOTIONID: TableField<TbsettlebankhistoryRecord, Int?> = createField(DSL.name("promotionId"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbSettleBankHistory.userId</code>.
     */
    val USERID: TableField<TbsettlebankhistoryRecord, Int?> = createField(DSL.name("userId"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbSettleBankHistory.completed</code>.
     */
    val COMPLETED: TableField<TbsettlebankhistoryRecord, LocalDateTime?> = createField(DSL.name("completed"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbSettleBankHistory.quantity</code>.
     */
    val QUANTITY: TableField<TbsettlebankhistoryRecord, Int?> = createField(DSL.name("quantity"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>tbSettleBankHistory.updated</code>.
     */
    val UPDATED: TableField<TbsettlebankhistoryRecord, LocalDateTime?> = createField(DSL.name("updated"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbSettleBankHistory.pUname</code>.
     */
    val PUNAME: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("pUname"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PFnCd3</code>.
     */
    val PFNCD3: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PFnCd3"), SQLDataType.VARCHAR(10).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PBname</code>.
     */
    val PBNAME: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PBname"), SQLDataType.VARCHAR(500).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PIntMon</code>.
     */
    val PINTMON: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PIntMon"), SQLDataType.VARCHAR(500).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PEmail</code>.
     */
    val PEMAIL: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PEmail"), SQLDataType.VARCHAR(500).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.POname</code>.
     */
    val PONAME: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("POname"), SQLDataType.VARCHAR(500).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PPayNo</code>.
     */
    val PPAYNO: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PPayNo"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PMixPayTrNo</code>.
     */
    val PMIXPAYTRNO: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PMixPayTrNo"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PMixPayAmt</code>.
     */
    val PMIXPAYAMT: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PMixPayAmt"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PPayAmt</code>.
     */
    val PPAYAMT: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PPayAmt"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PCashAuthNo</code>.
     */
    val PCASHAUTHNO: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PCashAuthNo"), SQLDataType.VARCHAR(20).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>tbSettleBankHistory.PHashSha256</code>.
     */
    val PHASHSHA256: TableField<TbsettlebankhistoryRecord, String?> = createField(DSL.name("PHashSha256"), SQLDataType.VARCHAR(256).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "")

    private constructor(alias: Name, aliased: Table<TbsettlebankhistoryRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TbsettlebankhistoryRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>tbSettleBankHistory</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>tbSettleBankHistory</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>tbSettleBankHistory</code> table reference
     */
    constructor(): this(DSL.name("tbSettleBankHistory"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TbsettlebankhistoryRecord>): this(Internal.createPathAlias(child, key), child, key, TBSETTLEBANKHISTORY, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TbsettlebankhistoryRecord, Int?> = super.getIdentity() as Identity<TbsettlebankhistoryRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<TbsettlebankhistoryRecord> = PK_SETTLEBANK_HISTORY_ID
    override fun getKeys(): List<UniqueKey<TbsettlebankhistoryRecord>> = listOf(PK_SETTLEBANK_HISTORY_ID, UIDX_POID)
    override fun `as`(alias: String): Tbsettlebankhistory = Tbsettlebankhistory(DSL.name(alias), this)
    override fun `as`(alias: Name): Tbsettlebankhistory = Tbsettlebankhistory(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Tbsettlebankhistory = Tbsettlebankhistory(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Tbsettlebankhistory = Tbsettlebankhistory(name, null)
}