package com.example.CourseApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseApp.entity.Courses;

@Repository
public interface MaincourseRepo extends JpaRepository<Courses, Long>{
    List<Courses> findByCategoriesIn(List<String> categories);

}
