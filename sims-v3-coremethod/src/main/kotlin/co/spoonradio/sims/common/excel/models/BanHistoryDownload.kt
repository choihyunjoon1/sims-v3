package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class BanHistoryDownload (
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("nickname", "닉네임") val nickname: String,
    @field:ExcelColumn("tag", "태그") val tag: String,
    @field:ExcelColumn("user_id", "유저번호") val userId: Long,
    @field:ExcelColumn("ban_status", "제재 상태") val banStatus: String,
    @field:ExcelColumn("remain_time", "잔여시간") val remainTime: String,
    @field:ExcelColumn("category_main_id", "대분류") val categoryMainId: Long,
    @field:ExcelColumn("category_sub_id", "중분류") val categorySubId: Long,
    @field:ExcelColumn("detail", "제재 상세 내용") val detail: String,
    @field:ExcelColumn("memo", "메모") val memo: String,
    @field:ExcelColumn("device_unique_id", "디바이스고유값") val deviceUniqueId: String,
    @field:ExcelColumn("end_date", "종료일") val endDate: String,
    @field:ExcelColumn("created", "생성일") val created: String,
)