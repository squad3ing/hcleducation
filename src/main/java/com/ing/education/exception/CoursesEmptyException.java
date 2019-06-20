package com.ing.education.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CoursesEmptyException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static String MESSAGE= "Currently courses not available";
	
	public CoursesEmptyException () {
		super(MESSAGE);
	}
		
	
	
}
