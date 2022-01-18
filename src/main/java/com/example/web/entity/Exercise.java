package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    public String Exercise_name;

    @Column(name = "description")
    public String Description;

    @Column(name = "equipment")
    public String equipment;

    @Column(name = "detail")
    public String DetailDescription;

    @Column(name = "image")
    public String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Column(name = "primary_muscle")
    public String Primary_muscle;
    public Exercise(String name, String description, String equipment, String primary_muscle,String detailDescription){
        this.DetailDescription = detailDescription;
        this.Description = description;
        this.equipment = equipment;
        this.Exercise_name = name;
        this.Primary_muscle = primary_muscle;
    }

    public String getDetailDescription() {
        return DetailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        DetailDescription = detailDescription;
    }


    public Set<Routine> getRoutine() {
        return routine;
    }

    public void setRoutine(Set<Routine> routine) {
        this.routine = routine;
    }

    @ManyToMany
    @JoinTable(name = "routine_exercise", joinColumns = @JoinColumn(name = "id_exercise"), inverseJoinColumns = @JoinColumn(name = "id_routine"))
    private Set<Routine> routine = new HashSet<>();

    public int getId() {
        return id;
    }

    public String getPrimary_muscle() {
        return Primary_muscle;
    }

    public void setPrimary_muscle(String primary_muscle) {
        Primary_muscle = primary_muscle;
    }

    public Exercise(){

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