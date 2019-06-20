package com.ing.education.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.education.dto.CourseDTO;
import com.ing.education.service.ICourseService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CourseController {
	private static final Logger lOGGER = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	ICourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		List<CourseDTO> courses = courseService.getAllCourses();
		lOGGER.info("fetching...");
		return new ResponseEntity<>(courses, HttpStatus.OK);

	}
}
