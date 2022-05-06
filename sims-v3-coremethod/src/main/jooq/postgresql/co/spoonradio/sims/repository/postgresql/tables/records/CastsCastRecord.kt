/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.records


import co.spoonradio.sims.repository.postgresql.tables.CastsCast

import java.time.OffsetDateTime

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CastsCastRecord() : UpdatableRecordImpl<CastsCastRecord>(CastsCast.CASTS_CAST) {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var title: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var interest: Int?
        set(value) = set(2, value)
        get() = get(2) as Int?

    var tags: Array<Any?>?
        set(value) = set(3, value)
        get() = get(3) as Array<Any?>?

    var imgKey: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var imgUrl: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var voiceKey: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var voiceUrl: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var duration: Double?
        set(value) = set(8, value)
        get() = get(8) as Double?

    var likeCount: Int?
        set(value) = set(9, value)
        get() = get(9) as Int?

    var playCount: Int?
        set(value) = set(10, value)
        get() = get(10) as Int?

    var playRealCount: Int?
        set(value) = set(11, value)
        get() = get(11) as Int?

    var voiceCommentCount: Int?
        set(value) = set(12, value)
        get() = get(12) as Int?

    var textCommentCount: Int?
        set(value) = set(13, value)
        get() = get(13) as Int?

    var reporters: Array<Any?>?
        set(value) = set(14, value)
        get() = get(14) as Array<Any?>?

    var updated: OffsetDateTime?
        set(value) = set(15, value)
        get() = get(15) as OffsetDateTime?

    var created: OffsetDateTime?
        set(value) = set(16, value)
        get() = get(16) as OffsetDateTime?

    var authorId: Int?
        set(value) = set(17, value)
        get() = get(17) as Int?

    var companyId: Int?
        set(value) = set(18, value)
        get() = get(18) as Int?

    var blockUsers: Array<Any?>?
        set(value) = set(19, value)
        get() = get(19) as Array<Any?>?

    var isDonated: Boolean?
        set(value) = set(20, value)
        get() = get(20) as Boolean?

    var spoonCount: Int?
        set(value) = set(21, value)
        get() = get(21) as Int?

    var status: Int?
        set(value) = set(22, value)
        get() = get(22) as Int?

    var type: Int?
        set(value) = set(23, value)
        get() = get(23) as Int?

    var category: String?
        set(value) = set(24, value)
        get() = get(24) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    /**
     * Create a detached, initialised CastsCastRecord
     */
    constructor(id: Int? = null, title: String? = null, interest: Int? = null, tags: Array<Any?>? = null, imgKey: String? = null, imgUrl: String? = null, voiceKey: String? = null, voiceUrl: String? = null, duration: Double? = null, likeCount: Int? = null, playCount: Int? = null, playRealCount: Int? = null, voiceCommentCount: Int? = null, textCommentCount: Int? = null, reporters: Array<Any?>? = null, updated: OffsetDateTime? = null, created: OffsetDateTime? = null, authorId: Int? = null, companyId: Int? = null, blockUsers: Array<Any?>? = null, isDonated: Boolean? = null, spoonCount: Int? = null, status: Int? = null, type: Int? = null, category: String? = null): this() {
        this.id = id
        this.title = title
        this.interest = interest
        this.tags = tags
        this.imgKey = imgKey
        this.imgUrl = imgUrl
        this.voiceKey = voiceKey
        this.voiceUrl = voiceUrl
        this.duration = duration
        this.likeCount = likeCount
        this.playCount = playCount
        this.playRealCount = playRealCount
        this.voiceCommentCount = voiceCommentCount
        this.textCommentCount = textCommentCount
        this.reporters = reporters
        this.updated = updated
        this.created = created
        this.authorId = authorId
        this.companyId = companyId
        this.blockUsers = blockUsers
        this.isDonated = isDonated
        this.spoonCount = spoonCount
        this.status = status
        this.type = type
        this.category = category
    }
}
