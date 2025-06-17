package com.example.playroom.controller.UserSettings;

import com.example.playroom.Exception.PRNotFoundException;
import com.example.playroom.component.MessageUtil;
import com.example.playroom.common.UserContext;
import com.example.playroom.controller.BaseController;
import com.example.playroom.dto.UserSettings;
import com.example.playroom.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userSettings")
public class UserSettingsController extends BaseController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/")
    public String index(Model model) {
        try {
            UserSettings userSettings = userInfoService.FindUserSettings(UserContext.getUserCode());
            model.addAttribute("userSettings", userSettings);
        } catch (PRNotFoundException e) {
            model.addAttribute("message",e.getMessage());
            throw new RuntimeException(e);
        }
        return "UserSettings/userSettings";
    }

    @ResponseBody
    @PostMapping("/update")
    public String updateSettings(@ModelAttribute UserSettings userSettings, Model model) {
        model.addAttribute("userSettings", userSettings);

        return MessageUtil.getMessage("message.editSuccess");
    }

}
