package co.spoonradio.sims.gateway;

import co.spoonradio.sims.dto.request.notification.NotificationRequestsEvent
import co.spoonradio.sims.dto.request.push.PushRequestsEvent
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.redis.EventRepository
import org.springframework.stereotype.Service

@Service
class DefaultRedisEventGateway(private val eventRepository: EventRepository) : RedisEventGateway {
    override fun pushRequestEvent(pushRequestsEvent: PushRequestsEvent) {
        try {
            eventRepository.pushRequestEvent(pushRequestsEvent)
        } catch (e: Exception) {
            e.printStackTrace()
            throw GeneralException("00023")
        }
    }

    override fun notificationRequestEvent(notificationRequestsEvent: NotificationRequestsEvent) {
        try {
            eventRepository.notificationRequestEvent(notificationRequestsEvent)
        } catch (e: Exception) {
            e.printStackTrace()
            throw GeneralException("00024")
        }
    }
}
