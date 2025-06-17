SELECT
    account_id
     , gender
     , self_introduction
     , birthday
     , residence
     , version
     , create_datetime
     , update_datetime
     , delete_datetime
FROM
    t_usersettings
WHERE
    account_id = /* id */0;
