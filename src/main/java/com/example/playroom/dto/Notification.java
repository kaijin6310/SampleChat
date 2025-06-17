package com.example.playroom.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Notification {

    private String title;

    private String message;

    private LocalDate CreateDate;
}
