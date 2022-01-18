package com.example.web.entity;

import com.example.web.more.LinkUsers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Transactional
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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
    public String sex;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "routine_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "routine_id"))
     private List<Routine> likedRoutine;

    public List<Routine> getLikedRoutine() {
        return likedRoutine;
    }

    public void setLikedRoutine(List<Routine> likedRoutine) {
        this.likedRoutine = likedRoutine;
    }

    public void like_Routine(Routine routine){
        if(likedRoutine == null) likedRoutine = new ArrayList<>();
        likedRoutine.add(routine);
    }

    public void unlike_routine(Routine routine){
        if(likedRoutine == null) throw new EntityNotFoundException();
        likedRoutine.remove(routine);
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner",
    cascade = CascadeType.ALL)
    public List<Routine> routineList;

    @OneToMany(mappedBy = "follower",
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

    public int getQuantityroutine() {
        return quantityroutine;
    }

    public void setQuantityroutine(int quantityroutine) {
        this.quantityroutine = quantityroutine;
    }

    public int getQuantityfollower() {
        return quantityfollower;
    }

    public void setQuantityfollower(int quantityfollower) {
        this.quantityfollower = quantityfollower;
    }

    public int getQuantityfollowed() {
        return quantityfollowed;
    }

    public void setQuantityfollowed(int quantityfollowed) {
        this.quantityfollowed = quantityfollowed;
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
        sex = "Male";
        age = 20;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
