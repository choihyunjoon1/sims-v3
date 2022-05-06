package co.spoonradio.sims.dto.response.common

import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/11/23.
 * @Desc
 */
data class SimsResponseEntity<T, ResponseExtraData>(
    val results: T,
    val extra_data: ResponseExtraData
):Serializable

