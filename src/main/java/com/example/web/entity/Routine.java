package com.example.web.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String Routine_name;
    int number; /// this is set training

    public Integer Duration;

    public Double Volumn;

    int id_owner;

    Integer LikeNumber;

    public Routine(int id, String name, int number) {
        this.id = id;
        this.Routine_name = name;
        this.number = number;
    }

    @OneToMany
    List<Exercise> exerciseList;

    List<Integer> listSet;

    public Routine() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Routine_name;
    }

    public void setName(String name) {
        this.Routine_name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
