package co.spoonradio.sims.type.spoonuser

/**
 * @author whale@spoonradio.co
 * @date   2021/11/30.
 * @Desc
 */
enum class SpoonUserStatus(val code:Int) {
    BANNED (-9),
    SIGNUP_PND(-3),
    LEAVED(-2) ,
    DORMANT(-1) ,
    LOGOUT( 0),
    LOGIN( 1);
}