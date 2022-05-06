package co.spoonradio.sims.repository.users

import co.spoonradio.sims.dto.response.users.UserProfileEntity
import co.spoonradio.sims.dto.response.users.ProfileInfo
import co.spoonradio.sims.dto.response.users.UsersSnsInfo

/**
 * @author whale@spoonradio.co
 * @date   2021/11/26.
 * @Desc
 */
interface PostgresUserProfileRepository {
    fun findUserIdByTag(tag:String):Int?
    fun findUserIdByNickname(nickname:String):List<Int>
    fun decreaseMyCount(toUserId:Int)
    fun increseMyCount(toUserId:Int)
    fun getUserSnsInfo(spoonUserId:Int): UsersSnsInfo?
    fun findUserProfileByTierId(tierId: Int): MutableMap<Int?, UserProfileEntity>
    fun findUserProfileByNickname(nickName:String): MutableMap<Int?, UserProfileEntity>
    fun findUserProfileByUserIds(userIds:List<Int>): MutableMap<Int?, UserProfileEntity>
    fun findUserProfileByTag(tag:String): MutableMap<Int?, UserProfileEntity>
}