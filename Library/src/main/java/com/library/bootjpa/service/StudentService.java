package com.library.bootjpa.service;
import java.util.List;
import com.library.bootjpa.entity.Student;
public interface StudentService {
	public void addStudent(Student st);
	public String selectStudentById(Long sid);
	//---------------------------------------
	public Student addStudents(Student b);
	public List <Student> getStudents();
	public void deleteStudent(Long id);
}
