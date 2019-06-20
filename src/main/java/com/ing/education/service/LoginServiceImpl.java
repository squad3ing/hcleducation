package com.ing.education.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.StudentDTO;
import com.ing.education.entity.Student;
import com.ing.education.exception.StudentNotFoundException;
import com.ing.education.repository.StudentRepository;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public StudentDTO login(String loginName, String password) throws IllegalAccessException, InvocationTargetException, StudentNotFoundException {
		StudentDTO studentDTO = new StudentDTO();
		Student student = studentRepo.findByLoginNameAndPassword(loginName, password);
		if(student!=null) {
			BeanUtils.copyProperties(studentDTO, student);
		}else {
			throw new StudentNotFoundException(loginName,password);
		}
		return studentDTO;
	}

}
