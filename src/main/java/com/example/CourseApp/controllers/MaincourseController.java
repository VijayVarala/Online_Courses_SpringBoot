package com.example.CourseApp.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseApp.entity.Courses;
import com.example.CourseApp.services.MaincourseService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MaincourseController {
	 @Autowired
	    private MaincourseService maincourseService;

	    @RequestMapping(value={"/","/index"})
	    @ResponseBody
	    public String index() {
	        return "index";
	    }

	    @PostMapping("/courses")
	    public ResponseEntity<Courses> saveCourse(@RequestBody Courses course) {
	        return new ResponseEntity<>(maincourseService.saveCourse(course), HttpStatus.CREATED);
	    }

	    @GetMapping("/courses")
	    public ResponseEntity<List<Courses>> getAllCourses() {
	        return new ResponseEntity<>(maincourseService.getAllCourses(), HttpStatus.OK);
	    }

	    @PutMapping("/courses/{id}")
	    public ResponseEntity<Courses> updateCourse(@PathVariable long id, @RequestBody Courses updatedCourse) {
	        Courses updated = maincourseService.updateCourse(id, updatedCourse);
	        if (updated != null) {
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}

