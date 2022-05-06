package co.spoonradio.sims.controller.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.RequestRegistUnfitWord
import co.spoonradio.sims.dto.request.voc.RequestUnfitWord
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.unfit.UnfitWord
import co.spoonradio.sims.service.voc.UnfitWordService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/voc/unfitword")
class UnfitWordController(val service: UnfitWordService) {

    @GetMapping
    fun getUnfitWord(
        @ModelAttribute baseDto: RequestBaseDto,
        @ModelAttribute param: RequestUnfitWord
    ): SimsResponseEntity<List<UnfitWord>, ExtraDataEntity> {
        param.base = baseDto
        return service.getUnfitWord(param)
    }

    @GetMapping("{unfitWordId}")
    fun getUnfitWordById(
        @PathVariable(value = "unfitWordId", required = true) unfitWordId: Int
    ): SimsResponseEntity<UnfitWord, ExtraDataEntity> {
        val result = service.getUnfitWordById(unfitWordId)
        return SimsResponseEntity(result, ExtraDataEntity())
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUnfitWord(
        @RequestBody requestRegistUnfitWord: RequestRegistUnfitWord
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.createUnfitWord(requestRegistUnfitWord)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @PutMapping("{unfitWordId}")
    @ResponseStatus(HttpStatus.OK)
    fun modifyUnfitWord(
        @PathVariable(value = "unfitWordId", required = true) unfitWordId: Int,
        @RequestBody requestRegistUnfitWord: RequestRegistUnfitWord
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.modifyUnfitWord(requestRegistUnfitWord, unfitWordId)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @DeleteMapping("{unfitWordId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUnfitWord(
        @PathVariable(value = "unfitWordId", required = true) unfitWordId: Int
    ): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        service.deleteUnfitWord(unfitWordId)
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

}
