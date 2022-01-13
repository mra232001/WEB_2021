package com.example.web.controller;

import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("")
    public String main_page(Model model){

        return "Authenticated/Home_page";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        List<Integer> listRoutines = new ArrayList<>();
        model.addAttribute("list_routines",listRoutines);
        return "Authenticated/MyPersonalPage";
    }

    @GetMapping("/logout")
    public String logout(){
        return "Guest/demo";
    }

}
