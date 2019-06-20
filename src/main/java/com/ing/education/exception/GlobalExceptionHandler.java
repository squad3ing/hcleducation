package com.ing.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {StudentNotFoundException.class})
	public ResponseEntity<ResponseError> loginError(Exception e){
		
		ResponseError loginError = new ResponseError(e.getMessage());
		
		return new ResponseEntity<ResponseError>(loginError,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(value = {EnrollmentNotFoundException.class})
	public ResponseEntity<ResponseError> enrollmentError(Exception e){
		
		ResponseError enrollmentError = new ResponseError(e.getMessage());
		
		return new ResponseEntity<ResponseError>(enrollmentError,HttpStatus.NOT_FOUND);
		
		
	}
	
}
