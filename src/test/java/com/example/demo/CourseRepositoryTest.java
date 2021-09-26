package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void printAllCourses() {
		List<Course> course = courseRepository.findAll();
		System.out.println("Courses :" + course);
	}

	//@Test
	public void savecoursewithTeacher() {
		Teacher teacher = Teacher.builder().firstName("priyanka").lastName("deshpande").build();
		Course course = Course.builder().title("kafka").credit(6).teacher(teacher).build();

		courseRepository.save(course);
	}

	@Test
	public void findAllPagination() {
		Pageable pagewith3 = PageRequest.of(0, 3);
		Pageable pagewith2 = PageRequest.of(0, 2);

		List<Course> courses = courseRepository.findAll(pagewith3).getContent();

		Long TotalElements = courseRepository.findAll(pagewith2).getTotalElements();

		int TotalPages = courseRepository.findAll(pagewith3).getTotalPages();

		System.out.println("Course with pagination: " + courses);
		
		System.out.println("Course with Total Element: " + TotalElements);
		System.out.println("Course with Total Pages : " + TotalPages);
	}

	@Test
	public void findAllwithSort() {
		Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title").ascending());
		Pageable sortByCredit = PageRequest.of(0, 3, Sort.by("credit").descending());
		Pageable sortByCreditandTitle = PageRequest.of(0, 3,
				Sort.by("title").descending().and(Sort.by("credit").ascending()));

		List<Course> courseT = courseRepository.findAll(sortByTitle).getContent();
		List<Course> courseC = courseRepository.findAll(sortByCredit).getContent();
		List<Course> courseTC = courseRepository.findAll(sortByCreditandTitle).getContent();

		System.out.println("Courses sort by title :" + courseT);
		System.out.println("Courses sort by Credit :" + courseC);
		System.out.println("Courses sort by title &  credit :" + courseTC);

	}
	
	@Test
	public void findByTitlebyContaining() {
		Pageable firstTenRecords = PageRequest.of(0, 10);
		
		List<Course> course = courseRepository.findByTitleContaining("D", firstTenRecords).getContent();
		
		System.out.println("Course with custom Page/sort: "+course);
	}
}
