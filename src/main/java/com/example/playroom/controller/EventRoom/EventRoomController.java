package com.example.playroom.controller.EventRoom;

import com.example.playroom.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventRoom")
public class EventRoomController extends BaseController {

    @GetMapping("/")
    public String index(){

        return "EventRoom/summary";
    }
}
