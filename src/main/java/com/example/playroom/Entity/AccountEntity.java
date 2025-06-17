package com.example.playroom.Entity;

import lombok.Data;
import org.seasar.doma.*;

@Entity
@Table(name = "m_account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public Long id;

    @Column(name = "account_code")
    public String accountCode;

    @Column(name = "password")
    public String password;

    @Column(name = "display_name")
    public String displayName;


}

