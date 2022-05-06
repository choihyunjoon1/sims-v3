package co.spoonradio.sims.component.aws.s3.requests

import co.spoonradio.sims.component.aws.s3.FileRequestType
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest

data class DeleteRequest(
    val requestType: FileRequestType,
    val requestPath: String
) {
    lateinit var requestObject: DeleteObjectRequest
}