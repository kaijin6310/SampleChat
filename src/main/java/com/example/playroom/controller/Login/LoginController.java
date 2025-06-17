package com.example.playroom.controller.Login;

import com.example.playroom.form.Login.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {

        LoginForm form = new LoginForm();
        model.addAttribute("loginForm",form);
        return "login";
    }

    @GetMapping("/")
    public String login() {
        return "redirect:/login";
    }

    @GetMapping("/loginFailed")
    public String loginFailed(Model model){
        LoginForm form = new LoginForm();
        model.addAttribute("loginForm",form);

        return "login";
    }

    @GetMapping("/SignIn")
    public String SignIn() {
        return "redirect:/home/";
    }


}