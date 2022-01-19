package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "erset")
public class RoutineExerciseSet {
    @EmbeddedId
    RoutineExerciseKey id = new RoutineExerciseKey();

    @ManyToOne
    @MapsId("routineid")
    @JoinColumn(name = "routine_id")
    Routine routine;

    @ManyToOne
    @MapsId("exerciseid")
    @JoinColumn(name = "exercise_id")
    Exercise exercise;

    int set;
    int rep;
    int weight;
    ///
    int idex;

    public RoutineExerciseSet() {

    }

    public RoutineExerciseKey getId() {
        return id;
    }

    public void setId(RoutineExerciseKey id) {
        this.id = id;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getIdex() {
        return idex;
    }

    public void setIdex(int idex) {
        this.idex = idex;
    }

    public RoutineExerciseSet(RoutineExerciseKey id, Routine routine, Exercise exercise, int set, int rep, int weight, int idex) {
        this.id = id;
        this.routine = routine;
        this.exercise = exercise;
        this.set = set;
        this.rep = rep;
        this.weight = weight;
        this.idex = idex;
    }
}
