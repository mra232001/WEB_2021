package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();

        model.addAttribute("user",user);

        return "Guest/register";
    }


    @GetMapping("/list")
    public String list(Model model){
        List<User> userList = loginService.listAll();

        model.addAttribute("users",userList);

        return "Guest/list";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){
        if(theUser.getPassword().equals(theUser.getPassword_confirm())) {
            loginService.Register(theUser);
            return "Guest/demo";
        } else return "redirect:/register";
    }

    @GetMapping("/login")
    public String login(Model model){
        User user = new User();

        model.addAttribute("user",user);
        return "Guest/login";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam("user") User theUser){
        return "Guest/demo";
    }
}
