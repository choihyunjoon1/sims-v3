
create table users_account
(
    id              serial                   not null
        constraint users_account_pkey
            primary key,
    sns_id          varchar(100),
    sns_type        varchar(20),
    facebook        varchar(100),
    google          varchar(100),
    email           varchar(100),
    phone           varchar(100),
    country_prefix  varchar(100),
    national_number varchar(100),
    created         timestamp with time zone not null,
    user_id         integer                  not null,
    twitter         varchar(100),
    password        varchar(128),
    apple           varchar(100),
    updated         timestamp with time zone
);

create table fanboard_fanmessage
(
    id         serial                   not null
        constraint fanboard_fanmessage_pkey
            primary key,
    contents   varchar(2048)            not null,
    created    timestamp with time zone not null,
    author_id  integer                  not null,
    comment_id integer                  not null
);


create table fanboard_fancomment
(
    id            serial                   not null
        constraint fanboard_fancomment_pkey
            primary key,
    contents      varchar(2048)            not null,
    is_blind      boolean                  not null,
    created       timestamp with time zone not null,
    author_id     integer                  not null,
    fan_board_id  integer                  not null,
    is_notice     boolean                  not null,
    to_user_id    integer,
    message_count integer                  not null
);

create table casts_textcomment
(
    id         serial                   not null
        constraint casts_textcomment_pkey
            primary key,
    contents   varchar(255),
    reporters  integer[]                not null,
    created    timestamp with time zone not null,
    author_id  integer                  not null,
    cast_id    integer                  not null,
    to_user_id integer
);



create table casts_cast
(
    id                  serial                   not null
        constraint casts_cast_pkey
            primary key,
    title               varchar(200)             not null,
    interest            integer                  not null,
    tags                varchar(100)[],
    img_key             varchar(100),
    img_url             varchar(255)             not null,
    voice_key           varchar(255)             not null,
    voice_url           varchar(255)             not null,
    duration            double precision         not null,
    like_count          integer                  not null,
    play_count          integer                  not null,
    play_real_count     integer                  not null,
    voice_comment_count integer                  not null,
    text_comment_count  integer                  not null,
    reporters           integer[],
    updated             timestamp with time zone not null,
    created             timestamp with time zone not null,
    author_id           integer                  not null,
    company_id          integer,
    block_users         integer[],
    is_donated          boolean                  not null,
    spoon_count         integer                  not null,
    status              integer,
    type                integer,
    category            varchar(64)
);


create table talks_talkvoicecomment
(
    id         serial                   not null
        constraint talks_talkvoicecomment_pkey
            primary key,
    voice_key  varchar(255)             not null,
    voice_url  varchar(255)             not null,
    duration   double precision         not null,
    reporters  integer[]                not null,
    created    timestamp with time zone not null,
    author_id  integer                  not null,
    talk_id    integer                  not null,
    to_user_id integer,
    like_count integer                  not null,
    play_count integer
);

create table talks_talk
(
    id                  serial                   not null
        constraint talks_talk_pkey
            primary key,
    title               varchar(100)             not null,
    img_key             varchar(100)             not null,
    img_url             varchar(255)             not null,
    voice_comment_count integer                  not null,
    reporters           integer[]                not null,
    member_count        integer                  not null,
    like_count          integer                  not null,
    created             timestamp with time zone not null,
    author_id           integer                  not null,
    block_users         integer[],
    banner_img_key      varchar(100),
    banner_img_url      varchar(255),
    event_end           timestamp with time zone,
    is_event            boolean                  not null,
    comment_like_count  integer,
    expired             timestamp with time zone,
    is_private          boolean,
    is_volatile         boolean,
    text                varchar(500),
    is_composited       boolean,
    comment_play_count  integer,
    enter_count         integer,
    tags                varchar(100)[],
    status              smallint default 1       not null
);


create table users_follow
(
    id           serial                   not null
        constraint users_follow_pkey
            primary key,
    push_level   integer                  not null,
    created      timestamp with time zone not null,
    from_user_id integer                  not null,
    to_user_id   integer                  not null
);


create table users_device
(
    id               serial                   not null
        constraint users_device_pkey
            primary key,
    device_token     varchar(200)             not null,
    os_type          varchar(10)              not null,
    model_name       varchar(50)              not null,
    build_no         integer                  not null,
    created          timestamp with time zone not null,
    user_id          integer,
    android_id       varchar(100),
    device_unique_id varchar(100)             not null,
    one_signal_id    varchar(100),
    updated          timestamp with time zone not null,
    ip_address       varchar(200),
    status           integer
);
create table users_bancategorycontent
(
    id      serial                   not null
        constraint users_bancategorycontent_pkey
            primary key,
    name    varchar(50)              not null,
    is_use  boolean                  not null,
    created timestamp with time zone not null
);

create table users_bancategorymain
(
    id      serial                   not null
        constraint users_bancategorymain_pkey
            primary key,
    name    varchar(50)              not null,
    is_use  boolean                  not null,
    created timestamp with time zone not null
);

create table users_bancategorysub
(
    id               serial                   not null
        constraint users_bancategorysub_pkey
            primary key,
    name             varchar(50)              not null,
    is_use           boolean                  not null,
    created          timestamp with time zone not null,
    category_main_id integer
);



create table users_grant
(
    id      serial                   not null constraint users_grant_pkey primary key,
    login   integer                  not null,
    "cast"  integer                  not null,
    talk    integer                  not null,
    live    integer                  not null,
    adult   integer                  not null,
    updated timestamp with time zone not null,
    phone   integer                  not null,
    payment integer                  not null,
    auth    integer
);

create table users_ban
(
    id                  serial                   not null        constraint users_ban_pkey            primary key,
    detail              varchar(500)             not null,
    memo                varchar(500)             not null,
    device_unique_id    varchar(100)             not null,
    type                integer                  not null,
    end_date            timestamp with time zone not null,
    created             timestamp with time zone not null,
    category_content_id integer,
    category_main_id    integer,
    category_sub_id     integer,
    user_id             integer
);


create table users_spoonuser
(
    id           serial                   not null
             primary key,
    password     varchar(128)             not null,
    last_login   timestamp with time zone,
    is_superuser boolean                  not null,
    username     varchar(150)             not null,
    first_name   varchar(30)              not null,
    last_name    varchar(30)              not null,
    email        varchar(254)             not null,
    is_staff     boolean                  not null,
    is_active    boolean                  not null,
    date_joined  timestamp with time zone not null,
    company_id   integer,
    budget_id    integer,
    grants_id    integer ,
    leaved       timestamp with time zone,
    status       integer,
    is_dormant   boolean
);


create table reports_castcommentreport
(
    id               serial       not null constraint reports_castcommentreport_pkey primary key,
    reporter         varchar(200) not null,
    reported         date         not null,
    "cast"           varchar(100) not null,
    cast_author      varchar(100) not null,
    cast_created     date         not null,
    comment_author   varchar(200) not null,
    comment_contents varchar(200) not null,
    comment_created  date         not null,
    report_descr     varchar(255),
    report_type      integer      not null
);

create table reports_castreport
(
    id           serial       not null
        constraint reports_castreport_pkey
            primary key,
    reporter     varchar(200) not null,
    reported     date         not null,
    "cast"       varchar(200) not null,
    cast_author  varchar(200) not null,
    cast_created date         not null,
    cast_url     varchar(200),
    report_descr varchar(255),
    report_type  integer      not null
);

create table reports_livemessagereport
(
    id               serial       not null
        constraint reports_livemessagereport_pkey
            primary key,
    reporter         varchar(200) not null,
    reported         date         not null,
    live             varchar(200) not null,
    live_author      varchar(200) not null,
    live_created     date         not null,
    message_author   varchar(200) not null,
    message_contents varchar(200) not null,
    report_descr     varchar(255),
    report_type      integer      not null
);

create table reports_talkcommentreport
(
    id              serial       not null
        constraint reports_talkcommentreport_pkey
            primary key,
    reporter        varchar(200) not null,
    reported        date         not null,
    talk            varchar(200) not null,
    talk_author     varchar(200) not null,
    talk_created    date         not null,
    comment_author  varchar(200) not null,
    comment_url     varchar(200) not null,
    comment_created date         not null,
    report_descr    varchar(255),
    report_type     integer      not null
);

create table reports_talkreport
(
    id           serial       not null
        constraint reports_talkreport_pkey
            primary key,
    reporter     varchar(200) not null,
    reported     date         not null,
    talk         varchar(200) not null,
    talk_author  varchar(200) not null,
    talk_created date         not null,
    report_descr varchar(255),
    report_type  integer      not null
);

create table reports_userreport
(
    id              serial       not null
        constraint reports_userreport_pkey
            primary key,
    reporter        varchar(200) not null,
    reported        date         not null,
    abuser          varchar(200) not null,
    abuser_tag      varchar(100),
    abuser_sns_type varchar(100) not null,
    abuser_sns_id   varchar(100) not null,
    report_descr    varchar(255),
    report_type     integer      not null
);

create table reports_mailboxmessagereport
(
    id               serial        not null
        constraint pk_reports_mailboxmessagereport_id
            primary key,
    report_type      integer       not null,
    report_descr     varchar(255),
    reporter         varchar(200)  not null,
    reported         date          not null,
    mailbox          varchar(200)  not null,
    live             varchar(200)  not null,
    live_author      varchar(200)  not null,
    live_created     date          not null,
    message_author   varchar(200)  not null,
    message_contents varchar(1024) not null
);


create table users_profile
(
    id serial       not null  constraint users_profile_pkey primary key,
    nickname               varchar(100) not null,
    tag                    varchar(15) constraint users_profile_tag_key unique,
    description            varchar(200) not null,
    gender                 integer      not null,
    date_of_birth          date,
    profile_url            varchar(255),
    profile_key            varchar(255),
    reporters              integer[],
    top_impressions        integer[],
    is_live                boolean      not null,
    fan_count              integer      not null,
    my_count               integer      not null,
    current_live_id        integer,
    last_live_created      timestamp with time zone,
    created                timestamp with time zone,
    user_id                integer      not null constraint users_profile_user_id_key unique,
    country                varchar(4),
    is_public_cast_storage boolean,
    is_public_like         boolean,
    is_vip                 boolean,
    verify_status          smallint
);


create table users_authortier
(
    id      serial                   not null
        constraint pk_users_authortier
            primary key,
    name    varchar(20)              not null
        constraint uidx_users_authortier_name
            unique,
    title   varchar(20)              not null,
    "order" integer                  not null
        constraint uidx_users_authortier_order unique,
    is_used boolean                  not null,
    created timestamp with time zone not null
);

create
index idx_users_authortier_name
    on users_authortier (name);

create table users_authortieruser
(
    id      serial                   not null
        constraint pk_users_authortieruser
            primary key,
    created timestamp with time zone not null,
    tier_id integer                  not null
        constraint fk_users_authortieruser_tier_id
            references users_authortier
            deferrable,
    user_id integer                  not null
        constraint uidx_users_authortieruser_user_id unique
);

create
index idx_users_authortieruser_tier_id
    on users_authortieruser (tier_id);

create table users_authortierhistory
(
    id       serial                   not null
        constraint pk_users_authortierhistory
            primary key,
    title    varchar(100),
    user_ids integer[] not null,
    is_used  boolean,
    created  timestamp with time zone not null,
    tier_id  integer
        constraint fk_users_authortierhistory_tier_id
            references users_authortier
            deferrable initially deferred
);
create table commons_unfitword
(
    id      serial          not null    constraint commons_unfitword_pkey       primary key,
    word    varchar(40)     not null    constraint commons_unfitword_word_key   unique,
    created     timestamp with time zone not null,
    is_used     boolean                  not null,
    to_contents boolean                  not null,
    to_nickname boolean                  not null,
    reword      varchar(40)
);


create table reports_livereport
(
    id               serial       not null constraint reports_livereport_pkey primary key,
    report_type      integer      not null,
    report_descr     varchar(255),
    reporter         varchar(200) not null,
    reported         date         not null,
    live             varchar(200) not null,
    live_author      varchar(200) not null,
    live_stream_name varchar(20)  not null,
    live_created     date         not null
);

create table `nice_niceauthuserinfo`
(
    `id`             serial                   not null constraint `nice_niceauthuserinfo_pkey` primary key,
    `name`           varchar(100)             not null,
    `gender`         integer                  not null,
    `birth_date`     date,
    `nation_info`    integer                  not null,
    `created`        timestamp with time zone not null,
    `user_id`        integer
        constraint `nice_niceauthuserinfo_user_id_d21cbec3_uniq` unique
        constraint `nice_niceauthuserinfo_user_id_d21cbec3_fk_users_spoonuser_id` references `users_spoonuser` deferrable initially deferred,
    `ci`             varchar(100),
    `auth_type`      varchar(1),
    `virtual_number` varchar(100)
);
