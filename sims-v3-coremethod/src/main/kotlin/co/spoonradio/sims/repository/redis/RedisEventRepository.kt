package co.spoonradio.sims.repository.redis

import co.spoonradio.arch.extension.toJson
import co.spoonradio.sims.dto.event.account.AccountBanEvent
import co.spoonradio.sims.dto.event.account.AccountEventType
import co.spoonradio.sims.dto.event.eventQueue.EventQueueName
import co.spoonradio.sims.dto.request.notification.NotificationRequestsEvent
import co.spoonradio.sims.dto.request.push.ArgsData
import co.spoonradio.sims.dto.request.push.PushData
import co.spoonradio.sims.dto.request.push.PushRequestsEvent
import co.spoonradio.sims.dto.response.users.UsersSnsInfo
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.type.event.EventType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/12/06.
 * @Desc
 */
@Repository
class RedisEventRepository(
    @Qualifier("eventStringRedisTemplate")
    val eventStringRedisTemplate: StringRedisTemplate
) : EventRepository {

    override fun accountBanEvent(usersSnsInfo: UsersSnsInfo?, eventType:String): Boolean {
        val accountBanEvent: AccountBanEvent = usersSnsInfo?.run {
            AccountBanEvent(
                eventType = eventType,
                snsType = this.sns_type,
                snsId = this.sns_id,
                userId = this.id,
                userTag = this.tag
            )


        } ?: throw GeneralException("00013")

        eventStringRedisTemplate.opsForList().rightPush(AccountEventType.ACCOUNT_BAN_EVENT.name, accountBanEvent.toJson())
        return true
    }

    override fun pushRequestEvent(pushRequestsEvent: PushRequestsEvent) : Boolean {
        eventStringRedisTemplate.opsForList()
            .rightPush(EventQueueName.PUSH_REQUEST_EVENT.name, pushRequestsEvent.toJson())

        return true
    }
    override fun notificationRequestEvent(notificationRequestsEvent: NotificationRequestsEvent) : Boolean{
        eventStringRedisTemplate.opsForList()
            .rightPush(EventQueueName.NOTIFICATION_REQUEST_EVENT.name, notificationRequestsEvent.toJson())

        return true
    }
}