package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn


// 라이브 좋아요 이력 다운로드
data class LiveLikeDownload(
    @field:ExcelColumn("id", "번호") val id: Long,
    @field:ExcelColumn("live_id", "라이브 번호") val liveId: Long,
    @field:ExcelColumn("live_title", "라이브 명") val liveTitle: String,
    @field:ExcelColumn("nickname", "닉네임") val nickname: String,
    @field:ExcelColumn("tag", "유저 태그") val tag: String,
    @field:ExcelColumn("count", "Like 후원 수") val count: Int,
    @field:ExcelColumn("status", "Like 후원 결과") val status: String,
    @field:ExcelColumn("price", "단가") val price: String,
    @field:ExcelColumn("created", "후원 일자") val created: String,
)