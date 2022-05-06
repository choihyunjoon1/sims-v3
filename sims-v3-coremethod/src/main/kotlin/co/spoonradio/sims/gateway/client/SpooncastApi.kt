package co.spoonradio.sims.gateway.client

import co.spoonradio.sims.dto.gateway.spooncast.SyncEsBanUser
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * @author whale@spoonradio.co
 * @date   2021/12/09.
 * @Desc ref : https://www.tabnine.com/code/java/classes/feign.Headers
 */
interface SpooncastApi {
    @PostMapping(value = ["/systems/event/"])
    fun syncEsBanUser(@RequestBody syncEsBanUser: SyncEsBanUser)
}