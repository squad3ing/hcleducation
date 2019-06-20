package com.ing.education.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	

	private static String LOGINEXCEPTION = "Student not found with : ";
	
	public StudentNotFoundException(String loginName,String password) {
		super(LOGINEXCEPTION + "LoginName " + loginName +" and "+ "Password " + password);
	}
}
