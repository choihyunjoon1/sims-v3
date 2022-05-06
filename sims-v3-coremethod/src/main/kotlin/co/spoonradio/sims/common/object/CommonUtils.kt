package co.spoonradio.sims.common.`object`

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author whale@spoonradio.co
 * @date   2021/08/09.
 * @ref https://develop-sense.tistory.com/62
 */

object CommonUtils {
    private const val NAME_REGEX = "(^[가-힣]+)$"
    private const val PHONE_REGEX = "(\\d{2,3})-?(\\d{3,4})-?(\\d{4})$"
    private const val ACCOUNT_REGEX = "(^[0-9]+)$"
    private const val BIRTHDAY_REGEX = "^((19|20)\\d\\d)?([-/.])?(0[1-9]|1[012])([-/.])?(0[1-9]|[12][0-9]|3[01])$"

    fun getPageCount(
        totalCount: Long,
        pageSize: Int
    ): Long {
        return if (totalCount.toInt().rem(pageSize) == 0)
            totalCount / pageSize
        else
            (totalCount / pageSize) + 1
    }

    fun getResponseExtraData(totalCount: Long, base: RequestBaseDto): ExtraDataEntity {
        return ExtraDataEntity(
            getPageCount(
                totalCount, base.page_size
            ), totalCount
        )
    }

    fun generateUUID(): String {
        return UUID.randomUUID().toString().replace("-", "")
    }

    /** EMAIL 마스킹 */
    fun emailMasking(email: String): String {
        val emailSplit = email.split("@")

        if (emailSplit[0].length <= 3) return email

        var START_INDEX = 3
        val END_INDEX = emailSplit[0].length - 1
        if (END_INDEX == START_INDEX) START_INDEX = START_INDEX - 1
        val replacementString = StringBuilder("")
        for (i in START_INDEX..END_INDEX) replacementString.append("*")
        return email.replaceRange(START_INDEX..END_INDEX, replacementString)
    }

    /** 이름 마스킹 */
    fun nameMasking(name: String): String {
        val matcher: Matcher = Pattern.compile(NAME_REGEX).matcher(name)
        if (matcher.find()) {
            val length = name.length
            val middleMask:String
            middleMask = if (length > 2) name.substring(1, length - 1)
            else    // 이름이 외자
                name.substring(1, length)

            var dot = ""
            for (i in 0 until middleMask.length) dot += "*"

            return if (length > 2)
                (name.substring(0, 1) + middleMask.replace(middleMask, dot) + name.substring(length - 1, length))
            else  // 이름이 외자 마스킹 리턴
                (name.substring(0, 1) + middleMask.replace(middleMask, dot))

        }
        return name
    }

    /** 휴대폰 마스킹 */
    fun phoneMasking(phoneNo: String): String {
        val matcher = Pattern.compile(PHONE_REGEX).matcher(phoneNo)
        if (matcher.find()) {
            val target = matcher.group(2)
            val length = target.length
            val c = CharArray(length)
            Arrays.fill(c, '*')
            return phoneNo.replace(target, String(c))
        }
        return phoneNo
    }


    fun accountNoMasking(accountNo: String): String {
        val matcher = Pattern.compile(ACCOUNT_REGEX).matcher(accountNo)
        if (matcher.find()) {
            val length = accountNo.length
            if (length > 5) {
                val c = CharArray(5)
                Arrays.fill(c, '*')
                return accountNo.replace(accountNo, accountNo.substring(0, length - 5) + String(c))
            }
        }
        return accountNo
    }
    fun residentFirstNumberMasking(residentFirstNumber: String): String {
        val matcher = Pattern.compile(ACCOUNT_REGEX).matcher(residentFirstNumber)
        if (matcher.find()) {
            val length = residentFirstNumber.length
            if (length > 1) {
                val c = CharArray(2)
                Arrays.fill(c, '*')
                return residentFirstNumber.replace(residentFirstNumber, residentFirstNumber.substring(0, length - 2) + String(c))
            }
        }
        return residentFirstNumber
    }

    fun residentLastNumberMasking(residentLastNumber: String) : String {
        val c = CharArray(residentLastNumber.length)
        Arrays.fill(c, '*')
        return residentLastNumber.replace(residentLastNumber, String(c) )
    }

    fun birthdayMasking(birthDay: String) : String {
        val matcher = Pattern.compile(BIRTHDAY_REGEX).matcher(birthDay)
        if (matcher.find()) {
            val c = CharArray(2)
            Arrays.fill(c, '*')
            return birthDay.replace(birthDay, birthDay.substring(0, birthDay.length - 2) + String(c))
        }
        return birthDay
    }


}