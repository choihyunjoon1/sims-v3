package co.spoonradio.sims.repository.condition

import co.spoonradio.arch.extension.defaultZoneId
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import org.jooq.Condition
import org.jooq.Converter
import org.jooq.Record
import org.jooq.TableField
import org.jooq.impl.DSL
import java.time.*

/**
 * @author whale@spoonradio.co
 * @date   2021/11/22.
 * @Desc
 */
open class CommonCondition {

    companion object {
        val localDateTimeToZonedDateTime: Converter<LocalDateTime, ZonedDateTime> = Converter.ofNullable(
            LocalDateTime::class.java,
            ZonedDateTime::class.java,
            { it.atZone(ZoneId.systemDefault()).withZoneSameInstant(defaultZoneId) },
            ZonedDateTime::toLocalDateTime
        )
    }


    fun getOffset(page: Int, size: Int) = if (page != 0) (page - 1) * size else 0
    fun getLimitCondition(size: Int) = if (size == 0) Int.MAX_VALUE else size

    inline fun <reified T : Record?, reified E> getDateConditional(
        anyDate: TableField<T, E>,
        base: RequestBaseDto
    ): Condition {
        if (base.isNullOrBlankForDate()) return DSL.noCondition()
        return when (E::class) {
            LocalDate::class -> {
                anyDate.between(
                    LocalDate.parse(base.from_date).atStartOfDay(defaultZoneId).toLocalDate() as E
                ).and(LocalDate.parse(base.to_date).atStartOfDay(defaultZoneId).toLocalDate() as E)
            }
            LocalDateTime::class -> {
                anyDate.between(
                    LocalDate.parse(base.from_date).atStartOfDay(defaultZoneId).toLocalDateTime() as E
                ).and(LocalDate.parse(base.to_date).atStartOfDay(defaultZoneId).plusDays(1).toLocalDateTime() as E)
            }
            OffsetDateTime::class -> {
                anyDate.between(
                    LocalDate.parse(base.from_date).atStartOfDay(defaultZoneId).toOffsetDateTime() as E
                ).and(LocalDate.parse(base.to_date).atStartOfDay(defaultZoneId).plusDays(1).toOffsetDateTime() as E)
            }
            else -> {
                DSL.noCondition()
            }
        }
    }

}