package co.spoonradio.sims.component.download

import co.spoonradio.sims.common.`object`.CommonUtils
import co.spoonradio.sims.component.aws.s3.FileRequestFactory
import co.spoonradio.sims.component.aws.s3.FileRequestType
import co.spoonradio.sims.component.aws.s3.S3FileManager
import co.spoonradio.sims.component.aws.ses.SesManager
import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import co.spoonradio.sims.repository.redis.StoreRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import org.springframework.http.MediaType
import org.springframework.stereotype.Component

/**
 * @author whale@spoonradio.co
 * @date   2021/12/21.
 * @Desc
 */
@Component
class MailManager(
    val fileRequestFactory: FileRequestFactory,
    val storeRepository: StoreRepository,
    val s3FileManager: S3FileManager,
    val simsEnvInfo: SimsEnvInfo,
    val sesManager: SesManager,
) {
    companion object {
        val FILE_DOWNLOAD_PREFIX = "sims"
    }

    /** 테스트 미 작성 */
    fun sendDownloadMail(sourceData: ByteArray, password: String, filename: String) {
        /** S3에 파일 올리기 */
        s3FileManager.uploadFileAndUrl(
            fileRequestFactory.createUploadRequest(
                FileRequestType.UPLOAD_VOC_HISTORY_EXCEL,
                "${FILE_DOWNLOAD_PREFIX}/${AdminUserInfoManager.getUserInfo().userName}-${filename}",
                sourceData,
                MediaType.APPLICATION_OCTET_STREAM
            )
        ).let {
            /** MAIL 보내기 */
            val uuid = CommonUtils.generateUUID()
            sesManager.sendMail(simsEnvInfo.downloadUrl + uuid, filename)
            storeRepository.add(
                "DOWNLOAD:${uuid}:${password}",
                it.toString()
            )
        }
    }

}