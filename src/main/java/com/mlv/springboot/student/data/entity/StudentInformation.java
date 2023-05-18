package com.mlv.springboot.student.data.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInformation {

	private Integer studentRollNumber;
	private String studentName;
	private Integer studentAge;
	private List<Integer> studentMarks;

}
