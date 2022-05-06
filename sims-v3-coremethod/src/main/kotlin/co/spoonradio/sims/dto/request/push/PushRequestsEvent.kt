package co.spoonradio.sims.dto.request.push

data class PushRequestsEvent(val eventType: String,
                             val fromUserId: Int,
                             val pushMessageKey: String,
                             val pushData: PushData,
                             val toUserId:Int
)
