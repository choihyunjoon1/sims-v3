package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class GiftCodeGenerationLogDownload (
    @field:ExcelColumn("code", "기프트 코드") val code: String,
    @field:ExcelColumn("code_type", "코드 종류") val codeType: String,
    @field:ExcelColumn("spoon_amount", "스푼 수량") val spoonAmount: String,
    @field:ExcelColumn("quantity", "아이템 수") val quantity: Int,
    @field:ExcelColumn("issue_type", "코드 발행처") val issueType: String,
    @field:ExcelColumn("status", "코드 상태") val status: String,
    @field:ExcelColumn("created", "생성일") val created: String,
    @field:ExcelColumn("expiry_date", "만료일") val expiryDate: String )