package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table
public class Like {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int like_id;
    int id_workout;
    int user_id;

    public Like() {

    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public int getId_workout() {
        return id_workout;
    }

    public void setId_workout(int id_workout) {
        this.id_workout = id_workout;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Like(int like_id, int id_workout, int user_id) {
        this.like_id = like_id;
        this.id_workout = id_workout;
        this.user_id = user_id;
    }
}
