/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_9
import co.spoonradio.sims.repository.mysql.tables.records.AuthPermissionRecord

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row4
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
open class AuthPermission(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, AuthPermissionRecord>?,
    aliased: Table<AuthPermissionRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<AuthPermissionRecord>(
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
         * The reference instance of <code>auth_permission</code>
         */
        val AUTH_PERMISSION = AuthPermission()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AuthPermissionRecord> = AuthPermissionRecord::class.java

    /**
     * The column <code>auth_permission.id</code>.
     */
    val ID: TableField<AuthPermissionRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>auth_permission.name</code>.
     */
    val NAME: TableField<AuthPermissionRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>auth_permission.content_type_id</code>.
     */
    val CONTENT_TYPE_ID: TableField<AuthPermissionRecord, Int?> = createField(DSL.name("content_type_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>auth_permission.codename</code>.
     */
    val CODENAME: TableField<AuthPermissionRecord, String?> = createField(DSL.name("codename"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<AuthPermissionRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<AuthPermissionRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>auth_permission</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>auth_permission</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>auth_permission</code> table reference
     */
    constructor(): this(DSL.name("auth_permission"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, AuthPermissionRecord>): this(Internal.createPathAlias(child, key), child, key, AUTH_PERMISSION, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<AuthPermissionRecord, Int?> = super.getIdentity() as Identity<AuthPermissionRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<AuthPermissionRecord> = CONSTRAINT_9
    override fun getKeys(): List<UniqueKey<AuthPermissionRecord>> = listOf(CONSTRAINT_9)
    override fun `as`(alias: String): AuthPermission = AuthPermission(DSL.name(alias), this)
    override fun `as`(alias: Name): AuthPermission = AuthPermission(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): AuthPermission = AuthPermission(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): AuthPermission = AuthPermission(name, null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<Int?, String?, Int?, String?> = super.fieldsRow() as Row4<Int?, String?, Int?, String?>
}
