package co.spoonradio.sims.repository.common.log

import co.spoonradio.sims.dto.common.AuditLog
import co.spoonradio.sims.repository.mysql.tables.references.AUDIT_LOG
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * @author whale@spoonradio.co
 * @date   2021/12/13.
 * @Desc
 */
@Repository
class MysqlLogRepository(val mysqlDslContext: DSLContext):LogRepository{

    override fun createAuditLog(auditLog: AuditLog) {
        mysqlDslContext.insertInto(AUDIT_LOG)
            .set(AUDIT_LOG.ACCESS_IP, auditLog.access_ip)
            .set(AUDIT_LOG.ACCESS_AGENT, auditLog.access_agent)
            .set(AUDIT_LOG.API_URL, auditLog.api_url)
            .set(AUDIT_LOG.API_METHOD, auditLog.api_method)
            .set(AUDIT_LOG.API_DETAIL, auditLog.api_detail)
            .set(AUDIT_LOG.REQ_PARAMETER, auditLog.req_parameter)
            .set(AUDIT_LOG.SUB_MENU_ID, auditLog.sub_menu_id)
            .set(AUDIT_LOG.SUB_MENU_NAME, auditLog.sub_menu_name)
            .set(AUDIT_LOG.USER_ID, auditLog.user_id)
            .set(AUDIT_LOG.USER_NAME, auditLog.user_name)
            .set(AUDIT_LOG.RESULT_CD, auditLog.result_cd)
            .set(AUDIT_LOG.CREATE_DT, auditLog.create_dt.toLocalDateTime())
            .set(AUDIT_LOG.DOWNLOAD_REASON, auditLog.download_reason)
            .set(AUDIT_LOG.EN_API_DETAIL, auditLog.en_api_detail)
            .set(AUDIT_LOG.EN_SUB_MENU_NAME, auditLog.en_sub_menu_name)
            .execute()
    }
}