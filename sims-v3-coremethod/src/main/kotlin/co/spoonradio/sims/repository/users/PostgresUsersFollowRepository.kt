package co.spoonradio.sims.repository.users

/**
 * @author whale@spoonradio.co
 * @date   2021/12/03.
 * @Desc
 */
interface PostgresUsersFollowRepository {
    fun decreaseFan(fromUserId:Int)
    fun increseFan(fromUserId:Int)
}