package co.spoonradio.sims.dto.request.cashout

import org.springframework.web.multipart.MultipartFile
import java.io.Serializable

data class RequestDepositExchange(
    var exchangeSpoon: Int,
    // 이용자 정보
    val applicantName: String,
    val email: String,
    val phoneNumber: String,
    val residentFirstNumber: String,
    val residentLastNumber: String,
    // 환전 받는 분 정보
    val accountHolder: String,
    val exchangeBank: String,
    val accountNumber: String,
    // 동의
    val privacyConsent: Boolean = false,
    val residentCollectionConsent: Boolean = false,
    // 동의서
    var familyRelationCertificates: List<MultipartFile>? = null,
    var legalRepresentativeAgreement: MultipartFile? = null
) : Serializable