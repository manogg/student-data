package com.mlv.springboot.student.data.repository;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.mlv.springboot.student.data.entity.StudentInformation;
import com.mlv.springboot.student.data.entity.StudentMarks;

@Repository
public class StudentRepository {

	public static List<StudentInformation> studentDatabase() {

		StudentInformation Mano = new StudentInformation(1, "Manog", 28, List.of(100, 90, 80, 70, 50));

		// StudentInformation Rajini = new StudentInformation(2, "Rajini", 30, (new
		// StudentMarks(100, 80, 90, 70, 50)));

		return Stream.of(Mano).collect(Collectors.toList());

	}

	// Retrieve all the students

	public List<StudentInformation> getAllStudents() {

		return studentDatabase().stream().collect(Collectors.toList());
	}

	// Retrieve a students

	public Stream<StudentInformation> getStudentByName(String name) {

		return studentDatabase().stream().filter(predicate -> predicate.getStudentName().equals(name));

	}

	// students count
	public long getStudentCount() {

		return studentDatabase().stream().count();

	}

	// Get list of students marks

	public List<List<Integer>> getStudentsSummary() {

		List<List<Integer>> marks = studentDatabase().stream().map(stu -> stu.getStudentMarks())
				.collect(Collectors.toList());

		return marks;

	}

	public Map<StudentInformation, Long> getStudentsSummary2() {

		Map<StudentInformation, Long> groupby = studentDatabase().stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return groupby;
	}

	public IntSummaryStatistics summaryStatistics() {

		IntSummaryStatistics sum = studentDatabase().stream().flatMap(stu -> stu.getStudentMarks().stream())
				.collect(Collectors.summarizingInt(s -> s));

		IntSummaryStatistics sum2 = studentDatabase().stream().filter(p -> p.getStudentName().equals("Mano"))
				.flatMap(stu -> stu.getStudentMarks().stream()).collect(Collectors.summarizingInt(s -> s));

		return sum;

	}

	public long summaryStatistics2() {

		IntSummaryStatistics sum = studentDatabase().stream().flatMap(stu -> stu.getStudentMarks().stream())
				.collect(Collectors.summarizingInt(s -> s));

		long percentage = sum.getSum() / 5;

		return percentage;

	}

	public IntSummaryStatistics summaryStatistics3(String name) {

		IntSummaryStatistics sum2 = studentDatabase().stream().filter(p -> p.getStudentName().equals("Mano"))
				.flatMap(stu -> stu.getStudentMarks().stream()).collect(Collectors.summarizingInt(s -> s));

		return sum2;

	}

}
