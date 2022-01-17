package com.example.web.repository;

import com.example.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findUsersByUsername(String Username);

    User findByUsername(String Username);
    public List<User> findUsersById(int id);
}
