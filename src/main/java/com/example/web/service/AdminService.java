package com.example.web.service;

import com.example.web.entity.User;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    public UserRepository userRepository;

    public List<User> ListAllUser(){
        return userRepository.findAll();
    }
}
