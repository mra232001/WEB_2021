package com.example.web.service;

import com.example.web.entity.Comment;
import com.example.web.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {

    @Autowired
    private CommentRepository commentRepository;

    public RoutineService(){

    }

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }
}
