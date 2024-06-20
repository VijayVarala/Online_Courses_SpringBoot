package com.example.CourseApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.CourseApp.controllers.StudySessionsController;
import com.example.CourseApp.entity.StudySessions;
import com.example.CourseApp.services.StudySessionsService;

public class StudySessionsControllerTest {
	@Mock
    private StudySessionsService studySessionsService;

    @InjectMocks
    private StudySessionsController studySessionsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudySessions_Success() {
        List<StudySessions> mockSessions = new ArrayList<>();
        mockSessions.add(new StudySessions("Session1", "Description1", "Location1",
                LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(),
                true, true, false));
        mockSessions.add(new StudySessions("Session2", "Description2", "Location2",
                LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(),
                false, true, true));
        when(studySessionsService.getAllStudySessions()).thenReturn(mockSessions);

        List<StudySessions> response = studySessionsController.getAllStudySessions();

        assertNotNull(response);
        assertEquals(2, response.size());
    }

    @Test
    void testGetStudySessionById_Success() {
        Long sessionId = 1L;
        StudySessions mockSession = new StudySessions("Session1", "Description1", "Location1",
                LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(),
                true, true, false);
        when(studySessionsService.getStudySessionById(sessionId)).thenReturn(mockSession);

        StudySessions response = studySessionsController.getStudySessionById(sessionId);

        assertNotNull(response);
        assertEquals(mockSession, response);
    }

    @Test
    void testCreateStudySession_Success() {
        StudySessions newSession = new StudySessions("Session1", "Description1", "Location1",
                LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(),
                true, true, false);
        when(studySessionsService.createStudySession(any(StudySessions.class))).thenReturn(newSession);

        StudySessions response = studySessionsController.createStudySession(newSession);

        assertNotNull(response);
        assertEquals(newSession, response);
    }
}
