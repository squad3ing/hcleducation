package com.ing.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.education.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
public Student findByLoginNameAndPassword(String loginName,String password);
}