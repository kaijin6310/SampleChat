package com.example.playroom.repository;

import com.example.playroom.Entity.NotificationEntity;
import com.example.playroom.dao.NotificationDao;
import com.example.playroom.dto.Notification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationRepository {

    NotificationDao notificationDao;

    NotificationRepository(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public List<Notification> findNotifications(){
        List<NotificationEntity> entities = notificationDao.findNotifications();
        return this.toNotifications(entities);
    }

    private List<Notification> toNotifications(List<NotificationEntity> entities){
        return entities.stream().map(this::toNotification).toList();
    }

    private Notification toNotification(NotificationEntity entity){
        Notification notification = new Notification();
        notification.setTitle(entity.title);
        notification.setMessage(entity.message);
        notification.setCreateDate(entity.CreateDateTime);

        return notification;
    }
}
