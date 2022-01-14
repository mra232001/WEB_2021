package com.example.web.entity;

import javax.persistence.*;

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

    @Column(name = "like_number")
    int LikeNumber;

    @Column(name = "comment_number")
    int CommentNumber;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "id_owner")
    private User owner;

    public void setLikeNumber(int likeNumber) {
        LikeNumber = likeNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Routine(int id, String name, int number) {
        this.id = id;
        this.Routine_name = name;
        this.number = number;
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
