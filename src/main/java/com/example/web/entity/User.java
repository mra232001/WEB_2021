package com.example.web.entity;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users",schema = "webproject")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(nullable = false,unique = false,name = "password")
    private String password;

    @Column(name = "id_role")
    private int id_role;

    public User(){

    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public User(String Username, String Password){
        this.username = Username;
        this.password = Password;
    }

    public String getUsername() {
        return username;
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

}
