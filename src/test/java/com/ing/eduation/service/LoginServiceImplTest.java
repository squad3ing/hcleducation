package com.ing.eduation.service;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.education.dto.StudentDTO;
import com.ing.education.entity.Student;
import com.ing.education.exception.StudentNotFoundException;
import com.ing.education.repository.StudentRepository;
import com.ing.education.service.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {
	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	@Mock
	StudentRepository studentRepository;

	Student student;

	@Before
	public void setUp() {
		student = new Student();
		student.setAge(20);
		student.setIsRegistered("no");
		student.setStudentId((long) 1);
		student.setLoginName("test");
		student.setPassword("test");

	}

	@Test
	public void loginSucess() throws IllegalAccessException, InvocationTargetException, StudentNotFoundException {

		String loginName = "test";
		String password = "test";
		Mockito.when(studentRepository.findByLoginNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(student);
		StudentDTO studentDTO = loginServiceImpl.login(loginName, password);
		Assert.assertEquals("no", studentDTO.getIsRegistered());
	}

	@Test(expected = StudentNotFoundException.class)
	public void loginFailure() throws IllegalAccessException, InvocationTargetException, StudentNotFoundException {

		String loginName = "faildff";
		String password = "fail";
		Mockito.when(studentRepository.findByLoginNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(null);
		StudentDTO studentDTO = loginServiceImpl.login(loginName, password);

	}
}
