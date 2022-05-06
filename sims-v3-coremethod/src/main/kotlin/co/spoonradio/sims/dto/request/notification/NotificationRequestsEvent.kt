package co.spoonradio.sims.dto.request.notification

import java.util.*

data class NotificationRequestsEvent(val eventType: String,
                                       val fromUserId: Long,
                                       val toUserId: Long,
                                       val notificationType: String,
                                       val notificationJsonData: String)
