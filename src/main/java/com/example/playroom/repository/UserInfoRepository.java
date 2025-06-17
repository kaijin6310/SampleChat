package com.example.playroom.repository;

import com.example.playroom.Entity.AccountEntity;
import com.example.playroom.Entity.UserSettingsEntity;
import com.example.playroom.dao.AccountDao;
import com.example.playroom.dto.Account;
import com.example.playroom.dto.UserSettings;
import com.example.playroom.form.Login.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public class UserInfoRepository {

    AccountDao accountDao;

    @Autowired
    public UserInfoRepository(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Optional<Account> getAccount(String accountCode) {
        AccountEntity entity = accountDao.findAccount(accountCode);

        if (Objects.isNull(entity)) {
            return Optional.empty();
        }

        // TODO：後でマッパーに移動させる
        Account account = new Account();
        account.setAccountId(entity.id);
        account.setAccountCode(entity.accountCode);
        account.setUsername(entity.displayName);
        account.setPassword(entity.password);

        return Optional.of(account);
    }


    public void CreateAccount(Account account) {
        AccountEntity entity = new AccountEntity();

        entity.accountCode = account.getAccountCode();
        entity.displayName = account.getUsername();
        entity.password = account.getPassword();

        accountDao.CreateAccount(entity);
    }

    public UserSettings FindUserSettings(Long accountId) {
        UserSettingsEntity userSettingsEntity = accountDao.findUserSettings(accountId);

        if (Objects.isNull(userSettingsEntity)) {
            return new UserSettings();
        }
        UserSettings userSettings = new UserSettings();
        userSettings.setGender(userSettingsEntity.gender);
        userSettings.setSelfIntroduction(userSettingsEntity.selfIntroduction);
        userSettings.setBirthday(userSettingsEntity.birthday);
        userSettings.setResidence(userSettingsEntity.residence);

        return userSettings;
    }

    public void UpdateAccount() {

    }

    public void DeleteAccount() {

    }

}
