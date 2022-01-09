package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute("user") User theUser){
        if(theUser.getPassword().equals( theUser.getPassword_confirm())) loginService.Register(theUser);
        return "redirect:/guest/login";
    }
}
