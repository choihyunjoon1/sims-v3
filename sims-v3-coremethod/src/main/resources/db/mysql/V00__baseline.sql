create table admin_user
(
    user_id           int auto_increment primary key,
    username          varchar(50)  not null,
    password          varchar(128) not null,
    email             varchar(255) not null,
    onelogin_id       varchar(100) not null,
    country_cd        varchar(5)   not null,
    profile_url       varchar(255) not null,
    user_auth_cd      varchar(5)   not null,
    user_auth_cfc_cd  varchar(5)   not null,
    user_grp_cd       varchar(5)   not null,
    user_position_cd  varchar(5)   not null,
    session_key       varchar(40)  not null,
    is_staff          tinyint(1) not null,
    is_active         tinyint(1) not null,
    last_login_dt     datetime(6) null,
    logout_dt         datetime(6) null,
    create_dt         datetime(6) not null,
    update_dt         datetime(6) not null,
    google_account_id varchar(100) not null,
    withdrew_dt       datetime(6) null,
    constraint email unique (email)
);

-- create index admin_user_create_dt_8c7c77c3
--     on admin_user (create_dt);
--
-- create index admin_user_last_login_dt_c592b1e3
--     on admin_user (last_login_dt);
--
-- create index admin_user_logout_dt_b88fab4e
--     on admin_user (logout_dt);
--
-- create index admin_user_withdrew_dt_cb7feaf0
--     on admin_user (withdrew_dt);

create table allow_equi
(
    allow_equi_id      int auto_increment primary key,
    allow_equi_type_cd varchar(5)   not null,
    allow_equi_info    varchar(255) not null,
    etc1               varchar(255) not null,
    etc2               varchar(255) not null,
    update_dt          datetime(6) not null,
    create_dt          datetime(6) not null
);

/*create index idx_allow_equi_allow_equi_type_cd
    on allow_equi (allow_equi_type_cd);*/

create table auth_group
(
    id   int auto_increment primary key,
    name varchar(150) not null,
    constraint name unique (name)
);

create table authtoken_token
(
    `key`   varchar(40) not null primary key,
    created datetime(6) not null,
    user_id int         not null,
    constraint user_id
        unique (user_id)
);

create table batch_log
(
    batch_log_id    int auto_increment primary key,
    batch_type_cd   varchar(5) not null,
    batch_detail    longtext   not null,
    batch_parameter longtext   not null,
    create_dt       datetime(6) not null,
    is_success      tinyint(1) not null,
    cnt             int null
);

-- create index batch_log_create_dt_5b991701 on batch_log (create_dt);

create table batch_log_deail
(
    batch_log_detail_id int auto_increment
        primary key,
    description         varchar(255) not null,
    user_id             int null,
    result_cd           int null,
    create_dt           datetime(6) not null,
    batch_log_id        int          not null
);

-- create index batch_log_deail_create_dt_9c519e22 on batch_log_deail (create_dt);

create table batch_manage
(
    batch_manage_id   int auto_increment primary key,
    batch_type_cd     varchar(5) not null,
    batch_description longtext   not null,
    is_run            tinyint(1) not null,
    update_dt         datetime(6) not null,
    create_dt         datetime(6) not null
);

-- create index batch_manage_create_dt_01325100 on batch_manage (create_dt);

create table com_code
(
    id                 int auto_increment primary key,
    grp_code_cd        varchar(5)   not null,
    grp_code_name      varchar(50)  not null,
    code_cd            varchar(14)  not null,
    code_nm            varchar(50)  not null,
    code_desc          varchar(255) not null,
    etc1               varchar(255) not null,
    etc2               varchar(255) not null,
    etc3               varchar(255) not null,
    parent_grp_code_cd varchar(5)   not null,
    parent_code_cd     varchar(5)   not null,
    use_yn             tinyint(1) not null,
    ord                int          not null,
    update_dt          datetime(6) not null,
    create_dt          datetime(6) not null,
    en_code_nm         varchar(50)  not null
);

create table django_content_type
(
    id        int auto_increment
        primary key,
    app_label varchar(100) not null,
    model     varchar(100) not null
);

create table auth_permission
(
    id              int auto_increment
        primary key,
    name            varchar(255) not null,
    content_type_id int          not null,
    codename        varchar(100) not null
);

create table auth_group_permissions
(
    id            int auto_increment
        primary key,
    group_id      int not null,
    permission_id int not null
);

create table django_admin_log
(
    id              int auto_increment
        primary key,
    action_time     datetime(6) not null,
    object_id       longtext null,
    object_repr     varchar(200) not null,
    action_flag     smallint unsigned not null,
    change_message  longtext     not null,
    content_type_id int null,
    user_id         int          not null
);

create table django_migrations
(
    id      int auto_increment
        primary key,
    app     varchar(255) not null,
    name    varchar(255) not null,
    applied datetime(6) not null
);

create table django_session
(
    session_key  varchar(40) not null
        primary key,
    session_data longtext    not null,
    expire_date  datetime(6) not null
);

-- create index django_session_expire_date_a5c62663 on django_session (expire_date);

create table external_link_log
(
    external_link_log_id    int auto_increment
        primary key,
    billing_id              int          not null,
    external_link_type_cd   varchar(5)   not null,
    external_link_detail    varchar(255) not null,
    external_link_parameter longtext     not null,
    result_cd               int null,
    external_link_response  longtext     not null,
    create_dt               datetime(6) not null
);

-- create index external_link_log_create_dt_833f0fda on external_link_log (create_dt);

create table grant_log
(
    grant_log_id         int auto_increment
        primary key,
    access_ip            varchar(15)           not null,
    main_menu_id         int null,
    main_menu_name       varchar(50)           not null,
    sub_menu_id          int null,
    sub_menu_name        varchar(50)           not null,
    grant_user_id        int                   not null,
    grant_user_name      varchar(255)          not null,
    grantee_user_id      int null,
    grantee_user_name    varchar(255)          not null,
    grant_before         varchar(255)          not null,
    grant_after          varchar(255)          not null,
    grant_to_apply       varchar(255)          not null,
    grant_status         varchar(5)            not null,
    grant_type           varchar(5)            not null,
    create_dt            datetime(6) not null,
    grant_user_email     varchar(255) null,
    grantee_user_email   varchar(255)          not null,
    grant_user_grp_cd    varchar(5)            not null,
    grantee_user_grp_cd  varchar(5)            not null,
    en_main_menu_name    varchar(50)           not null,
    en_sub_menu_name     varchar(50)           not null,
    grant_user_auth_cd   varchar(5) default '' not null,
    grantee_user_auth_cd varchar(5) default '' not null
);

-- create index grant_log_create_dt_043d6dcd on grant_log (create_dt);
-- create index grant_log_grant_user_id_af41c214    on grant_log (grant_user_id);
-- create index grant_log_grantee_user_id_5563acaf    on grant_log (grantee_user_id);

create table menu
(
    menu_id   int auto_increment
        primary key,
    name      varchar(50) not null,
    en_name   varchar(50) not null,
    ord       int         not null,
    create_dt datetime(6) not null,
    update_dt datetime(6) not null,
    icon      varchar(128) null,
    is_used   tinyint(1) default 1 not null
);

create table notice
(
    notice_id      int auto_increment
        primary key,
    name           varchar(100) not null,
    contents       longtext null,
    notice_image   varchar(200) null,
    notice_type_cd varchar(5)   not null,
    is_popup       tinyint(1) not null,
    is_available   tinyint(1) not null,
    start_dt       datetime(6) not null,
    end_dt         datetime(6) not null,
    create_dt      datetime(6) not null,
    update_dt      datetime(6) not null,
    user_name      varchar(45)  not null
);

create table notice_check
(
    notice_check_id int auto_increment
        primary key,
    user_id         int not null,
    create_dt       datetime(6) not null,
    notice_id       int not null
);

-- create index notice_check_notice_id_5d52e312
--     on notice_check (notice_id);

create table otp_totp_totpdevice
(
    id                           int auto_increment
        primary key,
    name                         varchar(64) not null,
    confirmed                    tinyint(1) not null,
    `key`                        varchar(80) not null,
    step                         smallint unsigned not null,
    t0                           bigint      not null,
    digits                       smallint unsigned not null,
    tolerance                    smallint unsigned not null,
    drift                        smallint    not null,
    last_t                       bigint      not null,
    user_id                      int         not null,
    throttling_failure_count     int unsigned not null,
    throttling_failure_timestamp datetime(6) null
);

create table spoon_reward
(
    id           int auto_increment
        primary key,
    title        varchar(50) not null,
    type         varchar(10) null,
    spoon_amount int unsigned not null,
    created      datetime(6) not null,
    creator      int unsigned not null,
    updated      datetime(6) not null,
    updater      int unsigned not null,
    pg_id        tinyint unsigned default 1 not null
);

create table spoon_reward_user
(
    id        int auto_increment
        primary key,
    user_id   int unsigned not null,
    tx_id     varchar(32) not null,
    status    varchar(8)  not null,
    created   datetime(6) not null,
    creator   int unsigned not null,
    updated   datetime(6) not null,
    updater   int unsigned not null,
    reward_id int         not null
);

create table sub_menu
(
    sub_menu_id        int auto_increment
        primary key,
    name               varchar(50)  not null,
    en_name            varchar(50)  not null,
    ord                int          not null,
    api                varchar(255) not null,
    api_method         varchar(7)   not null,
    api_detail         varchar(255) not null,
    menu_type_cd       varchar(5)   not null,
    spc_auth           tinyint(1) not null,
    spc_auth_cd        varchar(5)   not null,
    create_dt          datetime(6) not null,
    update_dt          datetime(6) not null,
    menu_id            int          not null,
    is_common          tinyint(1) not null,
    is_ns              tinyint(1) not null,
    menu_auth_type_cd  varchar(5)   not null,
    parent_sub_menu_id int null,
    en_api_detail      varchar(255) not null,
    parent_tab_menu_id smallint null,
    country_flag       tinyint unsigned default 0 not null,
    is_used            tinyint(1) default 1 not null
);

create table audit_log
(
    audit_log_id     int auto_increment
        primary key,
    access_ip        varchar(15)  not null,
    access_agent     varchar(255) not null,
    api_url          varchar(255) not null,
    api_method       varchar(7)   not null,
    api_detail       varchar(255) not null,
    req_parameter    longtext     not null,
    sub_menu_id      int null,
    sub_menu_name    varchar(50)  not null,
    user_id          int null,
    user_name        varchar(255) not null,
    result_cd        varchar(5)   not null,
    create_dt        datetime(6) not null,
    download_reason  varchar(255) not null,
    en_api_detail    varchar(255) not null,
    en_sub_menu_name varchar(50)  not null
);

-- create index audit_log_create_dt_81c2618f
--     on audit_log (create_dt);
--
-- create index audit_log_sub_menu_id_id_bc8d445b
--     on audit_log (sub_menu_id);
--
-- create index audit_log_user_id_a1b3392d
--     on audit_log (user_id);

create table grade_menu_auth_list
(
    id           int auto_increment
        primary key,
    user_auth_cd varchar(5) not null,
    create_dt    datetime(6) not null,
    update_dt    datetime(6) not null,
    sub_menu_id  int        not null
);

-- create index grade_menu_auth_list_user_auth_cd_8cdc63b4
--     on grade_menu_auth_list (user_auth_cd);

create table spc_auth_req
(
    spc_auth_req_id int auto_increment
        primary key,
    req_detail      varchar(50) not null,
    spc_auth_cd     varchar(5)  not null,
    status_cd       varchar(5)  not null,
    create_dt       datetime(6) not null,
    update_dt       datetime(6) not null,
    req_user_id     int         not null,
    sub_menu_id     int         not null,
    en_req_detail   varchar(50) not null
);

create table spc_auth_req_info
(
    spc_auth_approve_id int auto_increment
        primary key,
    ord                 int        not null,
    status_cd           varchar(5) not null,
    create_dt           datetime(6) not null,
    update_dt           datetime(6) not null,
    approve_user_id     int        not null,
    spc_auth_req_id     int        not null
);

create table `tbExchangeActionHistory`
(
    `id`           int unsigned AUTO_INCREMENT        primary key,
    `txid`         varchar(32)                        not null,
    `targetLockId` varchar(32)                        not null,
    `type`         varchar(6)                         not null,
    `created`      datetime default CURRENT_TIMESTAMP not null,
    `creator`      int unsigned not null
);

create table `tbSpoonValidSyncHistory`
(
    `id`           int unsigned auto_increment        primary key,
    `userId`       int unsigned not null,
    `beforeStatus` varchar(4096)                      not null,
    `afterStatus`  varchar(4096)                      not null,
    `created`      datetime default CURRENT_TIMESTAMP not null,
    `creator`      int unsigned not null
);

-- create index idx_tbSpoonValidSyncHistory_userId
--     on tbSpoonValidSyncHistory (userId);

create table team_menu_auth_list
(
    id          int auto_increment
        primary key,
    user_grp_cd varchar(5) not null,
    create_dt   datetime(6) not null,
    update_dt   datetime(6) not null,
    sub_menu_id int        not null
);

-- create index team_menu_auth_list_user_grp_cd_a8920055
--     on team_menu_auth_list (user_grp_cd);

create table terms
(
    terms_id      int auto_increment
        primary key,
    title         varchar(100) not null,
    contents      longtext     not null,
    notice_id     int          not null,
    terms_type_cd varchar(5)   not null,
    create_dt     datetime(6) not null,
    update_dt     datetime(6) not null
);

create table terms_check
(
    terms_check_id int auto_increment
        primary key,
    user_id        int not null,
    create_dt      datetime(6) not null,
    terms_id       int not null
);

create table user_menu_auth
(
    user_menu_auth_id int auto_increment
        primary key,
    unmasking         tinyint(1) not null,
    create_dt         datetime(6) not null,
    update_dt         datetime(6) not null,
    sub_menu_id       int not null,
    user_id           int not null
);

-- create index user_menu_auth_create_dt_c7b8b627
--     on user_menu_auth (create_dt);

create table users_deactive
(
    user_deactive_id int auto_increment
        primary key,
    user_id          int null,
    tag              varchar(15) null,
    date_of_birth    date null,
    first_name       varchar(30)  not null,
    last_name        varchar(150) not null,
    withdraw_date    datetime(6) not null,
    delete_date      datetime(6) not null,
    nickname         varchar(100) not null
);

create table voc_banshistory
(
    bans_history_id   int auto_increment primary key,
    bans_id           int unsigned not null,
    bans_user_id      int unsigned not null,
    handler_user_id   int unsigned not null,
    handler_user_name varchar(255) not null,
    create_dt         datetime(6) not null
);

create table voc_hist
(
    voc_hist_id            int auto_increment primary key,
    status_cd              varchar(5)   not null,
    spoon_user_id          int unsigned null,
    register_type_cd       varchar(5)   not null,
    bound_type_cd          varchar(5)   not null,
    criticality_type_cd    varchar(5)   not null,
    channel_cd             varchar(5)   not null,
    type_cd                varchar(5)   not null,
    category_cd            varchar(5)   not null,
    division_cd            varchar(5)   not null,
    section_cd             varchar(255) not null,
    comment                longtext     not null,
    reply                  longtext     not null,
    create_dt              datetime(6) not null,
    update_dt              datetime(6) not null,
    member_user_id         int          not null,
    reply_user_id          int null,
    spoon_user_nickname    varchar(255) not null,
    non_spoon_member_email varchar(255) not null,
    reply_dt               datetime(6) null,
    des_dt                 datetime(6) null,
    is_des                 tinyint(1) not null,
    upload_dt              datetime(6) null,
    os                     varchar(255) null comment 'os 혹은 브라우저',
    carrier                varchar(32) null comment '통신사',
    app_version            varchar(32) null comment '앱버전',
    device_model           varchar(32) null comment '디바이스'
);

create table voc_attachment
(
    attachment_id   int auto_increment primary key,
    voc_hist_id     int          not null comment 'voc_hist 의 id',
    attachment_path varchar(255) not null comment '첨부파일의 s3내 경로',
    create_dt       datetime(6) not null,
    update_dt       datetime(6) null
);

create table voc_reply
(
    reply_id       int auto_increment
        primary key,
    voc_hist_id    int not null comment 'voc_hist의 id',
    reply          text null comment '문의의 답변',
    create_dt      datetime(6) not null,
    update_dt      datetime(6) null,
    member_user_id int not null comment '답변을 생성한 유저의 아이디'
);
