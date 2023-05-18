package com.mlv.springboot.student.data.controller;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlv.springboot.student.data.entity.StudentInformation;
import com.mlv.springboot.student.data.entity.StudentMarks;
import com.mlv.springboot.student.data.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getAll")
	public List<StudentInformation> getAllStudents() {

		return studentService.getAllStudents();

	}

	@GetMapping("/getByName/{name}")
	public Stream<StudentInformation> getStudentByName(@PathVariable("name") String name) {

		return studentService.getStudentByName(name);
	}

	@GetMapping("/getCount")
	public long getStudentCount() {

		return studentService.getStudentCount();

	}

	@GetMapping("/getMarks")
	public List<List<Integer>> getStudentsSummary() {

		return studentService.getStudentsSummary();

	}

	@GetMapping("/group")
	public Map<StudentInformation, Long> getStudentsSummary2() {

		return studentService.getStudentsSummary2();
	}

	@GetMapping("/summary")
	public IntSummaryStatistics summaryStatistics() {

		return studentService.summaryStatistics();
	}

	@GetMapping("/summary/{name}")
	public IntSummaryStatistics summaryStatistics3(@PathVariable("name") String name) {
		return studentService.summaryStatistics3(name);

	}
}
