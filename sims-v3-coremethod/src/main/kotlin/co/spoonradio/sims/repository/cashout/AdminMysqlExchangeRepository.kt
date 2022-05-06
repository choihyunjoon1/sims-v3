package co.spoonradio.sims.repository.cashout

import co.spoonradio.sims.dto.request.cashout.RequestExchangeActionHistory


interface AdminMysqlExchangeRepository {
    fun insertExchangeActionHistory(param: RequestExchangeActionHistory): Int
}
