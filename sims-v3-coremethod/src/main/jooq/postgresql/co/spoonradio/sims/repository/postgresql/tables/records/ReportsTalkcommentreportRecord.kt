/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.postgresql.tables.records


import co.spoonradio.sims.repository.postgresql.tables.ReportsTalkcommentreport

import java.time.LocalDate

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record11
import org.jooq.Row11
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ReportsTalkcommentreportRecord() : UpdatableRecordImpl<ReportsTalkcommentreportRecord>(ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT), Record11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var reporter: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var reported: LocalDate?
        set(value) = set(2, value)
        get() = get(2) as LocalDate?

    var talk: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var talkAuthor: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var talkCreated: LocalDate?
        set(value) = set(5, value)
        get() = get(5) as LocalDate?

    var commentAuthor: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var commentUrl: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var commentCreated: LocalDate?
        set(value) = set(8, value)
        get() = get(8) as LocalDate?

    var reportDescr: String?
        set(value) = set(9, value)
        get() = get(9) as String?

    var reportType: Int?
        set(value) = set(10, value)
        get() = get(10) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?> = super.fieldsRow() as Row11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?>
    override fun valuesRow(): Row11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?> = super.valuesRow() as Row11<Int?, String?, LocalDate?, String?, String?, LocalDate?, String?, String?, LocalDate?, String?, Int?>
    override fun field1(): Field<Int?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.ID
    override fun field2(): Field<String?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.REPORTER
    override fun field3(): Field<LocalDate?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.REPORTED
    override fun field4(): Field<String?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.TALK
    override fun field5(): Field<String?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.TALK_AUTHOR
    override fun field6(): Field<LocalDate?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.TALK_CREATED
    override fun field7(): Field<String?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.COMMENT_AUTHOR
    override fun field8(): Field<String?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.COMMENT_URL
    override fun field9(): Field<LocalDate?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.COMMENT_CREATED
    override fun field10(): Field<String?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.REPORT_DESCR
    override fun field11(): Field<Int?> = ReportsTalkcommentreport.REPORTS_TALKCOMMENTREPORT.REPORT_TYPE
    override fun component1(): Int? = id
    override fun component2(): String? = reporter
    override fun component3(): LocalDate? = reported
    override fun component4(): String? = talk
    override fun component5(): String? = talkAuthor
    override fun component6(): LocalDate? = talkCreated
    override fun component7(): String? = commentAuthor
    override fun component8(): String? = commentUrl
    override fun component9(): LocalDate? = commentCreated
    override fun component10(): String? = reportDescr
    override fun component11(): Int? = reportType
    override fun value1(): Int? = id
    override fun value2(): String? = reporter
    override fun value3(): LocalDate? = reported
    override fun value4(): String? = talk
    override fun value5(): String? = talkAuthor
    override fun value6(): LocalDate? = talkCreated
    override fun value7(): String? = commentAuthor
    override fun value8(): String? = commentUrl
    override fun value9(): LocalDate? = commentCreated
    override fun value10(): String? = reportDescr
    override fun value11(): Int? = reportType

    override fun value1(value: Int?): ReportsTalkcommentreportRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): ReportsTalkcommentreportRecord {
        this.reporter = value
        return this
    }

    override fun value3(value: LocalDate?): ReportsTalkcommentreportRecord {
        this.reported = value
        return this
    }

    override fun value4(value: String?): ReportsTalkcommentreportRecord {
        this.talk = value
        return this
    }

    override fun value5(value: String?): ReportsTalkcommentreportRecord {
        this.talkAuthor = value
        return this
    }

    override fun value6(value: LocalDate?): ReportsTalkcommentreportRecord {
        this.talkCreated = value
        return this
    }

    override fun value7(value: String?): ReportsTalkcommentreportRecord {
        this.commentAuthor = value
        return this
    }

    override fun value8(value: String?): ReportsTalkcommentreportRecord {
        this.commentUrl = value
        return this
    }

    override fun value9(value: LocalDate?): ReportsTalkcommentreportRecord {
        this.commentCreated = value
        return this
    }

    override fun value10(value: String?): ReportsTalkcommentreportRecord {
        this.reportDescr = value
        return this
    }

    override fun value11(value: Int?): ReportsTalkcommentreportRecord {
        this.reportType = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: LocalDate?, value4: String?, value5: String?, value6: LocalDate?, value7: String?, value8: String?, value9: LocalDate?, value10: String?, value11: Int?): ReportsTalkcommentreportRecord {
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
        return this
    }

    /**
     * Create a detached, initialised ReportsTalkcommentreportRecord
     */
    constructor(id: Int? = null, reporter: String? = null, reported: LocalDate? = null, talk: String? = null, talkAuthor: String? = null, talkCreated: LocalDate? = null, commentAuthor: String? = null, commentUrl: String? = null, commentCreated: LocalDate? = null, reportDescr: String? = null, reportType: Int? = null): this() {
        this.id = id
        this.reporter = reporter
        this.reported = reported
        this.talk = talk
        this.talkAuthor = talkAuthor
        this.talkCreated = talkCreated
        this.commentAuthor = commentAuthor
        this.commentUrl = commentUrl
        this.commentCreated = commentCreated
        this.reportDescr = reportDescr
        this.reportType = reportType
    }
}