package co.spoonradio.sims.service.payment

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.payment.AppleStoreHistory
import org.springframework.stereotype.Service

@Service
class DefaultPaymentService() : PaymentService {
    override fun getAppleStoreHistory(base: RequestBaseDto): SimsResponseEntity<List<AppleStoreHistory>, ExtraDataEntity> {
        TODO("Not yet implemented")
    }
}
