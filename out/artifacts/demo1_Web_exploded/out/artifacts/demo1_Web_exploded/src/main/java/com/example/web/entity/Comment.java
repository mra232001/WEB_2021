package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int comment_id;
    int user_id;
    String comment_text;

    public Comment(int comment_id, int user_id, String comment_text) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.comment_text = comment_text;
    }

    public Comment() {

    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }
}
