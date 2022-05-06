package co.spoonradio.sims.component.aws.s3.requests

import co.spoonradio.sims.component.aws.s3.FileRequestType
import software.amazon.awssdk.services.s3.model.PutObjectRequest

data class UploadRequest (
    val requestType: FileRequestType,
    val data: ByteArray
) {
    lateinit var requestObject: PutObjectRequest
}