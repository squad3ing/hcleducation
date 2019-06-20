package com.ing.education.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.education.dto.StudentDTO;
import com.ing.education.exception.StudentNotFoundException;
import com.ing.education.service.ILoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","*/"},origins = {"*","*/"})
public class LoginController {
	
	@Autowired
	ILoginService loginService;
	
	@PutMapping("/login")
	public ResponseEntity<StudentDTO> login(@RequestBody StudentDTO studentDTO) throws IllegalAccessException, InvocationTargetException, StudentNotFoundException{
		 studentDTO = loginService.login(studentDTO.getLoginName(), studentDTO.getPassword());
		return new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.FOUND);
	}

}
