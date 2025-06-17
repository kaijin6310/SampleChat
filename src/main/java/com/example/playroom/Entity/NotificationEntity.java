package com.example.playroom.Entity;

import org.seasar.doma.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    public Long id;

    @Column(name = "title")
    public String title;

    @Column(name = "message")
    public String message;

    @Column(name = "create_datetime")
    public LocalDate CreateDateTime;
}
