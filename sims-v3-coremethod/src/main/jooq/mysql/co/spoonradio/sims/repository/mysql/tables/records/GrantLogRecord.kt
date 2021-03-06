/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.records


import co.spoonradio.sims.repository.mysql.tables.GrantLog

import java.time.LocalDateTime

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class GrantLogRecord() : UpdatableRecordImpl<GrantLogRecord>(GrantLog.GRANT_LOG) {

    var grantLogId: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var accessIp: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var mainMenuId: Int?
        set(value) = set(2, value)
        get() = get(2) as Int?

    var mainMenuName: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var subMenuId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var subMenuName: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var grantUserId: Int?
        set(value) = set(6, value)
        get() = get(6) as Int?

    var grantUserName: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var granteeUserId: Int?
        set(value) = set(8, value)
        get() = get(8) as Int?

    var granteeUserName: String?
        set(value) = set(9, value)
        get() = get(9) as String?

    var grantBefore: String?
        set(value) = set(10, value)
        get() = get(10) as String?

    var grantAfter: String?
        set(value) = set(11, value)
        get() = get(11) as String?

    var grantToApply: String?
        set(value) = set(12, value)
        get() = get(12) as String?

    var grantStatus: String?
        set(value) = set(13, value)
        get() = get(13) as String?

    var grantType: String?
        set(value) = set(14, value)
        get() = get(14) as String?

    var createDt: LocalDateTime?
        set(value) = set(15, value)
        get() = get(15) as LocalDateTime?

    var grantUserEmail: String?
        set(value) = set(16, value)
        get() = get(16) as String?

    var granteeUserEmail: String?
        set(value) = set(17, value)
        get() = get(17) as String?

    var grantUserGrpCd: String?
        set(value) = set(18, value)
        get() = get(18) as String?

    var granteeUserGrpCd: String?
        set(value) = set(19, value)
        get() = get(19) as String?

    var enMainMenuName: String?
        set(value) = set(20, value)
        get() = get(20) as String?

    var enSubMenuName: String?
        set(value) = set(21, value)
        get() = get(21) as String?

    var grantUserAuthCd: String?
        set(value) = set(22, value)
        get() = get(22) as String?

    var granteeUserAuthCd: String?
        set(value) = set(23, value)
        get() = get(23) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    /**
     * Create a detached, initialised GrantLogRecord
     */
    constructor(grantLogId: Int? = null, accessIp: String? = null, mainMenuId: Int? = null, mainMenuName: String? = null, subMenuId: Int? = null, subMenuName: String? = null, grantUserId: Int? = null, grantUserName: String? = null, granteeUserId: Int? = null, granteeUserName: String? = null, grantBefore: String? = null, grantAfter: String? = null, grantToApply: String? = null, grantStatus: String? = null, grantType: String? = null, createDt: LocalDateTime? = null, grantUserEmail: String? = null, granteeUserEmail: String? = null, grantUserGrpCd: String? = null, granteeUserGrpCd: String? = null, enMainMenuName: String? = null, enSubMenuName: String? = null, grantUserAuthCd: String? = null, granteeUserAuthCd: String? = null): this() {
        this.grantLogId = grantLogId
        this.accessIp = accessIp
        this.mainMenuId = mainMenuId
        this.mainMenuName = mainMenuName
        this.subMenuId = subMenuId
        this.subMenuName = subMenuName
        this.grantUserId = grantUserId
        this.grantUserName = grantUserName
        this.granteeUserId = granteeUserId
        this.granteeUserName = granteeUserName
        this.grantBefore = grantBefore
        this.grantAfter = grantAfter
        this.grantToApply = grantToApply
        this.grantStatus = grantStatus
        this.grantType = grantType
        this.createDt = createDt
        this.grantUserEmail = grantUserEmail
        this.granteeUserEmail = granteeUserEmail
        this.grantUserGrpCd = grantUserGrpCd
        this.granteeUserGrpCd = granteeUserGrpCd
        this.enMainMenuName = enMainMenuName
        this.enSubMenuName = enSubMenuName
        this.grantUserAuthCd = grantUserAuthCd
        this.granteeUserAuthCd = granteeUserAuthCd
    }
}
