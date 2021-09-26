package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

	@Id
	@SequenceGenerator(name = "course_Sequence", allocationSize = 1, sequenceName = "course_Sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_Sequence")
	private long courseId;
	private String title;
	private Integer credit;

	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
	private Teacher teacher;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_map", 
				joinColumns = @JoinColumn(referencedColumnName = "courseId", name = "course_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "studentId"))
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students ==null)
			students = new ArrayList<>();
		students.add(student);
			
	}
}
