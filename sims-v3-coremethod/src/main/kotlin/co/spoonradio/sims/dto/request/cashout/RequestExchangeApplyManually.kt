package co.spoonradio.sims.dto.request.cashout

import org.springframework.web.multipart.MultipartFile
import java.io.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class RequestExchangeApplyManually(
    val userId: Int,
    val exchangeSpoon: Int,
    val applicantName: String,
    @field:NotBlank @field:Size(min = 6, max = 6)
    val residentFirstNumber: String,
    @field:NotBlank @field:Size(min = 7, max = 7)
    val residentLastNumber: String,
    val phoneNumber: String,
    @field:Email
    val email: String,
    val accountHolder: String,
    val exchangeBank: String,
    val accountNumber: String,
    val privacyConsent: Boolean,
    val residentCollectionConsent: Boolean,
    var familyRelationCertificates:  List<MultipartFile>? = null,
    var legalRepresentativeAgreement: MultipartFile? = null
) :Serializable
