package co.spoonradio.sims.component.aws.s3.requests

import co.spoonradio.sims.component.aws.s3.FileRequestType
import software.amazon.awssdk.services.s3.model.GetObjectRequest

data class DownloadRequest (
    val requestType: FileRequestType,
    val requestPath: String
) {
    lateinit var requestObject: GetObjectRequest
}