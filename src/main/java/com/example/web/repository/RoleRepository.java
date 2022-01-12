package com.example.web.repository;

import com.example.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findById(int id);
}
