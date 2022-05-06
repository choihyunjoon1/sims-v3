package co.spoonradio.sims.gateway;

import co.spoonradio.sims.dto.request.notification.NotificationRequestsEvent
import co.spoonradio.sims.dto.request.push.PushRequestsEvent

interface RedisEventGateway {
    fun pushRequestEvent(pushRequestsEvent: PushRequestsEvent)
    fun notificationRequestEvent(notificationRequestsEvent: NotificationRequestsEvent)
}