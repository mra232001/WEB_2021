package com.example.web.repository;

import com.example.web.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Integer> {

    public Node findNodeById(int id);
}
