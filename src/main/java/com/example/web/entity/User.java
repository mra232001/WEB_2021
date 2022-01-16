package com.example.web.entity;

import com.example.web.more.LinkUsers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users",schema = "webproject")
@Transactional
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "username")
    public String username;

    @Column(nullable = false,unique = false,name = "password")
    private String password;

    @Column(name = "id_role")
    private int id_role;

    @Column(name = "fullname")
    public String fullname;

    @Column(name = "age")
    public int age;

    @Column(name = "quantityroutine")
    public int quantityroutine;

    @Column(name = "quantityfollower")
    public int quantityfollower;

    @Column(name = "quantityfollowed")
    public int quantityfollowed;

    @Column(name = "bio")
    public String bio;

    @Column(name = "sex")
    public int sex;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner",
    cascade = CascadeType.ALL)
    public List<Routine> routineList;

    @OneToMany(mappedBy = "id_follower",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<LinkUsers> linkUsersList;

    public List<LinkUsers> getLinkUsersList() {
        return linkUsersList;
    }

    public void setLinkUsersList(List<LinkUsers> linkUsersList) {
        this.linkUsersList = linkUsersList;
    }

    public void addLinkUsers(LinkUsers linkUsers){
        if(this.linkUsersList == null) this.linkUsersList = new ArrayList<>();
        this.linkUsersList.add(linkUsers);
    }

    public List<Routine> getRoutineList() {
        return routineList;
    }

    public void setRoutineList(List<Routine> routineList) {
        this.routineList = routineList;
    }

    public User(){

    }

    public void setId(int Id){
        this.id = Id;
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
        quantityroutine++;
        TempRoutine.setOwner(this);
    }

    public void SetProfile(){
        fullname = "";
        quantityroutine = 0;
        quantityfollowed = 0;
        quantityfollower = 0;
        bio = "";
        sex = 1;
        age = 20;
    }
}
