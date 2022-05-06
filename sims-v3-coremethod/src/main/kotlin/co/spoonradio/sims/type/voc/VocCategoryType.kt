package co.spoonradio.sims.type.voc

/**
 * @author whale@spoonradio.co
 * @date   2021/11/23.
 * @Desc
 */
enum class VocCategoryType(val groupCode:String, val description:String,val descriptionKR:String) {
    VCA01("GR009","Account", "계정"),
    VCA02("GR009","Cashout", "환전"),
    VCA03("GR009","Refund", "환불"),
    VCA04("GR009","Purchase", "결제"),
    VCA05("GR009","GeneralVOC", "일반"),
    VCA06("GR009","Etc", "기타"),
    VCA07("GR009","ServiceFailure", "장애"),
    VCA08("GR009","Report", "신고"),
    VCA09("GR009","Userrequest", "유저요청"),
    VCA10("GR009","Improvement", "개선")
}