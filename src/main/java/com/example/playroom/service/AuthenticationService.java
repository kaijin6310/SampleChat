package com.example.playroom.service;

import com.example.playroom.dto.Account;
import com.example.playroom.form.Login.LoginForm;
import com.example.playroom.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public Optional<Account> getAuthInfo(String userCode) {
        return userInfoRepository.getAccount(userCode);
    }
}
