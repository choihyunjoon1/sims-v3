package co.spoonradio.sims.service.voc

import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.dto.request.voc.RequestRegistUnfitWord
import co.spoonradio.sims.dto.request.voc.RequestUnfitWord
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.unfit.UnfitWord
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.voc.UnfitWordRepository
import org.springframework.stereotype.Service

@Service
class DefaultUnfitWordService(val unfitWordRepository: UnfitWordRepository) : UnfitWordService {
    override fun getUnfitWord(param: RequestUnfitWord): SimsResponseEntity<List<UnfitWord>, ExtraDataEntity> {
        val result = unfitWordRepository.getUnfitWord(param)
        val totalCount = result.second
        val pageCount = CommonUtils.getPageCount(totalCount, param.base!!.page_size)

        return SimsResponseEntity(result.first, ExtraDataEntity(pageCount, totalCount))
    }

    override fun getUnfitWordById(unfitWordId: Int): UnfitWord {
        return unfitWordRepository.getUnfitWordById(unfitWordId) ?: throw GeneralException("00010")
    }

    override fun createUnfitWord(param: RequestRegistUnfitWord) {
        unfitWordRepository.createUnfitWord(param)
    }

    override fun modifyUnfitWord(param: RequestRegistUnfitWord, unfitWordId: Int) {
        unfitWordRepository.getUnfitWordByWord(param.word)?.let{
            if(unfitWordId != it.id)
                throw GeneralException("00007")
        }

        unfitWordRepository.modifyUnfitWord(param)
    }

    override fun deleteUnfitWord(unfitWordId: Int) {
        unfitWordRepository.deleteUnfitWord(unfitWordId)
    }

}
