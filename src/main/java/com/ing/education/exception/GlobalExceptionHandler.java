package com.ing.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {StudentNotFoundException.class})
	public ResponseEntity<LoginError> loginError(Exception e){
		
		LoginError loginError = new LoginError(e.getMessage());
		
		return new ResponseEntity<LoginError>(loginError,HttpStatus.NOT_FOUND);
		
		
	}
	
}
