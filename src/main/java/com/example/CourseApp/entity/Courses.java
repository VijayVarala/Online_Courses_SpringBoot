package com.example.CourseApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String categories;

    // Constructors
    public Courses() {
    }

    public Courses(String categories) {
        this.categories = categories;
    }

    public Courses(long id, String categories) {
        this.id = id;
        this.categories = categories;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    // toString() method
    @Override
    public String toString() {
        return "Courses [id=" + id + ", categories=" + categories + "]";
    }
}
