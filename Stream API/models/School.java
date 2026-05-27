package models;

import java.util.List;

public class School {
    private List<Classroom> classrooms;

    public School(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
    public List<Classroom> getClassrooms() { return classrooms; }
}
