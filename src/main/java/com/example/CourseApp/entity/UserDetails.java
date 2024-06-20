package com.example.CourseApp.entity;
//
//public class UserDetails {
//
//}


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import java.util.Arrays;

@Entity
@Table(name = "user_detailsh") // Specify the table name
public class UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    public UserDetails(Integer id, String firstname, String lastname, String email, String password, String birthday,
			String location, String gender, String username, byte[] profilePicture, String[] selectedSubjects,
			String[] selectedGroups) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.location = location;
		this.gender = gender;
		this.username = username;
		this.profilePicture = profilePicture;
		this.selectedSubjects = selectedSubjects;
		this.selectedGroups = selectedGroups;
	}

	@Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "birthday")
    private String birthday;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "profilepicture")
    private byte[] profilePicture;
    
    @Column(name = "selectedsubjects")
    private String[] selectedSubjects;
    
    @Column(name = "selectedgroups")
    private String[] selectedGroups;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String[] getSelectedSubjects() {
        return selectedSubjects;
    }

    public void setSelectedSubjects(String[] selectedSubjects) {
        this.selectedSubjects = selectedSubjects;
    }

    public String[] getSelectedGroups() {
        return selectedGroups;
    }

    public void setSelectedGroups(String[] selectedGroups) {
        this.selectedGroups = selectedGroups;
    }
    public UserDetails() {
        // Default constructor
    }

}
