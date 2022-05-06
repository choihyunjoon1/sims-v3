package co.spoonradio.sims.repository.common.log

import co.spoonradio.sims.dto.common.AuditLog

/**
 * @author whale@spoonradio.co
 * @date   2021/12/13.
 * @Desc
 */
interface LogRepository {
    fun createAuditLog(auditLog: AuditLog)
}