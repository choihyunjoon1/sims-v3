/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_7F
import co.spoonradio.sims.repository.mysql.tables.records.VocHistRecord

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
open class VocHist(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, VocHistRecord>?,
    aliased: Table<VocHistRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<VocHistRecord>(
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
         * The reference instance of <code>voc_hist</code>
         */
        val VOC_HIST = VocHist()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<VocHistRecord> = VocHistRecord::class.java

    /**
     * The column <code>voc_hist.voc_hist_id</code>.
     */
    val VOC_HIST_ID: TableField<VocHistRecord, Int?> = createField(DSL.name("voc_hist_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>voc_hist.status_cd</code>.
     */
    val STATUS_CD: TableField<VocHistRecord, String?> = createField(DSL.name("status_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.spoon_user_id</code>.
     */
    val SPOON_USER_ID: TableField<VocHistRecord, Long?> = createField(DSL.name("spoon_user_id"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>voc_hist.register_type_cd</code>.
     */
    val REGISTER_TYPE_CD: TableField<VocHistRecord, String?> = createField(DSL.name("register_type_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.bound_type_cd</code>.
     */
    val BOUND_TYPE_CD: TableField<VocHistRecord, String?> = createField(DSL.name("bound_type_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.criticality_type_cd</code>.
     */
    val CRITICALITY_TYPE_CD: TableField<VocHistRecord, String?> = createField(DSL.name("criticality_type_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.channel_cd</code>.
     */
    val CHANNEL_CD: TableField<VocHistRecord, String?> = createField(DSL.name("channel_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.type_cd</code>.
     */
    val TYPE_CD: TableField<VocHistRecord, String?> = createField(DSL.name("type_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.category_cd</code>.
     */
    val CATEGORY_CD: TableField<VocHistRecord, String?> = createField(DSL.name("category_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.division_cd</code>.
     */
    val DIVISION_CD: TableField<VocHistRecord, String?> = createField(DSL.name("division_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>voc_hist.section_cd</code>.
     */
    val SECTION_CD: TableField<VocHistRecord, String?> = createField(DSL.name("section_cd"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>voc_hist.comment</code>.
     */
    val COMMENT: TableField<VocHistRecord, String?> = createField(DSL.name("comment"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>voc_hist.reply</code>.
     */
    val REPLY: TableField<VocHistRecord, String?> = createField(DSL.name("reply"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>voc_hist.create_dt</code>.
     */
    val CREATE_DT: TableField<VocHistRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>voc_hist.update_dt</code>.
     */
    val UPDATE_DT: TableField<VocHistRecord, LocalDateTime?> = createField(DSL.name("update_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>voc_hist.member_user_id</code>.
     */
    val MEMBER_USER_ID: TableField<VocHistRecord, Int?> = createField(DSL.name("member_user_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>voc_hist.reply_user_id</code>.
     */
    val REPLY_USER_ID: TableField<VocHistRecord, Int?> = createField(DSL.name("reply_user_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>voc_hist.spoon_user_nickname</code>.
     */
    val SPOON_USER_NICKNAME: TableField<VocHistRecord, String?> = createField(DSL.name("spoon_user_nickname"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>voc_hist.non_spoon_member_email</code>.
     */
    val NON_SPOON_MEMBER_EMAIL: TableField<VocHistRecord, String?> = createField(DSL.name("non_spoon_member_email"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>voc_hist.reply_dt</code>.
     */
    val REPLY_DT: TableField<VocHistRecord, LocalDateTime?> = createField(DSL.name("reply_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>voc_hist.des_dt</code>.
     */
    val DES_DT: TableField<VocHistRecord, LocalDateTime?> = createField(DSL.name("des_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>voc_hist.is_des</code>.
     */
    val IS_DES: TableField<VocHistRecord, Byte?> = createField(DSL.name("is_des"), SQLDataType.TINYINT.nullable(false), this, "")

    /**
     * The column <code>voc_hist.upload_dt</code>.
     */
    val UPLOAD_DT: TableField<VocHistRecord, LocalDateTime?> = createField(DSL.name("upload_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>voc_hist.os</code>.
     */
    val OS: TableField<VocHistRecord, String?> = createField(DSL.name("os"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>voc_hist.carrier</code>.
     */
    val CARRIER: TableField<VocHistRecord, String?> = createField(DSL.name("carrier"), SQLDataType.VARCHAR(32), this, "")

    /**
     * The column <code>voc_hist.app_version</code>.
     */
    val APP_VERSION: TableField<VocHistRecord, String?> = createField(DSL.name("app_version"), SQLDataType.VARCHAR(32), this, "")

    /**
     * The column <code>voc_hist.device_model</code>.
     */
    val DEVICE_MODEL: TableField<VocHistRecord, String?> = createField(DSL.name("device_model"), SQLDataType.VARCHAR(32), this, "")

    private constructor(alias: Name, aliased: Table<VocHistRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<VocHistRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>voc_hist</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>voc_hist</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>voc_hist</code> table reference
     */
    constructor(): this(DSL.name("voc_hist"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, VocHistRecord>): this(Internal.createPathAlias(child, key), child, key, VOC_HIST, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<VocHistRecord, Int?> = super.getIdentity() as Identity<VocHistRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<VocHistRecord> = CONSTRAINT_7F
    override fun getKeys(): List<UniqueKey<VocHistRecord>> = listOf(CONSTRAINT_7F)
    override fun `as`(alias: String): VocHist = VocHist(DSL.name(alias), this)
    override fun `as`(alias: Name): VocHist = VocHist(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): VocHist = VocHist(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): VocHist = VocHist(name, null)
}
