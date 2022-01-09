package com.example.web.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String username;
    String password;
    String firstname;
    String middlename;
    String lastname;
    String email;
    String avatar;

    /// user - comment
    @OneToMany(mappedBy = "user")
    Set<Comment> commentSet = new HashSet<>();

    /// user - like
    @OneToMany(mappedBy = "user")
    Set <Like> like = new HashSet<>();

    /// user - post;
    @OneToMany(mappedBy = "user")
    Set <Post> post = new HashSet<>();

    /// user - share
    @OneToMany(mappedBy = "user")
    Set <Share> share = new HashSet<>();

    // user - group
    @ManyToMany
    @JoinTable(name = "user_post", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    Set <Group> group = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public Set<Like> getLike() {
        return like;
    }

    public void setLike(Set<Like> like) {
        this.like = like;
    }

    public Set<Post> getPost() {
        return post;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }

    public Set<Share> getShare() {
        return share;
    }

    public void setShare(Set<Share> share) {
        this.share = share;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }

    public User() {

    }

    public User(Long id, String username, String password, String firstname, String middlename, String lastname, String email, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.avatar = avatar;
    }
}
