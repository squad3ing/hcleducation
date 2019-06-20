package com.ing.education.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.education.dto.CourseDTO;
import com.ing.education.entity.CourseEntity;
import com.ing.education.repository.CourseRepository;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {
	
	@Mock
	CourseRepository courseRepository;
	
	@InjectMocks
	CourseServiceImpl courseServiceImpl;
	
	
	@Test
	public void testGetAllCourses() {
		
		List<CourseEntity> courseList = new ArrayList<>();
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseName("cour1");
		courseList.add(courseEntity);
		courseEntity = new CourseEntity();
		courseEntity.setCourseName("cour2");
		courseList.add(courseEntity);
		Mockito.when(courseRepository.findAll()).thenReturn(courseList);
		List<CourseDTO> courses = courseServiceImpl.getAllCourses();
		Assert.assertEquals(2, courses.size());
		Assert.assertEquals("cour1", courses.get(0).getCourseName());
		
	}

}
