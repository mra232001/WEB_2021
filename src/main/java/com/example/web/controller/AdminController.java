package com.example.web.controller;

import com.example.web.entity.User;
import com.example.web.service.AdminService;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public AdminService adminService;

    @Autowired
    public MainService mainService;

    @GetMapping("/list")
    public String list(Model model){
        List<User> userList = adminService.ListAllUser();
        model.addAttribute("users",userList);
        return "Admin/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("user") int id){
        User user  = mainService.findUserbyId(id);
        adminService.DeleteUser(user);
        return "redirect:http://localhost:8080/profile/?userId=1&ses=1";
    }
}
