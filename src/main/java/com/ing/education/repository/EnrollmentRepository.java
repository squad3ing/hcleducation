package com.ing.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	@Query("Select e from Enrollment e where student.studentId = ?1")
	Enrollment findByStudent(long studentId);

}
