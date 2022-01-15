package com.example.web.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routine",schema = "webproject")
@Transactional
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String Routine_name;

    @Column(name = "duration")
    public Time Duration;

    @Column(name = "volumn")
    public Double Volumn;

    @Column(name = "like_number")
    int LikeNumber;

    @Column(name = "comment_number")
    int CommentNumber;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "id_owner")
    private User owner;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "routine_exercise",
    joinColumns = @JoinColumn(name = "id_routine"),
    inverseJoinColumns = @JoinColumn(name = "id_exercise"))
    private List<Exercise> exerciseList;

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public void addExercise(Exercise exercise){
        if(exerciseList == null){
            exerciseList = new ArrayList<>();
        }
        exerciseList.add(exercise);

    }

    public void setLikeNumber(int likeNumber) {
        LikeNumber = likeNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Routine(int id, String name) {
        this.id = id;
        this.Routine_name = name;
    }

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

    public String getRoutine_name() {
        return Routine_name;
    }

    public void setRoutine_name(String routine_name) {
        Routine_name = routine_name;
    }

    public Time getDuration() {
        return Duration;
    }

    public void setDuration(Time duration) {
        Duration = duration;
    }

    public Double getVolumn() {
        return Volumn;
    }

    public void setVolumn(Double volumn) {
        Volumn = volumn;
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

}
