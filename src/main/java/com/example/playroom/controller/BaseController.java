package com.example.playroom.controller;


import com.example.playroom.common.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;


public abstract class BaseController {

    @ModelAttribute
    public void setUserInfo(Model model) {
        String userCode = UserContext.getUserCode();
        model.addAttribute("name", userCode);
        model.addAttribute("icon", StringUtils.isEmpty(userCode) ? "" : userCode.substring(0, 1));
    }

    @GetMapping("/back")
    public String back(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String lastPage = StringUtils.toString(session.getAttribute("lastPage"));
        if (StringUtils.isEmpty(lastPage)) {
            lastPage = "/home/";
        }
        System.out.println("Redirecting to: " + lastPage);
        return "redirect:" + lastPage;
    }
}
