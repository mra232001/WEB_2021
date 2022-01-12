package com.example.web.entity;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routine",schema = "webproject")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String Routine_name;
    int number; /// this is set training

    @Column(name = "duration")
    public Integer Duration;

    @Column(name = "volumn")
    public Double Volumn;

    @Column(name = "id_owner")
    int id_owner;

    @Column(name = "like_number")
    int LikeNumber;

    @Column(name = "comment_number")
    int CommentNumber;

    public Routine(int id, String name, int number) {
        this.id = id;
        this.Routine_name = name;
        this.number = number;
    }

    @OneToMany
    List<Exercise> exerciseList;

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

    public String getRoutine_name() {
        return Routine_name;
    }

    public void setRoutine_name(String routine_name) {
        Routine_name = routine_name;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public Double getVolumn() {
        return Volumn;
    }

    public void setVolumn(Double volumn) {
        Volumn = volumn;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public Integer getLikeNumber() {
        return LikeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        LikeNumber = likeNumber;
    }

    public int getCommentNumber() {
        return CommentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        CommentNumber = commentNumber;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}
