package com.ing.education.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long enrollmentId;
	private Long studentId;
	private Long courseId;
	private Date enrollDate;
	private String courseName;
}
