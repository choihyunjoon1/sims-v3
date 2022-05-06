package co.spoonradio.sims.common.extension

import co.spoonradio.arch.extension.defaultZoneId
import co.spoonradio.sims.common.`object`.CommonUtils
import org.apache.poi.ss.formula.functions.T
import org.jooq.Converter
import org.jooq.Field
import org.jooq.impl.SQLDataType
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * @author whale@spoonradio.co
 * @date   2021/12/15.
 * @Desc
 */
val localDateTimeToZonedDateTime: Converter<LocalDateTime, ZonedDateTime> = Converter.ofNullable(
    LocalDateTime::class.java,
    ZonedDateTime::class.java,
    { it.atZone(ZoneId.systemDefault()).withZoneSameInstant(defaultZoneId) },
    ZonedDateTime::toLocalDateTime
)

val <T> Field<T>.zonedDateTime get() = cast(SQLDataType.LOCALDATETIME.asConvertedDataType(localDateTimeToZonedDateTime))
val String.emailMasking get() = CommonUtils.emailMasking(this)
val String.phoneNumMasking get() = CommonUtils.phoneMasking(this)
val String.residentFirstNumberMasking get() = CommonUtils.residentFirstNumberMasking(this)
val String.residentLastNumberMasking get() = CommonUtils.residentLastNumberMasking(this)
val String.accountNumberMasking get() = CommonUtils.accountNoMasking(this)
val String.nameMasking get() = CommonUtils.nameMasking(this)
val String.birthdayMasking get() = CommonUtils.birthdayMasking(this)
