package com.library.bootjpa.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.bootjpa.entity.LibraryBook;
import com.library.bootjpa.entity.Student;
import com.library.bootjpa.service.StudentService;
@Component
@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	public String insertStudentRecord(Student st)
	{
		studentService.addStudent(st);
		return "One Student Record Registered";
	}
	public String getStudentLoginPassword(Long id)
	{
		return studentService.selectStudentById(id);
	}
	//----------------------------------------------
	@RequestMapping(value = "/add", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student createStudent(@RequestBody Student s) {
		return studentService.addStudents(s);
	}
	@RequestMapping(value = "/display", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	@RequestMapping(value = "/remove/{stid}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteStudent(@PathVariable("stid") Long id) {
		studentService.deleteStudent(id);
	}
}
