/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.CONSTRAINT_5
import co.spoonradio.sims.repository.postgresql.tables.records.UsersSpoonuserRecord

import java.time.OffsetDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row17
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
open class UsersSpoonuser(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UsersSpoonuserRecord>?,
    aliased: Table<UsersSpoonuserRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UsersSpoonuserRecord>(
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
         * The reference instance of <code>users_spoonuser</code>
         */
        val USERS_SPOONUSER = UsersSpoonuser()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UsersSpoonuserRecord> = UsersSpoonuserRecord::class.java

    /**
     * The column <code>users_spoonuser.id</code>.
     */
    val ID: TableField<UsersSpoonuserRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>users_spoonuser.password</code>.
     */
    val PASSWORD: TableField<UsersSpoonuserRecord, String?> = createField(DSL.name("password"), SQLDataType.VARCHAR(128).nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.last_login</code>.
     */
    val LAST_LOGIN: TableField<UsersSpoonuserRecord, OffsetDateTime?> = createField(DSL.name("last_login"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "")

    /**
     * The column <code>users_spoonuser.is_superuser</code>.
     */
    val IS_SUPERUSER: TableField<UsersSpoonuserRecord, Boolean?> = createField(DSL.name("is_superuser"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.username</code>.
     */
    val USERNAME: TableField<UsersSpoonuserRecord, String?> = createField(DSL.name("username"), SQLDataType.VARCHAR(150).nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.first_name</code>.
     */
    val FIRST_NAME: TableField<UsersSpoonuserRecord, String?> = createField(DSL.name("first_name"), SQLDataType.VARCHAR(30).nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.last_name</code>.
     */
    val LAST_NAME: TableField<UsersSpoonuserRecord, String?> = createField(DSL.name("last_name"), SQLDataType.VARCHAR(30).nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.email</code>.
     */
    val EMAIL: TableField<UsersSpoonuserRecord, String?> = createField(DSL.name("email"), SQLDataType.VARCHAR(254).nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.is_staff</code>.
     */
    val IS_STAFF: TableField<UsersSpoonuserRecord, Boolean?> = createField(DSL.name("is_staff"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.is_active</code>.
     */
    val IS_ACTIVE: TableField<UsersSpoonuserRecord, Boolean?> = createField(DSL.name("is_active"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.date_joined</code>.
     */
    val DATE_JOINED: TableField<UsersSpoonuserRecord, OffsetDateTime?> = createField(DSL.name("date_joined"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>users_spoonuser.company_id</code>.
     */
    val COMPANY_ID: TableField<UsersSpoonuserRecord, Int?> = createField(DSL.name("company_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_spoonuser.budget_id</code>.
     */
    val BUDGET_ID: TableField<UsersSpoonuserRecord, Int?> = createField(DSL.name("budget_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_spoonuser.grants_id</code>.
     */
    val GRANTS_ID: TableField<UsersSpoonuserRecord, Int?> = createField(DSL.name("grants_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_spoonuser.leaved</code>.
     */
    val LEAVED: TableField<UsersSpoonuserRecord, OffsetDateTime?> = createField(DSL.name("leaved"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "")

    /**
     * The column <code>users_spoonuser.status</code>.
     */
    val STATUS: TableField<UsersSpoonuserRecord, Int?> = createField(DSL.name("status"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_spoonuser.is_dormant</code>.
     */
    val IS_DORMANT: TableField<UsersSpoonuserRecord, Boolean?> = createField(DSL.name("is_dormant"), SQLDataType.BOOLEAN, this, "")

    private constructor(alias: Name, aliased: Table<UsersSpoonuserRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UsersSpoonuserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>users_spoonuser</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>users_spoonuser</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>users_spoonuser</code> table reference
     */
    constructor(): this(DSL.name("users_spoonuser"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UsersSpoonuserRecord>): this(Internal.createPathAlias(child, key), child, key, USERS_SPOONUSER, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<UsersSpoonuserRecord, Int?> = super.getIdentity() as Identity<UsersSpoonuserRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<UsersSpoonuserRecord> = CONSTRAINT_5
    override fun getKeys(): List<UniqueKey<UsersSpoonuserRecord>> = listOf(CONSTRAINT_5)
    override fun `as`(alias: String): UsersSpoonuser = UsersSpoonuser(DSL.name(alias), this)
    override fun `as`(alias: Name): UsersSpoonuser = UsersSpoonuser(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UsersSpoonuser = UsersSpoonuser(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UsersSpoonuser = UsersSpoonuser(name, null)

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row17<Int?, String?, OffsetDateTime?, Boolean?, String?, String?, String?, String?, Boolean?, Boolean?, OffsetDateTime?, Int?, Int?, Int?, OffsetDateTime?, Int?, Boolean?> = super.fieldsRow() as Row17<Int?, String?, OffsetDateTime?, Boolean?, String?, String?, String?, String?, Boolean?, Boolean?, OffsetDateTime?, Int?, Int?, Int?, OffsetDateTime?, Int?, Boolean?>
}
