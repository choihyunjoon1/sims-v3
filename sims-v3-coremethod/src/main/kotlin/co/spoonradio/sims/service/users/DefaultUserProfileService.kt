package co.spoonradio.sims.service.users

import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.users.UserProfileRepository
import org.springframework.stereotype.Service

/**
 * @author whale@spoonradio.co
 * @date   2021/11/26.
 * @Desc
 */
@Service
class DefaultUserProfileService(val userProfileRepository: UserProfileRepository) : UserProfileService {

    override fun findUserIdByTag(tag: String): Int? {
        return userProfileRepository.findUserIdByTag(tag) ?: -1
    }

    override fun findUserIdByNickname(nickname: String): List<Int> {
        return userProfileRepository.findUserIdByNickname(nickname)
    }
}