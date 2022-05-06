/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_4
import co.spoonradio.sims.repository.mysql.tables.records.VocAttachmentRecord

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
open class VocAttachment(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, VocAttachmentRecord>?,
    aliased: Table<VocAttachmentRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<VocAttachmentRecord>(
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
         * The reference instance of <code>voc_attachment</code>
         */
        val VOC_ATTACHMENT = VocAttachment()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<VocAttachmentRecord> = VocAttachmentRecord::class.java

    /**
     * The column <code>voc_attachment.attachment_id</code>.
     */
    val ATTACHMENT_ID: TableField<VocAttachmentRecord, Int?> = createField(DSL.name("attachment_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>voc_attachment.voc_hist_id</code>.
     */
    val VOC_HIST_ID: TableField<VocAttachmentRecord, Int?> = createField(DSL.name("voc_hist_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>voc_attachment.attachment_path</code>.
     */
    val ATTACHMENT_PATH: TableField<VocAttachmentRecord, String?> = createField(DSL.name("attachment_path"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>voc_attachment.create_dt</code>.
     */
    val CREATE_DT: TableField<VocAttachmentRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>voc_attachment.update_dt</code>.
     */
    val UPDATE_DT: TableField<VocAttachmentRecord, LocalDateTime?> = createField(DSL.name("update_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<VocAttachmentRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<VocAttachmentRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>voc_attachment</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>voc_attachment</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>voc_attachment</code> table reference
     */
    constructor(): this(DSL.name("voc_attachment"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, VocAttachmentRecord>): this(Internal.createPathAlias(child, key), child, key, VOC_ATTACHMENT, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<VocAttachmentRecord, Int?> = super.getIdentity() as Identity<VocAttachmentRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<VocAttachmentRecord> = CONSTRAINT_4
    override fun getKeys(): List<UniqueKey<VocAttachmentRecord>> = listOf(CONSTRAINT_4)
    override fun `as`(alias: String): VocAttachment = VocAttachment(DSL.name(alias), this)
    override fun `as`(alias: Name): VocAttachment = VocAttachment(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): VocAttachment = VocAttachment(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): VocAttachment = VocAttachment(name, null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Int?, Int?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row5<Int?, Int?, String?, LocalDateTime?, LocalDateTime?>
}