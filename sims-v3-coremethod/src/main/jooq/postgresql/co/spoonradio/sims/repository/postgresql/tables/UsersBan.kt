/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.USERS_BAN_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.UsersBanRecord

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
open class UsersBan(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UsersBanRecord>?,
    aliased: Table<UsersBanRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UsersBanRecord>(
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
         * The reference instance of <code>users_ban</code>
         */
        val USERS_BAN = UsersBan()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UsersBanRecord> = UsersBanRecord::class.java

    /**
     * The column <code>users_ban.id</code>.
     */
    val ID: TableField<UsersBanRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>users_ban.detail</code>.
     */
    val DETAIL: TableField<UsersBanRecord, String?> = createField(DSL.name("detail"), SQLDataType.VARCHAR(500).nullable(false), this, "")

    /**
     * The column <code>users_ban.memo</code>.
     */
    val MEMO: TableField<UsersBanRecord, String?> = createField(DSL.name("memo"), SQLDataType.VARCHAR(500).nullable(false), this, "")

    /**
     * The column <code>users_ban.device_unique_id</code>.
     */
    val DEVICE_UNIQUE_ID: TableField<UsersBanRecord, String?> = createField(DSL.name("device_unique_id"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>users_ban.type</code>.
     */
    val TYPE: TableField<UsersBanRecord, Int?> = createField(DSL.name("type"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>users_ban.end_date</code>.
     */
    val END_DATE: TableField<UsersBanRecord, OffsetDateTime?> = createField(DSL.name("end_date"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>users_ban.created</code>.
     */
    val CREATED: TableField<UsersBanRecord, OffsetDateTime?> = createField(DSL.name("created"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>users_ban.category_content_id</code>.
     */
    val CATEGORY_CONTENT_ID: TableField<UsersBanRecord, Int?> = createField(DSL.name("category_content_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_ban.category_main_id</code>.
     */
    val CATEGORY_MAIN_ID: TableField<UsersBanRecord, Int?> = createField(DSL.name("category_main_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_ban.category_sub_id</code>.
     */
    val CATEGORY_SUB_ID: TableField<UsersBanRecord, Int?> = createField(DSL.name("category_sub_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_ban.user_id</code>.
     */
    val USER_ID: TableField<UsersBanRecord, Int?> = createField(DSL.name("user_id"), SQLDataType.INTEGER, this, "")

    private constructor(alias: Name, aliased: Table<UsersBanRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UsersBanRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>users_ban</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>users_ban</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>users_ban</code> table reference
     */
    constructor(): this(DSL.name("users_ban"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UsersBanRecord>): this(Internal.createPathAlias(child, key), child, key, USERS_BAN, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<UsersBanRecord, Int?> = super.getIdentity() as Identity<UsersBanRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<UsersBanRecord> = USERS_BAN_PKEY
    override fun getKeys(): List<UniqueKey<UsersBanRecord>> = listOf(USERS_BAN_PKEY)
    override fun `as`(alias: String): UsersBan = UsersBan(DSL.name(alias), this)
    override fun `as`(alias: Name): UsersBan = UsersBan(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UsersBan = UsersBan(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UsersBan = UsersBan(name, null)

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row11<Int?, String?, String?, String?, Int?, OffsetDateTime?, OffsetDateTime?, Int?, Int?, Int?, Int?> = super.fieldsRow() as Row11<Int?, String?, String?, String?, Int?, OffsetDateTime?, OffsetDateTime?, Int?, Int?, Int?, Int?>
}