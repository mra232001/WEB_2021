package com.example.web.service;

import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.more.ValidatedUser;
import com.example.web.repository.RoleRepository;
import com.example.web.repository.RoutineRepository;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoutineRepository routineRepository;

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void Register(ValidatedUser validatedUser){
        User user = new User();
        user.setUsername(validatedUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(validatedUser.getPassword()));
        if(user.getUsername().equals("admin")) user.setId_role(2); else user.setId_role(1);
        user.SetProfile();
        userRepository.save(user);
    }

    @Transactional
    public User findbyUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Invalid username and password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolestoAuthorities(user.getId_role()));
    }

    private Collection<? extends GrantedAuthority> mapRolestoAuthorities(int id_Role){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(roleRepository.findById(id_Role).getName()));
        return list;
    }
}
