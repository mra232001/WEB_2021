package com.example.web.service;

import com.example.web.entity.User;
import com.example.web.more.ValidatedUser;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    public UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void Register(ValidatedUser validatedUser){
        User user = new User();
        user.setUsername(validatedUser.getUsername());
        user.setPassword(passwordEncoder.encode(validatedUser.getPassword()));
        user.setPassword_Confirm(validatedUser.getPassword_confirm());
        userRepository.save(user);
    }

    public User findbyUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findbyUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),null);
    }
}
