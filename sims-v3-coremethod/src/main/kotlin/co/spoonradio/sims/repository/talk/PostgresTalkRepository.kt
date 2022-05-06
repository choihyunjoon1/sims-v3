package co.spoonradio.sims.repository.talk

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
interface PostgresTalkRepository {
    fun decreaseVoiceCommentCount(authorId:Int)
    fun increseVoiceCommentCount(authorId:Int)
}