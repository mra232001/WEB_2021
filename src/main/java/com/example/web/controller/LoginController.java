package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.more.ValidatedUser;
import com.example.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        ValidatedUser user = new ValidatedUser();
        model.addAttribute("user",user);

        return "Guest/register";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") ValidatedUser theUser,
                           BindingResult thebindingresult,
                           Model model ){
        if(thebindingresult.hasErrors()){
            return "Guest/register";
        }

        User exsitingUser = loginService.findbyUsername(theUser.getUsername());
        if(exsitingUser != null){
            model.addAttribute("user",new ValidatedUser());
            model.addAttribute("RegistrationError","Username already exists");
            return "Guest/register";
        }

        loginService.Register(theUser);
        return "Guest/demo";
    }

    @GetMapping("/login")
    public String login(Model model){
        User user = new User();

        model.addAttribute("user",user);
        return "Guest/login";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(){

        return "Guest/demo";
    }
}
