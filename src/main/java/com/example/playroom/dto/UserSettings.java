package com.example.playroom.dto;

import lombok.Data;
import org.seasar.doma.Column;

import java.time.LocalDate;

@Data
public class UserSettings {

    private Long accountId;

    private String accountCode;

    private String username;

    private String gender;

    private String selfIntroduction;

    private LocalDate birthday;

    private String residence;
}
