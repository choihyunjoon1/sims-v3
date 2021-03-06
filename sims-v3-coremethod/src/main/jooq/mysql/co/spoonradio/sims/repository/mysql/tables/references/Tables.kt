/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.mysql.tables.references


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



/**
 * The table <code>admin_user</code>.
 */
val ADMIN_USER = AdminUser.ADMIN_USER

/**
 * The table <code>allow_equi</code>.
 */
val ALLOW_EQUI = AllowEqui.ALLOW_EQUI

/**
 * The table <code>audit_log</code>.
 */
val AUDIT_LOG = AuditLog.AUDIT_LOG

/**
 * The table <code>auth_group</code>.
 */
val AUTH_GROUP = AuthGroup.AUTH_GROUP

/**
 * The table <code>auth_group_permissions</code>.
 */
val AUTH_GROUP_PERMISSIONS = AuthGroupPermissions.AUTH_GROUP_PERMISSIONS

/**
 * The table <code>auth_permission</code>.
 */
val AUTH_PERMISSION = AuthPermission.AUTH_PERMISSION

/**
 * The table <code>authtoken_token</code>.
 */
val AUTHTOKEN_TOKEN = AuthtokenToken.AUTHTOKEN_TOKEN

/**
 * The table <code>batch_log</code>.
 */
val BATCH_LOG = BatchLog.BATCH_LOG

/**
 * The table <code>batch_log_deail</code>.
 */
val BATCH_LOG_DEAIL = BatchLogDeail.BATCH_LOG_DEAIL

/**
 * The table <code>batch_manage</code>.
 */
val BATCH_MANAGE = BatchManage.BATCH_MANAGE

/**
 * The table <code>com_code</code>.
 */
val COM_CODE = ComCode.COM_CODE

/**
 * The table <code>django_admin_log</code>.
 */
val DJANGO_ADMIN_LOG = DjangoAdminLog.DJANGO_ADMIN_LOG

/**
 * The table <code>django_content_type</code>.
 */
val DJANGO_CONTENT_TYPE = DjangoContentType.DJANGO_CONTENT_TYPE

/**
 * The table <code>django_migrations</code>.
 */
val DJANGO_MIGRATIONS = DjangoMigrations.DJANGO_MIGRATIONS

/**
 * The table <code>django_session</code>.
 */
val DJANGO_SESSION = DjangoSession.DJANGO_SESSION

/**
 * The table <code>external_link_log</code>.
 */
val EXTERNAL_LINK_LOG = ExternalLinkLog.EXTERNAL_LINK_LOG

/**
 * The table <code>grade_menu_auth_list</code>.
 */
val GRADE_MENU_AUTH_LIST = GradeMenuAuthList.GRADE_MENU_AUTH_LIST

/**
 * The table <code>grant_log</code>.
 */
val GRANT_LOG = GrantLog.GRANT_LOG

/**
 * The table <code>menu</code>.
 */
val MENU = Menu.MENU

/**
 * The table <code>notice</code>.
 */
val NOTICE = Notice.NOTICE

/**
 * The table <code>notice_check</code>.
 */
val NOTICE_CHECK = NoticeCheck.NOTICE_CHECK

/**
 * The table <code>otp_totp_totpdevice</code>.
 */
val OTP_TOTP_TOTPDEVICE = OtpTotpTotpdevice.OTP_TOTP_TOTPDEVICE

/**
 * The table <code>spc_auth_req</code>.
 */
val SPC_AUTH_REQ = SpcAuthReq.SPC_AUTH_REQ

/**
 * The table <code>spc_auth_req_info</code>.
 */
val SPC_AUTH_REQ_INFO = SpcAuthReqInfo.SPC_AUTH_REQ_INFO

/**
 * The table <code>spoon_reward</code>.
 */
val SPOON_REWARD = SpoonReward.SPOON_REWARD

/**
 * The table <code>spoon_reward_user</code>.
 */
val SPOON_REWARD_USER = SpoonRewardUser.SPOON_REWARD_USER

/**
 * The table <code>sub_menu</code>.
 */
val SUB_MENU = SubMenu.SUB_MENU

/**
 * The table <code>tbExchangeActionHistory</code>.
 */
val TBEXCHANGEACTIONHISTORY = Tbexchangeactionhistory.TBEXCHANGEACTIONHISTORY

/**
 * The table <code>tbSpoonValidSyncHistory</code>.
 */
val TBSPOONVALIDSYNCHISTORY = Tbspoonvalidsynchistory.TBSPOONVALIDSYNCHISTORY

/**
 * The table <code>team_menu_auth_list</code>.
 */
val TEAM_MENU_AUTH_LIST = TeamMenuAuthList.TEAM_MENU_AUTH_LIST

/**
 * The table <code>terms</code>.
 */
val TERMS = Terms.TERMS

/**
 * The table <code>terms_check</code>.
 */
val TERMS_CHECK = TermsCheck.TERMS_CHECK

/**
 * The table <code>user_menu_auth</code>.
 */
val USER_MENU_AUTH = UserMenuAuth.USER_MENU_AUTH

/**
 * The table <code>users_deactive</code>.
 */
val USERS_DEACTIVE = UsersDeactive.USERS_DEACTIVE

/**
 * The table <code>voc_attachment</code>.
 */
val VOC_ATTACHMENT = VocAttachment.VOC_ATTACHMENT

/**
 * The table <code>voc_banshistory</code>.
 */
val VOC_BANSHISTORY = VocBanshistory.VOC_BANSHISTORY

/**
 * The table <code>voc_hist</code>.
 */
val VOC_HIST = VocHist.VOC_HIST

/**
 * The table <code>voc_reply</code>.
 */
val VOC_REPLY = VocReply.VOC_REPLY
