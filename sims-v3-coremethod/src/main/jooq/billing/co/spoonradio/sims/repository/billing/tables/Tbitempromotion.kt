/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables


import co.spoonradio.sims.repository.billing.DefaultSchema
import co.spoonradio.sims.repository.billing.keys.PK_ITEM_PROMOTION_ID
import co.spoonradio.sims.repository.billing.keys.UIDX_CODE
import co.spoonradio.sims.repository.billing.tables.records.TbitempromotionRecord

import java.time.LocalDateTime

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
open class Tbitempromotion(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TbitempromotionRecord>?,
    aliased: Table<TbitempromotionRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TbitempromotionRecord>(
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
         * The reference instance of <code>tbItemPromotion</code>
         */
        val TBITEMPROMOTION = Tbitempromotion()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TbitempromotionRecord> = TbitempromotionRecord::class.java

    /**
     * The column <code>tbItemPromotion.id</code>.
     */
    val ID: TableField<TbitempromotionRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>tbItemPromotion.name</code>.
     */
    val NAME: TableField<TbitempromotionRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>tbItemPromotion.code</code>.
     */
    val CODE: TableField<TbitempromotionRecord, String?> = createField(DSL.name("code"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>tbItemPromotion.value</code>.
     */
    val VALUE: TableField<TbitempromotionRecord, Int?> = createField(DSL.name("value"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbItemPromotion.isUse</code>.
     */
    val ISUSE: TableField<TbitempromotionRecord, Boolean?> = createField(DSL.name("isUse"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>tbItemPromotion.startDate</code>.
     */
    val STARTDATE: TableField<TbitempromotionRecord, LocalDateTime?> = createField(DSL.name("startDate"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbItemPromotion.endDate</code>.
     */
    val ENDDATE: TableField<TbitempromotionRecord, LocalDateTime?> = createField(DSL.name("endDate"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbItemPromotion.createdDate</code>.
     */
    val CREATEDDATE: TableField<TbitempromotionRecord, LocalDateTime?> = createField(DSL.name("createdDate"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>tbItemPromotion.updatedDate</code>.
     */
    val UPDATEDDATE: TableField<TbitempromotionRecord, LocalDateTime?> = createField(DSL.name("updatedDate"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>tbItemPromotion.creator</code>.
     */
    val CREATOR: TableField<TbitempromotionRecord, Int?> = createField(DSL.name("creator"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>tbItemPromotion.updater</code>.
     */
    val UPDATER: TableField<TbitempromotionRecord, Int?> = createField(DSL.name("updater"), SQLDataType.INTEGER, this, "")

    private constructor(alias: Name, aliased: Table<TbitempromotionRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TbitempromotionRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>tbItemPromotion</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>tbItemPromotion</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>tbItemPromotion</code> table reference
     */
    constructor(): this(DSL.name("tbItemPromotion"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TbitempromotionRecord>): this(Internal.createPathAlias(child, key), child, key, TBITEMPROMOTION, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TbitempromotionRecord, Int?> = super.getIdentity() as Identity<TbitempromotionRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<TbitempromotionRecord> = PK_ITEM_PROMOTION_ID
    override fun getKeys(): List<UniqueKey<TbitempromotionRecord>> = listOf(PK_ITEM_PROMOTION_ID, UIDX_CODE)
    override fun `as`(alias: String): Tbitempromotion = Tbitempromotion(DSL.name(alias), this)
    override fun `as`(alias: Name): Tbitempromotion = Tbitempromotion(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Tbitempromotion = Tbitempromotion(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Tbitempromotion = Tbitempromotion(name, null)

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row11<Int?, String?, String?, Int?, Boolean?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?, Int?, Int?> = super.fieldsRow() as Row11<Int?, String?, String?, Int?, Boolean?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?, Int?, Int?>
}
