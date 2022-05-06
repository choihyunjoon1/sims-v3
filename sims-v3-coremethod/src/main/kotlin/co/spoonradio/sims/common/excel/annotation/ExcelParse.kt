package co.spoonradio.sims.common.excel.annotation

annotation class ExcelParse(
    val fieldName: String,
    val order: Int // constructor 의 순서와 맞는 숫자가 들어가야만 한다
)
