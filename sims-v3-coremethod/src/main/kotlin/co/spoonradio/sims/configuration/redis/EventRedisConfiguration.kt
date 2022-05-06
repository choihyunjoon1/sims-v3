package co.spoonradio.sims.configuration.redis

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * @author whale@spoonradio.co
 * @date   2021/11/26.
 * @Desc
 */
@Configuration
class EventRedisConfiguration {
    @Value("\${event.redis.host}")
    var redisHost: String = "localhost"

    @Value("\${event.redis.port}")
    var redisPort: String = "6380"


    companion object {
        val TIMEOUT_SECOND: Long = 3
    }

    @Bean(name=["eventRedisConnectionFactory"])
    fun eventRedisConnectionFactory() = LettuceConnectionFactory(
        RedisStandaloneConfiguration().apply {
            database = 1
            hostName = redisHost
            port = redisPort.toInt()
        }
    )


    @Bean(name=["eventStringRedisTemplate"])
    fun eventStringRedisTemplate(@Qualifier("eventRedisConnectionFactory") eventRedisConnectionFactory: RedisConnectionFactory) = StringRedisTemplate().apply {
        setConnectionFactory(eventRedisConnectionFactory)
        keySerializer = StringRedisSerializer()
        setEnableTransactionSupport(true)
    }

}