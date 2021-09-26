package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		Course course = Course.builder().title("DSA").credit(10).build();
		Course courseJava = Course.builder().title("JAVA").credit(10).build();
		Teacher teacher = Teacher.builder().firstName("usain").lastName("bolt")
				//.courses(List.of(course,courseJava))
				.build();
		teacherRepository.save(teacher);
	}
	
	@Test
	public void printTeacher() {
		List<Teacher> teacher = teacherRepository.findAll();
		System.out.println("Teacher :" + teacher);
	}
}
