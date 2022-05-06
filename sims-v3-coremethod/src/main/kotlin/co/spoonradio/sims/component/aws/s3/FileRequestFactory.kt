package co.spoonradio.sims.component.aws.s3

import co.spoonradio.sims.component.aws.s3.requests.DeleteRequest
import co.spoonradio.sims.component.aws.s3.requests.DownloadRequest
import co.spoonradio.sims.component.aws.s3.requests.UploadRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest
import software.amazon.awssdk.services.s3.model.GetObjectRequest
import software.amazon.awssdk.services.s3.model.PutObjectRequest


@Component
class FileRequestFactory {

    @Value("\${cloud.aws.s3.buckets.contents}")
    var CONTENTS_BUCKET: String = "default.sims"

    @Value("\${cloud.aws.s3.buckets.static}")
    var STATIC_BUCKET: String = "default.sims"

    @Value("\${cloud.aws.s3.buckets.private}")
    var PRIVATE_BUCKET: String = "default.sims"

    @Value("\${cloud.aws.s3.buckets.sims}")
    var  SIMS_BUCKET: String = "default.sims"


    private fun getBucket(targetBucket: TargetBucket): String = when (targetBucket) {
        TargetBucket.STATIC -> this.STATIC_BUCKET
        TargetBucket.CONTENT -> this.CONTENTS_BUCKET
        TargetBucket.PRIVATE -> this.PRIVATE_BUCKET
        TargetBucket.SIMS -> this.SIMS_BUCKET
    }

    fun createUploadRequest(
        requestType: FileRequestType,
        key: String,
        data: ByteArray,
        contentType: MediaType
    ): UploadRequest {
        require(requestType.action == FileAction.PUT)

        return UploadRequest(requestType, data).also {
            it.requestObject = PutObjectRequest.builder()
                .bucket(getBucket(requestType.bucket))
                .key(key)
                .contentType(contentType.toString())
                .contentLength(data.size.toLong())
                .build()
        }
    }

    fun createDownloadRequest(requestType: FileRequestType, key: String): DownloadRequest {
        require(requestType.action == FileAction.GET)

        return DownloadRequest(
            requestType, key
        ).also {
            it.requestObject = GetObjectRequest
                .builder()
                .bucket(getBucket(requestType.bucket))
                .key(key)
                .build()
        }
    }

    fun createDeleteRequest(requestType: FileRequestType, key: String): DeleteRequest {
        require(requestType.action == FileAction.DELETE)

        return DeleteRequest(requestType, key).also {
            it.requestObject = DeleteObjectRequest.builder().bucket(getBucket(requestType.bucket)).key(key).build()
        }
    }
}