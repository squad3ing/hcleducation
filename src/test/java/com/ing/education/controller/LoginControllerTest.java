package com.ing.education.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.education.IngeducationApplication;
import com.ing.education.dto.StudentDTO;
import com.ing.education.service.ILoginService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)
public class LoginControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	ILoginService loginService;

	@Test
	public void login() throws Exception {
		
		StudentDTO dto = new StudentDTO();
		dto.setLoginName("test");
		dto.setPassword("test");

		Mockito.when(loginService.login("test", "test")).thenReturn(dto);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/login")

				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(dto)))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
