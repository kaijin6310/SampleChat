SELECT
    notification_id
     , title
     , message
     , create_datetime
FROM
    t_notifications
WHERE
    NOW() >= from_date
  AND NOW() <= to_date
  AND is_delete = false;
