package com.ing.education.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.entity.CourseEntity;
import com.ing.education.entity.Enrollment;
import com.ing.education.entity.Student;
import com.ing.education.exception.EnrollmentNotFoundException;
import com.ing.education.service.EnrollmentServiceImpl;
import com.ing.education.service.IEnrollmentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentSummaryControllerTest {

	@Mock
	IEnrollmentService iEnrollmentService;

	@InjectMocks
	StudentSummaryController studentSummaryController;

	EnrollmentServiceImpl enrollmentServiceImpl;

	CourseEntity courseEntity;
	Student student;
	EnrollmentDTO enrollmentDTO;

	Enrollment enrollment;

	@Before
	public void setup() {
		courseEntity = new CourseEntity();
		student = new Student();
		enrollmentDTO = new EnrollmentDTO();
		enrollment = new Enrollment();
		courseEntity.setCourseId(1);
		courseEntity.setCourseName("BE");
		student.setStudentId(1l);
		student.setStudentName("deepika");

		enrollmentDTO.setEnrollmentId(1l);
		enrollmentDTO.setCourseName("BE");
	}

	@Test
	
	public void tesGetCourseSummary() throws EnrollmentNotFoundException {

		Mockito.lenient().when(iEnrollmentService.getCourseSummary(2)).thenReturn(enrollmentDTO);
		Assert.assertEquals(enrollmentDTO, studentSummaryController.getCourseSummary(2).getBody());
		Assert.assertEquals("BE", enrollmentDTO.getCourseName());

	}

}
