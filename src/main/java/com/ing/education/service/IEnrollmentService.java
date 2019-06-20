package com.ing.education.service;

import org.springframework.stereotype.Service;

import com.ing.education.dto.EnrollmentDTO;

@Service
public interface IEnrollmentService {

	EnrollmentDTO getCourseSummary(long studentId);

	EnrollmentDTO enrollment(EnrollmentDTO enrollmentDTO);
}
