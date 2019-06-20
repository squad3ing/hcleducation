package com.ing.education.controller;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.education.dto.EnrollmentDTO;
import com.ing.education.service.IEnrollmentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EnrollmentController.class, secure = false)
public class EnrollmentControllerTest {
	/*
	 * @Mock IEnrollmentService enrollmentService;
	 * 
	 * @InjectMocks EnrollmentController enrollmentController;
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IEnrollmentService enrollmentService;

	@Test
	public void studentRegistration() throws Exception {
		EnrollmentDTO dto = new EnrollmentDTO();
		dto.setCourseId(1L);
		dto.setCourseName("ankit");
		dto.setEnrollDate(new Date());
		dto.setStudentId(1L);
		Mockito.when(enrollmentService.enrollment(Mockito.anyObject())).thenReturn(dto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/enrollment")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String InputType = this.mapToJson(dto);
		String OutputType = result.getResponse().getContentAsString();
		MockHttpServletResponse response = result.getResponse();
		System.out.println(OutputType.equals(InputType));

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}