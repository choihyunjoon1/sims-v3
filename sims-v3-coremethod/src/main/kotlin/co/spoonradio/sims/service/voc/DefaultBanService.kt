package co.spoonradio.sims.service.voc

import co.spoonradio.arch.extension.toLong
import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.dto.gateway.spooncast.SyncEsBanUser
import co.spoonradio.sims.dto.request.base.RequestBaseDto
import co.spoonradio.sims.dto.request.voc.ban.*
import co.spoonradio.sims.dto.response.common.CommonResponseMessage
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.voc.ban.Ban
import co.spoonradio.sims.dto.response.voc.ban.BanHistory
import co.spoonradio.sims.dto.response.voc.ban.UsersBan
import co.spoonradio.sims.dto.response.voc.ban.UsersBanEntity
import co.spoonradio.sims.dto.response.voc.ban.category.ContentCategory
import co.spoonradio.sims.dto.response.voc.ban.category.MainCategory
import co.spoonradio.sims.dto.response.voc.ban.category.SubCategory
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.gateway.client.SpooncastApi
import co.spoonradio.sims.repository.cast.PostgresCastRepository
import co.spoonradio.sims.repository.fanboard.PostgresFanboardRepository
import co.spoonradio.sims.repository.redis.RedisEventRepository
import co.spoonradio.sims.repository.talk.PostgresTalkRepository
import co.spoonradio.sims.repository.users.PostgresUserProfileRepository
import co.spoonradio.sims.repository.users.PostgresUsersFollowRepository
import co.spoonradio.sims.repository.voc.PostgresBanRepository
import co.spoonradio.sims.repository.voc.VocHistoryRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import co.spoonradio.sims.type.event.EventType
import co.spoonradio.sims.type.spoonuser.SpoonGrantStatus
import co.spoonradio.sims.type.spoonuser.SpoonUserStatus
import co.spoonradio.sims.type.voc.BanStatusType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit


/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
@Service
class DefaultBanService(
    val historyRepository: VocHistoryRepository,
    val banRepository: PostgresBanRepository,
    val userProfileRepository: PostgresUserProfileRepository,
    val usersFollowRepository: PostgresUsersFollowRepository,
    val talkRepository: PostgresTalkRepository,
    val castRepository: PostgresCastRepository,
    val fanboardRepository: PostgresFanboardRepository,
    val eventRepository: RedisEventRepository,
    val spooncastApi: SpooncastApi
) : BanService {

    companion object {
        val FOEVER_EXPIRE = 365000L
        val SERVICE_NAME = "SIMS"
    }

    override fun getBans(param: RequestBan): SimsResponseEntity<List<Ban>, ExtraDataEntity> {
        val bansList = banRepository.getBans(param)
        return SimsResponseEntity(
            bansList.first,
            CommonUtils.getResponseExtraData(bansList.second, param.base ?: throw GeneralException("00005"))
        )
    }

    /** 해당 사용자의 Ban 이력 - 신고 -> 상세정보에서 활용 */
    override fun getBansHistory(reportUserId: Long): SimsResponseEntity<UsersBanEntity, ExtraDataEntity> {
        /** BAN HISTORY */
        val banIds: MutableMap<Long?, String?> = historyRepository.getBansHistory(reportUserId)
        var usersBanUser: List<UsersBan> = listOf()

        if (banIds.size != 0) {
            usersBanUser = banRepository.getBanUsers(banIds.keys.toList())
            usersBanUser.forEach {
                it.handler_user_name = banIds.get(it.id.toLong())
            }
        }

        /** REPORT_DETAIL */
        return SimsResponseEntity(
            UsersBanEntity(
                usersBan_ = usersBanUser
            ),
            ExtraDataEntity(0, 0)
        )

    }

    /** TEST 미작성 */
    override fun bundleRegistBan(requestRegistBan: RequestRegistBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        /*val excel = requestRegistBan.xlsx_file
        val file: File = File(requestRegistBan.xlsx_file?.originalFilename)
        excel?.transferTo(file)

        val list = ExcelParser.parseExcel<RequestBundleRegistUserIdBan>(file)
        list.forEach { item -> println(item.user_id) }
*/
        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    @Transactional("postgresTxManager")
    override fun updateBan(requestUpdateBan: RequestUpdateBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {

        /** 수정하려는 타입(기간)이 이미 지났으면 Exception을 발생하며, UI에서는 해제를 진행시키도록 유도한다. */
        if (!requestUpdateBan.type.equals("0")) {
            val pastRange =
                requestUpdateBan.created_utc.plusDays(requestUpdateBan.type.toLong()).truncatedTo(ChronoUnit.MILLIS)
                    .toLong()
            val now = ZonedDateTime.now(ZoneId.of("UTC")).truncatedTo(ChronoUnit.MILLIS).toLong()
            if (0 > (pastRange - now)) throw GeneralException("00015")
        }

        requestUpdateBan.apply {
            device_unique_id = banRepository.getUserDeviceInfo(this.user_id) ?: throw GeneralException("00012")
            end_date_utc =
                requestUpdateBan.created_utc.plusDays(if (this.type.equals("0")) FOEVER_EXPIRE else this.type.toLong())
                    ?.truncatedTo(ChronoUnit.HOURS)?.plusHours(1) //분단위로 올림
        }
        //제재 상태일때에만 수정 가능
        if (requestUpdateBan.ban_status != BanStatusType.BS001.name) throw GeneralException("00014")

        //제재 상태 업데이트
        banRepository.updateBan(requestUpdateBan)

        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity(0, 0))
    }

    @Transactional
    override fun registBan(requestRegistBan: RequestRegistBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        requestRegistBan.apply {
            device_unique_id = banRepository.getUserDeviceInfo(this.user_id) ?: throw GeneralException("00012")
            created = ZonedDateTime.now(ZoneId.of("UTC"))
            end_date = ZonedDateTime.now(ZoneId.of("UTC")).plusDays(
                if (this.type.equals("0")) FOEVER_EXPIRE else this.type.toLong()
            ).truncatedTo(ChronoUnit.HOURS).plusHours(1) //분단위로 올림
        }

        /** USERS_BAN에 등록 */
        val banId = banRepository.registBan(requestRegistBan) ?: throw GeneralException("00011")

        /** USERS_GRANT의 login 값을 -1로 변경*/
        banRepository.updateUsersGrantStatus(requestRegistBan.user_id, SpoonGrantStatus.BAN.code)

        /** USERS_SPOONUSER의 status 값을 -9로 변경*/
        banRepository.updateUsersSpoonStatus(requestRegistBan.user_id, SpoonUserStatus.BANNED.code)

        /** VOC_BANSHISTORY에 등록*/
        historyRepository.registVocBan(
            BanHistory(
                bans_id = banId.toLong(),
                bans_user_id = requestRegistBan.user_id.toLong(),
                handler_user_id = AdminUserInfoManager.getUserInfo().userId.toLong(),
                handler_user_name = AdminUserInfoManager.getUserInfo().userName
            )
        )

        /** 영구정지 일때*/
        if (requestRegistBan.type.equals("0")) {
            userProfileRepository.decreaseMyCount(requestRegistBan.user_id)
            usersFollowRepository.decreaseFan(requestRegistBan.user_id)
            talkRepository.decreaseVoiceCommentCount(requestRegistBan.user_id)
            castRepository.decreaseTextCommentCount(requestRegistBan.user_id)
            fanboardRepository.decreaseMessageCount(requestRegistBan.user_id)
        }

        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }


    @Transactional("postgresTxManager")
    override fun recovertyBan(requestRecoveryBan: RequestRecoveryBan): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity> {
        //var tx: TransactionStatus = postgresTxManager.getTransaction(DefaultTransactionDefinition())
        val userId = requestRecoveryBan.user_id
        /** USERS_GRANT의 login 값을 1로 변경*/
        banRepository.updateUsersGrantStatus(userId, SpoonGrantStatus.EXIST.code)

        /** USERS_SPOONUSER의 status 값을 0 변경*/
        banRepository.updateUsersSpoonStatus(userId, SpoonUserStatus.LOGOUT.code)

        /** 영구정지 일때*/
        if (requestRecoveryBan.type.equals("0")) {
            userProfileRepository.increseMyCount(userId)
            usersFollowRepository.increseFan(userId)
            talkRepository.increseVoiceCommentCount(userId)
            castRepository.increseTextCommentCount(userId)
            fanboardRepository.increseMessageCount(userId)
        }

        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }

    override fun executeBanEvent(userId:Int, eventType:EventType): SimsResponseEntity<CommonResponseMessage, ExtraDataEntity>{

        /** Send EVENT  ( ACCOUNT_BAN_EVENT ) */
        /* stg-apne1-jp-mars.kjchp6.ng.0001.apne1.cache.amazonaws.com */
        userProfileRepository.getUserSnsInfo(userId).let {
            eventRepository.accountBanEvent(it, eventType.name)
        }

        /** Sync ES  (ACCOUNT_BAN_EVENT)  */
        spooncastApi.syncEsBanUser(
            SyncEsBanUser(
                service = SERVICE_NAME,
                target_type = "USER",
                event_type = eventType.syncEventname,
                target_ids = listOf(userId)
            )
        )

        return SimsResponseEntity(CommonResponseMessage(), ExtraDataEntity())
    }


    override fun getBanMainCategory(baseDto: RequestBaseDto): SimsResponseEntity<List<MainCategory>, ExtraDataEntity> {
        val mainCategory = banRepository.getBanMainCategory(baseDto)

        return SimsResponseEntity(mainCategory.first, CommonUtils.getResponseExtraData(mainCategory.second, baseDto))
    }


    override fun getBanSubCategory(baseDto: RequestBaseDto): SimsResponseEntity<List<SubCategory>, ExtraDataEntity> {
        val subCategory = banRepository.getBanSubCategory(baseDto)

        return SimsResponseEntity(subCategory.first, CommonUtils.getResponseExtraData(subCategory.second, baseDto))
    }


    override fun getBanContentCategory(base: RequestBaseDto): SimsResponseEntity<List<ContentCategory>, ExtraDataEntity> {
        val result = banRepository.getBanContentCategory(base)

        return SimsResponseEntity(result.first, CommonUtils.getResponseExtraData(result.second, base))
    }


    @Transactional("postgresTxManager")
    override fun registBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory) {
        banRepository.registBanMainCategory(requestRegistBanMainCategory)
    }

    override fun getBanMainCategoryDetail(categoryId: Int): SimsResponseEntity<MainCategory?, ExtraDataEntity> {
        val result = banRepository.getBanMainCategoryDetail(categoryId)
        return SimsResponseEntity(result, ExtraDataEntity(0, 0))
    }

    @Transactional("postgresTxManager")
    override fun updateBanMainCategory(requestRegistBanMainCategory: RequestRegistBanMainCategory) {
        banRepository.updateBanMainCategory(requestRegistBanMainCategory)
    }


    override fun getBanSubCategoryDetail(subCategoryId: Int): SimsResponseEntity<SubCategory?, ExtraDataEntity> {
        val result = banRepository.getBanSubCategoryDetail(subCategoryId)
        return SimsResponseEntity(result, ExtraDataEntity(0, 0))
    }

    @Transactional("postgresTxManager")
    override fun registBanSubCategory(requestRegistBanSubCategory: RequestRegistBanSubCategory) {
        banRepository.registBanSubCategory(requestRegistBanSubCategory)
    }

    @Transactional("postgresTxManager")
    override fun updateBanSubCategory(requestRegistBanSubCategory: RequestRegistBanSubCategory) {
        banRepository.updateBanSubCategory(requestRegistBanSubCategory)
    }


    override fun getBanContentCategoryDetail(contentCategoryId: Int): SimsResponseEntity<ContentCategory?, ExtraDataEntity> {
        val result = banRepository.getBanContentCategoryDetail(contentCategoryId)
        return SimsResponseEntity(result, ExtraDataEntity(0, 0))
    }

    @Transactional("postgresTxManager")
    override fun registBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory) {
        banRepository.registBanContentCategory(requestRegistBanContentCategory)
    }

    @Transactional("postgresTxManager")
    override fun updateBanContentCategory(requestRegistBanContentCategory: RequestRegistBanContentCategory) {
        banRepository.updateBanContentCategory(requestRegistBanContentCategory)
    }


}
