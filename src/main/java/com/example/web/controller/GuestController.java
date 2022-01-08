package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

    @GetMapping("")
    public String index(){
        return "Guest/demo";
    }

    @GetMapping("/login")
    public String loginFrom(){
        return "Guest/login";
    }

    @GetMapping("/avaiable-routine")
    public String AvaiableRoutine(){
        return "Guest/Page_Avaiable_Routines";
    }

}
