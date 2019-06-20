package com.ing.education.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.exception.EnrollmentNotFoundException;
import com.ing.education.exception.StudentNotFoundException;
import com.ing.education.service.IEnrollmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders= {"*","/"},origins = {"*","/"})
public class StudentSummaryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentSummaryController.class);
	
	@Autowired
	IEnrollmentService iEnrollmentService;
	
	@GetMapping("/summary/{studentId}")
	public ResponseEntity<EnrollmentDTO> getCourseSummary(@PathVariable long studentId)throws EnrollmentNotFoundException{
		EnrollmentDTO enrollmentDTO = iEnrollmentService.getCourseSummary(studentId);
		if(enrollmentDTO ==null) {
			return new ResponseEntity<EnrollmentDTO>(enrollmentDTO, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<EnrollmentDTO>(enrollmentDTO,HttpStatus.OK);
	}
	
	

}
