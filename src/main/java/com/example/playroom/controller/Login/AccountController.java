package com.example.playroom.controller.Login;

import com.example.playroom.dto.Account;
import com.example.playroom.form.Login.CreateAccountForm;
import com.example.playroom.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/account")
public class AccountController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(Model model) {

        CreateAccountForm createAccountForm = new CreateAccountForm();
        model.addAttribute(createAccountForm);
        return "Login/account";
    }

    @PostMapping("/create")
    public String CreateAccount(CreateAccountForm createAccountForm) {


        // TODO:後でマッパーに入れる
        Account account = new Account();
        account.setAccountCode(createAccountForm.getAccountCode());
        account.setUsername(createAccountForm.getUsername());
        account.setPassword(passwordEncoder.encode(createAccountForm.getPassword()));

        userInfoService.CreateAccount(account);


        return "redirect:/login";
    }

}
