package co.spoonradio.sims.common.cipher;

import co.spoonradio.sims.exception.GeneralException
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class AESCipherDelegator(secretKey:String) {
    companion object {
        const val CHARACTER_ENCODING = "UTF-8"
        const val CIPHER_TRANSFORMATION = "AES/CBC/NoPadding"
        const val AES_ENCRYPTION_ALGORITHM = "AES"
        const val MESSAGE_DIGEST_ALGORITHM = "SHA-256"
        const val IV_SIZE = 16
        const val KEY_SIZE = 32
        var SECRET_KEY_SPEC: SecretKeySpec? = null
    }

    init {
        try {
            val secretKeyByte: ByteArray = secretKey.toByteArray(charset(CHARACTER_ENCODING))
            val digest = MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM)
            digest.update(secretKeyByte)

            val keyBytes = ByteArray(KEY_SIZE)
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.size)
            SECRET_KEY_SPEC = SecretKeySpec(keyBytes, AES_ENCRYPTION_ALGORITHM)
        } catch (e: Exception) {
            throw GeneralException("")
        }
    }

    fun encrypt(plainMessage: String): String {
        return try {
            val encrypted = encrypt(plainMessage.toByteArray(StandardCharsets.UTF_8))
            Base64.getEncoder().encodeToString(encrypted)
        } catch (e: Exception) {
            plainMessage
        }
    }

    fun decrypt(encryptedMessage: String): String {
        return try {
            Base64.getDecoder().decode(encryptedMessage)?.let {
                return decrypt(it).toString(StandardCharsets.UTF_8)
            }
            encryptedMessage
        } catch (e: Exception) {
            encryptedMessage
        }
    }

    private fun encrypt(plainMessage: ByteArray): ByteArray {
        // for NoPadding
        val paddedMsgSize = calcPaddedMsgSize(plainMessage)
        val paddedMsg = ByteArray(paddedMsgSize)
        System.arraycopy(plainMessage, 0, paddedMsg, 0, plainMessage.size)
        val iv = ByteArray(IV_SIZE)
        val random = SecureRandom()
        random.nextBytes(iv)
        val ivParameterSpec = IvParameterSpec(iv)
        val cipher = Cipher.getInstance(CIPHER_TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC, ivParameterSpec)
        val encrypted = cipher.doFinal(paddedMsg)

        // Combine IV and encrypted part.
        val encryptedIVAndText = ByteArray(IV_SIZE + encrypted.size)
        System.arraycopy(iv, 0, encryptedIVAndText, 0, IV_SIZE)
        System.arraycopy(encrypted, 0, encryptedIVAndText, IV_SIZE, encrypted.size)
        return encryptedIVAndText
    }

    private fun decrypt(encryptMessage: ByteArray): ByteArray {
        val iv = ByteArray(IV_SIZE)
        System.arraycopy(encryptMessage, 0, iv, 0, iv.size)
        val ivParameterSpec = IvParameterSpec(iv)

        // Extract encrypted part.
        val encryptedSize = encryptMessage.size - IV_SIZE
        val encryptedBytes = ByteArray(encryptedSize)
        System.arraycopy(encryptMessage, IV_SIZE, encryptedBytes, 0, encryptedSize)

        // Decrypt.
        val cipherDecrypt = Cipher.getInstance(CIPHER_TRANSFORMATION)
        cipherDecrypt.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC, ivParameterSpec)
        val paddedPlainMsg = cipherDecrypt.doFinal(encryptedBytes)

        // for NoPadding
        val paddedByte = paddedPlainMsg[paddedPlainMsg.size - 1]
        var paddedLastIdx = paddedPlainMsg.size - 1
        for (idx in paddedLastIdx downTo 0) {
            paddedLastIdx = if (paddedPlainMsg[idx] == paddedByte) {
                idx
            } else {
                break
            }
        }
        val plainMsgSize = paddedLastIdx
        val plainMsg = ByteArray(plainMsgSize)
        System.arraycopy(paddedPlainMsg, 0, plainMsg, 0, plainMsgSize)
        return plainMsg
    }

    private fun calcPaddedMsgSize(plainData: ByteArray): Int {
        return plainData.size + (16 - plainData.size % 16)
    }
}
