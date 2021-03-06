/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_7FC
import co.spoonradio.sims.repository.mysql.tables.records.VocReplyRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row6
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
open class VocReply(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, VocReplyRecord>?,
    aliased: Table<VocReplyRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<VocReplyRecord>(
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
         * The reference instance of <code>voc_reply</code>
         */
        val VOC_REPLY = VocReply()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<VocReplyRecord> = VocReplyRecord::class.java

    /**
     * The column <code>voc_reply.reply_id</code>.
     */
    val REPLY_ID: TableField<VocReplyRecord, Int?> = createField(DSL.name("reply_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>voc_reply.voc_hist_id</code>.
     */
    val VOC_HIST_ID: TableField<VocReplyRecord, Int?> = createField(DSL.name("voc_hist_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>voc_reply.reply</code>.
     */
    val REPLY: TableField<VocReplyRecord, String?> = createField(DSL.name("reply"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>voc_reply.create_dt</code>.
     */
    val CREATE_DT: TableField<VocReplyRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>voc_reply.update_dt</code>.
     */
    val UPDATE_DT: TableField<VocReplyRecord, LocalDateTime?> = createField(DSL.name("update_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>voc_reply.member_user_id</code>.
     */
    val MEMBER_USER_ID: TableField<VocReplyRecord, Int?> = createField(DSL.name("member_user_id"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<VocReplyRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<VocReplyRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>voc_reply</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>voc_reply</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>voc_reply</code> table reference
     */
    constructor(): this(DSL.name("voc_reply"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, VocReplyRecord>): this(Internal.createPathAlias(child, key), child, key, VOC_REPLY, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<VocReplyRecord, Int?> = super.getIdentity() as Identity<VocReplyRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<VocReplyRecord> = CONSTRAINT_7FC
    override fun getKeys(): List<UniqueKey<VocReplyRecord>> = listOf(CONSTRAINT_7FC)
    override fun `as`(alias: String): VocReply = VocReply(DSL.name(alias), this)
    override fun `as`(alias: Name): VocReply = VocReply(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): VocReply = VocReply(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): VocReply = VocReply(name, null)

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row6<Int?, Int?, String?, LocalDateTime?, LocalDateTime?, Int?> = super.fieldsRow() as Row6<Int?, Int?, String?, LocalDateTime?, LocalDateTime?, Int?>
}
