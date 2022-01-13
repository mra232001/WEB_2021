package com.example.web.service;

import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.repository.RoleRepository;
import com.example.web.repository.RoutineRepository;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService  {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public RoutineRepository routineRepository;

    public MainService(UserRepository userRepository, RoutineRepository routineRepository){
        this.routineRepository = routineRepository;
        this.userRepository = userRepository;
    }

    public List<Routine> findAllroutinesOwned(int id){
        return routineRepository.findAllById_owner(id);
    }


}
