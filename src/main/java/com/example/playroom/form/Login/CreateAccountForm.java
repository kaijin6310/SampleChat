package com.example.playroom.form.Login;

import lombok.Data;

@Data
public class CreateAccountForm {

    private String accountCode;

    private String username;

    private  String password;

    private String passwordConf;
}
