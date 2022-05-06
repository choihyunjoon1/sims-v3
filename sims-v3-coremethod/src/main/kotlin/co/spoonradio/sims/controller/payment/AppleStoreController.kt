package co.spoonradio.sims.controller.payment;


import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.payment.AppleStoreHistory
import co.spoonradio.sims.service.payment.PaymentService
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = ["VOC"])
@RestController
@RequestMapping("/payment/history/apple-store")
class AppleStoreController(val service: PaymentService) {
    @GetMapping
    fun getAppleStoreHistory(@ModelAttribute baseDto: RequestBaseDto) : SimsResponseEntity<List<AppleStoreHistory>, ExtraDataEntity>  {
        return service.getAppleStoreHistory(baseDto)
    }
}
