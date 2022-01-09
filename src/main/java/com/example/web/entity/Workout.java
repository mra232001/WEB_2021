package com.example.web.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    int number; /// this is set training

    public Workout(Long id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    @ManyToMany
    @JoinTable(name = "post_work", joinColumns = @JoinColumn(name = "workout_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
    Set<Post> post;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workout workout = (Workout) o;

        return id != null ? id.equals(workout.id) : workout.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Workout() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Post> getPost() {
        return post;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }
}
