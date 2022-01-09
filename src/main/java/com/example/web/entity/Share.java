package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table
public class Share {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Share share = (Share) o;

        return id != null ? id.equals(share.id) : share.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Share(Long id) {
        this.id = id;
    }

    /// share - user: manytoone
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

    public Share() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
