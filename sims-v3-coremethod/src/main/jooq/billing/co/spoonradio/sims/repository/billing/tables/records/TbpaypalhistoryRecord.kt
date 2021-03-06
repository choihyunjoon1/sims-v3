/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.tables.records


import co.spoonradio.sims.repository.billing.tables.Tbpaypalhistory

import java.time.LocalDateTime

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TbpaypalhistoryRecord() : UpdatableRecordImpl<TbpaypalhistoryRecord>(Tbpaypalhistory.TBPAYPALHISTORY) {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var txid: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var quantity: Int?
        set(value) = set(2, value)
        get() = get(2) as Int?

    var status: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var useragent: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var updated: LocalDateTime?
        set(value) = set(5, value)
        get() = get(5) as LocalDateTime?

    var completed: LocalDateTime?
        set(value) = set(6, value)
        get() = get(6) as LocalDateTime?

    var created: LocalDateTime?
        set(value) = set(7, value)
        get() = get(7) as LocalDateTime?

    var errormessage: String?
        set(value) = set(8, value)
        get() = get(8) as String?

    var amount: Double?
        set(value) = set(9, value)
        get() = get(9) as Double?

    var itemname: String?
        set(value) = set(10, value)
        get() = get(10) as String?

    var countrycode: String?
        set(value) = set(11, value)
        get() = get(11) as String?

    var detailcountrycode: String?
        set(value) = set(12, value)
        get() = get(12) as String?

    var linkcapture: String?
        set(value) = set(13, value)
        get() = get(13) as String?

    var linkapprove: String?
        set(value) = set(14, value)
        get() = get(14) as String?

    var payerid: String?
        set(value) = set(15, value)
        get() = get(15) as String?

    var grossamount: Double?
        set(value) = set(16, value)
        get() = get(16) as Double?

    var feesamount: Double?
        set(value) = set(17, value)
        get() = get(17) as Double?

    var netamount: Double?
        set(value) = set(18, value)
        get() = get(18) as Double?

    var productid: Int?
        set(value) = set(19, value)
        get() = get(19) as Int?

    var promotionid: Int?
        set(value) = set(20, value)
        get() = get(20) as Int?

    var userid: Int?
        set(value) = set(21, value)
        get() = get(21) as Int?

    var paymentstatus: String?
        set(value) = set(22, value)
        get() = get(22) as String?

    var currency: String?
        set(value) = set(23, value)
        get() = get(23) as String?

    var paypalcaptureid: String?
        set(value) = set(24, value)
        get() = get(24) as String?

    var orderid: String?
        set(value) = set(25, value)
        get() = get(25) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    /**
     * Create a detached, initialised TbpaypalhistoryRecord
     */
    constructor(id: Int? = null, txid: String? = null, quantity: Int? = null, status: String? = null, useragent: String? = null, updated: LocalDateTime? = null, completed: LocalDateTime? = null, created: LocalDateTime? = null, errormessage: String? = null, amount: Double? = null, itemname: String? = null, countrycode: String? = null, detailcountrycode: String? = null, linkcapture: String? = null, linkapprove: String? = null, payerid: String? = null, grossamount: Double? = null, feesamount: Double? = null, netamount: Double? = null, productid: Int? = null, promotionid: Int? = null, userid: Int? = null, paymentstatus: String? = null, currency: String? = null, paypalcaptureid: String? = null, orderid: String? = null): this() {
        this.id = id
        this.txid = txid
        this.quantity = quantity
        this.status = status
        this.useragent = useragent
        this.updated = updated
        this.completed = completed
        this.created = created
        this.errormessage = errormessage
        this.amount = amount
        this.itemname = itemname
        this.countrycode = countrycode
        this.detailcountrycode = detailcountrycode
        this.linkcapture = linkcapture
        this.linkapprove = linkapprove
        this.payerid = payerid
        this.grossamount = grossamount
        this.feesamount = feesamount
        this.netamount = netamount
        this.productid = productid
        this.promotionid = promotionid
        this.userid = userid
        this.paymentstatus = paymentstatus
        this.currency = currency
        this.paypalcaptureid = paypalcaptureid
        this.orderid = orderid
    }
}
