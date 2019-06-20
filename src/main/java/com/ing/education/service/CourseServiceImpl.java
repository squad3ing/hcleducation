package com.ing.education.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.CourseDTO;
import com.ing.education.entity.CourseEntity;
import com.ing.education.exception.CoursesEmptyException;
import com.ing.education.repository.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	CourseRepository courseRepository;

	public List<CourseDTO> getAllCourses() {
		List<CourseDTO> courseDtos = new ArrayList<>();
		List<CourseEntity> courseList = courseRepository.findByStartDateAfter(new Date());
		if(courseList.size()>0) {
		for (CourseEntity courseEntity : courseList) {
			CourseDTO courseDto=new CourseDTO();
			courseDto.setCourseId(courseEntity.getCourseId());
			courseDto.setCourseName(courseEntity.getCourseName());
			courseDto.setDuration(courseEntity.getDuration());
			courseDto.setFee(courseEntity.getFee());
			courseDto.setStartDate(courseEntity.getStartDate());
			courseDtos.add(courseDto);
			
		}
		}
		else {
			throw new CoursesEmptyException();
		}
		return courseDtos;

	}

}
