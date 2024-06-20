package com.example.CourseApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseApp.entity.StudySessions;
import com.example.CourseApp.repo.StudySessionsRepository;
@Service
public class StudySessionsService {
	private final StudySessionsRepository studySessionsRepository;

    @Autowired
    public StudySessionsService(StudySessionsRepository studySessionsRepository) {
        this.studySessionsRepository = studySessionsRepository;
    }

    public List<StudySessions> getAllStudySessions() {
        return studySessionsRepository.findAll();
    }

    public StudySessions getStudySessionById(Long id) {
        Optional<StudySessions> optionalStudySession = studySessionsRepository.findById(id);
        return optionalStudySession.orElse(null);
    }

    public StudySessions createStudySession(StudySessions studySessions) {
        return studySessionsRepository.save(studySessions);
    }
}
