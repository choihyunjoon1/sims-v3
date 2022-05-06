package co.spoonradio.sims.type.voc

/**
 * @author whale@spoonradio.co
 * @date   2021/11/23.
 * @Desc 상담일지 접수경로
 */
enum class VocChannelType(val groupCode:String, val path:String) {
    VCH01("GR007", "zendesk"),
    VCH02("GR007", "sns"),
    VCH03("GR007", "app review"),
    VCH04("GR007", "email"),
    VCH05("GR007", "phone"),
    VCH06("GR007", "모니터링"),
    VCH07("GR007", "support")
}