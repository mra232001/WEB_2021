package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String description;

    public int onwerID;

    public int RoutineId;
}
