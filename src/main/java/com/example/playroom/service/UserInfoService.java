package com.example.playroom.service;

import com.example.playroom.Exception.PRNotFoundException;
import com.example.playroom.dto.Account;
import com.example.playroom.dto.UserSettings;
import com.example.playroom.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Transactional
    public void CreateAccount (Account account){
        userInfoRepository.CreateAccount(account);
    }

    public UserSettings FindUserSettings (String accountCode) throws PRNotFoundException {
        Optional<Account> accountOpt = userInfoRepository.getAccount(accountCode);

        if(accountOpt.isEmpty()){
            throw new PRNotFoundException("アカウント情報が見つかりません");
        }
        Account account = accountOpt.get();
        UserSettings userSettings = userInfoRepository.FindUserSettings(account.getAccountId());
        userSettings.setAccountId(account.getAccountId());
        userSettings.setAccountCode(account.getAccountCode());
        userSettings.setUsername(account.getUsername());
        return userSettings;

    }

}
