package com.example.CourseApp;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.CourseApp.controllers.MaincourseController;
import com.example.CourseApp.entity.Courses;
import com.example.CourseApp.services.MaincourseService;

@ExtendWith(MockitoExtension.class)
public class MaincourseControllerTest {

    @Mock
    private MaincourseService maincourseServiceMock;

    @InjectMocks
    private MaincourseController maincourseController;

    private List<Courses> mockCoursesList;

    @BeforeEach
    void setUp() {
        mockCoursesList = new ArrayList<>();
        Courses course1 = new Courses(1, "Course 1");
        Courses course2 = new Courses(2, "Course 2");
        mockCoursesList.add(course1);
        mockCoursesList.add(course2);
    }

    @Test
    void testSaveCourse_Success() {
        Courses newCourse = new Courses(3, "New Course");
        when(maincourseServiceMock.saveCourse(any(Courses.class))).thenReturn(newCourse);

        ResponseEntity<Courses> response = maincourseController.saveCourse(newCourse);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newCourse, response.getBody());
    }

    @Test
    void testGetAllCourses_Success() {
        when(maincourseServiceMock.getAllCourses()).thenReturn(mockCoursesList);

        ResponseEntity<List<Courses>> response = maincourseController.getAllCourses();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCoursesList, response.getBody());
    }

    @Test
    void testUpdateCourse_Success() {
        long courseId = 1;
        Courses updatedCourse = new Courses(courseId, "Updated Course");
        when(maincourseServiceMock.updateCourse(courseId, updatedCourse)).thenReturn(updatedCourse);

        ResponseEntity<Courses> response = maincourseController.updateCourse(courseId, updatedCourse);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCourse, response.getBody());
    }

    @Test
    void testUpdateCourse_NotFound() {
        long nonExistentCourseId = 100;
        Courses updatedCourse = new Courses(nonExistentCourseId, "Updated Course");
        when(maincourseServiceMock.updateCourse(nonExistentCourseId, updatedCourse)).thenReturn(null);

        ResponseEntity<Courses> response = maincourseController.updateCourse(nonExistentCourseId, updatedCourse);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
