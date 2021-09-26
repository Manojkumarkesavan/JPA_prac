package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import com.example.demo.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder().title(".net").credit(10).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("udemy.com")
				.course(course)
				.build();
		courseMaterialRepository.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
		System.out.println("Course Material :" +courseMaterial);
	}
}
