/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.TALKS_TALKVOICECOMMENT_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.TalksTalkvoicecommentRecord

import java.time.OffsetDateTime

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
open class TalksTalkvoicecomment(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TalksTalkvoicecommentRecord>?,
    aliased: Table<TalksTalkvoicecommentRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TalksTalkvoicecommentRecord>(
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
         * The reference instance of <code>talks_talkvoicecomment</code>
         */
        val TALKS_TALKVOICECOMMENT = TalksTalkvoicecomment()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TalksTalkvoicecommentRecord> = TalksTalkvoicecommentRecord::class.java

    /**
     * The column <code>talks_talkvoicecomment.id</code>.
     */
    val ID: TableField<TalksTalkvoicecommentRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>talks_talkvoicecomment.voice_key</code>.
     */
    val VOICE_KEY: TableField<TalksTalkvoicecommentRecord, String?> = createField(DSL.name("voice_key"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.voice_url</code>.
     */
    val VOICE_URL: TableField<TalksTalkvoicecommentRecord, String?> = createField(DSL.name("voice_url"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.duration</code>.
     */
    val DURATION: TableField<TalksTalkvoicecommentRecord, Double?> = createField(DSL.name("duration"), SQLDataType.DOUBLE.nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.reporters</code>.
     */
    val REPORTERS: TableField<TalksTalkvoicecommentRecord, Array<Any?>?> = createField(DSL.name("reporters"), SQLDataType.OTHER.getArrayDataType(), this, "")

    /**
     * The column <code>talks_talkvoicecomment.created</code>.
     */
    val CREATED: TableField<TalksTalkvoicecommentRecord, OffsetDateTime?> = createField(DSL.name("created"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.author_id</code>.
     */
    val AUTHOR_ID: TableField<TalksTalkvoicecommentRecord, Int?> = createField(DSL.name("author_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.talk_id</code>.
     */
    val TALK_ID: TableField<TalksTalkvoicecommentRecord, Int?> = createField(DSL.name("talk_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.to_user_id</code>.
     */
    val TO_USER_ID: TableField<TalksTalkvoicecommentRecord, Int?> = createField(DSL.name("to_user_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>talks_talkvoicecomment.like_count</code>.
     */
    val LIKE_COUNT: TableField<TalksTalkvoicecommentRecord, Int?> = createField(DSL.name("like_count"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>talks_talkvoicecomment.play_count</code>.
     */
    val PLAY_COUNT: TableField<TalksTalkvoicecommentRecord, Int?> = createField(DSL.name("play_count"), SQLDataType.INTEGER, this, "")

    private constructor(alias: Name, aliased: Table<TalksTalkvoicecommentRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TalksTalkvoicecommentRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>talks_talkvoicecomment</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>talks_talkvoicecomment</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>talks_talkvoicecomment</code> table reference
     */
    constructor(): this(DSL.name("talks_talkvoicecomment"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TalksTalkvoicecommentRecord>): this(Internal.createPathAlias(child, key), child, key, TALKS_TALKVOICECOMMENT, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<TalksTalkvoicecommentRecord, Int?> = super.getIdentity() as Identity<TalksTalkvoicecommentRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<TalksTalkvoicecommentRecord> = TALKS_TALKVOICECOMMENT_PKEY
    override fun getKeys(): List<UniqueKey<TalksTalkvoicecommentRecord>> = listOf(TALKS_TALKVOICECOMMENT_PKEY)
    override fun `as`(alias: String): TalksTalkvoicecomment = TalksTalkvoicecomment(DSL.name(alias), this)
    override fun `as`(alias: Name): TalksTalkvoicecomment = TalksTalkvoicecomment(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): TalksTalkvoicecomment = TalksTalkvoicecomment(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): TalksTalkvoicecomment = TalksTalkvoicecomment(name, null)

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row11<Int?, String?, String?, Double?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?, Int?, Int?> = super.fieldsRow() as Row11<Int?, String?, String?, Double?, Array<Any?>?, OffsetDateTime?, Int?, Int?, Int?, Int?, Int?>
}