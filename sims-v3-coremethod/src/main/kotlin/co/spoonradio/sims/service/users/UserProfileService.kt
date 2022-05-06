package co.spoonradio.sims.service.users

/**
 * @author whale@spoonradio.co
 * @date   2021/11/26.
 * @Desc
 */
interface UserProfileService {
    fun findUserIdByTag(tag:String):Int?
    fun findUserIdByNickname(nickname:String):List<Int>
}