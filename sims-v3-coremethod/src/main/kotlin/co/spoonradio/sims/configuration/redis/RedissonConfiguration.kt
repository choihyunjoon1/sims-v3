package co.spoonradio.sims.configuration.redis

//import org.redisson.Redisson
//import org.redisson.config.Config
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration

/**
 * @author whale@spoonradio.co
 * @date   2021/08/27.
 * @Desc
 */
//@Configuration
//class RedissonConfiguration {
//
//    @Value("\${spring.redis.host}")
//    var redisHost: String = "localhost"
//
//    @Value("\${spring.redis.port}")
//    var redisPort: String = "6379"
//
//    @Bean
//    fun redissonClient() = Redisson.create(Config().apply {
//        useSingleServer().address = "redis://${redisHost}:${redisPort}"
//    })!!
//
//}