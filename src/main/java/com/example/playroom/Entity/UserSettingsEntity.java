package com.example.playroom.Entity;

import org.seasar.doma.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "t_usersettings")
public class UserSettingsEntity {

    @Id
    @Column(name = "account_id")
    public Long id;

    @Column(name = "gender")
    public String gender;

    @Column(name = "self_introduction")
    public String selfIntroduction;

    @Column(name = "birthday")
    public LocalDate birthday;

    @Column(name = "residence")
    public String residence;

    @Column(name = "version")
    public String version;

    @Column(name = "create_datetime")
    public String createDatetime;

    @Column(name = "update_datetime")
    public String updateDatetime;

    @Column(name = "delete_datetime")
    public String deleteDatetime;


}