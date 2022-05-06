package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class DotMoneyGiftCodeGenerationLogDownload (
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("code_id", "코드 번호") val codeId: Long,
    @field:ExcelColumn("transaction_id", "트랜잭션 ID") val transactionId: String,
    @field:ExcelColumn("dotmoney_amount", "닷머니 포인트") val dotmoneyAmount: Int,
    @field:ExcelColumn("spoon_amount", "스푼 수량") val spoonAmount: Int,
    @field:ExcelColumn("created", "생성일") val created: String,
)