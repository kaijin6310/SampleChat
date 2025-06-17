package com.example.playroom.controller.Home;

import com.example.playroom.controller.BaseController;
import com.example.playroom.dto.Notification;
import com.example.playroom.common.UserContext;
import com.example.playroom.service.NotificationService;
import org.apache.catalina.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/")
    public String index(Model model) {
        List<Notification> notifications = notificationService.findNotifications();
        model.addAttribute("notifications", notifications);
        return "Home/index";
    }
}
