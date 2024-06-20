package com.example.CourseApp.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity

public class Sessions {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;
	    private String location;
	    private boolean isPrivate;
	    private boolean approvalRequired;
	    private String studyTime;

	    @Temporal(TemporalType.DATE)
	    private Date sessionDate;

	    @Temporal(TemporalType.TIME)
	    private Time startTime;

	    @Temporal(TemporalType.TIME)
	    private Time endTime;

	    @Lob
	    private byte[] image;

	    public Sessions() {
	        super();
	    }

	    public Sessions(Long id, String name, String description, String location, boolean isPrivate,
	                    boolean approvalRequired, String studyTime, Date sessionDate, Time startTime, Time endTime, byte[] image) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.location = location;
	        this.isPrivate = isPrivate;
	        this.approvalRequired = approvalRequired;
	        this.studyTime = studyTime;
	        this.sessionDate = sessionDate;
	        this.startTime = startTime;
	        this.endTime = endTime;
	        this.image = image;
	    }

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

	    public boolean isPrivate() {
	        return isPrivate;
	    }

	    public void setPrivate(boolean isPrivate) {
	        this.isPrivate = isPrivate;
	    }

	    public boolean isApprovalRequired() {
	        return approvalRequired;
	    }

	    public void setApprovalRequired(boolean approvalRequired) {
	        this.approvalRequired = approvalRequired;
	    }

	    public String getStudyTime() {
	        return studyTime;
	    }

	    public void setStudyTime(String studyTime) {
	        this.studyTime = studyTime;
	    }

	    public Date getSessionDate() {
	        return sessionDate;
	    }

	    public void setSessionDate(Date sessionDate) {
	        this.sessionDate = sessionDate;
	    }

	    public Time getStartTime() {
	        return startTime;
	    }

	    public void setStartTime(Time startTime) {
	        this.startTime = startTime;
	    }

	    public Time getEndTime() {
	        return endTime;
	    }

	    public void setEndTime(Time endTime) {
	        this.endTime = endTime;
	    }

	    public byte[] getImage() {
	        return image;
	    }

	    public void setImage(byte[] image) {
	        this.image = image;
	    }

	    @Override
	    public String toString() {
	        return "Sessions [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
	                + ", isPrivate=" + isPrivate + ", approvalRequired=" + approvalRequired + ", StudyTime=" + studyTime
	                + ", sessionDate=" + sessionDate + ", startTime=" + startTime + ", endTime=" + endTime + ", image="
	                + Arrays.toString(image) + "]";
	    }
	}

//{not in use as of now}