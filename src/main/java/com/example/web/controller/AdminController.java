package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public AdminService adminService;

    @GetMapping("/list")
    public String list(Model model){
        List<User> userList = adminService.ListAllUser();
        model.addAttribute("users",userList);
        return "Admin/list";
    }
}
