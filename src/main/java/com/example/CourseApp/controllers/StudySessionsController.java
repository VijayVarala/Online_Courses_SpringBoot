package com.example.CourseApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseApp.entity.StudySessions;
import com.example.CourseApp.services.StudySessionsService;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/study-sessions")
public class StudySessionsController {
	private final StudySessionsService studySessionsService;

    @Autowired
    public StudySessionsController(StudySessionsService studySessionsService) {
        this.studySessionsService = studySessionsService;
    }

    @GetMapping
    public List<StudySessions> getAllStudySessions() {
        return studySessionsService.getAllStudySessions();
    }

    @GetMapping("/{id}")
    public StudySessions getStudySessionById(@PathVariable Long id) {
        return studySessionsService.getStudySessionById(id);
    }

    @PostMapping
    public StudySessions createStudySession(@RequestBody StudySessions studySessions) {
        return studySessionsService.createStudySession(studySessions);
    }

}
