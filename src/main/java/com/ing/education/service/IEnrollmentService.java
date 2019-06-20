package com.ing.education.service;

import org.springframework.stereotype.Service;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.exception.EnrollmentNotFoundException;

@Service
public interface IEnrollmentService {

	EnrollmentDTO getCourseSummary(long studentId)throws EnrollmentNotFoundException;

	EnrollmentDTO enrollment(EnrollmentDTO enrollmentDTO);
}
