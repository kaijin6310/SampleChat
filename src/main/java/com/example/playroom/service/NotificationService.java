package com.example.playroom.service;

import com.example.playroom.dto.Notification;
import com.example.playroom.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> findNotifications(){
        return notificationRepository.findNotifications();
    }

}
