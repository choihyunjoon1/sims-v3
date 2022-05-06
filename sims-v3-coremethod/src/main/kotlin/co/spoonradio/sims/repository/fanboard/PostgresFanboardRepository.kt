package co.spoonradio.sims.repository.fanboard

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
interface PostgresFanboardRepository {
    fun decreaseMessageCount(authorId:Int)
    fun increseMessageCount(authorId:Int)
}