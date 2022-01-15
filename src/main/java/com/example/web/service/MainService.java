package com.example.web.service;

import com.example.web.entity.Exercise;
import com.example.web.repository.ExerciseRepository;
import com.example.web.repository.RoutineRepository;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Exercise> listAllExercises(){
        return exerciseRepository.findAll();
    }

    public Exercise findById(int id){
        return exerciseRepository.getById(id);
    }
}
