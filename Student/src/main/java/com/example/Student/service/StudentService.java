package com.example.Student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.domain.Student;
import com.example.Student.repository.StudentRepository;

@Service
public class StudentService {

	protected StudentService() {
		System.out.println("\nCalling Service Class....\n");
	}
	@Autowired
    private StudentRepository repo;
   
	public List<Student> listAll() {
        return repo.findAll();
    }
	
	public List<Student> listByOwner(String owner){
		return repo.findByOwner(owner);
	}
     
    public void save(Student std) {
        repo.save(std);
    }
     
    public Student get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
