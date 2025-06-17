package com.example.playroom.controller.Chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @ResponseBody
    @GetMapping("/message")
    private List<String> getMessages() {

        return new ArrayList<>();
    }

    @ResponseBody
    @PutMapping("/message")
    private List<String> sendMessages() {

        return new ArrayList<>();
    }

}
