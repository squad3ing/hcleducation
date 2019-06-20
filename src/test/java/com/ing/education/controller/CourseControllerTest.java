
package com.ing.education.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.education.controller.CourseController;
import com.ing.education.dto.CourseDTO;
import com.ing.education.service.ICourseService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
  public class CourseControllerTest {
	  
	@Mock
	ICourseService courseService;
	@InjectMocks
	CourseController courseController;
	
	@Test
	public void testGetAllCourses() {
		List<CourseDTO> courses = new ArrayList<>();
		CourseDTO courseDto = new CourseDTO();
		courseDto.setCourseId(1);
		courseDto.setCourseName("mba");
		courses.add(courseDto);
		Mockito.lenient().when(courseService.getAllCourses()).thenReturn(courses);
		Assert.assertEquals(courses, courseController.getAllCourses().getBody());
		Assert.assertEquals(1, courses.size());
	}
  }
 