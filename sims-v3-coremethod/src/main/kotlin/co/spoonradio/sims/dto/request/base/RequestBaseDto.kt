package co.spoonradio.sims.dto.request.base

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.time.temporal.TemporalAdjusters.firstDayOfMonth
import java.time.temporal.TemporalAdjusters.lastDayOfMonth

/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */
data class RequestBaseDto(
    var page: Int = 0,
    var page_size: Int = 20,
    var from_date: String? = null,
    var to_date: String? = null,
    var field: String? = null,
    var value: String? = null,
){
    fun isNullOrBlankForDate():Boolean{
        return (from_date.isNullOrBlank() || to_date.isNullOrBlank())
    }
}
