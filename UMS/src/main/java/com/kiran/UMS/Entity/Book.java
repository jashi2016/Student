package com.kiran.UMS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;

    public Book() {
    }

    public Book(String id, String title, String author, String description, String price, Student student) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.student = student;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
