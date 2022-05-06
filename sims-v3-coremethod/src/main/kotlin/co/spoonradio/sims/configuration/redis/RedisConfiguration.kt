package co.spoonradio.sims.configuration.redis

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

/**
 * @author whale@spoonradio.co
 * @date   2021/11/26.
 * @Desc
 */
@Configuration
class RedisConfiguration {

    @Value("\${spring.redis.host}")
    var redisHost: String = "localhost"

    @Value("\${spring.redis.port}")
    var redisPort: String = "6379"


    companion object {
        val TIMEOUT_SECOND: Long = 3
    }

    @Primary
    @Bean(name=["redisConnectionFactory"])
    fun redisConnectionFactory() = LettuceConnectionFactory(
        RedisStandaloneConfiguration().apply {
            database = 0
            hostName = redisHost
            port = redisPort.toInt()
        },
        LettuceClientConfiguration.builder()
            .commandTimeout(Duration.ofSeconds(TIMEOUT_SECOND))
            .shutdownTimeout(Duration.ZERO)
            .build()
    )


    @Bean(name=["stringRedisTemplate"])
    fun stringRedisTemplate(@Qualifier("redisConnectionFactory") redisConnectionFactory: RedisConnectionFactory) = StringRedisTemplate().apply {
        setConnectionFactory(redisConnectionFactory)
        keySerializer = StringRedisSerializer()
        setEnableTransactionSupport(true)
    }



}