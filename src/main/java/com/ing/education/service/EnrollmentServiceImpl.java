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
			courseDetailsDTO.setStudent(studentDTO);
			courseDetailsDTO.setCourse(courseDTO);

			return courseDetailsDTO;
		}
	}

}
