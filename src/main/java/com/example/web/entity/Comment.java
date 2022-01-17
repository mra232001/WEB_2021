package com.example.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment",schema = "webproject")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "description" )
    public String content;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "writerid")
    public User writer;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "routineid")
    private Routine routine;

    public Comment(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}
