package com.example.web.repository;

import com.example.web.entity.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}
