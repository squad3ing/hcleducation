package com.ing.education.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentDTO {

	private Long studentId;
	private String studentName;
	private String sex;
	private String loginName;
	private String password;
	private String isRegistered;
	private String email;
	private int age;
}
