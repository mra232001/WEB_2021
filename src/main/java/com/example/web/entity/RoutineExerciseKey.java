package com.example.web.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoutineExerciseKey implements Serializable {
    @Column(name = "routine_id")
    int routineid;

    @Column(name = "exercise")
    int exerciseid;

    public RoutineExerciseKey(int routineid, int exerciseid) {
        this.routineid = routineid;
        this.exerciseid = exerciseid;
    }

    public RoutineExerciseKey() {

    }

    public int getRoutineid() {
        return routineid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutineExerciseKey that = (RoutineExerciseKey) o;

        if (routineid != that.routineid) return false;
        return exerciseid == that.exerciseid;
    }

    @Override
    public int hashCode() {
        int result = routineid;
        result = 31 * result + exerciseid;
        return result;
    }

    public void setRoutineid(int routineid) {
        this.routineid = routineid;
    }

    public int getExerciseid() {
        return exerciseid;
    }

    public void setExerciseid(int exerciseid) {
        this.exerciseid = exerciseid;
    }
}
