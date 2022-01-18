package com.example.web.entity;

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

    @ManyToMany(cascade = CascadeType.ALL)
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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "receiver")
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addNewNoti(Notification notification){
        if(notifications == null) notifications = new ArrayList<>();
        notifications.add(notification);
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

    @ManyToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private List<User> followers = new ArrayList<>();

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="UserRel",
            joinColumns={@JoinColumn(name="UserId")},
            inverseJoinColumns={@JoinColumn(name="ParentId")})
    private List<User> following = new ArrayList<>();


    public void follow(User user){
        following.add(user);
        quantityfollowed++;
    }

    public void befollowed(User user){
        followers.add(user);
        quantityfollower++;
    }

    public void unfollow(User user){
        following.remove(user);
        quantityfollowed--;
    }

    public void beUnfollow(User user){
        followers.remove(user);
        quantityfollower--;
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
