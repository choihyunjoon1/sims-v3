package co.spoonradio.sims.repository.nice

import co.spoonradio.sims.dto.response.users.NiceInfo

interface PostgresUserNiceAuthRepository {
    fun findNiceAuthByUserIds(userIds:List<Int>):MutableMap<Int?, NiceInfo>?
}