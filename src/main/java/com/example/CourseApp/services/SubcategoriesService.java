package com.example.CourseApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseApp.entity.Subcategory;
import com.example.CourseApp.repo.SubcategoryRepo;

@Service
public class SubcategoriesService {
	 @Autowired
	    private SubcategoryRepo subcategoryRepo;
	 
	 public List<Subcategory> getAllSubcategories() {
	        return subcategoryRepo.findAll();
	    }

	    public List<Subcategory> getSubcategoriesByCategoryId(Long categoryId) {
	        return subcategoryRepo.findAllByCoursesId(categoryId);
	    }
	}