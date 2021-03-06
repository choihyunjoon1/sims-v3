/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.OtpTotpTotpdevice

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record13
import org.jooq.Row13
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class OtpTotpTotpdeviceRecord() : UpdatableRecordImpl<OtpTotpTotpdeviceRecord>(OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE), Record13<Int?, String?, Byte?, String?, Int?, Long?, Int?, Int?, Short?, Long?, Int?, Long?, LocalDateTime?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var name: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var confirmed: Byte?
        set(value) = set(2, value)
        get() = get(2) as Byte?

    var key: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var step: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var t0: Long?
        set(value) = set(5, value)
        get() = get(5) as Long?

    var digits: Int?
        set(value) = set(6, value)
        get() = get(6) as Int?

    var tolerance: Int?
        set(value) = set(7, value)
        get() = get(7) as Int?

    var drift: Short?
        set(value) = set(8, value)
        get() = get(8) as Short?

    var lastT: Long?
        set(value) = set(9, value)
        get() = get(9) as Long?

    var userId: Int?
        set(value) = set(10, value)
        get() = get(10) as Int?

    var throttlingFailureCount: Long?
        set(value) = set(11, value)
        get() = get(11) as Long?

    var throttlingFailureTimestamp: LocalDateTime?
        set(value) = set(12, value)
        get() = get(12) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row13<Int?, String?, Byte?, String?, Int?, Long?, Int?, Int?, Short?, Long?, Int?, Long?, LocalDateTime?> = super.fieldsRow() as Row13<Int?, String?, Byte?, String?, Int?, Long?, Int?, Int?, Short?, Long?, Int?, Long?, LocalDateTime?>
    override fun valuesRow(): Row13<Int?, String?, Byte?, String?, Int?, Long?, Int?, Int?, Short?, Long?, Int?, Long?, LocalDateTime?> = super.valuesRow() as Row13<Int?, String?, Byte?, String?, Int?, Long?, Int?, Int?, Short?, Long?, Int?, Long?, LocalDateTime?>
    override fun field1(): Field<Int?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.ID
    override fun field2(): Field<String?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.NAME
    override fun field3(): Field<Byte?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.CONFIRMED
    override fun field4(): Field<String?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.KEY
    override fun field5(): Field<Int?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.STEP
    override fun field6(): Field<Long?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.T0
    override fun field7(): Field<Int?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.DIGITS
    override fun field8(): Field<Int?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.TOLERANCE
    override fun field9(): Field<Short?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.DRIFT
    override fun field10(): Field<Long?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.LAST_T
    override fun field11(): Field<Int?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.USER_ID
    override fun field12(): Field<Long?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.THROTTLING_FAILURE_COUNT
    override fun field13(): Field<LocalDateTime?> = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.THROTTLING_FAILURE_TIMESTAMP
    override fun component1(): Int? = id
    override fun component2(): String? = name
    override fun component3(): Byte? = confirmed
    override fun component4(): String? = key
    override fun component5(): Int? = step
    override fun component6(): Long? = t0
    override fun component7(): Int? = digits
    override fun component8(): Int? = tolerance
    override fun component9(): Short? = drift
    override fun component10(): Long? = lastT
    override fun component11(): Int? = userId
    override fun component12(): Long? = throttlingFailureCount
    override fun component13(): LocalDateTime? = throttlingFailureTimestamp
    override fun value1(): Int? = id
    override fun value2(): String? = name
    override fun value3(): Byte? = confirmed
    override fun value4(): String? = key
    override fun value5(): Int? = step
    override fun value6(): Long? = t0
    override fun value7(): Int? = digits
    override fun value8(): Int? = tolerance
    override fun value9(): Short? = drift
    override fun value10(): Long? = lastT
    override fun value11(): Int? = userId
    override fun value12(): Long? = throttlingFailureCount
    override fun value13(): LocalDateTime? = throttlingFailureTimestamp

    override fun value1(value: Int?): OtpTotpTotpdeviceRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): OtpTotpTotpdeviceRecord {
        this.name = value
        return this
    }

    override fun value3(value: Byte?): OtpTotpTotpdeviceRecord {
        this.confirmed = value
        return this
    }

    override fun value4(value: String?): OtpTotpTotpdeviceRecord {
        this.key = value
        return this
    }

    override fun value5(value: Int?): OtpTotpTotpdeviceRecord {
        this.step = value
        return this
    }

    override fun value6(value: Long?): OtpTotpTotpdeviceRecord {
        this.t0 = value
        return this
    }

    override fun value7(value: Int?): OtpTotpTotpdeviceRecord {
        this.digits = value
        return this
    }

    override fun value8(value: Int?): OtpTotpTotpdeviceRecord {
        this.tolerance = value
        return this
    }

    override fun value9(value: Short?): OtpTotpTotpdeviceRecord {
        this.drift = value
        return this
    }

    override fun value10(value: Long?): OtpTotpTotpdeviceRecord {
        this.lastT = value
        return this
    }

    override fun value11(value: Int?): OtpTotpTotpdeviceRecord {
        this.userId = value
        return this
    }

    override fun value12(value: Long?): OtpTotpTotpdeviceRecord {
        this.throttlingFailureCount = value
        return this
    }

    override fun value13(value: LocalDateTime?): OtpTotpTotpdeviceRecord {
        this.throttlingFailureTimestamp = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: Byte?, value4: String?, value5: Int?, value6: Long?, value7: Int?, value8: Int?, value9: Short?, value10: Long?, value11: Int?, value12: Long?, value13: LocalDateTime?): OtpTotpTotpdeviceRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        this.value10(value10)
        this.value11(value11)
        this.value12(value12)
        this.value13(value13)
        return this
    }

    /**
     * Create a detached, initialised OtpTotpTotpdeviceRecord
     */
    constructor(id: Int? = null, name: String? = null, confirmed: Byte? = null, key: String? = null, step: Int? = null, t0: Long? = null, digits: Int? = null, tolerance: Int? = null, drift: Short? = null, lastT: Long? = null, userId: Int? = null, throttlingFailureCount: Long? = null, throttlingFailureTimestamp: LocalDateTime? = null): this() {
        this.id = id
        this.name = name
        this.confirmed = confirmed
        this.key = key
        this.step = step
        this.t0 = t0
        this.digits = digits
        this.tolerance = tolerance
        this.drift = drift
        this.lastT = lastT
        this.userId = userId
        this.throttlingFailureCount = throttlingFailureCount
        this.throttlingFailureTimestamp = throttlingFailureTimestamp
    }
}
