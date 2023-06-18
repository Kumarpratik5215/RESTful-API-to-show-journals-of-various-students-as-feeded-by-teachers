package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Students;

@Service
public class StudentServiceImpl implements StudentService {

	
	List<Students> list;
	
	public StudentServiceImpl() {
		list = new ArrayList<>();
		list.add(new Students(5215,"Kumar Pratik","He is great Java Developer"));
		list.add(new Students(5209,"Aditya","He is great Backend Developer"));
	}
	@Override
	public List<Students> getStudents() {
		
		return list;
	}
	@Override
	public Students getStudent(long studentId) {
		 
		Students s = null;
		for(Students student:list) {
			if(student.getId()==studentId) {
				s=student;
				break;
			}
		}
		return s;
	}
	@Override
	public Students addStudent(Students student) {
		
		list.add(student);
		return student;
	}
	@Override
	public Students updateStudents(Students student) {
		list.forEach(e -> {
			if(e.getId()==student.getId()) {
				e.setName(student.getName());
				e.setDescroption(student.getDescription());
			}
		});
		return student;
	}
	@Override
	public void deleteStudent(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}
	

}
