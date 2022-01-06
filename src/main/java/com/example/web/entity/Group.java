package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Group {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;
    @JsonIgnore
    @OneToMany
    ArrayList <User> users = new ArrayList<>();

    public Group(int id, String name, ArrayList<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Group() {

    }
}
