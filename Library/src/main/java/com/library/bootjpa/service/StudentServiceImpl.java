package com.library.bootjpa.service;
import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.bootjpa.entity.Student;
import com.library.bootjpa.repository.StudentRepository;
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void addStudent(Student st) {
		studentRepository.save(st);
	}
	@Override
	public String selectStudentById(Long sid) {
		String pwd=studentRepository.selectStudentById(sid);
		return pwd;
	}
	//-------------------------------------------------------
	@Override
	public Student addStudents(Student b) {
		return studentRepository.save(b);
	}
	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);
	}
}

