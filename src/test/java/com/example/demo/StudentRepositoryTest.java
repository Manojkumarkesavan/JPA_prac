package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("shabbir1@gmail.com").firstName("Shabbir").lastName("Dawoodi")
				// .guardianName("Nikhil")
				// .guardianEmail("nikhil@gmail.com")
				// .guardianMobile("9999999999")
				.build();

		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder().email("guardian@gmail.com").mobile("789451231").name("guardman").build();
		Student stud = Student.builder().emailId("manoj@gmail.com").firstName("manoj").lastName("kumar")
				.guardian(guardian).build();
		studentRepository.save(stud);
	}
	@Test
	public void saveStudentWithGuardian1() {
		Guardian guardian = Guardian.builder().email("guardian1@gmail.com").mobile("123456789").name("guardman1").build();
		Student stud = Student.builder().emailId("kumar@gmail.com").firstName("kumar").lastName("manoj")
				.guardian(guardian).build();
		studentRepository.save(stud);
	}
	@Test
	public void saveStudentWithGuardian2() {
		Guardian guardian = Guardian.builder().email("guardian2@gmail.com").mobile("87514645").name("guardman2").build();
		Student stud = Student.builder().emailId("salo@gmail.com").firstName("salamon").lastName("raj")
				.guardian(guardian).build();
		studentRepository.save(stud);
	}
	@Test
	public void saveStudentWithGuardian3() {
		Guardian guardian = Guardian.builder().email("guardian3@gmail.com").mobile("9416526542").name("guardman3").build();
		Student stud = Student.builder().emailId("bawa@gmail.com").firstName("rajasekar").lastName("bawa")
				.guardian(guardian).build();
		studentRepository.save(stud);
	}
	@Test
	public void saveStudentWithGuardian4() {
		Guardian guardian = Guardian.builder().email("guardian4@gmail.com").mobile("451651651").name("guardman4").build();
		Student stud = Student.builder().emailId("mj@gmail.com").firstName("manoj").lastName("MJ")
				.guardian(guardian).build();
		studentRepository.save(stud);
	}
	@Test
	public void saveStudentWithGuardian5() {
		Guardian guardian = Guardian.builder().email("guardian5@gmail.com").mobile("7165182465").name("guardman5").build();
		Student stud = Student.builder().emailId("joker@gmail.com").firstName("Thanos").lastName("manoj")
				.guardian(guardian).build();
		studentRepository.save(stud);
	}

	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();

		System.out.println("studentList = " + studentList);
	}
	
	@Test
	public void getStudbyID() {
		List<Student> Student = studentRepository.findByFirstName("kumar");
		System.out.println("Student by firrstName " +Student );
	}
	
	@Test
	public void getByEmailId() {
		List<Student> Student=studentRepository.findByEmailId("manoj@gmail.com");
		System.out.println("student BY Emailid : "+Student);
		List<Student> Student1=studentRepository.findByEmailId("kumar@gmail.com");
		System.out.println("student BY Emailid : "+Student1);
	}
	
	@Test
	public void getnamebycontaining() {
		List<Student> Student= studentRepository.findByEmailIdContaining("ma");
		System.out.println("student BY Emailid containing: "+Student);
	}
	
	@Test
	public void getlastnamebynotnull() {
		List<Student> Student= studentRepository.findBylastNameNotNull();
		System.out.println("student BY lastname not null: "+Student);
	}
	
	@Test
	public void getStudentByEmailAddress() {
		Student stud=studentRepository.getStudentByEmailAddress("manoj@gmail.com");
		System.out.println("student by Query annotation : "+stud);
	}
	
	@Test
	public void  getstudentnamefromemail() {
		String firstName= studentRepository.getStudentNameByEmailId("manoj@gmail.com");
		System.out.println("Student firstName : "+firstName);
	}
	
	@Test
	public void  getstudentnameandlastnamefromemail() {
		String firstName= studentRepository.getStudentNameandlastnameByEmailId("manoj@gmail.com");
		System.out.println("Student firstName and last name: "+firstName);
	}
	
	@Test
	public void getFullnamewithEmailIdNativeQuery() {
		String fullName = studentRepository.getfullnamefromemailNativeQuery("manoj@gmail.com");
		System.out.println("Studen FullName using native query: "+ fullName);
	}
	
	@Test
	public void getFullnamewithEmailIdNativeParam() {
		String fullName = studentRepository.getfullnamefromemailnamedParam("manoj@gmail.com");
		System.out.println("Studen FullName using named param: "+ fullName);
	}
	
	@Test
	public void updateFirstnamebyemail() {
		studentRepository.updateStudentNamebyEmail("Manoj__MJ", "manoj@gmail.com");
	}
}
