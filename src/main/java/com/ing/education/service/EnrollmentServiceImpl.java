package com.ing.education.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.CourseDTO;
import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.dto.StudentDTO;
import com.ing.education.entity.Enrollment;
import com.ing.education.exception.EnrollmentNotFoundException;
import com.ing.education.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
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
	@Override
	public EnrollmentDTO getCourseSummary(long studentId) throws EnrollmentNotFoundException {
		StudentDTO studentDTO = new StudentDTO();
		CourseDTO courseDTO = new CourseDTO();

		Enrollment courseDetailsEntity = enrollmentRepository.findByStudent(studentId);
		if (courseDetailsEntity == null) {
			throw new EnrollmentNotFoundException(studentId);
		} else {

			EnrollmentDTO courseDetailsDTO = new EnrollmentDTO();
			BeanUtils.copyProperties(courseDetailsEntity, courseDetailsDTO);
			BeanUtils.copyProperties(courseDetailsEntity.getStudent(), studentDTO);
			BeanUtils.copyProperties(courseDetailsEntity.getCourse(), courseDTO);
			courseDetailsDTO.setStudentId(studentDTO.getStudentId());
			courseDetailsDTO.setCourseId(courseDTO.getCourseId());

			return courseDetailsDTO;
		}

	}

}
