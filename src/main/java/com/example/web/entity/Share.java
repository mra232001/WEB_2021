package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table
public class Share {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int user;
    int workout;

    public Share(int id, int user, int workout) {
        this.id = id;
        this.user = user;
        this.workout = workout;
    }

    public Share() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getWorkout() {
        return workout;
    }

    public void setWorkout(int workout) {
        this.workout = workout;
    }
}
