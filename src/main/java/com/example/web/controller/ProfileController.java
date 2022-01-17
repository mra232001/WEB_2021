package com.example.web.controller;


import com.example.web.entity.User;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    public MainService mainService;

    @GetMapping("")
    public String ShowProfile(@RequestParam("userId") int Id,
                              Model model){
        User user = mainService.userRepository.getById(Id);
        model.addAttribute("user",user);
        model.addAttribute("ID",Id);
        return "Authenticated/OtherUser;sPersonalpage2";
    }

}
