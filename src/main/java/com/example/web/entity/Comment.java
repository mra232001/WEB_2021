package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;
    private String comment_text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return comment_id != null ? comment_id.equals(comment.comment_id) : comment.comment_id == null;
    }

    @Override
    public int hashCode() {
        return comment_id != null ? comment_id.hashCode() : 0;
    }

    public Comment(Long comment_id, String comment_text) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
    }

    public Comment() {

    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
