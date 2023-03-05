package com.library.bootjpa;
public class BookNotFoundException extends Exception{
	public BookNotFoundException() {
		System.out.println("Book doesn't exist");
	}
}
