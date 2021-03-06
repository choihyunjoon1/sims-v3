/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbpromotionhistory

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record5
import org.jooq.Row5
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbpromotionhistoryRecord() : UpdatableRecordImpl<TbpromotionhistoryRecord>(Tbpromotionhistory.TBPROMOTIONHISTORY), Record5<Long?, Int?, String?, String?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var promotionid: Int?
        set(value) = set(1, value)
        get() = get(1) as Int?

    var orderid: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var txid: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var createddate: LocalDateTime?
        set(value) = set(4, value)
        get() = get(4) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row5<Long?, Int?, String?, String?, LocalDateTime?> = super.fieldsRow() as Row5<Long?, Int?, String?, String?, LocalDateTime?>
    override fun valuesRow(): Row5<Long?, Int?, String?, String?, LocalDateTime?> = super.valuesRow() as Row5<Long?, Int?, String?, String?, LocalDateTime?>
    override fun field1(): Field<Long?> = Tbpromotionhistory.TBPROMOTIONHISTORY.ID
    override fun field2(): Field<Int?> = Tbpromotionhistory.TBPROMOTIONHISTORY.PROMOTIONID
    override fun field3(): Field<String?> = Tbpromotionhistory.TBPROMOTIONHISTORY.ORDERID
    override fun field4(): Field<String?> = Tbpromotionhistory.TBPROMOTIONHISTORY.TXID
    override fun field5(): Field<LocalDateTime?> = Tbpromotionhistory.TBPROMOTIONHISTORY.CREATEDDATE
    override fun component1(): Long? = id
    override fun component2(): Int? = promotionid
    override fun component3(): String? = orderid
    override fun component4(): String? = txid
    override fun component5(): LocalDateTime? = createddate
    override fun value1(): Long? = id
    override fun value2(): Int? = promotionid
    override fun value3(): String? = orderid
    override fun value4(): String? = txid
    override fun value5(): LocalDateTime? = createddate

    override fun value1(value: Long?): TbpromotionhistoryRecord {
        this.id = value
        return this
    }

    override fun value2(value: Int?): TbpromotionhistoryRecord {
        this.promotionid = value
        return this
    }

    override fun value3(value: String?): TbpromotionhistoryRecord {
        this.orderid = value
        return this
    }

    override fun value4(value: String?): TbpromotionhistoryRecord {
        this.txid = value
        return this
    }

    override fun value5(value: LocalDateTime?): TbpromotionhistoryRecord {
        this.createddate = value
        return this
    }

    override fun values(value1: Long?, value2: Int?, value3: String?, value4: String?, value5: LocalDateTime?): TbpromotionhistoryRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        return this
    }

    /**
     * Create a detached, initialised TbpromotionhistoryRecord
     */
    constructor(id: Long? = null, promotionid: Int? = null, orderid: String? = null, txid: String? = null, createddate: LocalDateTime? = null): this() {
        this.id = id
        this.promotionid = promotionid
        this.orderid = orderid
        this.txid = txid
        this.createddate = createddate
    }
}
