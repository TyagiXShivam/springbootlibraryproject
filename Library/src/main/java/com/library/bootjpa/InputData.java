package com.library.bootjpa;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.library.bootjpa.controller.LibraryBookController;
import com.library.bootjpa.entity.Address;
import com.library.bootjpa.entity.Bookissue;
import com.library.bootjpa.entity.LibraryBook;
import com.library.bootjpa.entity.Student;
public class InputData {
	public static LibraryBook getBookDetails(Scanner sc) {
		LibraryBook l1=null;
		try {
			System.out.println("Enter book name:");
			String bname=sc.next();
			System.out.println("Enter book type:");
			String btype=sc.next();
			System.out.println("Enter quantity:");
			int quantity=sc.nextInt();
			LibraryBook l=new LibraryBook();
			l.setBookname(bname);
			l.setBooktype(btype);
			l.setQuantity(quantity);
			l1=l;
		}
		catch(Exception e) {
			System.out.println("Invalid input");
			System.out.println("Give digits as quantity");
			sc.nextLine();
		}
		return l1;
	}
	public static Student getStudentDetails(Scanner sc) {
		Student st1=null;
		try {
			System.out.println("Enter student name:");
			String name=sc.next();
			System.out.println("Enter student phone:");
			Long phone=sc.nextLong();
			System.out.println("Enter student email:");
			String email=sc.next();
			System.out.println("Enter student branch:");
			String branch=sc.next();
			System.out.println("Enter student sem:");
			int sem=sc.nextInt();
			System.out.println("Enter student password:");
			String pwd=sc.next();
			System.out.println("Enter building");
			String building=sc.next();
			System.out.println("Enter street");
			String street=sc.next();
			System.out.println("Enter city");
			String city=sc.next();
			System.out.println("Enter state");
			String state=sc.next();
			System.out.println("Enter country");
			String country=sc.next();
			System.out.println("Enter zipcode");
			String zipcode=sc.next();
			Address addr=new Address(); 
			addr.setBuilding(building);
			addr.setStreet(street);
			addr.setCity(city);
			addr.setState(state);
			addr.setCountry(country);
			addr.setZipcode(zipcode);
			Student st=new Student();
			st.setStname(name);
			st.setStphone(phone);
			st.setStemail(email);
			st.setStbranch(branch);
			st.setStpassword(pwd);
			st.setStsem(sem);
			st.setAddress(addr);
			st1=st;
			System.out.println("Student registered successfully");
		}
		catch(Exception e) {
			System.out.println("Invalid input");
			System.out.println("Give digits as input");
		}
		return st1;
	}
	static Long dummyStudentId;
	public static ArrayList loginStudent(Scanner sc) {
		System.out.println("Student Id:");
		Long stid=sc.nextLong();
		dummyStudentId=stid;
		System.out.println("Student Password:");
		String spwd=sc.next();
		ArrayList studentDetails=new ArrayList();
		studentDetails.add(stid);//0 index
		studentDetails.add(spwd);//1 index
		return studentDetails;
	}
	public static Bookissue getIssuedBookDetails(Scanner sc) {
		System.out.println("Please enter book id:");
		Long id=sc.nextLong();
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		String strDate=formatter.format(date);
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE,5);
		String returndate=formatter.format(c.getTime());
		Bookissue b=new Bookissue();
		b.setBookId(id);
		b.setIssueDate(strDate);
		b.setReturnDate(returndate);
		b.setStId(dummyStudentId);
		b.setReturnStatus("No");
		return b;
	}
	static Long dummyBookId;
	public static Bookissue returnStatus(Scanner sc) {
		System.out.println("Enter issue id:");
		Long iid=sc.nextLong();
		System.out.println("Enter book id:");
		Long bid=sc.nextLong();
		dummyBookId=bid;
		Bookissue b1=new Bookissue();
		b1.setIssueId(iid);
		b1.setBookId(bid);
		return b1;
	}
}
