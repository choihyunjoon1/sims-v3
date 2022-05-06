package co.spoonradio.sims.type.voc

/**
 * @author whale@spoonradio.co
 * @date   2021/11/23.
 * @Desc
 */
enum class VocType(val groupCode:String, val description:String,val descriptionKR:String) {
    VTY01("GR008","General","일반"),
    VTY02("GR008","ServiceFailure","장애"),
    VTY03("GR008","Report","신고"),
    VTY04("GR008","Improvement","개선"),
    VTY05("GR008","Dissatisfaction","불만"),
    VTY06("GR008","BalckConsumer","강성"),
    VTY07("GR008","UserㄱRequest","유저요청")
}