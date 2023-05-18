package com.mlv.springboot.student.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMarks {

	private Integer tamil;
	private Integer english;
	private Integer maths;
	private Integer science;
	private Integer socialScience;

}
