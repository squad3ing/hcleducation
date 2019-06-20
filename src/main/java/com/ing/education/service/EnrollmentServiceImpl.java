package com.ing.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.entity.CourseEntity;
import com.ing.education.entity.Enrollment;
import com.ing.education.entity.Student;
import com.ing.education.repository.CourseRepository;
import com.ing.education.repository.EnrollmentRepository;
import com.ing.education.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public EnrollmentDTO enrollment(EnrollmentDTO enrollmentDTO) {
		Student student = studentRepository.findById((long) enrollmentDTO.getStudentId()).get();

		CourseEntity course = courseRepository.findById((long) enrollmentDTO.getCourseId()).get();

		Enrollment enrollment = new Enrollment();
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		enrollment.setCourseName(course.getCourseName());
		student.setIsRegistered("yes");
		enrollment = enrollmentRepository.save(enrollment);

		enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
		enrollmentDTO.setMessage("Student enrolled sucessfully");

		return enrollmentDTO;
	}

}
