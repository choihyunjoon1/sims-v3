package co.spoonradio.sims.service.voc

import co.spoonradio.sims.common.excel.ExcelGenerator
import co.spoonradio.sims.component.download.MailManager
import co.spoonradio.sims.dto.request.voc.*
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.history.Attachment
import co.spoonradio.sims.dto.response.voc.history.Reply
import co.spoonradio.sims.dto.response.voc.history.VocHistory
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.voc.VocHistoryRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import co.spoonradio.sims.service.users.UserProfileService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DefaultVocHistoryService(
    val historyRepository: VocHistoryRepository,
    val userProfileService: UserProfileService,
    val mailManager: MailManager,
) : VocHistoryService {

    override fun getVocHistory(param: RequestVoc): SimsResponseEntity<List<VocHistory>, ExtraDataEntity> {
        param.base?.let {
            if (it.field == "tag") it.value =
                it.value?.let { value -> userProfileService.findUserIdByTag(value).toString() }
            if (it.field == "nickname") it.value =
                it.value?.let { value -> userProfileService.findUserIdByNickname(value).toString() }
        }
        val result = historyRepository.getVocHistory(param)
        return SimsResponseEntity(result.first, ExtraDataEntity(result.first.count().toLong(), result.second))
    }


    /** 테스트 미작성 */
    override fun createVocExcel(param: RequestVoc, password: String) {
        val list = this.getVocHistory(param).results
        if (list.isEmpty()) throw GeneralException("00117")

        /** 엑셀 S3 업로드 */
        mailManager.sendDownloadMail(
            sourceData = ExcelGenerator.generateToByteArray<VocHistory>(list, password),
            password = password,
            filename = "VocList.xlsx"
        )
    }


    override fun getVocHistoryDetail(histId: Int): SimsResponseEntity<VocHistory?, ExtraDataEntity> {
        val ret = historyRepository.getVocHistoryDetail(histId)
        return SimsResponseEntity(ret, ExtraDataEntity(0, 0))
    }

    @Transactional("mysqlTxManager")
    override fun createVoc(createVocHistory: RequestRegistVocHistory) {
        createVocHistory.member_user_id = AdminUserInfoManager.getUserInfo().userId//.getAdminUser().id
        historyRepository.registVoc(createVocHistory)
    }

    @Transactional("mysqlTxManager")
    override fun updateVoc(updateVocHistory: RequestRegistVocHistory) {
        historyRepository.updateVoc(updateVocHistory)
    }

    @Transactional("mysqlTxManager")
    override fun deleteVoc(histId: Int) {
        historyRepository.deleteVoc(histId)
    }

    @Transactional("mysqlTxManager")
    override fun updateReply(updateReply: RequestReply) {
        updateReply.member_user_id = AdminUserInfoManager.getUserInfo().userId//adminUserAuditorAware.getAdminUser().id
        historyRepository.updateReply(updateReply)
    }

    override fun getAttachments(histId: Int): SimsResponseEntity<List<Attachment>, ExtraDataEntity> {
        val result = historyRepository.getAttachments(histId)
        return SimsResponseEntity(result.first, ExtraDataEntity(result.first.count().toLong(), result.second))
    }

    override fun getSpoonSupportReplies(histId: Int): SimsResponseEntity<List<Reply>, ExtraDataEntity> {
        val result = historyRepository.getSpoonSupportReplies(histId)
        return SimsResponseEntity(result.first, ExtraDataEntity(result.first.count().toLong(), result.second))
    }

    @Transactional("mysqlTxManager")
    override fun registSpoonSupportReply(requestReply: RequestReply) {
        requestReply.member_user_id = AdminUserInfoManager.getUserInfo().userId//adminUserAuditorAware.getAdminUser().id
        historyRepository.registSpoonSupportReply(requestReply)
    }

    @Transactional("mysqlTxManager")
    override fun updateMultipleStatus(multipleParam: RequestMultipleAction) {
        historyRepository.updateMultipleStatus(multipleParam)
    }

    @Transactional("mysqlTxManager")
    override fun updateMultipleUpdateCriticalityType(multipleParam: RequestMultipleAction) {
        historyRepository.updateMultipleUpdateCriticalityType(multipleParam)
    }

    @Transactional("mysqlTxManager")
    override fun updateMultipleUpdateMemberUser(multipleParam: RequestMultipleMemberUpdateAction) {
        historyRepository.updateMultipleUpdateMemberUser(multipleParam)
    }
}
