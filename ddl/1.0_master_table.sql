-- マスタテーブル追加

-- アカウントマスター
CREATE TABLE m_account
    (
        account_id      serial NOT NULL,
        account_code    CHARACTER varying(64) NOT NULL,
        password        CHARACTER varying(512) NOT NULL,
        display_name    CHARACTER varying(128) NOT NULL,
        create_datetime timestamp(6) without time zone DEFAULT NOW() NOT NULL,
        is_delete       boolean                        DEFAULT FALSE NOT NULL,
        update_datetime timestamp(6) without time zone DEFAULT NOW() NOT NULL,
        delete_datetime timestamp(6) without time zone DEFAULT '9999-12-31 00:00:00' NOT NULL,
        PRIMARY KEY (account_id)
    );

ALTER TABLE m_account
    ADD CONSTRAINT m_account_uk_code UNIQUE (account_code);

COMMENT
    ON TABLE m_account IS 'アカウントマスター';

COMMENT
    ON COLUMN m_account.account_id IS 'アカウントID';

COMMENT
    ON COLUMN m_account.account_code IS 'アカウントコード';

COMMENT
    ON COLUMN m_account.password IS 'パスワード';

COMMENT
    ON COLUMN m_account.display_name IS '表示名';

COMMENT
    ON COLUMN m_account.create_datetime IS '作成日';

COMMENT
    ON COLUMN m_account.is_delete IS '削除フラグ';

COMMENT
    ON COLUMN m_account.update_datetime IS '更新日';

COMMENT
    ON COLUMN m_account.delete_datetime IS '削除日';

-- 機能マスター
CREATE TABLE m_functions(
                            function_id serial NOT NULL
    , function_code VARCHAR (64) NOT NULL
    , name VARCHAR (255) NOT NULL
    , url VARCHAR (255)
    , remark TEXT
    , create_datetime timestamp (6) without time zone DEFAULT NOW() NOT NULL
    , is_delete boolean DEFAULT FALSE NOT NULL
    , update_datetime timestamp (6) without time zone DEFAULT NOW() NOT NULL
    , delete_datetime timestamp (6) without time zone DEFAULT '9999-12-31 00:00:00' NOT NULL
    , PRIMARY KEY (function_id)
                        );

COMMENT
    ON TABLE m_functions IS '機能マスター';

COMMENT
    ON COLUMN m_functions.function_id IS '機能ID';

COMMENT
    ON COLUMN m_functions.name IS '機能コード';

COMMENT
    ON COLUMN m_functions.name IS '機能名';

COMMENT
    ON COLUMN m_functions.url IS 'url';

COMMENT
    ON COLUMN m_functions.remark IS '備考';

COMMENT
    ON COLUMN m_functions.create_datetime IS '作成日';

COMMENT
    ON COLUMN m_functions.is_delete IS '削除フラグ';

COMMENT
    ON COLUMN m_functions.update_datetime IS '更新日';

COMMENT
    ON COLUMN m_functions.delete_datetime IS '削除日';

-- チャンネルマスター
CREATE TABLE m_channel(
    channel_id serial NOT NULL
    , channel_code character varying (128) NOT NULL
    , channel_name character varying (128) NOT NULL
    , remark text
    , create_datetime timestamp (6) without time zone default now() NOT NULL
    , is_delete boolean default FALSE NOT NULL
    , update_datetime timestamp (6) without time zone default now() NOT NULL
    , delete_datetime timestamp (6) without time zone default '9999-12-31 00:00:00' NOT NULL
    , primary key (channel_id)
);

ALTER TABLE m_channel ADD CONSTRAINT m_channel_uk_code UNIQUE (channel_code);

COMMENT
    ON TABLE m_channel IS 'チャンネルマスター';

COMMENT
    ON COLUMN m_channel.channel_id IS 'チャンネルID';

COMMENT
    ON COLUMN m_channel.channel_name IS 'チャンネル名';

COMMENT
    ON COLUMN m_channel.remark IS '備考';

COMMENT
    ON COLUMN m_channel.create_datetime IS '作成日';

COMMENT
    ON COLUMN m_channel.is_delete IS '削除フラグ';

COMMENT
    ON COLUMN m_channel.update_datetime IS '更新日';

COMMENT
    ON COLUMN m_channel.delete_datetime IS '削除日';
