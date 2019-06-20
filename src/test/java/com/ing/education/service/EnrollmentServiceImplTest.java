package com.ing.education.service;

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
import com.ing.education.repository.EnrollmentRepository;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceImplTest {

	@Mock
	EnrollmentRepository enrollmentRepository;

	@InjectMocks

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
		
		
		enrollment.setCourse(courseEntity);
		enrollment.setStudent(student);
		enrollment.setEnrollmentId(1l);
		enrollment.setCourseName("BE");
	}

	@Test
	public void tesGetCourseSummary() throws EnrollmentNotFoundException {

		
		Mockito.when(enrollmentRepository.findByStudent(2)).thenReturn(enrollment);
		//EnrollmentDTO enrollment2 = new EnrollmentDTO();
		enrollmentDTO = enrollmentServiceImpl.getCourseSummary(2);
		Assert.assertEquals("BE", enrollmentDTO.getCourseName());

	}
}
