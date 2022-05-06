/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_3
import co.spoonradio.sims.repository.mysql.tables.records.AuthtokenTokenRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row3
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
open class AuthtokenToken(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, AuthtokenTokenRecord>?,
    aliased: Table<AuthtokenTokenRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<AuthtokenTokenRecord>(
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
         * The reference instance of <code>authtoken_token</code>
         */
        val AUTHTOKEN_TOKEN = AuthtokenToken()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AuthtokenTokenRecord> = AuthtokenTokenRecord::class.java

    /**
     * The column <code>authtoken_token.key</code>.
     */
    val KEY: TableField<AuthtokenTokenRecord, String?> = createField(DSL.name("key"), SQLDataType.VARCHAR(40).nullable(false), this, "")

    /**
     * The column <code>authtoken_token.created</code>.
     */
    val CREATED: TableField<AuthtokenTokenRecord, LocalDateTime?> = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>authtoken_token.user_id</code>.
     */
    val USER_ID: TableField<AuthtokenTokenRecord, Int?> = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<AuthtokenTokenRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<AuthtokenTokenRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>authtoken_token</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>authtoken_token</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>authtoken_token</code> table reference
     */
    constructor(): this(DSL.name("authtoken_token"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, AuthtokenTokenRecord>): this(Internal.createPathAlias(child, key), child, key, AUTHTOKEN_TOKEN, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getPrimaryKey(): UniqueKey<AuthtokenTokenRecord> = CONSTRAINT_3
    override fun getKeys(): List<UniqueKey<AuthtokenTokenRecord>> = listOf(CONSTRAINT_3, co.spoonradio.sims.repository.mysql.keys.USER_ID)
    override fun `as`(alias: String): AuthtokenToken = AuthtokenToken(DSL.name(alias), this)
    override fun `as`(alias: Name): AuthtokenToken = AuthtokenToken(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): AuthtokenToken = AuthtokenToken(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): AuthtokenToken = AuthtokenToken(name, null)

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row3<String?, LocalDateTime?, Int?> = super.fieldsRow() as Row3<String?, LocalDateTime?, Int?>
}
