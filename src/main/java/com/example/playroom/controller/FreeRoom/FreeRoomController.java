package com.example.playroom.controller.FreeRoom;

import com.example.playroom.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freeRoom")
public class FreeRoomController extends BaseController {

    @GetMapping("/")
    public String index(){

        return "FreeRoom/summary";
    }
}
