package com.example.web.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routine")
@Transactional
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    public String name;

    @Column(name = "duration")
    public Time Duration;

    @Column(name = "volumn")
    public Double Volumn;

    @Column(name = "like_number")
    int LikeNumber;

    @Column(name = "comment_number")
    int CommentNumber;

    @Column(name = "image")
    private String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<User> getLikes() {
        return like;
    }

    public void setLikes(List<User> likes) {
        this.like = likes;
    }

    @ManyToMany(mappedBy = "likedRoutine")
    private List<User> like;

    public void addLike(User user){
        if(like == null) like = new ArrayList<>();
        like.add(user);
        LikeNumber++;
    }

    public void unLike(User user){
        if(like == null) throw new EntityNotFoundException();
        like.remove(user);
        LikeNumber--;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "id_owner")
    private User owner;

    @ManyToMany(mappedBy = "routine")
    private Set<Exercise> exerciseList = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "routine",
            cascade = CascadeType.ALL)
    public List<Comment> commentList = new ArrayList<>();

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void addComment(Comment comment){
        if(commentList == null) commentList = new ArrayList<>();
        commentList.add(comment);
        CommentNumber++;
        comment.setRoutine(this);
    }

    public Set<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(Set<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public void addExercise(Exercise exercise){
        if(exerciseList == null){
            exerciseList = new HashSet<>();
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
        this.name = name;
    }

    public Routine() {

    }

    public Routine(Routine routine){
        this.name = routine.getName();
        this.Duration = routine.getDuration();
        this.Volumn = routine.getVolumn();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getLikeNumber() {
        return LikeNumber;
    }

    public int getCommentNumber() {
        return CommentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        CommentNumber = commentNumber;
    }

    public Routine(int id, String name, Time duration, Double volumn, int likeNumber, int commentNumber, String urlImage, List<User> like, User owner, Set<Exercise> exerciseList, List<Comment> commentList) {
        this.id = id;
        this.name = name;
        Duration = duration;
        Volumn = volumn;
        LikeNumber = likeNumber;
        CommentNumber = commentNumber;
        this.urlImage = urlImage;
        this.like = like;
        this.owner = owner;
        this.exerciseList = exerciseList;
        this.commentList = commentList;
    }

    public void setObject(Routine routine){
        this.name = routine.name;
        this.owner = routine.owner;
    }

}
