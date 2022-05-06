package co.spoonradio.sims.dto.response.cashout

import co.spoonradio.sims.dto.response.users.NiceInfo
import co.spoonradio.sims.dto.response.users.ProfileInfo
import co.spoonradio.sims.dto.response.users.TierInfo
import co.spoonradio.sims.dto.response.users.UserProfileEntity

data class ExchangeUser(
    var profileInfo: ProfileInfo,
    var niceInfo: NiceInfo?,
    var tierInfo: TierInfo?
) {
    constructor(userProfileEntity: UserProfileEntity) : this(
        profileInfo = ProfileInfo(
            userProfileEntity.id,
            userProfileEntity.tag,
            userProfileEntity.nickname,
            userProfileEntity.status
        ),
        niceInfo = NiceInfo(
            userProfileEntity.niceId,
            userProfileEntity.id,
            userProfileEntity.niceName,
            userProfileEntity.niceGender,
            userProfileEntity.niceBirthDate,
            userProfileEntity.niceCreated
        ),
        tierInfo = TierInfo(userProfileEntity.tierName, userProfileEntity.id),
    )
}


