package com.example.web.service;

import com.example.web.entity.Comment;
import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.repository.CommentRepository;
import com.example.web.repository.RoutineRepository;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoutineService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private UserRepository userRepository;

    public RoutineService(){

    }

    @Transactional
    public void addLike(User user, Routine routine){
        userRepository.save(user);
        routineRepository.save(routine);
    }

    public void unLike(User user, Routine routine){
        userRepository.save(user);
        routineRepository.save(routine);
    }

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }
}
