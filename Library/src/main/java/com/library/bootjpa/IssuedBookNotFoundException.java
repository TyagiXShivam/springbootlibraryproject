package com.library.bootjpa;
public class IssuedBookNotFoundException extends Exception{
	public IssuedBookNotFoundException() {
		System.out.println("Book doesn't exist");
	}
}
