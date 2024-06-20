package com.example.CourseApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseApp.entity.Courses;
import com.example.CourseApp.repo.MaincourseRepo;
@Service
public class MaincourseService {
	@Autowired
    private MaincourseRepo maincourseRepo;

    public Courses saveCourse(Courses course) {
        return maincourseRepo.save(course);
    }

    public List<Courses> getAllCourses() {
        return maincourseRepo.findAll();
    }

    public Optional<Courses> getCourseById(long id) {
        return maincourseRepo.findById(id);
    }

    public Courses updateCourse(long id, Courses updatedCourse) {
        Optional<Courses> course = maincourseRepo.findById(id);
        if (course.isPresent()) {
            Courses existingCourse = course.get();
            existingCourse.setCategories(updatedCourse.getCategories());
            return maincourseRepo.save(existingCourse);
        } else {
            return null;
        }
    }

    public void deleteCourse(long id) {
        maincourseRepo.deleteById(id);
    }
    public List<Courses> getCoursesBySelectedSubjects(List<String> selectedSubjects) {
        // Fetch courses whose categories match any of the selected subjects
        return maincourseRepo.findByCategoriesIn(selectedSubjects);
    }
    
}
