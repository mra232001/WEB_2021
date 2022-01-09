package com.example.web.service;

import com.example.web.entity.User;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    public UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void Register(User user){
        if(user.getPassword() == user.getPassword_confirm()){
            userRepository.save(user);
        }
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }
}
