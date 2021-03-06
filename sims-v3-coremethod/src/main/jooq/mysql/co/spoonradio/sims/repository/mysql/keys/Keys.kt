/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.keys


import co.spoonradio.sims.repository.mysql.tables.AdminUser
import co.spoonradio.sims.repository.mysql.tables.AllowEqui
import co.spoonradio.sims.repository.mysql.tables.AuditLog
import co.spoonradio.sims.repository.mysql.tables.AuthGroup
import co.spoonradio.sims.repository.mysql.tables.AuthGroupPermissions
import co.spoonradio.sims.repository.mysql.tables.AuthPermission
import co.spoonradio.sims.repository.mysql.tables.AuthtokenToken
import co.spoonradio.sims.repository.mysql.tables.BatchLog
import co.spoonradio.sims.repository.mysql.tables.BatchLogDeail
import co.spoonradio.sims.repository.mysql.tables.BatchManage
import co.spoonradio.sims.repository.mysql.tables.ComCode
import co.spoonradio.sims.repository.mysql.tables.DjangoAdminLog
import co.spoonradio.sims.repository.mysql.tables.DjangoContentType
import co.spoonradio.sims.repository.mysql.tables.DjangoMigrations
import co.spoonradio.sims.repository.mysql.tables.DjangoSession
import co.spoonradio.sims.repository.mysql.tables.ExternalLinkLog
import co.spoonradio.sims.repository.mysql.tables.GradeMenuAuthList
import co.spoonradio.sims.repository.mysql.tables.GrantLog
import co.spoonradio.sims.repository.mysql.tables.Menu
import co.spoonradio.sims.repository.mysql.tables.Notice
import co.spoonradio.sims.repository.mysql.tables.NoticeCheck
import co.spoonradio.sims.repository.mysql.tables.OtpTotpTotpdevice
import co.spoonradio.sims.repository.mysql.tables.SpcAuthReq
import co.spoonradio.sims.repository.mysql.tables.SpcAuthReqInfo
import co.spoonradio.sims.repository.mysql.tables.SpoonReward
import co.spoonradio.sims.repository.mysql.tables.SpoonRewardUser
import co.spoonradio.sims.repository.mysql.tables.SubMenu
import co.spoonradio.sims.repository.mysql.tables.Tbexchangeactionhistory
import co.spoonradio.sims.repository.mysql.tables.Tbspoonvalidsynchistory
import co.spoonradio.sims.repository.mysql.tables.TeamMenuAuthList
import co.spoonradio.sims.repository.mysql.tables.Terms
import co.spoonradio.sims.repository.mysql.tables.TermsCheck
import co.spoonradio.sims.repository.mysql.tables.UserMenuAuth
import co.spoonradio.sims.repository.mysql.tables.UsersDeactive
import co.spoonradio.sims.repository.mysql.tables.VocAttachment
import co.spoonradio.sims.repository.mysql.tables.VocBanshistory
import co.spoonradio.sims.repository.mysql.tables.VocHist
import co.spoonradio.sims.repository.mysql.tables.VocReply
import co.spoonradio.sims.repository.mysql.tables.records.AdminUserRecord
import co.spoonradio.sims.repository.mysql.tables.records.AllowEquiRecord
import co.spoonradio.sims.repository.mysql.tables.records.AuditLogRecord
import co.spoonradio.sims.repository.mysql.tables.records.AuthGroupPermissionsRecord
import co.spoonradio.sims.repository.mysql.tables.records.AuthGroupRecord
import co.spoonradio.sims.repository.mysql.tables.records.AuthPermissionRecord
import co.spoonradio.sims.repository.mysql.tables.records.AuthtokenTokenRecord
import co.spoonradio.sims.repository.mysql.tables.records.BatchLogDeailRecord
import co.spoonradio.sims.repository.mysql.tables.records.BatchLogRecord
import co.spoonradio.sims.repository.mysql.tables.records.BatchManageRecord
import co.spoonradio.sims.repository.mysql.tables.records.ComCodeRecord
import co.spoonradio.sims.repository.mysql.tables.records.DjangoAdminLogRecord
import co.spoonradio.sims.repository.mysql.tables.records.DjangoContentTypeRecord
import co.spoonradio.sims.repository.mysql.tables.records.DjangoMigrationsRecord
import co.spoonradio.sims.repository.mysql.tables.records.DjangoSessionRecord
import co.spoonradio.sims.repository.mysql.tables.records.ExternalLinkLogRecord
import co.spoonradio.sims.repository.mysql.tables.records.GradeMenuAuthListRecord
import co.spoonradio.sims.repository.mysql.tables.records.GrantLogRecord
import co.spoonradio.sims.repository.mysql.tables.records.MenuRecord
import co.spoonradio.sims.repository.mysql.tables.records.NoticeCheckRecord
import co.spoonradio.sims.repository.mysql.tables.records.NoticeRecord
import co.spoonradio.sims.repository.mysql.tables.records.OtpTotpTotpdeviceRecord
import co.spoonradio.sims.repository.mysql.tables.records.SpcAuthReqInfoRecord
import co.spoonradio.sims.repository.mysql.tables.records.SpcAuthReqRecord
import co.spoonradio.sims.repository.mysql.tables.records.SpoonRewardRecord
import co.spoonradio.sims.repository.mysql.tables.records.SpoonRewardUserRecord
import co.spoonradio.sims.repository.mysql.tables.records.SubMenuRecord
import co.spoonradio.sims.repository.mysql.tables.records.TbexchangeactionhistoryRecord
import co.spoonradio.sims.repository.mysql.tables.records.TbspoonvalidsynchistoryRecord
import co.spoonradio.sims.repository.mysql.tables.records.TeamMenuAuthListRecord
import co.spoonradio.sims.repository.mysql.tables.records.TermsCheckRecord
import co.spoonradio.sims.repository.mysql.tables.records.TermsRecord
import co.spoonradio.sims.repository.mysql.tables.records.UserMenuAuthRecord
import co.spoonradio.sims.repository.mysql.tables.records.UsersDeactiveRecord
import co.spoonradio.sims.repository.mysql.tables.records.VocAttachmentRecord
import co.spoonradio.sims.repository.mysql.tables.records.VocBanshistoryRecord
import co.spoonradio.sims.repository.mysql.tables.records.VocHistRecord
import co.spoonradio.sims.repository.mysql.tables.records.VocReplyRecord

import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val CONSTRAINT_2: UniqueKey<AdminUserRecord> = Internal.createUniqueKey(AdminUser.ADMIN_USER, DSL.name("CONSTRAINT_2"), arrayOf(AdminUser.ADMIN_USER.USER_ID), true)
val EMAIL: UniqueKey<AdminUserRecord> = Internal.createUniqueKey(AdminUser.ADMIN_USER, DSL.name("email"), arrayOf(AdminUser.ADMIN_USER.EMAIL), true)
val CONSTRAINT_B: UniqueKey<AllowEquiRecord> = Internal.createUniqueKey(AllowEqui.ALLOW_EQUI, DSL.name("CONSTRAINT_B"), arrayOf(AllowEqui.ALLOW_EQUI.ALLOW_EQUI_ID), true)
val CONSTRAINT_B8: UniqueKey<AuditLogRecord> = Internal.createUniqueKey(AuditLog.AUDIT_LOG, DSL.name("CONSTRAINT_B8"), arrayOf(AuditLog.AUDIT_LOG.AUDIT_LOG_ID), true)
val CONSTRAINT_8: UniqueKey<AuthGroupRecord> = Internal.createUniqueKey(AuthGroup.AUTH_GROUP, DSL.name("CONSTRAINT_8"), arrayOf(AuthGroup.AUTH_GROUP.ID), true)
val NAME: UniqueKey<AuthGroupRecord> = Internal.createUniqueKey(AuthGroup.AUTH_GROUP, DSL.name("name"), arrayOf(AuthGroup.AUTH_GROUP.NAME), true)
val CONSTRAINT_BE: UniqueKey<AuthGroupPermissionsRecord> = Internal.createUniqueKey(AuthGroupPermissions.AUTH_GROUP_PERMISSIONS, DSL.name("CONSTRAINT_BE"), arrayOf(AuthGroupPermissions.AUTH_GROUP_PERMISSIONS.ID), true)
val CONSTRAINT_9: UniqueKey<AuthPermissionRecord> = Internal.createUniqueKey(AuthPermission.AUTH_PERMISSION, DSL.name("CONSTRAINT_9"), arrayOf(AuthPermission.AUTH_PERMISSION.ID), true)
val CONSTRAINT_3: UniqueKey<AuthtokenTokenRecord> = Internal.createUniqueKey(AuthtokenToken.AUTHTOKEN_TOKEN, DSL.name("CONSTRAINT_3"), arrayOf(AuthtokenToken.AUTHTOKEN_TOKEN.KEY), true)
val USER_ID: UniqueKey<AuthtokenTokenRecord> = Internal.createUniqueKey(AuthtokenToken.AUTHTOKEN_TOKEN, DSL.name("user_id"), arrayOf(AuthtokenToken.AUTHTOKEN_TOKEN.USER_ID), true)
val CONSTRAINT_C: UniqueKey<BatchLogRecord> = Internal.createUniqueKey(BatchLog.BATCH_LOG, DSL.name("CONSTRAINT_C"), arrayOf(BatchLog.BATCH_LOG.BATCH_LOG_ID), true)
val CONSTRAINT_B4: UniqueKey<BatchLogDeailRecord> = Internal.createUniqueKey(BatchLogDeail.BATCH_LOG_DEAIL, DSL.name("CONSTRAINT_B4"), arrayOf(BatchLogDeail.BATCH_LOG_DEAIL.BATCH_LOG_DETAIL_ID), true)
val CONSTRAINT_F: UniqueKey<BatchManageRecord> = Internal.createUniqueKey(BatchManage.BATCH_MANAGE, DSL.name("CONSTRAINT_F"), arrayOf(BatchManage.BATCH_MANAGE.BATCH_MANAGE_ID), true)
val CONSTRAINT_D: UniqueKey<ComCodeRecord> = Internal.createUniqueKey(ComCode.COM_CODE, DSL.name("CONSTRAINT_D"), arrayOf(ComCode.COM_CODE.ID), true)
val CONSTRAINT_B3: UniqueKey<DjangoAdminLogRecord> = Internal.createUniqueKey(DjangoAdminLog.DJANGO_ADMIN_LOG, DSL.name("CONSTRAINT_B3"), arrayOf(DjangoAdminLog.DJANGO_ADMIN_LOG.ID), true)
val CONSTRAINT_2A: UniqueKey<DjangoContentTypeRecord> = Internal.createUniqueKey(DjangoContentType.DJANGO_CONTENT_TYPE, DSL.name("CONSTRAINT_2A"), arrayOf(DjangoContentType.DJANGO_CONTENT_TYPE.ID), true)
val CONSTRAINT_6: UniqueKey<DjangoMigrationsRecord> = Internal.createUniqueKey(DjangoMigrations.DJANGO_MIGRATIONS, DSL.name("CONSTRAINT_6"), arrayOf(DjangoMigrations.DJANGO_MIGRATIONS.ID), true)
val CONSTRAINT_7: UniqueKey<DjangoSessionRecord> = Internal.createUniqueKey(DjangoSession.DJANGO_SESSION, DSL.name("CONSTRAINT_7"), arrayOf(DjangoSession.DJANGO_SESSION.SESSION_KEY), true)
val CONSTRAINT_A: UniqueKey<ExternalLinkLogRecord> = Internal.createUniqueKey(ExternalLinkLog.EXTERNAL_LINK_LOG, DSL.name("CONSTRAINT_A"), arrayOf(ExternalLinkLog.EXTERNAL_LINK_LOG.EXTERNAL_LINK_LOG_ID), true)
val CONSTRAINT_BA: UniqueKey<GradeMenuAuthListRecord> = Internal.createUniqueKey(GradeMenuAuthList.GRADE_MENU_AUTH_LIST, DSL.name("CONSTRAINT_BA"), arrayOf(GradeMenuAuthList.GRADE_MENU_AUTH_LIST.ID), true)
val CONSTRAINT_B7: UniqueKey<GrantLogRecord> = Internal.createUniqueKey(GrantLog.GRANT_LOG, DSL.name("CONSTRAINT_B7"), arrayOf(GrantLog.GRANT_LOG.GRANT_LOG_ID), true)
val CONSTRAINT_33: UniqueKey<MenuRecord> = Internal.createUniqueKey(Menu.MENU, DSL.name("CONSTRAINT_33"), arrayOf(Menu.MENU.MENU_ID), true)
val CONSTRAINT_C2: UniqueKey<NoticeRecord> = Internal.createUniqueKey(Notice.NOTICE, DSL.name("CONSTRAINT_C2"), arrayOf(Notice.NOTICE.NOTICE_ID), true)
val CONSTRAINT_1: UniqueKey<NoticeCheckRecord> = Internal.createUniqueKey(NoticeCheck.NOTICE_CHECK, DSL.name("CONSTRAINT_1"), arrayOf(NoticeCheck.NOTICE_CHECK.NOTICE_CHECK_ID), true)
val CONSTRAINT_79: UniqueKey<OtpTotpTotpdeviceRecord> = Internal.createUniqueKey(OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE, DSL.name("CONSTRAINT_79"), arrayOf(OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE.ID), true)
val CONSTRAINT_6C: UniqueKey<SpcAuthReqRecord> = Internal.createUniqueKey(SpcAuthReq.SPC_AUTH_REQ, DSL.name("CONSTRAINT_6C"), arrayOf(SpcAuthReq.SPC_AUTH_REQ.SPC_AUTH_REQ_ID), true)
val CONSTRAINT_35: UniqueKey<SpcAuthReqInfoRecord> = Internal.createUniqueKey(SpcAuthReqInfo.SPC_AUTH_REQ_INFO, DSL.name("CONSTRAINT_35"), arrayOf(SpcAuthReqInfo.SPC_AUTH_REQ_INFO.SPC_AUTH_APPROVE_ID), true)
val CONSTRAINT_DA: UniqueKey<SpoonRewardRecord> = Internal.createUniqueKey(SpoonReward.SPOON_REWARD, DSL.name("CONSTRAINT_DA"), arrayOf(SpoonReward.SPOON_REWARD.ID), true)
val CONSTRAINT_5: UniqueKey<SpoonRewardUserRecord> = Internal.createUniqueKey(SpoonRewardUser.SPOON_REWARD_USER, DSL.name("CONSTRAINT_5"), arrayOf(SpoonRewardUser.SPOON_REWARD_USER.ID), true)
val CONSTRAINT_84: UniqueKey<SubMenuRecord> = Internal.createUniqueKey(SubMenu.SUB_MENU, DSL.name("CONSTRAINT_84"), arrayOf(SubMenu.SUB_MENU.SUB_MENU_ID), true)
val CONSTRAINT_F5: UniqueKey<TbexchangeactionhistoryRecord> = Internal.createUniqueKey(Tbexchangeactionhistory.TBEXCHANGEACTIONHISTORY, DSL.name("CONSTRAINT_F5"), arrayOf(Tbexchangeactionhistory.TBEXCHANGEACTIONHISTORY.ID), true)
val CONSTRAINT_C5: UniqueKey<TbspoonvalidsynchistoryRecord> = Internal.createUniqueKey(Tbspoonvalidsynchistory.TBSPOONVALIDSYNCHISTORY, DSL.name("CONSTRAINT_C5"), arrayOf(Tbspoonvalidsynchistory.TBSPOONVALIDSYNCHISTORY.ID), true)
val CONSTRAINT_50: UniqueKey<TeamMenuAuthListRecord> = Internal.createUniqueKey(TeamMenuAuthList.TEAM_MENU_AUTH_LIST, DSL.name("CONSTRAINT_50"), arrayOf(TeamMenuAuthList.TEAM_MENU_AUTH_LIST.ID), true)
val CONSTRAINT_69: UniqueKey<TermsRecord> = Internal.createUniqueKey(Terms.TERMS, DSL.name("CONSTRAINT_69"), arrayOf(Terms.TERMS.TERMS_ID), true)
val CONSTRAINT_85: UniqueKey<TermsCheckRecord> = Internal.createUniqueKey(TermsCheck.TERMS_CHECK, DSL.name("CONSTRAINT_85"), arrayOf(TermsCheck.TERMS_CHECK.TERMS_CHECK_ID), true)
val CONSTRAINT_25: UniqueKey<UserMenuAuthRecord> = Internal.createUniqueKey(UserMenuAuth.USER_MENU_AUTH, DSL.name("CONSTRAINT_25"), arrayOf(UserMenuAuth.USER_MENU_AUTH.USER_MENU_AUTH_ID), true)
val CONSTRAINT_96: UniqueKey<UsersDeactiveRecord> = Internal.createUniqueKey(UsersDeactive.USERS_DEACTIVE, DSL.name("CONSTRAINT_96"), arrayOf(UsersDeactive.USERS_DEACTIVE.USER_DEACTIVE_ID), true)
val CONSTRAINT_4: UniqueKey<VocAttachmentRecord> = Internal.createUniqueKey(VocAttachment.VOC_ATTACHMENT, DSL.name("CONSTRAINT_4"), arrayOf(VocAttachment.VOC_ATTACHMENT.ATTACHMENT_ID), true)
val CONSTRAINT_98: UniqueKey<VocBanshistoryRecord> = Internal.createUniqueKey(VocBanshistory.VOC_BANSHISTORY, DSL.name("CONSTRAINT_98"), arrayOf(VocBanshistory.VOC_BANSHISTORY.BANS_HISTORY_ID), true)
val CONSTRAINT_7F: UniqueKey<VocHistRecord> = Internal.createUniqueKey(VocHist.VOC_HIST, DSL.name("CONSTRAINT_7F"), arrayOf(VocHist.VOC_HIST.VOC_HIST_ID), true)
val CONSTRAINT_7FC: UniqueKey<VocReplyRecord> = Internal.createUniqueKey(VocReply.VOC_REPLY, DSL.name("CONSTRAINT_7FC"), arrayOf(VocReply.VOC_REPLY.REPLY_ID), true)
