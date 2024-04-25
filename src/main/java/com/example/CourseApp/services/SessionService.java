package com.example.CourseApp.services;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseApp.entity.Sessions;
import com.example.CourseApp.repo.SessionRepo;

@Service

public class SessionService {
	@Autowired
    private SessionRepo sessionsRepo;

    public List<Sessions> getAllSessions() {
        return sessionsRepo.findAll();
    }

    public Optional<Sessions> getSessionById(Long id) {
        return sessionsRepo.findById(id);
    }

    public Sessions createSession(Sessions session) {
        return sessionsRepo.save(session);
    }
 // Retrieve night study sessions based on date and time range
    public List<Sessions> getNightStudySessions(Date date) {
        LocalTime nightStartTime = LocalTime.of(18, 0); // Adjust as needed
        LocalTime nightEndTime = LocalTime.of(6, 0);    // Adjust as needed

        Time startTime = Time.valueOf(nightStartTime);
        Time endTime = Time.valueOf(nightEndTime);

        return sessionsRepo.findBySessionDateAndStartTimeBetween(date, startTime, endTime);
    }

    // Retrieve day study sessions based on date and time range
    public List<Sessions> getDayStudySessions(Date date) {
        LocalTime dayStartTime = LocalTime.of(6, 0);    // Adjust as needed
        LocalTime dayEndTime = LocalTime.of(18, 0);    // Adjust as needed

        Time startTime = Time.valueOf(dayStartTime);
        Time endTime = Time.valueOf(dayEndTime);

        return sessionsRepo.findBySessionDateAndStartTimeBetween(date, startTime, endTime);
    }
}
