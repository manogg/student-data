package com.mlv.springboot.student.data.service;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlv.springboot.student.data.entity.StudentInformation;
import com.mlv.springboot.student.data.entity.StudentMarks;
import com.mlv.springboot.student.data.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// Retrieve all the students

	public List<StudentInformation> getAllStudents() {

		return studentRepository.getAllStudents();
	}

	// Retrieve s students

	public Stream<StudentInformation> getStudentByName(String name) {

		return studentRepository.getStudentByName(name);
	}

	// students count
	public long getStudentCount() {

		return studentRepository.getStudentCount();

	}

	public List<List<Integer>> getStudentsSummary() {

		return studentRepository.getStudentsSummary();

	}

	public Map<StudentInformation, Long> getStudentsSummary2() {

		return studentRepository.getStudentsSummary2();
	}

	public IntSummaryStatistics summaryStatistics() {

		return studentRepository.summaryStatistics();
	}

	public IntSummaryStatistics summaryStatistics3(String name) {

		return studentRepository.summaryStatistics3(name);
	}

}
