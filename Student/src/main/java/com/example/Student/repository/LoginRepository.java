package com.example.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Student.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

	@Query("from tbl_login where username = :uname")
	Login findByUserName(@Param("uname") String name);
}