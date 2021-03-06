package com.example.web.repository;

import com.example.web.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
    Exercise findById(int id);
}
