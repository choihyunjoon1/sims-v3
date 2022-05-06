package co.spoonradio.sims.common.cipher;

import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import org.springframework.stereotype.Component


interface AESCipher {
    fun encrypt(plainMessage: String): String
    fun decrypt(encryptedMessage: String): String
}
