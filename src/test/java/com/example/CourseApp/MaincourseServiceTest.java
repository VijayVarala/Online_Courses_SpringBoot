package com.example.CourseApp;
//
//public class MaincourseServiceTest {
//
//}


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.CourseApp.entity.Courses;
import com.example.CourseApp.repo.MaincourseRepo;
import com.example.CourseApp.services.MaincourseService;

@ExtendWith(MockitoExtension.class)
public class MaincourseServiceTest {

    @Mock
    private MaincourseRepo maincourseRepo;

    @InjectMocks
    private MaincourseService maincourseService;

    @Test
    public void testGetAllCourses() {
        // Prepare mock data
        List<Courses> mockCourses = new ArrayList<>();
        Courses course1 = new Courses();
        course1.setCategories("Category 1");
        mockCourses.add(course1);

        Courses course2 = new Courses();
        course2.setCategories("Category 2");
        mockCourses.add(course2);

        // Mock behavior
        when(maincourseRepo.findAll()).thenReturn(mockCourses);

        // Perform the test
        List<Courses> result = maincourseService.getAllCourses();

        // Assertions
        assertEquals(mockCourses.size(), result.size());
        assertEquals(mockCourses.get(0).getCategories(), result.get(0).getCategories());
        assertEquals(mockCourses.get(1).getCategories(), result.get(1).getCategories());
    }

    @Test
    public void testUpdateCourse() {
        // Prepare mock data
        long courseId = 1L;
        Courses existingCourse = new Courses();
        existingCourse.setId(courseId);
        existingCourse.setCategories("Category 1");

        Courses updatedCourse = new Courses();
        updatedCourse.setId(courseId);
        updatedCourse.setCategories("Updated Category 1");

        // Mock behavior
        when(maincourseRepo.findById(courseId)).thenReturn(Optional.of(existingCourse));
        when(maincourseRepo.save(existingCourse)).thenReturn(updatedCourse);

        // Perform the test
        Courses result = maincourseService.updateCourse(courseId, updatedCourse);

        // Assertions
        assertEquals(updatedCourse, result);
    }

    // Add more test cases as needed for other methods
}
