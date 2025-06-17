-- トランザクションテーブル追加

-- 通知
CREATE TABLE t_notifications
    (
        notification_id SERIAL NOT NULL,
        from_date       DATE NOT NULL,
        to_date         DATE NOT NULL,
        title           VARCHAR(32) NOT NULL,
        message         TEXT NOT NULL,
        create_datetime timestamp(6) without time zone DEFAULT NOW() NOT NULL,
        is_delete       boolean                        DEFAULT FALSE NOT NULL,
        update_datetime timestamp(6) without time zone DEFAULT NOW() NOT NULL,
        delete_datetime timestamp(6) without time zone DEFAULT '9999-12-31 00:00:00' NOT NULL,
        PRIMARY KEY (notification_id)
    );

COMMENT
    ON TABLE t_notifications IS '通知';

COMMENT
    ON COLUMN t_notifications.notification_id IS '通知ID';

COMMENT
    ON COLUMN t_notifications.from_date IS '通知開始日';

COMMENT
    ON COLUMN t_notifications.to_date IS '通知終了日';

COMMENT
    ON COLUMN t_notifications.title IS 'タイトル';

COMMENT
    ON COLUMN t_notifications.message IS 'メッセージ';

COMMENT
    ON COLUMN t_notifications.create_datetime IS '作成日';

COMMENT
    ON COLUMN t_notifications.is_delete IS '削除フラグ';

COMMENT
    ON COLUMN t_notifications.update_datetime IS '更新日';

COMMENT
    ON COLUMN t_notifications.delete_datetime IS '削除日';

-- 機能階層
CREATE TABLE t_function_hierarchy(
    ancestor_id INT NOT NULL
    , descendant_id INT NOT NULL
    , depth_div INT NOT NULL
    , PRIMARY KEY (ancestor_id, descendant_id)
                                 );

COMMENT
    ON TABLE t_function_hierarchy IS '機能階層';

COMMENT
    ON COLUMN t_function_hierarchy.ancestor_id IS '親機能ID';

COMMENT
    ON COLUMN t_function_hierarchy.descendant_id IS '子機能ID';

COMMENT
    ON COLUMN t_function_hierarchy.depth_div IS '深度';

-- ユーザー設定
CREATE TABLE t_usersettings(
                               account_id INTEGER NOT NULL
    , gender CHAR (2) NOT NULL
    , self_introduction VARCHAR (512)
    , birthday DATE
    , residence VARCHAR (64)
    , version INTEGER NOT NULL
    , create_datetime timestamp (6) with time zone NOT NULL
    , update_datetime timestamp (6) with time zone NOT NULL
    , delete_datetime timestamp (6) with time zone default '9999-12-31 00:00:00' NOT NULL
    , primary key (account_id)
);

COMMENT
ON TABLE t_usersettings IS 'ユーザー設定';

COMMENT
ON COLUMN t_usersettings.account_id IS 'アカウントID';

COMMENT
ON COLUMN t_usersettings.gender IS '性別';

COMMENT
ON COLUMN t_usersettings.self_introduction IS '自己紹介';

COMMENT
ON COLUMN t_usersettings.birthday IS '誕生日';

COMMENT
ON COLUMN t_usersettings.residence IS '居住地';

COMMENT
ON COLUMN t_usersettings.version IS 'バージョン';

COMMENT
ON COLUMN t_usersettings.create_datetime IS '作成日';

COMMENT
ON COLUMN t_usersettings.update_datetime IS '更新日';

COMMENT
ON COLUMN t_usersettings.delete_datetime IS '削除日';

-- チャンネル所属
CREATE TABLE t_channel_affiliation(
    channel_affiliation_id serial NOT NULL
    , channel_id integer NOT NULL
    , account_id integer NOT NULL
    , from_date date NOT NULL
    , to_date date NOT NULL
    , create_datetime timestamp (6) without time zone default now() NOT NULL
    , is_delete boolean default false not null
    , update_datetime timestamp (6) without time zone default now() NOT NULL
    , delete_datetime timestamp (6) without time zone default '9999-12-31 00:00:00' NOT NULL
    , primary key (channel_affiliation_id)
);

ALTER TABLE t_channel_affiliation ADD CONSTRAINT t_channel_affiliation_uk_code UNIQUE (channel_id, account_id)
;

COMMENT
    ON TABLE t_channel_affiliation IS 'チャンネル所属';

COMMENT
    ON COLUMN t_channel_affiliation.channel_id IS 'チャンネルID';

COMMENT
    ON COLUMN t_channel_affiliation.account_id IS 'アカウントID';

COMMENT
    ON COLUMN t_channel_affiliation.from_date IS '開始日';

COMMENT
    ON COLUMN t_channel_affiliation.to_date IS '終了日';

COMMENT
    ON COLUMN t_channel_affiliation.create_datetime IS '作成日';

COMMENT
    ON COLUMN t_channel_affiliation.is_delete IS '削除フラグ';

COMMENT
    ON COLUMN t_channel_affiliation.update_datetime IS '更新日';

COMMENT
    ON COLUMN t_channel_affiliation.delete_datetime IS '削除日';

-- チャンネル投稿
CREATE TABLE t_channel_post(
    channel_post_id serial NOT NULL
    , channel_id integer NOT NULL
    , account_id integer NOT NULL
    , post_comment text NOT NULL
    , create_datetime timestamp (6) without time zone default now() NOT NULL
    , is_delete boolean default false not null
    , update_datetime timestamp (6) without time zone default now() NOT NULL
    , delete_datetime timestamp (6) without time zone default '9999-12-31 00:00:00' NOT NULL
    , primary key (channel_post_id)
);

ALTER TABLE t_channel_post ADD CONSTRAINT t_channel_post_uk_code UNIQUE (channel_id, account_id, create_datetime)
;

COMMENT
    ON TABLE t_channel_post IS 'チャンネル投稿';

COMMENT
    ON COLUMN t_channel_post.channel_id IS 'チャンネルID';

COMMENT
    ON COLUMN t_channel_post.account_id IS 'アカウントID';

COMMENT
    ON COLUMN t_channel_post.post_comment IS '投稿コメント';

COMMENT
    ON COLUMN t_channel_post.create_datetime IS '作成日';

COMMENT
    ON COLUMN t_channel_post.is_delete IS '削除フラグ';

COMMENT
    ON COLUMN t_channel_post.update_datetime IS '更新日';

COMMENT
    ON COLUMN t_channel_post.delete_datetime IS '削除日';
