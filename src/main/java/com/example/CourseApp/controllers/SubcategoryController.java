package com.example.CourseApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseApp.entity.Subcategory;
import com.example.CourseApp.services.SubcategoriesService;

@RestController
@RequestMapping("/subcategories")
public class SubcategoryController {
	 @Autowired
	    private SubcategoriesService subcategoryService;
	 
	 @GetMapping
	    public List<Subcategory> getAllSubcategories() {
	        return subcategoryService.getAllSubcategories();
	    }

	    @GetMapping("/category/{categoryId}")
	    public List<Subcategory> getSubcategoriesByCategoryId(@PathVariable Long categoryId) {
	        return subcategoryService.getSubcategoriesByCategoryId(categoryId);
	    }
	}