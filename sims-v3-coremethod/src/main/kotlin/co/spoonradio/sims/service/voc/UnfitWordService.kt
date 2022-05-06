package co.spoonradio.sims.service.voc

import co.spoonradio.sims.dto.request.voc.RequestRegistUnfitWord
import co.spoonradio.sims.dto.request.voc.RequestUnfitWord
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.unfit.UnfitWord

interface UnfitWordService {
    fun getUnfitWord(param: RequestUnfitWord): SimsResponseEntity<List<UnfitWord>, ExtraDataEntity>
    fun createUnfitWord(param: RequestRegistUnfitWord)
    fun modifyUnfitWord(param: RequestRegistUnfitWord, unfitWordId: Int)
    fun deleteUnfitWord(unfitWordId: Int)
    fun getUnfitWordById(unfitWordId: Int): UnfitWord
}
