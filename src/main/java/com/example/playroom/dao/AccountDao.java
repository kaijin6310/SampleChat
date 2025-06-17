package com.example.playroom.dao;


import com.example.playroom.Entity.AccountEntity;
import com.example.playroom.Entity.UserSettingsEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface AccountDao {

    @Select
    AccountEntity findAccount(String accountCode);

    @Select
    UserSettingsEntity findUserSettings(Long id);

    @Insert
    int CreateAccount(AccountEntity entity);
}
