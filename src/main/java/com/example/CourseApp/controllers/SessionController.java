package com.example.CourseApp.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseApp.entity.Sessions;
import com.example.CourseApp.services.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
	  @Autowired
	    private SessionService sessionService;

	    @GetMapping
	    public ResponseEntity<List<Sessions>> getAllSessions() {
	        List<Sessions> sessions = sessionService.getAllSessions();
	        return new ResponseEntity<>(sessions, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Sessions> getSessionById(@PathVariable Long id) {
	        Optional<Sessions> session = sessionService.getSessionById(id);
	        return session.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public ResponseEntity<Sessions> createSession(@RequestBody Sessions session) {
	        Sessions createdSession = sessionService.createSession(session);
	        return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
	    }
	 //  to get night study sessions
	    @GetMapping("/study-night")
	    public ResponseEntity<List<Sessions>> getNightStudySessions(
	            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
	        List<Sessions> nightStudySessions = sessionService.getNightStudySessions(date);
	        return new ResponseEntity<>(nightStudySessions, HttpStatus.OK);
	    }

	    // to get day study sessions
	    @GetMapping("/study-day")
	    public ResponseEntity<List<Sessions>> getDayStudySessions(
	            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
	        List<Sessions> dayStudySessions = sessionService.getDayStudySessions(date);
	        return new ResponseEntity<>(dayStudySessions, HttpStatus.OK);
	    }
	    
//	    @GetMapping("/study-day")
//	    public ResponseEntity<List<Sessions>> getDayStudySessions() {
//	        // Get the current date
//	        Date currentDate = new Date();
//
//	        // Retrieve day study sessions for the current date
//	        List<Sessions> dayStudySessions = sessionService.getDayStudySessions(currentDate);
//
//	        return new ResponseEntity<>(dayStudySessions, HttpStatus.OK);
//	    }
	}	