package co.spoonradio.sims.repository.redis

/**
 * @author whale@spoonradio.co
 * @date   2021/11/27.
 * @Desc
 */
interface StoreRepository {
    fun add(key: String, value: String, expire: Long = 30)
    fun remove(key: String)
    fun get(key: String): String?
}