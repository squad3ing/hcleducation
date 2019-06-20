package com.ing.education.service;

import java.lang.reflect.InvocationTargetException;

import com.ing.education.dto.StudentDTO;
import com.ing.education.exception.StudentNotFoundException;

public interface ILoginService {
	
	public StudentDTO login(String loginName, String password) throws IllegalAccessException, InvocationTargetException, StudentNotFoundException;

}
