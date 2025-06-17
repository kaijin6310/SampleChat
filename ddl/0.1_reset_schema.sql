-- スキーマ洗い替え
DROP SCHEMA IF EXISTS playroom CASCADE;
CREATE SCHEMA playroom;
SET search_path = 'playroom';