package com.example.CourseApp.repo;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseApp.entity.Sessions;
@Repository

public interface SessionRepo extends JpaRepository<Sessions, Long> {
    List<Sessions> findBySessionDateAndStartTimeBetween(Date sessionDate, Time startTime, Time endTime);
}
