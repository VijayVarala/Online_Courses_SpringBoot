package com.example.CourseApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseApp.entity.Subcategory;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, Long>{
    List<Subcategory> findAllByCoursesId(Long courseId);

}
