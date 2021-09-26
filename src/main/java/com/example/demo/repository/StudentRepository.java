package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

	List<Student> findByFirstName(String string);

	List<Student> findByEmailId(String string);

	List<Student> findByEmailIdContaining(String string);

	List<Student> findBylastNameNotNull();
	
	//Query
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String email);
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentNameByEmailId(String email);
	
	@Query("select s.firstName,s.lastName,s.studentId from Student s where s.emailId = ?1")
	String getStudentNameandlastnameByEmailId(String email);
	
	//Native Query
	@Query(nativeQuery = true,value = "select CONCAT(first_name,' ',last_name) as fullName from tbl_student where email_address = ?1")
	String getfullnamefromemailNativeQuery(String email);
	
	//Native Query Params
	@Query(nativeQuery = true,value = "select CONCAT(first_name,' ',last_name) as fullName from tbl_student where email_address = :email_Id")
	String getfullnamefromemailnamedParam(@Param(value = "email_Id") String email);
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?1 where email_address = ?2",nativeQuery = true)
	int updateStudentNamebyEmail(String name,String Email);
}
