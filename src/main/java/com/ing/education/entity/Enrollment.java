package com.ing.education.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "enrollment")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enrollment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long enrollmentId;
	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;
	@OneToOne
	@JoinColumn(name = "courseId")
	private CourseEntity course;
	private Date enrollDate;
	private String courseName;

}
