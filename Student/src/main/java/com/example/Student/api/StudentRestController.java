package com.example.Student.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Exception.RecordNotFound;
import com.example.Student.domain.Student;
import com.example.Student.repository.StudentRepository;
import com.example.Student.service.StudentService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping(value = "api/student/")
public class StudentRestController {
	@Autowired
	private StudentService service;

	/*@GetMapping(value = "/")
	public List<Student> getStudents() {
		List<Student> studentList = service.listAll();
		return studentList;
	}*/
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/{owner}")
	public List<Student> getStudents(@PathVariable("owner")String owner) {
		List<Student> studentList;
		if(owner.equals("admin")) {
			studentList = service.listAll();
		}
		else {
			studentList = service.listByOwner(owner); 
		}
		return studentList;
	}
		
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/create")
	public ResponseEntity<String> createStudents(@RequestBody Student std) {
		service.save(std);
		System.out.println("\tCREATE=====================  " + std);

		ResponseEntity<String> res = new ResponseEntity<>("Record Inserted Successfully", HttpStatus.OK);
		return res;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/fetch/{id}")  
	public Student getStudentById(@PathVariable("id")long id){  
		Student s = service.get(id);
		return s;  
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<String> updateStudents(@PathVariable(value = "id") long id, @RequestBody Student std)  {
		std.setId(id);
		
		System.out.print("\n\t ===  Student Data : " + std);
		service.save(std);

		ResponseEntity<String> res = new ResponseEntity<>("Record Updated of ID " + id, HttpStatus.OK);
		return res;
	}  
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteStudents(@PathVariable(value="id")long id){
		service.delete(id);

		ResponseEntity<String> res = new ResponseEntity<>("Record Deleted of ID " + id, HttpStatus.OK);
		return res;
	}
	
}
