package com.kiran.UMS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    private String id;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student;

    public Laptop() {
    }

    public Laptop(String id, String name, String brand, Integer price, Student student) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
