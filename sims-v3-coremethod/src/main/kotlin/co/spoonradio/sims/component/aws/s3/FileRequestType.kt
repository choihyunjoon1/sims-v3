package co.spoonradio.sims.component.aws.s3

enum class FileRequestType (val action: FileAction, val bucket: TargetBucket) {

    DOWNLOAD_LIVE_AUDIO(FileAction.GET, TargetBucket.CONTENT),
    DOWNLOAD_LIVE_REPORT_EXCEL(FileAction.GET, TargetBucket.SIMS),
    DOWNLOAD_CAST_REPORT_EXCEL(FileAction.GET, TargetBucket.SIMS),
    UPLOAD_VOC_HISTORY_EXCEL(FileAction.PUT, TargetBucket.SIMS),
    UPLOAD_STICKER_JSON(FileAction.PUT, TargetBucket.STATIC),
    DELETE_USER_IMAGE(FileAction.DELETE, TargetBucket.STATIC),
    VIEW_PRIVACY_IMAGE(FileAction.GET, TargetBucket.PRIVATE),
//    DOWNLOAD_CAST_AUDIO
//        (FileAction.GET, TargetBucket.CONTENT),
//    DOWNLOAD_TALK_AUDIO
//        (FileAction.GET, TargetBucket.CONTENT),
//    DOWNLOAD_PROFILE_EXCEL
//        (FileAction.GET, TargetBucket.SIMS),
//    DOWNLOAD_LIVE_LIKE_HISTORY_EXCEL
//        (FileAction.GET, TargetBucket.SIMS),
//    DOWNLOAD_NICKNAME_CHANGE_HISTORY_EXCEL
//        (FileAction.GET, TargetBucket.SIMS),
//    DOWNLOAD_LEGAL_REP_EMAIL_HISTORY_EXCEL
//        (FileAction.GET, TargetBucket.SIMS),
//    DOWNLOAD_VOC_HISTORY_EXCEL
//        (FileAction.GET, TargetBucket.SIMS),
//    DOWNLOAD_VOC_ATTACHMENT_FILE
//        (FileAction.GET, TargetBucket.SIMS),
//    DOWNLOAD_LIVE_MESSAGE_EXCEL
//        (FileAction.GET, TargetBucket.SIMS),

}

enum class FileAction {
    DELETE,
    PUT,
    GET
}

enum class TargetBucket {
    STATIC,
    CONTENT,
    PRIVATE,
    SIMS
}