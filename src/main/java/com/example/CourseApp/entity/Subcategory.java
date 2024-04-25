package com.example.CourseApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Subcategory {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne
    private Courses courses;

    // Constructors
    public Subcategory() {
    }

    public Subcategory(String name, Courses courses) {
        this.name = name;
        this.courses = courses;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    // toString() method
    @Override
    public String toString() {
        return "Subcategory [id=" + id + ", name=" + name + ", courses=" + courses + "]";
    }
}