package com.example.web.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Workout {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id_workout;
    String name;
    String status;
    LocalDateTime time;
    String comment;
    int user_id;
    int set;
    int reps;
    int weight;
    int rest_time;

    public Workout(int id_workout, String name, String status, LocalDateTime time, String comment, int user_id, int set, int reps, int weight, int rest_time) {
        this.id_workout = id_workout;
        this.name = name;
        this.status = status;
        this.time = time;
        this.comment = comment;
        this.user_id = user_id;
        this.set = set;
        this.reps = reps;
        this.weight = weight;
        this.rest_time = rest_time;
    }

    public Workout() {

    }

    public int getId_workout() {
        return id_workout;
    }

    public void setId_workout(int id_workout) {
        this.id_workout = id_workout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRest_time() {
        return rest_time;
    }

    public void setRest_time(int rest_time) {
        this.rest_time = rest_time;
    }
}
