package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.RequestRegistUnfitWord
import co.spoonradio.sims.dto.request.voc.RequestUnfitWord
import co.spoonradio.sims.dto.response.voc.unfit.UnfitWord

interface UnfitWordRepository {
    fun getUnfitWord(param: RequestUnfitWord): Pair<List<UnfitWord>, Long>
    fun createUnfitWord(param: RequestRegistUnfitWord): Int
    fun modifyUnfitWord(param: RequestRegistUnfitWord): Int
    fun getUnfitWordByWord(word: String): UnfitWord?
    fun deleteUnfitWord(unfitWordId : Int) : Int
    fun getUnfitWordById(unfitWordId: Int): UnfitWord?
}
