package co.spoonradio.sims.common.cipher;

import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import org.springframework.stereotype.Component


@Component
class DefaultAESCipher(val simsEnvInfo: SimsEnvInfo) : AESCipher {
    //빌링 암복호화 마이그레이션 이후 val billingAESCipherKey = simsEnvInfo.billingAesCipherKey로 세팅할 것
    val billingAESCipherKey = "{\"symmetric\":\""+simsEnvInfo.billingAesCipherKey+"\"}"

    override fun encrypt(plainMessage: String): String {
       return AESCipherDelegator(billingAESCipherKey).encrypt(plainMessage)
    }

    override fun decrypt(encryptedMessage: String): String {
       return AESCipherDelegator(billingAESCipherKey).decrypt(encryptedMessage)
    }
}
