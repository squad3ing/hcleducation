package com.ing.education.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.entity.CourseEntity;
import com.ing.education.entity.Enrollment;
import com.ing.education.entity.Student;
import com.ing.education.exception.EnrollmentNotFoundException;
import com.ing.education.repository.CourseRepository;
import com.ing.education.repository.EnrollmentRepository;
import com.ing.education.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired 
	StudentRepository studentRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	public EnrollmentDTO enrollment(EnrollmentDTO enrollmentDTO) {
		Student student = studentRepository.findById( enrollmentDTO.getStudentId()).get();

		CourseEntity course = courseRepository.findById(enrollmentDTO.getCourseId()).get();

		Enrollment enrollment = new Enrollment();
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		enrollment.setCourseName(course.getCourseName());
		enrollment.setEnrollDate(new Date());
		student.setIsRegistered("yes");
		enrollment = enrollmentRepository.save(enrollment);

		enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());

		return enrollmentDTO;
	}
	
	@Override
	public EnrollmentDTO getCourseSummary(long studentId) throws EnrollmentNotFoundException {
	

		Enrollment enrollDetailsEntity = enrollmentRepository.findByStudent(studentId);
		if (enrollDetailsEntity == null) {
			throw new EnrollmentNotFoundException(studentId);
		} else {
			EnrollmentDTO enrollDetailsDTO = new EnrollmentDTO();
			
			enrollDetailsDTO.setCourseId(enrollDetailsEntity.getCourse().getCourseId());
			enrollDetailsDTO.setStudentId(enrollDetailsEntity.getStudent().getStudentId());
			enrollDetailsDTO.setCourseName(enrollDetailsEntity.getCourseName());
			enrollDetailsDTO.setEnrollDate(enrollDetailsEntity.getEnrollDate());
			enrollDetailsDTO.setEnrollmentId(enrollDetailsEntity.getEnrollmentId());
			enrollDetailsDTO.setDuration(enrollDetailsEntity.getCourse().getDuration());
			enrollDetailsDTO.setFee(enrollDetailsEntity.getCourse().getFee());

			return enrollDetailsDTO;
		}

	}

}
