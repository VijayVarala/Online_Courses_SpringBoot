//package com.example.CourseApp.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Groups {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String description;
//
//    @Column(nullable = false)
//    private String location;
//
//    @Column(nullable = false)
//    private boolean publicGroup; // Renamed from 'Public'
//
//    @Column(nullable = false)
//    private boolean approvalRequired;
//
//    @Column
//    private String subjects;
//
//    @Column(nullable = false)
//    private String username; // New column added
//
//    // Default constructor
//    public Groups() {
//        // Default constructor for JPA
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public boolean isPublicGroup() { // Renamed from 'isPublic'
//        return publicGroup;
//    }
//
//    public void setPublicGroup(boolean publicGroup) { // Renamed from 'setPublic'
//        this.publicGroup = publicGroup;
//    }
//
//    public boolean isApprovalRequired() {
//        return approvalRequired;
//    }
//
//    public void setApprovalRequired(boolean approvalRequired) {
//        this.approvalRequired = approvalRequired;
//    }
//
//    public String getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(String subjects) {
//        this.subjects = subjects;
//    }
//    
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}


package com.example.CourseApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private boolean publicGroup; // Renamed from 'Public'

    @Column(nullable = false)
    private boolean approvalRequired;

    @Column
    private String subjects;

    @Column(nullable = false)
    private String username; // New column added

    // Default constructor
    public Groups() {
        // Default constructor for JPA
    }

    // Constructor with arguments
    public Groups(Long id, String name, String description, String location, boolean publicGroup, boolean approvalRequired, String subjects, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.publicGroup = publicGroup;
        this.approvalRequired = approvalRequired;
        this.subjects = subjects;
        this.username = username;
    }

    // Getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPublicGroup() { // Renamed from 'isPublic'
        return publicGroup;
    }

    public void setPublicGroup(boolean publicGroup) { // Renamed from 'setPublic'
        this.publicGroup = publicGroup;
    }

    public boolean isApprovalRequired() {
        return approvalRequired;
    }

    public void setApprovalRequired(boolean approvalRequired) {
        this.approvalRequired = approvalRequired;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
