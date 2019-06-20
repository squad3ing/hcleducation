package com.ing.education.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CourseDTO {
	private long courseId;
	private String courseName;
	private double fee;
	private String duration;
	private Date startDate;
}
