package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public String Exercise_name;

    public String Description;

    public String equipment;

    public Exercise(String name, String description, String equipment){
        this.Description = description;
        this.equipment = equipment;
        this.Exercise_name = name;
    }

    public Exercise(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise_name() {
        return Exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        Exercise_name = exercise_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
