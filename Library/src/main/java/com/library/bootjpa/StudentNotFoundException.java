package com.library.bootjpa;
public class StudentNotFoundException extends Exception{
	public StudentNotFoundException() {
		System.out.println("Student doesn't exist in the database");
	}
}
