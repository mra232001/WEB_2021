package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

    @GetMapping("")
    public String index(){
        return "Guest/demo";
    }

    @GetMapping("/avaiable-routines")
    public String AvaiableRoutine(){
        return "Guest/Page_Avaiable_Routines";
    }

    @GetMapping("/login")
    public String login(){
        return "Guest/login";
    }

}
