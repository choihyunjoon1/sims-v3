package co.spoonradio.sims.controller.common

import co.spoonradio.arch.extension.toJson
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.Download
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.init.Menu.MainMenu
import co.spoonradio.sims.service.common.CommonService
import co.spoonradio.sims.service.common.DefaultCommonService
import io.swagger.annotations.Api
import org.slf4j.MDC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.Serializable

/**
 * @author whale@spoonradio.co
 * @date   2021/12/11.
 * @Desc
 */
@Api(tags = ["COMMON"])
@RestController
@RequestMapping("/commons")
class CommonController(val defaultCommonService: CommonService) {

    @GetMapping(value = ["/init"])
    fun getInit(): SimsResponseEntity<List<MainMenu>, ExtraDataEntity> {
        return defaultCommonService.getInit()
    }

    @GetMapping(value = ["/download/{key}"])
    fun download(
        @PathVariable key: String
    ): Download {
        return defaultCommonService.download(key)
    }
}
