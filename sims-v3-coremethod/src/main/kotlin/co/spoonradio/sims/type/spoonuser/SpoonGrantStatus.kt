package co.spoonradio.sims.type.spoonuser

/**
 * @author whale@spoonradio.co
 * @date   2021/12/08.
 * @Desc
 */
enum class SpoonGrantStatus(val code: Int) {
    BAN(-1),
    NONE(0),
    EXIST(1),
}