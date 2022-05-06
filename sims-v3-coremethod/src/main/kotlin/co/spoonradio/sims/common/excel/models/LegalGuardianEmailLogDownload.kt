package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn


data class LegalGuardianEmailLogDownload(
    @field:ExcelColumn("updated", "발송일") val updated: String,
    @field:ExcelColumn("user.id", "결제유저번호") val userId: Long,
    @field:ExcelColumn("user.tag", "결제유저태그") val userTag: String,
    @field:ExcelColumn("user.nickname", "결제유저닉네임") val userNickname: String,
    @field:ExcelColumn("niceInfo.name", "결제자이름") val niceInfoName: String,
    @field:ExcelColumn("niceInfo.gender", "결제자성별") val niceInfoGender: String,
    @field:ExcelColumn("niceInfo.birth_date", "결제자 생년월일") val niceInfoBirthDate: String,
    @field:ExcelColumn("niceInfo.age", "결제자나이") val niceInfoAge: Int,
    @field:ExcelColumn("niceInfo.nation_info", "결제자국적") val niceInfoNationInfo: String,
    @field:ExcelColumn("niceInfo.auth_type", "결제자인증방법") val niceInfoAuthType: String,
    @field:ExcelColumn("niceInfo.created", "결제자인증완료일자") val niceInfoCreated: String,
    @field:ExcelColumn("amount", "구매금액") val amount: Int,
    @field:ExcelColumn("paymentMethod", "결제수단") val paymentMethod: String,
    @field:ExcelColumn("completedDate", "결제완료일") val completedDate: String,
    @field:ExcelColumn("email", "대리인이메일") val email: String,
    @field:ExcelColumn("parentNiceInfo.name", "대리인이름") val parentNiceInfoName: String,
    @field:ExcelColumn("parentNiceInfo.gender", "대리인성별") val parentNiceInfoGender: String,
    @field:ExcelColumn("parentNiceInfo.birth_date", "대리인생년월일") val parentNiceInfoBirthDate: String,
    @field:ExcelColumn("parentNiceInfo.age", "대리인나이") val parentNiceInfoAge: String,
    @field:ExcelColumn("parentNiceInfo.nation_info", "대리인국적") val parentNiceInfoNationInfo: String,
    @field:ExcelColumn("parentNiceInfo.auth_type", "대리인인증방법") val parentNiceInfoAuthType: String,
    @field:ExcelColumn("parentNiceInfo.created", "대리인인증완료일") val parentNiceInfoCreated: String,
    @field:ExcelColumn("status", "발송여부") val status: String
)
