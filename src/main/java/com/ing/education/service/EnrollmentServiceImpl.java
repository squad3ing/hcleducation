package com.ing.education.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.CourseDTO;
import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.dto.StudentDTO;
import com.ing.education.entity.Enrollment;
import com.ing.education.repository.CourseRepository;
import com.ing.education.repository.EnrollmentRepository;
import com.ing.education.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService{
	
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	

	@Override
	public EnrollmentDTO getCourseSummary(long studentId) {
		StudentDTO studentDTO = new StudentDTO();
		CourseDTO courseDTO = new CourseDTO();
		
		Enrollment courseDetailsEntity = enrollmentRepository.findByStudent(studentId);
		if(courseDetailsEntity==null) {
			return null;
		}
		EnrollmentDTO courseDetailsDTO = new EnrollmentDTO();
		BeanUtils.copyProperties(courseDetailsEntity, courseDetailsDTO);
		BeanUtils.copyProperties(courseDetailsEntity.getStudent(),studentDTO);
		BeanUtils.copyProperties(courseDetailsEntity.getCourse(), courseDTO);
		courseDetailsDTO.setStudentId(studentDTO.getStudentId());
		courseDetailsDTO.setCourseId(courseDTO.getCourseId());
		
		return courseDetailsDTO;
	}

}
