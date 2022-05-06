package co.spoonradio.sims.type.event

/**
 * @author whale@spoonradio.co
 * @date   2021/12/08.
 * @Desc
 */
enum class EventType(val syncEventname:String) {
    CREATED("BAN"),
    DELETED("RELEAE_BAN")
}