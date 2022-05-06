package co.spoonradio.sims.service.voc

import co.spoonradio.sims.dto.request.voc.*
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.history.Attachment
import co.spoonradio.sims.dto.response.voc.history.Reply
import co.spoonradio.sims.dto.response.voc.history.VocHistory

/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */
interface VocHistoryService {
    fun getVocHistory(param: RequestVoc): SimsResponseEntity<List<VocHistory>, ExtraDataEntity>
    fun createVocExcel(param: RequestVoc, password:String)
    fun getVocHistoryDetail(histId: Int): SimsResponseEntity<VocHistory?, ExtraDataEntity>
    fun createVoc(createVocHistory: RequestRegistVocHistory)
    fun updateVoc(updateVocHistory: RequestRegistVocHistory)
    fun deleteVoc(histId: Int)
    fun updateReply(updateReply: RequestReply)
    fun getAttachments(histId: Int): SimsResponseEntity<List<Attachment>, ExtraDataEntity>
    fun getSpoonSupportReplies(histId: Int): SimsResponseEntity<List<Reply>, ExtraDataEntity>
    fun registSpoonSupportReply(requestReply: RequestReply)
    fun updateMultipleStatus(multipleParam: RequestMultipleAction)
    fun updateMultipleUpdateCriticalityType(multipleParam: RequestMultipleAction)
    fun updateMultipleUpdateMemberUser(multipleParam: RequestMultipleMemberUpdateAction)

}