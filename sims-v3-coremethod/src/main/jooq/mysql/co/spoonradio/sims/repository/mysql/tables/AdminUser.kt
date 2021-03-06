/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables


import co.spoonradio.sims.repository.mysql.DefaultSchema
import co.spoonradio.sims.repository.mysql.keys.CONSTRAINT_2
import co.spoonradio.sims.repository.mysql.tables.records.AdminUserRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row20
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
open class AdminUser(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, AdminUserRecord>?,
    aliased: Table<AdminUserRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<AdminUserRecord>(
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
         * The reference instance of <code>admin_user</code>
         */
        val ADMIN_USER = AdminUser()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AdminUserRecord> = AdminUserRecord::class.java

    /**
     * The column <code>admin_user.user_id</code>.
     */
    val USER_ID: TableField<AdminUserRecord, Int?> = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>admin_user.username</code>.
     */
    val USERNAME: TableField<AdminUserRecord, String?> = createField(DSL.name("username"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>admin_user.password</code>.
     */
    val PASSWORD: TableField<AdminUserRecord, String?> = createField(DSL.name("password"), SQLDataType.VARCHAR(128).nullable(false), this, "")

    /**
     * The column <code>admin_user.email</code>.
     */
    val EMAIL: TableField<AdminUserRecord, String?> = createField(DSL.name("email"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>admin_user.onelogin_id</code>.
     */
    val ONELOGIN_ID: TableField<AdminUserRecord, String?> = createField(DSL.name("onelogin_id"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>admin_user.country_cd</code>.
     */
    val COUNTRY_CD: TableField<AdminUserRecord, String?> = createField(DSL.name("country_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>admin_user.profile_url</code>.
     */
    val PROFILE_URL: TableField<AdminUserRecord, String?> = createField(DSL.name("profile_url"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>admin_user.user_auth_cd</code>.
     */
    val USER_AUTH_CD: TableField<AdminUserRecord, String?> = createField(DSL.name("user_auth_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>admin_user.user_auth_cfc_cd</code>.
     */
    val USER_AUTH_CFC_CD: TableField<AdminUserRecord, String?> = createField(DSL.name("user_auth_cfc_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>admin_user.user_grp_cd</code>.
     */
    val USER_GRP_CD: TableField<AdminUserRecord, String?> = createField(DSL.name("user_grp_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>admin_user.user_position_cd</code>.
     */
    val USER_POSITION_CD: TableField<AdminUserRecord, String?> = createField(DSL.name("user_position_cd"), SQLDataType.VARCHAR(5).nullable(false), this, "")

    /**
     * The column <code>admin_user.session_key</code>.
     */
    val SESSION_KEY: TableField<AdminUserRecord, String?> = createField(DSL.name("session_key"), SQLDataType.VARCHAR(40).nullable(false), this, "")

    /**
     * The column <code>admin_user.is_staff</code>.
     */
    val IS_STAFF: TableField<AdminUserRecord, Byte?> = createField(DSL.name("is_staff"), SQLDataType.TINYINT.nullable(false), this, "")

    /**
     * The column <code>admin_user.is_active</code>.
     */
    val IS_ACTIVE: TableField<AdminUserRecord, Byte?> = createField(DSL.name("is_active"), SQLDataType.TINYINT.nullable(false), this, "")

    /**
     * The column <code>admin_user.last_login_dt</code>.
     */
    val LAST_LOGIN_DT: TableField<AdminUserRecord, LocalDateTime?> = createField(DSL.name("last_login_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>admin_user.logout_dt</code>.
     */
    val LOGOUT_DT: TableField<AdminUserRecord, LocalDateTime?> = createField(DSL.name("logout_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>admin_user.create_dt</code>.
     */
    val CREATE_DT: TableField<AdminUserRecord, LocalDateTime?> = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>admin_user.update_dt</code>.
     */
    val UPDATE_DT: TableField<AdminUserRecord, LocalDateTime?> = createField(DSL.name("update_dt"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>admin_user.google_account_id</code>.
     */
    val GOOGLE_ACCOUNT_ID: TableField<AdminUserRecord, String?> = createField(DSL.name("google_account_id"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>admin_user.withdrew_dt</code>.
     */
    val WITHDREW_DT: TableField<AdminUserRecord, LocalDateTime?> = createField(DSL.name("withdrew_dt"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<AdminUserRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<AdminUserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>admin_user</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>admin_user</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>admin_user</code> table reference
     */
    constructor(): this(DSL.name("admin_user"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, AdminUserRecord>): this(Internal.createPathAlias(child, key), child, key, ADMIN_USER, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<AdminUserRecord, Int?> = super.getIdentity() as Identity<AdminUserRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<AdminUserRecord> = CONSTRAINT_2
    override fun getKeys(): List<UniqueKey<AdminUserRecord>> = listOf(CONSTRAINT_2, co.spoonradio.sims.repository.mysql.keys.EMAIL)
    override fun `as`(alias: String): AdminUser = AdminUser(DSL.name(alias), this)
    override fun `as`(alias: Name): AdminUser = AdminUser(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): AdminUser = AdminUser(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): AdminUser = AdminUser(name, null)

    // -------------------------------------------------------------------------
    // Row20 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row20<Int?, String?, String?, String?, String?, String?, String?, String?, String?, String?, String?, String?, Byte?, Byte?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?, String?, LocalDateTime?> = super.fieldsRow() as Row20<Int?, String?, String?, String?, String?, String?, String?, String?, String?, String?, String?, String?, Byte?, Byte?, LocalDateTime?, LocalDateTime?, LocalDateTime?, LocalDateTime?, String?, LocalDateTime?>
}
