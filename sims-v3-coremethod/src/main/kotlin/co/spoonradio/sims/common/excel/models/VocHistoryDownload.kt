package co.spoonradio.sims.common.excel.models

import co.spoonradio.sims.common.excel.annotation.ExcelColumn

data class VocHistoryDownload(
    @field:ExcelColumn("voc_hist_id", "번호",) val vocHistId: Long,
    @field:ExcelColumn("member_user_username", "담당자 유저 이메일",) val memberUserUsername: String,
    @field:ExcelColumn("spoon_user_id", "스푼 유저 번호",) val spoonUserId: Long,
    @field:ExcelColumn("spoon_user_nickname", "스푼 유저 닉네임",) val spoonUserNickname: String,
    @field:ExcelColumn("status_cd", "처리 상태",) val statusCd: String,
    @field:ExcelColumn("register_type_cd", "가입 형태",) val registerTypeCd: String,
    @field:ExcelColumn("bound_type_cd", "문의 유형",) val boundTypeCd: String,
    @field:ExcelColumn("criticality_type_cd", "상담 구분",) val criticalityTypeCd: String,
    @field:ExcelColumn("channel_cd", "채널 유형",) val channelCd: String,
    @field:ExcelColumn("type_cd", "상담 타입",) val typeCd: String,
    @field:ExcelColumn("category_cd", "대분류",) val categoryCd: String,
    @field:ExcelColumn("division_cd", "중분류",) val divisionCd: String,
    @field:ExcelColumn("section_cd", "소분류",) val sectionCd: String,
    @field:ExcelColumn("comment", "문의 내용",) val comment: String,
    @field:ExcelColumn("reply", "처리 내용",) val reply: String,
    @field:ExcelColumn("reply_user_username", "처리자 이메일",) val replyUserUsername: String,
    @field:ExcelColumn("create_dt", "생성 날짜") val createDt: String
)

