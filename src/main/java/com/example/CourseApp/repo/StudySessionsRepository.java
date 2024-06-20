package com.example.CourseApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseApp.entity.StudySessions;

public interface StudySessionsRepository extends JpaRepository<StudySessions, Long> {

}
