package com.ing.education.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.education.dto.CourseDTO;
import com.ing.education.entity.CourseEntity;
import com.ing.education.repository.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	CourseRepository courseRepository;

	public List<CourseDTO> getAllCourses() {
		List<CourseDTO> courseDtos = new ArrayList<CourseDTO>();
		List<CourseEntity> courseList = courseRepository.findAll();
		for (CourseEntity courseEntity : courseList) {
			CourseDTO courseDto=new CourseDTO();
			courseDto.setCourseId(courseEntity.getCourseId());
			courseDto.setCourseName(courseEntity.getCourseName());
			courseDto.setDuration(courseEntity.getDuration());
			courseDto.setFee(courseEntity.getFee());
			courseDto.setStartDate(courseEntity.getStartDate());
			courseDtos.add(courseDto);
			
		}
		return courseDtos;

	}

}
