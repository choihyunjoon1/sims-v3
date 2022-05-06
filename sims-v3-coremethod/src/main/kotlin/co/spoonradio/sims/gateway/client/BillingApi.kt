package co.spoonradio.sims.gateway.client

import co.spoonradio.sims.dto.response.cashout.general.ExchangeApplyManually
import feign.Headers
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile


interface BillingApi {
    @PostMapping(value = ["/internal/exchanges"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @Headers(value = ["multipart/form-data"])
    fun depositExchanges(@RequestHeader("X-User-Id") userId:Int,
                         @RequestPart(value="exchangeSpoon") exchangeSpoon: Int,
                         @RequestPart(value="applicantName") applicantName: String,
                         @RequestPart(value="email") email: String,
                         @RequestPart(value="phoneNumber") phoneNumber: String,
                         @RequestPart(value="residentFirstNumber") residentFirstNumber: String,
                         @RequestPart(value="residentLastNumber") residentLastNumber: String,
                         @RequestPart(value="accountHolder") accountHolder: String,
                         @RequestPart(value="exchangeBank") exchangeBank: String,
                         @RequestPart(value="accountNumber") accountNumber: String,
                         @RequestPart(value="privacyConsent") privacyConsent: Boolean,
                         @RequestPart(value="residentCollectionConsent") residentCollectionConsent: Boolean,
                         @RequestPart(value="familyRelationCertificates") familyRelationCertificates: List<MultipartFile>?,
                         @RequestPart(value="legalRepresentativeAgreement") legalRepresentativeAgreement: MultipartFile?) : ExchangeApplyManually


}

