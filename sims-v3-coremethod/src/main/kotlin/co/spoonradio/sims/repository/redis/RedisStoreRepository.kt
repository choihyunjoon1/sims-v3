package co.spoonradio.sims.repository.redis

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Repository
import java.util.concurrent.TimeUnit

/**
 * @author whale@spoonradio.co
 * @date   2021/11/27.
 * @Desc
 */
@Repository
class RedisStoreRepository(val stringRedisTemplate: StringRedisTemplate) : StoreRepository {

    override fun add(key: String, value: String, expire: Long) {
        stringRedisTemplate.opsForValue().set(key, value)
        stringRedisTemplate.expire(key, expire, TimeUnit.MINUTES)
    }

    override fun remove(key: String) {
        stringRedisTemplate.expire(key, 0, TimeUnit.SECONDS)
    }

    override fun get(key: String): String? {
        return stringRedisTemplate.opsForValue().get(key)
    }

}