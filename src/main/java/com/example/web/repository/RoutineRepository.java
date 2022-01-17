package com.example.web.repository;

import com.example.web.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Integer> {

    public List<Routine> findRoutineByName(String name);

    public List<Routine> findRoutineById(int id);
}
