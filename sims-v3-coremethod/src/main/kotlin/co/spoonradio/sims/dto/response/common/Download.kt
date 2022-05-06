package co.spoonradio.sims.dto.response.common

import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/12/21.
 * @Desc
 */
data class Download(
    val valid: Boolean,
    val url: String
): Serializable
