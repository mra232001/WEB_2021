package com.example.web.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users",schema = "webproject")
@Transactional
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

    @OneToMany(mappedBy = "owner",
    cascade = CascadeType.ALL)
    private List<Routine> routineList;

    public List<Routine> getRoutineList() {
        return routineList;
    }

    public void setRoutineList(List<Routine> routineList) {
        this.routineList = routineList;
    }

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


    //add convenience method for bi-directional relationship
    public void add(Routine TempRoutine){
        if(this.routineList == null){
            this.routineList = new ArrayList<>();
        }
        routineList.add(TempRoutine);
        TempRoutine.setOwner(this);
    }
}
