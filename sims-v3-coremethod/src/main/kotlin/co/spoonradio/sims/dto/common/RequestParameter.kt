package co.spoonradio.sims.dto.common

import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/12/13.
 * @Desc
 */
data class RequestParameter(
    var path_params: MutableList<String> = mutableListOf(),
    var query_params: MutableList<String> = mutableListOf(),
    var request_body: MutableList<String> = mutableListOf(),
    var download_reason: String = "",
) : Serializable
