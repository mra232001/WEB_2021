package com.example.web.controller;


import com.example.web.entity.User;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    public MainService mainService;

    @GetMapping("")
    public String ShowProfile(@RequestParam("userId") int Id,
                              Model model,
                              @RequestParam("ses") int idSes){
        User Sessionuser = mainService.findUserbyId(idSes);
        User user = mainService.findUserbyId(Id);
        model.addAttribute("user",user);
        model.addAttribute("ID",Id);
        model.addAttribute("sesUser",Sessionuser);
        return "Authenticated/OtherUser;sPersonalpage2";
    }

    @GetMapping("/configure")
    public String ConfigureProfile(@RequestParam("id") int id,
                                   Model model){
        User user = mainService.findUserbyId(id);
        model.addAttribute("user",user);
        return "Authenticated/Configure";
    }

    @PostMapping("/save")
    public String SaveProfile(@ModelAttribute("user") User user
                              ){
        mainService.saveUser(user);
        return "redirect:/profile/?userId=" + user.getId()+"&ses="+user.getId();
    }
}
