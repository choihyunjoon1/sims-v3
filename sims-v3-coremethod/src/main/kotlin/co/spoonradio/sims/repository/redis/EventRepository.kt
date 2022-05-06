package co.spoonradio.sims.repository.redis

import co.spoonradio.sims.dto.request.notification.NotificationRequestsEvent
import co.spoonradio.sims.dto.request.push.PushRequestsEvent
import co.spoonradio.sims.dto.response.users.UsersSnsInfo

/**
 * @author whale@spoonradio.co
 * @date   2021/12/06.
 * @Desc
 */
interface EventRepository {
    fun accountBanEvent(usersSnsInfo: UsersSnsInfo?, eventType: String): Boolean
    fun pushRequestEvent(pushRequestsEvent: PushRequestsEvent) : Boolean
    fun notificationRequestEvent(notificationRequestsEvent: NotificationRequestsEvent) : Boolean
}