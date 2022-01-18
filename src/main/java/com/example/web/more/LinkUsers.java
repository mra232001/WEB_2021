package com.example.web.more;

import com.example.web.entity.User;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linkusers")
public class LinkUsers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_follower")
    private User follower;

    @OneToOne
    @JoinColumn(name = "id_followed")
    private User followed;

    public LinkUsers() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkUsers(User follower, User followed){
        this.follower = follower;
        this.followed = followed;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User id_followed) {
        this.followed = id_followed;
    }
}
