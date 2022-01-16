package com.example.web.more;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linkuser")
public class LinkUsers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_follower")
    private int id_follower;

    @Column(name = "id_followed")
    private int id_followed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_follower() {
        return id_follower;
    }

    public void setId_follower(int id_follower) {
        this.id_follower = id_follower;
    }

    public int getId_followed() {
        return id_followed;
    }

    public void setId_followed(int id_followed) {
        this.id_followed = id_followed;
    }
}
