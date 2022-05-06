
CREATE TABLE `tbSubscribe`
(
    `id`                    INT AUTO_INCREMENT ,
    `originalTransactionId` VARCHAR(255)                       NOT NULL COMMENT '플랫폼에서 조회할수있는 구독의 판별자 ios: originalTransactionId, android: purchaseToken',
    `status`                TINYINT                            NOT NULL COMMENT '구독 상태',
    `productId`             INT                                NOT NULL COMMENT '상품아이디',
    `userId`                INT                                NOT NULL,
    `price`                 INT                                NOT NULL COMMENT '상품가격',
    `spoonAmount`           INT                                NOT NULL COMMENT '지급 스푼 개수',
    `platform`              TINYINT                            NOT NULL COMMENT '플랫폼 (android/ios)',
    `isAutoRenew`           BOOL                               NOT NULL COMMENT '구독 갱신 유무',
    `createdDate`           DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
    `updatedDate`           DATETIME                           NULL ON UPDATE CURRENT_TIMESTAMP,
    `startDate`             DATETIME                           NOT NULL COMMENT '구독 시작일',
    `expireDate`            DATETIME                           NOT NULL COMMENT '구독 만료일',
    CONSTRAINT `pk_subscribe_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_original_transaction_id` UNIQUE (`originalTransactionId`)
) ENGINE = innodb;

CREATE TABLE `tbPayment`
(
    `id`              INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `userId`          INT                NOT NULL COMMENT '구매한 user ID',
    `productId`       INT                NOT NULL COMMENT '구매한 Product ID - item_product.id',
    `status`          VARCHAR(10)        NOT NULL COMMENT 'status ex) COMP/PROC',
    `amount`          INT                NOT NULL COMMENT '상품가격',
    `spoonAmount`     INT                NOT NULL COMMENT '지급스푼개수',
    `quantity`        INT                NOT NULL COMMENT '수량',
    `displayName`     VARCHAR(64)        NOT NULL COMMENT '상품표출명',
    `orderId`         VARCHAR(28)        NOT NULL COMMENT '주문번호',
    `txId`            VARCHAR(64)        NOT NULL COMMENT 'Transaction ID (UUID)',
    `platform`        CHAR(4)            NOT NULL COMMENT 'user platform ex) WEB',
    `dueDate`         DATETIME                    DEFAULT NULL COMMENT '결제완료시간(가상계좌결제)',
    `completed`       DATETIME                    DEFAULT NULL COMMENT '완료 시간',
    `createdDate`     DATETIME           NOT NULL DEFAULT current_timestamp COMMENT '생성일시',
    `type`            TINYINT            NOT NULL COMMENT '결제타입 ex) 일반결제, 정기결제 타입',
    `promotionId`     INT                NULL COMMENT '프로모션 아이디',
    `paymentMethodId` INT                NULL COMMENT '결제방법 아이디',
    CONSTRAINT `pk_payment_id` PRIMARY KEY (`id`, `createdDate`),
    CONSTRAINT `uidx_payment_order_id` UNIQUE (`orderId`),
    UNIQUE KEY `uidx_Payment_txid` (`txId`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;


CREATE TABLE `tbSubscribeAndroidHistory`
(
    `id`          INT AUTO_INCREMENT NOT NULL,
    `subscribeId` INT                                NOT NULL COMMENT '구독 아이디 - tbSubscribe.id',
    `txId`        VARCHAR(64)                        NOT NULL,
    `orderId`     VARCHAR(64)                        NOT NULL COMMENT '주문 아이디',
    `status`      VARCHAR(10)                        NOT NULL COMMENT '지급 상태',
    `createdDate` DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
    `startDate`   DATETIME                           NULL COMMENT '정기결제 시작일',
    `expireDate`  DATETIME                           NOT NULL COMMENT '정기결제 만료일',
    `updatedDate` DATETIME                           NULL ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `pk_subscribe_android_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_subscribe_android_history_order_id` UNIQUE (`orderId`)
) ENGINE = innodb;

CREATE TABLE `tbSubscribeIosHistory`
(
    `id`                          INT AUTO_INCREMENT,
    `subscribeId`                 INT                                NOT NULL COMMENT '구독아이디 - tbSubscribe.id',
    `status`                      VARCHAR(10)                        NOT NULL COMMENT '지급상태',
    `txId`                        VARCHAR(64)                        NOT NULL,
    `receiptData`                 MEDIUMTEXT                         NOT NULL COMMENT '영수증',
    `transactionId`               VARCHAR(64)                        NULL COMMENT '주문아이디',
    `webOrderLineItemId`          VARCHAR(255)                       NULL COMMENT '결제 식별자',
    `trialPeriod`                 VARCHAR(5)                         NOT NULL COMMENT '구독 무료기간 유무 (true/false)',
    `inIntroOfferPeriod`          VARCHAR(5)                         NOT NULL COMMENT '할인가격 기간인지 유무 (true/false)',
    `subscriptionGroupIdentifier` VARCHAR(255)                       NOT NULL COMMENT '구독 아이템 식별자',
    `createdDate`                 DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
    `startDate`                   DATETIME                           NOT NULL COMMENT '구독 시작일',
    `expireDate`                  DATETIME                           NOT NULL COMMENT '구독 만료일',
    `updatedDate`                 DATETIME                           NULL on update CURRENT_TIMESTAMP,
    CONSTRAINT `pk_subscribe_ios_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_subscribe_ios_history_transaction_id` UNIQUE (`transactionId`)
) ENGINE = innodb;

CREATE TABLE `tbApplestoreHistory`
(
    `id`               INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `txId`             VARCHAR(64)                 DEFAULT NULL COMMENT '결제 고유 값',
    `transactionId`    VARCHAR(255)       NOT NULL,
    `transactionDate`  DATETIME                    DEFAULT NULL,
    `transactionState` INT                         DEFAULT NULL,
    `transactionError` TEXT,
    `receiptData`      TEXT,
    `status`           VARCHAR(10)        NOT NULL,
    `modelName`        VARCHAR(100)                DEFAULT NULL,
    `buildNo`          INT                NOT NULL,
    `requestTime`      DATETIME                    DEFAULT NULL,
    `consumeTime`      DATETIME                    DEFAULT NULL,
    `created`          DATETIME           NOT NULL DEFAULT current_timestamp,
    `productId`        INT                NOT NULL,
    `userId`           INT                NOT NULL,
    `updated`          DATETIME           NULL on update CURRENT_TIMESTAMP,
    CONSTRAINT `pk_apple_store_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_apple_store_transaction_id` UNIQUE (`transactionId`)
) ENGINE = innodb;
CREATE INDEX `idx_securityKey` on `tbApplestoreHistory` (`txId`);

CREATE TABLE `tbPaypalHistory`
(
    `id`              INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `txId`            VARCHAR(64)                 DEFAULT NULL COMMENT '결제 고유 값',
    `quantity`        INT                         DEFAULT NULL,
    `status`          VARCHAR(10)        NOT NULL,
    `userAgent`       VARCHAR(100)                DEFAULT NULL,
    `updated`         DATETIME           NULL on update CURRENT_TIMESTAMP,
    `completed`       DATETIME                    DEFAULT NULL,
    `created`         DATETIME           NOT NULL DEFAULT current_timestamp,
    `errorMessage`    VARCHAR(128)                DEFAULT NULL,
    `amount`          DOUBLE                      DEFAULT NULL,
    `itemName`        VARCHAR(80)        NOT NULL,
    `countryCode`     VARCHAR(4)         NOT NULL,
    `detailCountryCode`     VARCHAR(4)         NOT NULL,
    `linkCapture`     VARCHAR(255)                DEFAULT NULL,
    `linkApprove`     VARCHAR(255)                DEFAULT NULL,
    `payerId`         VARCHAR(32)                 DEFAULT NULL,
    `grossAmount`     DOUBLE                      DEFAULT NULL,
    `feesAmount`      DOUBLE                      DEFAULT NULL,
    `netAmount`       DOUBLE                      DEFAULT NULL,
    `productId`       INT                         DEFAULT NULL,
    `promotionId`     INT                         DEFAULT NULL,
    `userId`          INT                         DEFAULT NULL,
    `paymentStatus`   VARCHAR(32)                 DEFAULT NULL,
    `currency`        CHAR(3)                     DEFAULT NULL,
    `paypalCaptureId` VARCHAR(32)                 DEFAULT NULL,
    `orderId`         VARCHAR(100)       NOT NULL,
    CONSTRAINT `pk_paypal_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_paypal_history_order_id` UNIQUE (`orderId`)
) ENGINE = innodb;

CREATE TABLE `tbPlaystoreHistory`
(
    `id`            INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `txId`          VARCHAR(64)                 DEFAULT NULL,
    `orderId`       VARCHAR(100)                DEFAULT NULL,
    `purchaseToken` VARCHAR(255)                DEFAULT NULL,
    `purchaseState` INT                         DEFAULT '0',
    `purchaseTime`  DATETIME                    DEFAULT NULL,
    `status`        VARCHAR(10)        NOT NULL,
    `modelName`     VARCHAR(100)                DEFAULT NULL,
    `buildNo`       INT                NOT NULL,
    `requestTime`   DATETIME                    DEFAULT NULL,
    `verifyTime`    DATETIME                    DEFAULT NULL,
    `consumeTime`   DATETIME                    DEFAULT NULL,
    `created`       DATETIME           NOT NULL DEFAULT current_timestamp,
    `productId`     INT                         DEFAULT NULL,
    `userId`        INT                         DEFAULT NULL,
    `updated`       DATETIME           NULL on update CURRENT_TIMESTAMP,
    CONSTRAINT `pk_playstore_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_playstore_history_order_id` UNIQUE (`orderId`)
) ENGINE = innodb;

CREATE TABLE `tbSettleBankHistory`
(
    `id`            INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `userAgent`     VARCHAR(32)                 DEFAULT NULL,
    `status`        VARCHAR(10)                 DEFAULT NULL,
    `vbankStatus`   INT                         DEFAULT NULL,
    `txId`          VARCHAR(64)                 DEFAULT NULL,
    `pStateCd`      VARCHAR(4)                  DEFAULT NULL,
    `pTrno`         VARCHAR(100)                DEFAULT NULL,
    `pType`         VARCHAR(100)                DEFAULT NULL,
    `pMid`          VARCHAR(10)                 DEFAULT NULL,
    `pOid`          VARCHAR(100)                DEFAULT NULL,
    `pMname`        VARCHAR(100)                DEFAULT NULL,
    `pEname`        VARCHAR(20)                 DEFAULT NULL,
    `pGoods`        VARCHAR(200)                DEFAULT NULL,
    `pHash`         VARCHAR(100)                DEFAULT NULL,
    `pFnCd1`        VARCHAR(10)                 DEFAULT NULL,
    `pFnCd2`        VARCHAR(10)                 DEFAULT NULL,
    `pFnNm`         VARCHAR(50)                 DEFAULT NULL,
    `pAmt`          VARCHAR(8)                  DEFAULT NULL,
    `pAuthNo`       VARCHAR(50)                 DEFAULT NULL,
    `pAuthDt`       VARCHAR(14)                 DEFAULT NULL,
    `pNoti`         VARCHAR(1024)               DEFAULT NULL,
    `pRmesg1`       VARCHAR(500)                DEFAULT NULL,
    `pRmesg2`       VARCHAR(500)                DEFAULT NULL,
    `refundName`    VARCHAR(200)                DEFAULT NULL,
    `refundAccount` VARCHAR(200)                DEFAULT NULL,
    `refundBank`    VARCHAR(200)                DEFAULT NULL,
    `payDueDate`    DATETIME                    DEFAULT NULL,
    `created`       TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `productId`     INT                         DEFAULT NULL,
    `promotionId`   INT                         DEFAULT NULL,
    `userId`        INT                         DEFAULT NULL,
    `completed`     DATETIME                    DEFAULT NULL,
    `quantity`      INT                         DEFAULT NULL,
    `updated`       DATETIME                    DEFAULT NULL,
    `pUname`        VARCHAR(20)                 DEFAULT NULL,
    `PFnCd3`        VARCHAR(10)                 DEFAULT NULL,
    `PBname`        VARCHAR(500)                DEFAULT NULL,
    `PIntMon`       VARCHAR(500)                DEFAULT NULL,
    `PEmail`        VARCHAR(500)                DEFAULT NULL,
    `POname`        VARCHAR(500)                DEFAULT NULL,
    `PPayNo`        VARCHAR(20)                 DEFAULT NULL,
    `PMixPayTrNo`   VARCHAR(20)                 DEFAULT NULL,
    `PMixPayAmt`    VARCHAR(20)                 DEFAULT NULL,
    `PPayAmt`       VARCHAR(20)                 DEFAULT NULL,
    `PCashAuthNo`   VARCHAR(20)                 DEFAULT NULL,
    `PHashSha256`   VARCHAR(256)                DEFAULT NULL,
    CONSTRAINT `pk_settlebank_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_poid` UNIQUE (`pOid`)
) ENGINE = innodb;

CREATE TABLE `tbSoftBankHistory`
(
    `id`          INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `status`      VARCHAR(10)        NOT NULL,
    `txId`        VARCHAR(64) DEFAULT NULL,
    `payMethod`   VARCHAR(100)       NOT NULL,
    `orderId`     VARCHAR(100)       NOT NULL,
    `tax`         INT                NOT NULL,
    `payType`     INT                NOT NULL,
    `limitSecond` INT                NOT NULL,
    `spsHashcode` VARCHAR(40)        NOT NULL,
    `userAgent`   VARCHAR(100)       NOT NULL,
    `errorCode`   VARCHAR(10)        NOT NULL,
    `resResult`   VARCHAR(2)         NOT NULL,
    `requestDate` VARCHAR(20) DEFAULT NULL,
    `completed`   DATETIME    DEFAULT NULL,
    `created`     DATETIME    DEFAULT NULL,
    `productId`   INT         DEFAULT NULL,
    `promotionId` INT         DEFAULT NULL,
    `userId`      INT         DEFAULT NULL,
    `amount`      INT                NOT NULL,
    `quantity`    INT         DEFAULT NULL,
    `updated`     DATETIME    DEFAULT NULL,
    CONSTRAINT `pk_softbank_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_softbank_history_order_id` UNIQUE (`orderId`)
) ENGINE = innodb;


CREATE TABLE `tbTossHistory`
(
    `id`                  INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `userAgent`           VARCHAR(32)  DEFAULT NULL,
    `productDesc`         VARCHAR(100) DEFAULT NULL,
    `status`              VARCHAR(10)  DEFAULT NULL,
    `txId`                VARCHAR(64)  DEFAULT NULL,
    `orderNo`             VARCHAR(100) DEFAULT NULL,
    `payToken`            VARCHAR(100) DEFAULT NULL,
    `approvalTime`        VARCHAR(20)  DEFAULT NULL,
    `discountedAmount`    INT          DEFAULT NULL,
    `paidPoint`           INT          DEFAULT NULL,
    `paidAmount`          INT          DEFAULT NULL,
    `payMethod`           VARCHAR(10)  DEFAULT NULL,
    `transactionId`       VARCHAR(40)  DEFAULT NULL,
    `cardCompanyName`     VARCHAR(5)   DEFAULT NULL,
    `cardCompanyCode`     INT          DEFAULT NULL,
    `cardAuthorizationNo` VARCHAR(8)   DEFAULT NULL,
    `spreadOut`           INT          DEFAULT NULL,
    `noInterest`          BOOL               NOT NULL,
    `salesCheckLinkUrl`   VARCHAR(500) DEFAULT NULL,
    `cardMethodType`      VARCHAR(10)  DEFAULT NULL,
    `cardNumber`          VARCHAR(20)  DEFAULT NULL,
    `amount`              INT          DEFAULT NULL,
    `amountTaxfree`       INT          DEFAULT NULL,
    `errorMsg`            VARCHAR(500) DEFAULT NULL,
    `errorCode`           VARCHAR(500) DEFAULT NULL,
    `created`             DATETIME     DEFAULT NULL,
    `productId`           INT          DEFAULT NULL,
    `promotionId`         INT          DEFAULT NULL,
    `userId`              INT          DEFAULT NULL,
    `completed`           DATETIME     DEFAULT NULL,
    `quantity`            INT          DEFAULT NULL,
    `updated`             DATETIME     DEFAULT NULL,
    CONSTRAINT `pk_toss_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_order_no` UNIQUE (`orderNo`)
) ENGINE = innodb;

CREATE TABLE `tbWebMoneyHistory`
(
    `id`                INT          NOT NULL AUTO_INCREMENT,
    `txId`              VARCHAR(64)  DEFAULT NULL,
    `quantity`          INT          DEFAULT NULL,
    `status`            VARCHAR(10)  NOT NULL,
    `userAgent`         VARCHAR(32)  NOT NULL,
    `updated`           DATETIME     DEFAULT NULL,
    `completed`         DATETIME     DEFAULT NULL,
    `created`           DATETIME     DEFAULT NULL,
    `amount`            INT          NOT NULL,
    `itemCode`          VARCHAR(25)  DEFAULT NULL,
    `itemName`          VARCHAR(80)  NOT NULL,
    `orderCode`         VARCHAR(128) NOT NULL,
    `settlementVersion` VARCHAR(3)   DEFAULT NULL,
    `settlementCode`    VARCHAR(25)  DEFAULT NULL,
    `settlementDate`    VARCHAR(14)  DEFAULT NULL,
    `serialNumber`      VARCHAR(26)  DEFAULT NULL,
    `errorMessage`      VARCHAR(126) DEFAULT NULL,
    `productId`         INT          DEFAULT NULL,
    `promotionId`       INT unsigned DEFAULT NULL,
    `userId`            INT          DEFAULT NULL,
    CONSTRAINT `pk_webmoney_history_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_order_code` UNIQUE (`orderCode`)
) ENGINE = innodb;

CREATE TABLE `tbPaymentMethod`
(
    `id`          INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `name`        VARCHAR(64)        NOT NULL COMMENT 'method 이름',
    `pgId`        INT                NOT NULL COMMENT 'PG 사 ID - payment_gateway.id',
    `type`        TINYINT            NOT NULL COMMENT '결제타입',
    `fee`         INT                NOT NULL COMMENT '?',
    `description` VARCHAR(1024) COMMENT '설명',
    `isUse`       BOOL               NOT NULL DEFAULT TRUE COMMENT '사용 여부',
    `createdDate` DATETIME           NOT NULL DEFAULT current_timestamp COMMENT '생성일자',
    `updatedDate` DATETIME           NULL COMMENT '갱신일자',
    `creator`     INT                NOT NULL COMMENT '생성한 사용자 ID',
    `updater`     INT                NULL COMMENT '변경한 사용자 ID',
    `country`     CHAR(2)                     DEFAULT NULL COMMENT '국가토드 2자리(임시코드로 삭제예정, 테스트위함)',
    CONSTRAINT `pk_PaymentMethod_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb, AUTO_INCREMENT = 0;

CREATE TABLE `tbItemPromotion`
(
    `id`          INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `name`        VARCHAR(64)        NOT NULL COMMENT 'Promotion 이름',
    `code`        VARCHAR(64)        NOT NULL COMMENT 'Promotion 코드',
    `value`       INT                NOT NULL COMMENT 'Promotion 증가 수치',
    `isUse`       BOOL               NOT NULL COMMENT '사용 여부',
    `startDate`   TIMESTAMP default CURRENT_TIMESTAMP         NOT NULL COMMENT '프로모션 시작 시간',
    `endDate`     TIMESTAMP default CURRENT_TIMESTAMP         NOT NULL COMMENT '프로모션 종료 시간',
    `createdDate` DATETIME  default CURRENT_TIMESTAMP         NOT NULL COMMENT '생성일자',
    `updatedDate` DATETIME           NULL COMMENT '갱신일자',
    `creator`     INT                NOT NULL COMMENT '생성한 사용자 ID',
    `updater`     INT                NULL COMMENT '변경한 사용자 ID',
    CONSTRAINT `pk_item_promotion_id` PRIMARY KEY (`id`),
    CONSTRAINT `uidx_code` UNIQUE (`code`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbItemProduct`
(
    `id`          INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `promotionId` INT                NULL COMMENT 'item_promotion_id',
    `name`        VARCHAR(64)        NOT NULL COMMENT 'Product 이름',
    `price`       INT                NOT NULL COMMENT 'product 가격',
    `amount`      INT                NOT NULL COMMENT 'spoon 갯수',
    `type`        TINYINT            NOT NULL COMMENT '상품타입 ex) 일반/정기결제',
    `isUse`       BOOL               NOT NULL DEFAULT TRUE COMMENT '사용 여부',
    `createdDate` DATETIME           NOT NULL DEFAULT current_timestamp COMMENT '생성일자',
    `updatedDate` DATETIME           NULL COMMENT '갱신일자',
    `creator`     INT                NOT NULL COMMENT '생성한 사용자 ID',
    `updater`     INT                NULL COMMENT '변경한 사용자 ID',
    `store`       TINYINT            NOT NULL COMMENT '스토어',
    CONSTRAINT `pk_ItemProduct_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbAdpopcornHistory`
(
    `id`          INT unsigned AUTO_INCREMENT COMMENT '',
    `rewardKey`   VARCHAR(255) NOT NULL COMMENT '',
    `userId`      INT          NOT NULL COMMENT '',
    `campaignKey` VARCHAR(255) NOT NULL COMMENT '',
    `quantity`    INT          NOT NULL COMMENT '',
    `signedValue` VARCHAR(255) NOT NULL COMMENT '',
    `txId`        VARCHAR(64)  NOT NULL COMMENT '',
    `created`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `uidx_rewardKey_userId` UNIQUE (`userId`, `rewardKey`),
    CONSTRAINT `pk_RewardAdpopcornHistory_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb ,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbGiftcardHistory`
(
    `id`          INT AUTO_INCREMENT NOT NULL COMMENT '자동증가 PK',
    `payMethod`   VARCHAR(10)                 DEFAULT NULL,
    `txId`        VARCHAR(64)                 DEFAULT NULL,
    `status`      VARCHAR(10)        NOT NULL,
    `giftCardNumber` VARCHAR(16)  NOT NULL,
    `amount`      INT                NOT NULL,
    `userId`      INT                         DEFAULT NULL,
    `createdDate` DATETIME           NOT NULL DEFAULT current_timestamp COMMENT '생성일시',
    CONSTRAINT `pk_giftcard_history_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbPromotionHistory`
(
    `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `promotionId` INT          NULL COMMENT '프로모션 아이디',
    `orderId`     VARCHAR(64)  NOT NULL COMMENT '주문 아이디',
    `txId`        VARCHAR(64)  NOT NULL,
    `createdDate` DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '생성일시',
    CONSTRAINT `pk_PromotionHistory_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbItemStore`
(
    `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `rewardId`    INT                                NOT NULL COMMENT '스토어 내 상품아이디',
    `productId`   INT                                NOT NULL COMMENT '스토어 아이템과 같이 지급될 상품아이디',
    `creator`     INT                                NOT NULL COMMENT '생성자',
    `updater`     INT                                NULL COMMENT '수정자',
    `createdDate` datetime default CURRENT_TIMESTAMP NOT NULL COMMENT '생성시각',
    `updatedDate` datetime                           NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정시각',
    `isUse`       BOOL                               NOT NULL COMMENT '사용유무',
    CONSTRAINT `pk_ItemStore_id` PRIMARY KEY (`id`)
)
    ENGINE =innodb ,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbErrorLog`
(
    `id`           INT AUTO_INCREMENT NOT NULL COMMENT '',
    `txId`         CHAR(64)                    DEFAULT NULL,
    `actionType`   VARCHAR(256)       NOT NULL,
    `parameter`    VARCHAR(516)       NOT NULL,
    `status`       VARCHAR(8)                  DEFAULT NULL,
    `createdDate`  DATETIME           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `pk_ErrorLog_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchange`
(
    `id`                        INT           UNSIGNED NOT NULL AUTO_INCREMENT,
    `applicantId`               INT           UNSIGNED NOT NULL,
    `methodType`                VARCHAR(8)             NOT NULL COMMENT '{DEPOSIT, PAYONEER, DOTMONEY}',
    `totalExchangeSpoon`        INT           UNSIGNED NOT NULL COMMENT '총 환전될 스푼양',
    `currency`                  CHAR(3)                NULL COMMENT '통화',
    `totalExchangeAmount`       INT           UNSIGNED NOT NULL COMMENT '총 환전 된 금액 및 포인트',
    `estimatedExchangeAmount`   INT           UNSIGNED NOT NULL COMMENT '예상 환전 총 금액 및 포인트',
    `expectedExchangedDate`     DATE                   NOT NULL COMMENT '입금 예정일',
    `status`                    VARCHAR(15)            NOT NULL COMMENT '{REQUEST, UNDER_REVIEW, DEPOSIT_WAITING, EXCHANGED, REJECTED, CANCELED}',
    `created`                   DATETIME(3)   DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `updated`                   DATETIME(3)   DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    CONSTRAINT `pk_Exchange_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeDotmoneyProducts`
(
    `id`                          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `title`                       VARCHAR(50) NOT NULL COMMENT '닷머니 상품 타이틀',
    `description`                 VARCHAR(200) NOT NULL COMMENT '닷머니 상품 설명',
    `thumbnailUrl`                VARCHAR(100) NULL COMMENT '닷머니 상품 썸네일 URL',
    `withdrawalProductId`         INT UNSIGNED NOT NULL COMMENT '닷머니 측 상품 id',
    `withdrawalProductType`       VARCHAR(5) NOT NULL COMMENT '{point, gift, bank}',
    `withdrawalProductUnit`       VARCHAR(5) NOT NULL COMMENT '닷머니 상품 단위(ex. 원, 포인트, ..)',
    `spoonUnit`                   INT UNSIGNED NOT NULL COMMENT '환전 될 스푼 최소 단위',
    `targetAmountUnit`            INT UNSIGNED NOT NULL COMMENT '환전 될 닷머니 상품 금액 및 포인트의 최소 단위',
    `displayIndex`                INT UNSIGNED NOT NULL COMMENT '정렬 순서',
    `status`                      VARCHAR(8) NOT NULL COMMENT '{SALE, NON_SALE}',
    `created`                     DATETIME(3)  DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `creator`                     INT          UNSIGNED                      NOT NULL COMMENT '운영자',
    `updated`                     DATETIME(3)  DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `updater`                     INT          UNSIGNED                      NOT NULL COMMENT '운영자',
    CONSTRAINT `pk_ExchangeDotmoneyProducts_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeAmount`
(
    `id`                        INT           UNSIGNED NOT NULL AUTO_INCREMENT,
    `exchangeId`                INT           UNSIGNED NOT NULL,
    `balanceLockId`             CHAR(32)               NOT NULL COMMENT '밸런스에서 대기중인 환전 요청에 대한 UNIQUE key',
    `currency`                  CHAR(3)                NULL COMMENT '통화',
    `exchangeSpoon`             INT           UNSIGNED NULL COMMENT '환전 될 부분 스푼양',
    `amount`                    INT           UNSIGNED NULL COMMENT '환전 될 부분 금액 및 포인트(현재는 미국 1일 1000달러 이하 환전 기준에 대한 용도로만 사용)',
    `status`                    VARCHAR(15)            NOT NULL COMMENT '{DEPOSIT_WAITING, EXCHANGED, CANCELED}',
    `created`                   DATETIME(3)   DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `updated`                   DATETIME(3)   DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    CONSTRAINT `pk_ExchangeAmount_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeDotmoneySignatureData`
(
    `userId`                      INT UNSIGNED NOT NULL COMMENT '사용자 id',
    `signature`                   CHAR(73) NOT NULL COMMENT '닷머니로 보내는 signature',
    `exchangedDotmoneyPoint`      INT UNSIGNED NOT NULL COMMENT '환전 될 닷머니 포인트',
    `exchangedSpoon`              INT UNSIGNED NOT NULL COMMENT '환전 될 스푼양',
    `userName`                    VARCHAR(50) NOT NULL COMMENT '사용자 이름',
    `expireAt`                    DATETIME(3) NOT NULL COMMENT '해당 시그니처 만료일',
    `created`                     DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    CONSTRAINT `pk_ExchangeDotmoneySignatureData_userId` PRIMARY KEY (`userId`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeAmountDotmoneyHistory`
(
    `exchangeAmountId`          INT           UNSIGNED NOT NULL,
    `dotmoneyHistoryId`         BIGINT        UNSIGNED NOT NULL,
    CONSTRAINT `pk_ExchangeAmountDotmoneyHistory_exchangeAmountId` PRIMARY KEY (`exchangeAmountId`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeRejectReason`
(
    `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `exchangeId` INT UNSIGNED NOT NULL,
    `reason`     VARCHAR(100) NOT NULL COMMENT '반려 사유',
    `created`    DATETIME(3)  DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `creator`    INT          UNSIGNED                      NOT NULL COMMENT '운영자',
    `updated`    DATETIME(3)  DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `updater`    INT          UNSIGNED                      NOT NULL COMMENT '운영자',
    CONSTRAINT `pk_ExchangeRejectReason_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeSubmitDocument`
(
    `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `exchangeId` INT UNSIGNED NOT NULL,
    `type`       VARCHAR(30)  NOT NULL COMMENT '{FAMILY_RELATION_CERTIFICATE, LEGAL_REPRESENTATIVE_AGREEMENT}',
    `url`        VARCHAR(256) NOT NULL COMMENT '환전에 필요한 제출 서류 URL',
    `created`    DATETIME(3)  DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    CONSTRAINT `pk_ExchangeSubmitDocument_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeHistory`
(
    `id`         INT          UNSIGNED                        NOT NULL AUTO_INCREMENT,
    `exchangeId` INT          UNSIGNED                        NOT NULL,
    `status`     VARCHAR(15)                                  NOT NULL,
    `created`    DATETIME(3)  DEFAULT CURRENT_TIMESTAMP (3)   NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;

CREATE TABLE `tbExchangeDeposit`
(
    `id`                          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `exchangeId`                  INT UNSIGNED NOT NULL,
    `applicantName`               VARCHAR(30) NOT NULL COMMENT '환전 신청자 이름',
    `email`                       VARCHAR(100) NOT NULL COMMENT '환전 신청자 이메일',
    `phoneNumber`                 VARCHAR(13) NOT NULL COMMENT '환전 신청자 폰 번호',
    `residentFirstNumber`         CHAR(44) NOT NULL COMMENT '환전 신청자 주민등록번호 앞자리',
    `residentLastNumber`          CHAR(44) NOT NULL COMMENT '환전 신청자 주민등록번호 뒷자리',
    `accountHolder`               VARCHAR(30) NOT NULL COMMENT '환전 받을 계좌주 이름',
    `exchangeBank`                CHAR(3)     NOT NULL COMMENT '환전 받을 계좌 은행',
    `accountNumber`               CHAR(44) NOT NULL COMMENT '환전 받을 계좌 번호',
    `isMinor`                     BOOLEAN     NOT NULL COMMENT '미성년자 여부',
    `isDifferentAccountHolder`    BOOLEAN     NOT NULL COMMENT '환전 신청자와 환전 받을 계좌주 동일 여부',
    `privacyConsent`              BOOLEAN       NOT NULL COMMENT '개인 정보 수집 동의 여부',
    `residentCollectionConsent`   BOOLEAN       NOT NULL COMMENT '주민등록번호 수집 동의 여부',
    `created`                     DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    `updated`                     DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3) NOT NULL,
    CONSTRAINT `pk_ExchangeDeposit_id` PRIMARY KEY (`id`)
)
    ENGINE = innodb,
    AUTO_INCREMENT = 0;
