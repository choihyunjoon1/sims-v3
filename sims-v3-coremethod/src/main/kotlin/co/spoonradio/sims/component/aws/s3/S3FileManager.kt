package co.spoonradio.sims.component.aws.s3

import co.spoonradio.arch.logger.Logger
import co.spoonradio.sims.component.aws.s3.requests.DeleteRequest
import co.spoonradio.sims.component.aws.s3.requests.DownloadRequest
import co.spoonradio.sims.component.aws.s3.requests.UploadRequest
import org.springframework.stereotype.Component
import software.amazon.awssdk.core.ResponseBytes
import software.amazon.awssdk.core.ResponseInputStream
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.core.sync.ResponseTransformer
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.GetObjectRequest
import software.amazon.awssdk.services.s3.model.GetObjectResponse
import software.amazon.awssdk.services.s3.presigner.S3Presigner
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest
import java.net.URL
import java.time.Duration


@Component
class S3FileManager(private val s3client: S3Client, private val s3Presigner: S3Presigner) {

    companion object : Logger

    fun uploadFile(request: UploadRequest) {
        s3client.putObject(
            request.requestObject,
            RequestBody.fromBytes(request.data)
        )
    }

    fun uploadFileAndUrl(request: UploadRequest, expireDays : Int = 7) : URL {
        s3client.putObject(
            request.requestObject,
            RequestBody.fromBytes(request.data)
        )

        val getObject = GetObjectRequest
            .builder()
            .bucket(request.requestObject.bucket())
            .key(request.requestObject.key())
            .build()

        val presignRequest: GetObjectPresignRequest = GetObjectPresignRequest.builder()
            .signatureDuration(Duration.ofDays(expireDays.toLong()))
            .getObjectRequest(getObject)
            .build()

        return s3Presigner.presignGetObject(presignRequest).url()
    }

    fun deleteFile(request: DeleteRequest) {
        s3client.deleteObject(request.requestObject)
    }

    fun downloadFile(request: DownloadRequest): ByteArray {
        val objectBytes: ResponseBytes<GetObjectResponse> = s3client.getObjectAsBytes(request.requestObject)
        return objectBytes.asByteArray()
    }

    fun getFile(request: DownloadRequest): ResponseInputStream<GetObjectResponse> {
         return s3client.getObject(request.requestObject, ResponseTransformer.toInputStream())
    }
}