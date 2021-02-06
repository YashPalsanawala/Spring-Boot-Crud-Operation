package com.example.Student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Student.domain.Login;
import com.example.Student.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("from tbl_student where owner = :own")
	List<Student> findByOwner(@Param("own") String owner);
	
}
