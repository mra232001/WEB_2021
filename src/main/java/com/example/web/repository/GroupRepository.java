package com.example.web.repository;

import com.example.web.entity.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository <Group, Long> {
}
