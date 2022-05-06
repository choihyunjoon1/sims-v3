package co.spoonradio.sims.repository.voc

import co.spoonradio.sims.dto.request.voc.*
import co.spoonradio.sims.dto.response.voc.ban.BanHistory
import co.spoonradio.sims.dto.response.voc.history.Attachment
import co.spoonradio.sims.dto.response.voc.history.Reply
import co.spoonradio.sims.dto.response.voc.history.VocHistory

/**
 * @author whale@spoonradio.co
 * @date   2021/11/19.
 * @Desc
 */
interface VocHistoryRepository {
    fun getVocHistoryDetail(histId: Int): VocHistory?
    fun getVocHistory(param: RequestVoc): Pair<List<VocHistory>, Long>
    fun registVoc(registVoc: RequestRegistVocHistory): Int?
    fun registVocBan(banHistory: BanHistory): Int?
    fun deleteVoc(histId: Int): Int
    fun updateVoc(updateVoc: RequestRegistVocHistory): Int?
    fun updateReply(requestReply: RequestReply): Int?
    fun getAttachments(histId: Int): Pair<List<Attachment>, Long>
    fun getSpoonSupportReplies(histId: Int): Pair<List<Reply>, Long>
    fun registSpoonSupportReply(requestReply: RequestReply): Int?
    fun updateMultipleStatus(multipleParam: RequestMultipleAction): Int
    fun updateMultipleUpdateCriticalityType(multipleParam: RequestMultipleAction): Int
    fun updateMultipleUpdateMemberUser(multipleParam: RequestMultipleMemberUpdateAction): Int
    fun getBansHistory(reportUserId: Long):  MutableMap<Long?, String?>
}