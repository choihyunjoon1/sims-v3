/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables


import co.spoonradio.sims.repository.postgresql.DefaultSchema
import co.spoonradio.sims.repository.postgresql.keys.USERS_DEVICE_PKEY
import co.spoonradio.sims.repository.postgresql.tables.records.UsersDeviceRecord

import java.time.OffsetDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row13
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
open class UsersDevice(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UsersDeviceRecord>?,
    aliased: Table<UsersDeviceRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UsersDeviceRecord>(
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
         * The reference instance of <code>users_device</code>
         */
        val USERS_DEVICE = UsersDevice()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UsersDeviceRecord> = UsersDeviceRecord::class.java

    /**
     * The column <code>users_device.id</code>.
     */
    val ID: TableField<UsersDeviceRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>users_device.device_token</code>.
     */
    val DEVICE_TOKEN: TableField<UsersDeviceRecord, String?> = createField(DSL.name("device_token"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>users_device.os_type</code>.
     */
    val OS_TYPE: TableField<UsersDeviceRecord, String?> = createField(DSL.name("os_type"), SQLDataType.VARCHAR(10).nullable(false), this, "")

    /**
     * The column <code>users_device.model_name</code>.
     */
    val MODEL_NAME: TableField<UsersDeviceRecord, String?> = createField(DSL.name("model_name"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>users_device.build_no</code>.
     */
    val BUILD_NO: TableField<UsersDeviceRecord, Int?> = createField(DSL.name("build_no"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>users_device.created</code>.
     */
    val CREATED: TableField<UsersDeviceRecord, OffsetDateTime?> = createField(DSL.name("created"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>users_device.user_id</code>.
     */
    val USER_ID: TableField<UsersDeviceRecord, Int?> = createField(DSL.name("user_id"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>users_device.android_id</code>.
     */
    val ANDROID_ID: TableField<UsersDeviceRecord, String?> = createField(DSL.name("android_id"), SQLDataType.VARCHAR(100), this, "")

    /**
     * The column <code>users_device.device_unique_id</code>.
     */
    val DEVICE_UNIQUE_ID: TableField<UsersDeviceRecord, String?> = createField(DSL.name("device_unique_id"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>users_device.one_signal_id</code>.
     */
    val ONE_SIGNAL_ID: TableField<UsersDeviceRecord, String?> = createField(DSL.name("one_signal_id"), SQLDataType.VARCHAR(100), this, "")

    /**
     * The column <code>users_device.updated</code>.
     */
    val UPDATED: TableField<UsersDeviceRecord, OffsetDateTime?> = createField(DSL.name("updated"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>users_device.ip_address</code>.
     */
    val IP_ADDRESS: TableField<UsersDeviceRecord, String?> = createField(DSL.name("ip_address"), SQLDataType.VARCHAR(200), this, "")

    /**
     * The column <code>users_device.status</code>.
     */
    val STATUS: TableField<UsersDeviceRecord, Int?> = createField(DSL.name("status"), SQLDataType.INTEGER, this, "")

    private constructor(alias: Name, aliased: Table<UsersDeviceRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UsersDeviceRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>users_device</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>users_device</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>users_device</code> table reference
     */
    constructor(): this(DSL.name("users_device"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UsersDeviceRecord>): this(Internal.createPathAlias(child, key), child, key, USERS_DEVICE, null)
    override fun getSchema(): Schema = DefaultSchema.DEFAULT_SCHEMA
    override fun getIdentity(): Identity<UsersDeviceRecord, Int?> = super.getIdentity() as Identity<UsersDeviceRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<UsersDeviceRecord> = USERS_DEVICE_PKEY
    override fun getKeys(): List<UniqueKey<UsersDeviceRecord>> = listOf(USERS_DEVICE_PKEY)
    override fun `as`(alias: String): UsersDevice = UsersDevice(DSL.name(alias), this)
    override fun `as`(alias: Name): UsersDevice = UsersDevice(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UsersDevice = UsersDevice(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UsersDevice = UsersDevice(name, null)

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row13<Int?, String?, String?, String?, Int?, OffsetDateTime?, Int?, String?, String?, String?, OffsetDateTime?, String?, Int?> = super.fieldsRow() as Row13<Int?, String?, String?, String?, Int?, OffsetDateTime?, Int?, String?, String?, String?, OffsetDateTime?, String?, Int?>
}
