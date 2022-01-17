package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.more.ValidatedUser;
import com.example.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    public LoginService loginService;

    private final Logger logger = Logger.getLogger(getClass().getName());

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String register(Model model){
        ValidatedUser user = new ValidatedUser();
        model.addAttribute("user",user);

        return "Guest/register";
    }

    @PostMapping("/save")
    public String saveUser( @ModelAttribute("user") @Valid ValidatedUser theUser,
                           BindingResult thebindingresult,
                           Model model ){

        String userName = theUser.getUsername();
        logger.info("Processing registration form for: " + userName);

        if(thebindingresult.hasErrors()){
            return "Guest/register";
        }

        User exsitingUser = loginService.findbyUsername(theUser.getUsername());
        if(exsitingUser != null){
            model.addAttribute("user",new ValidatedUser());
            model.addAttribute("registrationError","Username already exists");

            logger.warning("Username is already exists.");
            return "Guest/register";
        }

        loginService.Register(theUser);

        logger.info("Successfully created user: " + userName);

        return "Guest/demo";
    }

}
