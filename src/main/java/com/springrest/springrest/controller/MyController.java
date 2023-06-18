package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Students;
import com.springrest.springrest.services.StudentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	//get the student
	@GetMapping("/students")
	public List<Students> getStudents(){
		
		//to call the method of getstudent of interface but as it 
		//has no body it will call its parent class
		return this.studentService.getStudents();
		
	}
	
	//get single student
	@GetMapping("/students/{studentId}")
	public Students getStudent(@PathVariable String studentId ) {
		return this.studentService.getStudent(Long.parseLong(studentId));
	}
	
	//add single student
	@PostMapping("/students")
	public Students addStudent(@RequestBody Students student) {
		
		return this.studentService.addStudent(student);
	}
	
	//update the course
	@PutMapping("/students")
	public Students updateStudent(@RequestBody Students student) {
		return this.studentService.updateStudents(student);
	}
	
	//delete the course
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId){
		try {
			this.studentService.deleteStudent(Long.parseLong(studentId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
