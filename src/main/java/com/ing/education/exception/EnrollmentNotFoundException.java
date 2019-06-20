package com.ing.education.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnrollmentNotFoundException extends Exception implements Serializable {
	
private static final long serialVersionUID = 1L;
	


	private static String enrollmentException = "Enrollment not found with StudentId : ";
	
	public EnrollmentNotFoundException(long studentId) {
		super(enrollmentException + String.valueOf(studentId));
	}

}
