package co.spoonradio.sims.repository.cashout

import co.spoonradio.sims.dto.request.cashout.RequestExchangeActionHistory
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.condition.CommonCondition
import co.spoonradio.sims.repository.mysql.tables.references.TBEXCHANGEACTIONHISTORY
import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.springframework.stereotype.Repository
import java.time.ZoneId
import java.time.ZonedDateTime

@Repository
class AdminExchangeRepository(val mysqlDslContext: DSLContext) : AdminMysqlExchangeRepository, CommonCondition() {
    override fun insertExchangeActionHistory(param: RequestExchangeActionHistory): Int {
        try {
            return mysqlDslContext
                .insertInto(TBEXCHANGEACTIONHISTORY)
                .columns(
                    TBEXCHANGEACTIONHISTORY.TXID,
                    TBEXCHANGEACTIONHISTORY.TARGETLOCKID,
                    TBEXCHANGEACTIONHISTORY.TYPE,
                    TBEXCHANGEACTIONHISTORY.CREATED,
                    TBEXCHANGEACTIONHISTORY.CREATOR
                )
                .values(param.txId, param.targetLockId, param.type, ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime(), param.creator)
                .execute()
        } catch (e: DataAccessException) {
            throw GeneralException("00006")
        }
    }
}
