package com.example.web.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String status;
    String comment;

    /// post - workout
    @ManyToMany(mappedBy = "post")
    Set<Workout> workout;

    /// post - user
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Post(Long id, String name, String status, String comment) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.comment = comment;
    }

    /// post - share: 1: n share
    @OneToMany(mappedBy = "post")
    Set <Share> share = new HashSet<>();

    /// post - like: 1 n
    @OneToMany(mappedBy = "post")
    Set <Share> like = new HashSet<>();

    public Post() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id != null ? id.equals(post.id) : post.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Workout> getWorkout() {
        return workout;
    }

    public void setWorkout(Set<Workout> workout) {
        this.workout = workout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Share> getShare() {
        return share;
    }

    public void setShare(Set<Share> share) {
        this.share = share;
    }

    public Set<Share> getLike() {
        return like;
    }

    public void setLike(Set<Share> like) {
        this.like = like;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /// post - comment: 1 n
    @OneToMany(mappedBy = "post")
    Set <Comment> comments = new HashSet<>();
}
