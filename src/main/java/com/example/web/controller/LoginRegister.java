package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegister {

    private final CommentRepository commentRepository;

    public LoginRegister(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        commentRepository.save(user);
        model.addAttribute(user.getId(), commentRepository.findAll());
        return "login";
    }
}
