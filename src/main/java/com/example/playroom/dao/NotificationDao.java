package com.example.playroom.dao;

import com.example.playroom.Entity.NotificationEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface NotificationDao {

    @Select
    List<NotificationEntity> findNotifications();
}
