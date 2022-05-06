/*
 * This file is generated by jOOQ.
 */
package co.spoonradio.sims.repository.billing.keys


import co.spoonradio.sims.repository.billing.tables.Tbadpopcornhistory
import co.spoonradio.sims.repository.billing.tables.Tbapplestorehistory
import co.spoonradio.sims.repository.billing.tables.Tberrorlog
import co.spoonradio.sims.repository.billing.tables.Tbexchange
import co.spoonradio.sims.repository.billing.tables.Tbexchangeamount
import co.spoonradio.sims.repository.billing.tables.Tbexchangeamountdotmoneyhistory
import co.spoonradio.sims.repository.billing.tables.Tbexchangedeposit
import co.spoonradio.sims.repository.billing.tables.Tbexchangedotmoneyproducts
import co.spoonradio.sims.repository.billing.tables.Tbexchangedotmoneysignaturedata
import co.spoonradio.sims.repository.billing.tables.Tbexchangehistory
import co.spoonradio.sims.repository.billing.tables.Tbexchangerejectreason
import co.spoonradio.sims.repository.billing.tables.Tbexchangesubmitdocument
import co.spoonradio.sims.repository.billing.tables.Tbgiftcardhistory
import co.spoonradio.sims.repository.billing.tables.Tbitemproduct
import co.spoonradio.sims.repository.billing.tables.Tbitempromotion
import co.spoonradio.sims.repository.billing.tables.Tbitemstore
import co.spoonradio.sims.repository.billing.tables.Tbpayment
import co.spoonradio.sims.repository.billing.tables.Tbpaymentmethod
import co.spoonradio.sims.repository.billing.tables.Tbpaypalhistory
import co.spoonradio.sims.repository.billing.tables.Tbplaystorehistory
import co.spoonradio.sims.repository.billing.tables.Tbpromotionhistory
import co.spoonradio.sims.repository.billing.tables.Tbsettlebankhistory
import co.spoonradio.sims.repository.billing.tables.Tbsoftbankhistory
import co.spoonradio.sims.repository.billing.tables.Tbsubscribe
import co.spoonradio.sims.repository.billing.tables.Tbsubscribeandroidhistory
import co.spoonradio.sims.repository.billing.tables.Tbsubscribeioshistory
import co.spoonradio.sims.repository.billing.tables.Tbtosshistory
import co.spoonradio.sims.repository.billing.tables.Tbwebmoneyhistory
import co.spoonradio.sims.repository.billing.tables.records.TbadpopcornhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbapplestorehistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TberrorlogRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangeRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangeamountRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangeamountdotmoneyhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangedepositRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangedotmoneyproductsRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangedotmoneysignaturedataRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangehistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangerejectreasonRecord
import co.spoonradio.sims.repository.billing.tables.records.TbexchangesubmitdocumentRecord
import co.spoonradio.sims.repository.billing.tables.records.TbgiftcardhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbitemproductRecord
import co.spoonradio.sims.repository.billing.tables.records.TbitempromotionRecord
import co.spoonradio.sims.repository.billing.tables.records.TbitemstoreRecord
import co.spoonradio.sims.repository.billing.tables.records.TbpaymentRecord
import co.spoonradio.sims.repository.billing.tables.records.TbpaymentmethodRecord
import co.spoonradio.sims.repository.billing.tables.records.TbpaypalhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbplaystorehistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbpromotionhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbsettlebankhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbsoftbankhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbsubscribeRecord
import co.spoonradio.sims.repository.billing.tables.records.TbsubscribeandroidhistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbsubscribeioshistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbtosshistoryRecord
import co.spoonradio.sims.repository.billing.tables.records.TbwebmoneyhistoryRecord

import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val PK_REWARDADPOPCORNHISTORY_ID: UniqueKey<TbadpopcornhistoryRecord> = Internal.createUniqueKey(Tbadpopcornhistory.TBADPOPCORNHISTORY, DSL.name("pk_RewardAdpopcornHistory_id"), arrayOf(Tbadpopcornhistory.TBADPOPCORNHISTORY.ID), true)
val UIDX_REWARDKEY_USERID: UniqueKey<TbadpopcornhistoryRecord> = Internal.createUniqueKey(Tbadpopcornhistory.TBADPOPCORNHISTORY, DSL.name("uidx_rewardKey_userId"), arrayOf(Tbadpopcornhistory.TBADPOPCORNHISTORY.USERID, Tbadpopcornhistory.TBADPOPCORNHISTORY.REWARDKEY), true)
val PK_APPLE_STORE_HISTORY_ID: UniqueKey<TbapplestorehistoryRecord> = Internal.createUniqueKey(Tbapplestorehistory.TBAPPLESTOREHISTORY, DSL.name("pk_apple_store_history_id"), arrayOf(Tbapplestorehistory.TBAPPLESTOREHISTORY.ID), true)
val UIDX_APPLE_STORE_TRANSACTION_ID: UniqueKey<TbapplestorehistoryRecord> = Internal.createUniqueKey(Tbapplestorehistory.TBAPPLESTOREHISTORY, DSL.name("uidx_apple_store_transaction_id"), arrayOf(Tbapplestorehistory.TBAPPLESTOREHISTORY.TRANSACTIONID), true)
val PK_ERRORLOG_ID: UniqueKey<TberrorlogRecord> = Internal.createUniqueKey(Tberrorlog.TBERRORLOG, DSL.name("pk_ErrorLog_id"), arrayOf(Tberrorlog.TBERRORLOG.ID), true)
val PK_EXCHANGE_ID: UniqueKey<TbexchangeRecord> = Internal.createUniqueKey(Tbexchange.TBEXCHANGE, DSL.name("pk_Exchange_id"), arrayOf(Tbexchange.TBEXCHANGE.ID), true)
val PK_EXCHANGEAMOUNT_ID: UniqueKey<TbexchangeamountRecord> = Internal.createUniqueKey(Tbexchangeamount.TBEXCHANGEAMOUNT, DSL.name("pk_ExchangeAmount_id"), arrayOf(Tbexchangeamount.TBEXCHANGEAMOUNT.ID), true)
val PK_EXCHANGEAMOUNTDOTMONEYHISTORY_EXCHANGEAMOUNTID: UniqueKey<TbexchangeamountdotmoneyhistoryRecord> = Internal.createUniqueKey(Tbexchangeamountdotmoneyhistory.TBEXCHANGEAMOUNTDOTMONEYHISTORY, DSL.name("pk_ExchangeAmountDotmoneyHistory_exchangeAmountId"), arrayOf(Tbexchangeamountdotmoneyhistory.TBEXCHANGEAMOUNTDOTMONEYHISTORY.EXCHANGEAMOUNTID), true)
val PK_EXCHANGEDEPOSIT_ID: UniqueKey<TbexchangedepositRecord> = Internal.createUniqueKey(Tbexchangedeposit.TBEXCHANGEDEPOSIT, DSL.name("pk_ExchangeDeposit_id"), arrayOf(Tbexchangedeposit.TBEXCHANGEDEPOSIT.ID), true)
val PK_EXCHANGEDOTMONEYPRODUCTS_ID: UniqueKey<TbexchangedotmoneyproductsRecord> = Internal.createUniqueKey(Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS, DSL.name("pk_ExchangeDotmoneyProducts_id"), arrayOf(Tbexchangedotmoneyproducts.TBEXCHANGEDOTMONEYPRODUCTS.ID), true)
val PK_EXCHANGEDOTMONEYSIGNATUREDATA_USERID: UniqueKey<TbexchangedotmoneysignaturedataRecord> = Internal.createUniqueKey(Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA, DSL.name("pk_ExchangeDotmoneySignatureData_userId"), arrayOf(Tbexchangedotmoneysignaturedata.TBEXCHANGEDOTMONEYSIGNATUREDATA.USERID), true)
val CONSTRAINT_F: UniqueKey<TbexchangehistoryRecord> = Internal.createUniqueKey(Tbexchangehistory.TBEXCHANGEHISTORY, DSL.name("CONSTRAINT_F"), arrayOf(Tbexchangehistory.TBEXCHANGEHISTORY.ID), true)
val PK_EXCHANGEREJECTREASON_ID: UniqueKey<TbexchangerejectreasonRecord> = Internal.createUniqueKey(Tbexchangerejectreason.TBEXCHANGEREJECTREASON, DSL.name("pk_ExchangeRejectReason_id"), arrayOf(Tbexchangerejectreason.TBEXCHANGEREJECTREASON.ID), true)
val PK_EXCHANGESUBMITDOCUMENT_ID: UniqueKey<TbexchangesubmitdocumentRecord> = Internal.createUniqueKey(Tbexchangesubmitdocument.TBEXCHANGESUBMITDOCUMENT, DSL.name("pk_ExchangeSubmitDocument_id"), arrayOf(Tbexchangesubmitdocument.TBEXCHANGESUBMITDOCUMENT.ID), true)
val PK_GIFTCARD_HISTORY_ID: UniqueKey<TbgiftcardhistoryRecord> = Internal.createUniqueKey(Tbgiftcardhistory.TBGIFTCARDHISTORY, DSL.name("pk_giftcard_history_id"), arrayOf(Tbgiftcardhistory.TBGIFTCARDHISTORY.ID), true)
val PK_ITEMPRODUCT_ID: UniqueKey<TbitemproductRecord> = Internal.createUniqueKey(Tbitemproduct.TBITEMPRODUCT, DSL.name("pk_ItemProduct_id"), arrayOf(Tbitemproduct.TBITEMPRODUCT.ID), true)
val PK_ITEM_PROMOTION_ID: UniqueKey<TbitempromotionRecord> = Internal.createUniqueKey(Tbitempromotion.TBITEMPROMOTION, DSL.name("pk_item_promotion_id"), arrayOf(Tbitempromotion.TBITEMPROMOTION.ID), true)
val UIDX_CODE: UniqueKey<TbitempromotionRecord> = Internal.createUniqueKey(Tbitempromotion.TBITEMPROMOTION, DSL.name("uidx_code"), arrayOf(Tbitempromotion.TBITEMPROMOTION.CODE), true)
val PK_ITEMSTORE_ID: UniqueKey<TbitemstoreRecord> = Internal.createUniqueKey(Tbitemstore.TBITEMSTORE, DSL.name("pk_ItemStore_id"), arrayOf(Tbitemstore.TBITEMSTORE.ID), true)
val PK_PAYMENT_ID: UniqueKey<TbpaymentRecord> = Internal.createUniqueKey(Tbpayment.TBPAYMENT, DSL.name("pk_payment_id"), arrayOf(Tbpayment.TBPAYMENT.ID, Tbpayment.TBPAYMENT.CREATEDDATE), true)
val UIDX_PAYMENT_ORDER_ID: UniqueKey<TbpaymentRecord> = Internal.createUniqueKey(Tbpayment.TBPAYMENT, DSL.name("uidx_payment_order_id"), arrayOf(Tbpayment.TBPAYMENT.ORDERID), true)
val UIDX_PAYMENT_TXID: UniqueKey<TbpaymentRecord> = Internal.createUniqueKey(Tbpayment.TBPAYMENT, DSL.name("uidx_Payment_txid"), arrayOf(Tbpayment.TBPAYMENT.TXID), true)
val PK_PAYMENTMETHOD_ID: UniqueKey<TbpaymentmethodRecord> = Internal.createUniqueKey(Tbpaymentmethod.TBPAYMENTMETHOD, DSL.name("pk_PaymentMethod_id"), arrayOf(Tbpaymentmethod.TBPAYMENTMETHOD.ID), true)
val PK_PAYPAL_HISTORY_ID: UniqueKey<TbpaypalhistoryRecord> = Internal.createUniqueKey(Tbpaypalhistory.TBPAYPALHISTORY, DSL.name("pk_paypal_history_id"), arrayOf(Tbpaypalhistory.TBPAYPALHISTORY.ID), true)
val UIDX_PAYPAL_HISTORY_ORDER_ID: UniqueKey<TbpaypalhistoryRecord> = Internal.createUniqueKey(Tbpaypalhistory.TBPAYPALHISTORY, DSL.name("uidx_paypal_history_order_id"), arrayOf(Tbpaypalhistory.TBPAYPALHISTORY.ORDERID), true)
val PK_PLAYSTORE_HISTORY_ID: UniqueKey<TbplaystorehistoryRecord> = Internal.createUniqueKey(Tbplaystorehistory.TBPLAYSTOREHISTORY, DSL.name("pk_playstore_history_id"), arrayOf(Tbplaystorehistory.TBPLAYSTOREHISTORY.ID), true)
val UIDX_PLAYSTORE_HISTORY_ORDER_ID: UniqueKey<TbplaystorehistoryRecord> = Internal.createUniqueKey(Tbplaystorehistory.TBPLAYSTOREHISTORY, DSL.name("uidx_playstore_history_order_id"), arrayOf(Tbplaystorehistory.TBPLAYSTOREHISTORY.ORDERID), true)
val PK_PROMOTIONHISTORY_ID: UniqueKey<TbpromotionhistoryRecord> = Internal.createUniqueKey(Tbpromotionhistory.TBPROMOTIONHISTORY, DSL.name("pk_PromotionHistory_id"), arrayOf(Tbpromotionhistory.TBPROMOTIONHISTORY.ID), true)
val PK_SETTLEBANK_HISTORY_ID: UniqueKey<TbsettlebankhistoryRecord> = Internal.createUniqueKey(Tbsettlebankhistory.TBSETTLEBANKHISTORY, DSL.name("pk_settlebank_history_id"), arrayOf(Tbsettlebankhistory.TBSETTLEBANKHISTORY.ID), true)
val UIDX_POID: UniqueKey<TbsettlebankhistoryRecord> = Internal.createUniqueKey(Tbsettlebankhistory.TBSETTLEBANKHISTORY, DSL.name("uidx_poid"), arrayOf(Tbsettlebankhistory.TBSETTLEBANKHISTORY.POID), true)
val PK_SOFTBANK_HISTORY_ID: UniqueKey<TbsoftbankhistoryRecord> = Internal.createUniqueKey(Tbsoftbankhistory.TBSOFTBANKHISTORY, DSL.name("pk_softbank_history_id"), arrayOf(Tbsoftbankhistory.TBSOFTBANKHISTORY.ID), true)
val UIDX_SOFTBANK_HISTORY_ORDER_ID: UniqueKey<TbsoftbankhistoryRecord> = Internal.createUniqueKey(Tbsoftbankhistory.TBSOFTBANKHISTORY, DSL.name("uidx_softbank_history_order_id"), arrayOf(Tbsoftbankhistory.TBSOFTBANKHISTORY.ORDERID), true)
val PK_SUBSCRIBE_ID: UniqueKey<TbsubscribeRecord> = Internal.createUniqueKey(Tbsubscribe.TBSUBSCRIBE, DSL.name("pk_subscribe_id"), arrayOf(Tbsubscribe.TBSUBSCRIBE.ID), true)
val UIDX_ORIGINAL_TRANSACTION_ID: UniqueKey<TbsubscribeRecord> = Internal.createUniqueKey(Tbsubscribe.TBSUBSCRIBE, DSL.name("uidx_original_transaction_id"), arrayOf(Tbsubscribe.TBSUBSCRIBE.ORIGINALTRANSACTIONID), true)
val PK_SUBSCRIBE_ANDROID_HISTORY_ID: UniqueKey<TbsubscribeandroidhistoryRecord> = Internal.createUniqueKey(Tbsubscribeandroidhistory.TBSUBSCRIBEANDROIDHISTORY, DSL.name("pk_subscribe_android_history_id"), arrayOf(Tbsubscribeandroidhistory.TBSUBSCRIBEANDROIDHISTORY.ID), true)
val UIDX_SUBSCRIBE_ANDROID_HISTORY_ORDER_ID: UniqueKey<TbsubscribeandroidhistoryRecord> = Internal.createUniqueKey(Tbsubscribeandroidhistory.TBSUBSCRIBEANDROIDHISTORY, DSL.name("uidx_subscribe_android_history_order_id"), arrayOf(Tbsubscribeandroidhistory.TBSUBSCRIBEANDROIDHISTORY.ORDERID), true)
val PK_SUBSCRIBE_IOS_HISTORY_ID: UniqueKey<TbsubscribeioshistoryRecord> = Internal.createUniqueKey(Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY, DSL.name("pk_subscribe_ios_history_id"), arrayOf(Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.ID), true)
val UIDX_SUBSCRIBE_IOS_HISTORY_TRANSACTION_ID: UniqueKey<TbsubscribeioshistoryRecord> = Internal.createUniqueKey(Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY, DSL.name("uidx_subscribe_ios_history_transaction_id"), arrayOf(Tbsubscribeioshistory.TBSUBSCRIBEIOSHISTORY.TRANSACTIONID), true)
val PK_TOSS_HISTORY_ID: UniqueKey<TbtosshistoryRecord> = Internal.createUniqueKey(Tbtosshistory.TBTOSSHISTORY, DSL.name("pk_toss_history_id"), arrayOf(Tbtosshistory.TBTOSSHISTORY.ID), true)
val UIDX_ORDER_NO: UniqueKey<TbtosshistoryRecord> = Internal.createUniqueKey(Tbtosshistory.TBTOSSHISTORY, DSL.name("uidx_order_no"), arrayOf(Tbtosshistory.TBTOSSHISTORY.ORDERNO), true)
val PK_WEBMONEY_HISTORY_ID: UniqueKey<TbwebmoneyhistoryRecord> = Internal.createUniqueKey(Tbwebmoneyhistory.TBWEBMONEYHISTORY, DSL.name("pk_webmoney_history_id"), arrayOf(Tbwebmoneyhistory.TBWEBMONEYHISTORY.ID), true)
val UIDX_ORDER_CODE: UniqueKey<TbwebmoneyhistoryRecord> = Internal.createUniqueKey(Tbwebmoneyhistory.TBWEBMONEYHISTORY, DSL.name("uidx_order_code"), arrayOf(Tbwebmoneyhistory.TBWEBMONEYHISTORY.ORDERCODE), true)
