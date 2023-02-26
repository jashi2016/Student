package com.kiran.UMS.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private String id;
    private String title;
    private String description;
    private String duration;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Student> studentList;

    public Course() {
    }

    public Course(String id, String title, String description, String duration, List<Student> studentList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.studentList = studentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
