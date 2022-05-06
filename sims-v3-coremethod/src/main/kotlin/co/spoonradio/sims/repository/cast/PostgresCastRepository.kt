package co.spoonradio.sims.repository.cast

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
interface PostgresCastRepository {
    fun decreaseTextCommentCount(authorId:Int)
    fun increseTextCommentCount(authorId:Int)
}