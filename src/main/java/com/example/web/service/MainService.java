package com.example.web.service;

import com.example.web.entity.Exercise;
import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.repository.ExerciseRepository;
import com.example.web.repository.RoutineRepository;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostLoad;
import java.util.List;
import java.util.Optional;

@Service
public class MainService  {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoutineRepository routineRepository;

    @Autowired
    public ExerciseRepository exerciseRepository;

    public MainService(){

    }

    public MainService(UserRepository userRepository, RoutineRepository routineRepository){
        this.routineRepository = routineRepository;
        this.userRepository = userRepository;
    }

    public List<User> findUserById(int id){
        return userRepository.findUsersById(id);
    }


    public List<Routine> findRoutineByName(String name){
        return routineRepository.findRoutineByName(name);
    }


    public List<Exercise> listAllExercises(){
        return exerciseRepository.findAll();
    }


    public Exercise findExerciseById(int id){
        return exerciseRepository.getById(id);
    }

    public List<User> findUserbyUsername(String username){
        return userRepository.findUsersByUsername(username);
    }

    public List<Routine> findRoutineById(int id){
        return routineRepository.findRoutineById(id);
    }
}
