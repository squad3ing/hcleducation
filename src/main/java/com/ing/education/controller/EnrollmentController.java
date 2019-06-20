package com.ing.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.service.IEnrollmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = {})
public class EnrollmentController {

	@Autowired
	private IEnrollmentService enrollmentService;

	@PostMapping("/enrollment") 
	public ResponseEntity<EnrollmentDTO>studentRegistration(@RequestBody EnrollmentDTO enrollmentDTO) { 
	 EnrollmentDTO dto=	enrollmentService.enrollment(enrollmentDTO);
	 return new ResponseEntity<EnrollmentDTO>(dto,HttpStatus.CREATED);
		
		
	}

}
