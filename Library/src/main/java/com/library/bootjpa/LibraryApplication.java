package com.library.bootjpa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.library.bootjpa.controller.BookissueController;
import com.library.bootjpa.controller.LibraryBookController;
import com.library.bootjpa.controller.StudentController;
import com.library.bootjpa.entity.Bookissue;
import com.library.bootjpa.entity.LibraryBook;
import com.library.bootjpa.entity.Student;
@ComponentScan(basePackages = "com.*")
@EntityScan("com.library.bootjpa.entity")
@SpringBootApplication
public class LibraryApplication {
	public static void main(String[] args)  {
		ApplicationContext ctx=SpringApplication.run(LibraryApplication.class, args);
		Scanner sc=new Scanner(System.in);
		System.out.println("LIBRARY SYSTEM");
		System.out.println("--------------");
		char c;
		do
		{
			try {
				System.out.println("1.Admin");
				System.out.println("2.Student");
				System.out.println("Please Select Option:");
				int opt=sc.nextInt();
				if(opt==1) {
					System.out.println("Admin ID:");
					String id=sc.next();
					System.out.println("Admin Password:");
					String pwd=sc.next();
					if(id.equals("admin")&&pwd.equals("admin")) {
						char ch;
						LibraryBookController bookctrl=ctx.getBean(LibraryBookController.class);
						do { 
							try {
								System.out.println("1.Book Registration");
								System.out.println("2.Admin Logout");
								System.out.println("Please select an option:");
								int opt1=sc.nextInt();
								if (opt1==1){
									char c1;
									do {
										LibraryBook l1=InputData.getBookDetails(sc);
										bookctrl.insertLibraryBook(l1);
										System.out.println("Do you want to continue book registration?");
										c1=sc.next().charAt(0);
									}while(c1=='y'||c1=='Y');
								}
								else if(opt1==2){
									break;	
								}
								else {
									System.out.println("Invalid option");
									System.out.println("Select an option either 1 or 2");
								}
							}catch(InputMismatchException e){
								System.out.println("Invalid Input");
								System.out.println("Select either 1 or 2");
								sc.next();
							}
							System.out.println("Do you want to continue as admin?");
							ch=sc.next().charAt(0);
						}while(ch=='y'||ch=='Y');
					}
					else {
						System.out.println("Invalid admin details");
					}
				}
				else if(opt==2){
					char ca;
					StudentController studentctrl=ctx.getBean(StudentController.class);
					do {
						try {
							System.out.println("1.Student Registration");
							System.out.println("2.Student Login");
							System.out.println("3.Student Logout");
							System.out.println("Please Select Option:");
							int opt2=sc.nextInt();
							if(opt2==1) {
								char c2;
								do {
									Student st=InputData.getStudentDetails(sc);
									studentctrl.insertStudentRecord(st);
									System.out.println("Do you want to continue student registration?");
									sc.nextLine();
									c2=sc.next().charAt(0);
								}while(c2=='y'||c2=='Y');
							}
							else if(opt2==2) {
								char c6;
								do {
									ArrayList studentDetails=InputData.loginStudent(sc);
									String originalpwd=studentctrl.getStudentLoginPassword((Long)studentDetails.get(0));
									if(originalpwd==null) {
										try {
											throw new StudentNotFoundException();
										} catch (StudentNotFoundException e) {
										}
									}
									else {
										if(originalpwd.equals((String)studentDetails.get(1))) {
											char c5;
											BookissueController bookissuectrl=ctx.getBean(BookissueController.class);
											do {
												try {
													System.out.println("1 Issue book");
													System.out.println("2 Return book");
													System.out.println("Please Select Option:");
													int opt3=sc.nextInt();
													if(opt3==1) {
														char c3;
														do {
															LibraryBookController librarybookcntrl=ctx.getBean(LibraryBookController.class);
															librarybookcntrl.fetchAllLibraryBooks();
															Bookissue b=InputData.getIssuedBookDetails(sc);
															Long originalbookid=librarybookcntrl.getBookId(b.getBookId());
															if(originalbookid==null) {
																try {
																	throw new BookNotFoundException();
																} catch(BookNotFoundException e) {
																}
															}
															else {
																bookissuectrl.issueLibraryBook(b);
																System.out.println("Book Issued Successfully");
																System.out.println("Happy Learning!");
																librarybookcntrl.updateLibraryBook(b.getBookId());
															}
															System.out.println("Do you want to issue another book?");
															c3=sc.next().charAt(0);												
														}while(c3=='y'||c3=='Y');
													}
													else if (opt3==2) {
														char c1;
														do {
															Bookissue b1=InputData.returnStatus(sc);
															Long originalbookid=bookissuectrl.getBookId1(b1.getBookId());
															Long originalissueid=bookissuectrl.getIssueId(b1.getIssueId());
															if(originalbookid==null||originalissueid==null) {
																try {
																	throw new IssuedBookNotFoundException();
																} catch(IssuedBookNotFoundException e) {
																}
															}
															else {
																if(originalbookid==InputData.dummyBookId) {
																String returnStatus=bookissuectrl.getReturnStatus(b1.getIssueId(), b1.getBookId());
																if(returnStatus.equals("yes")) {
																	System.out.println("Book already returned");
																}
																else {
																	System.out.println("Book Returned Successsfully!");
																	bookissuectrl.updateBookissue("yes",b1.getBookId());
																	LibraryBookController s4=ctx.getBean(LibraryBookController.class);
																	s4.updateLibraryBook1(b1.getBookId());
																}
															}
																else {
																	System.out.println("Invalid book id");
																}
															}
															System.out.println("Do you want to return another book");
															c1=sc.next().charAt(0);
														}while(c1=='y'||c1=='Y');
													}
													else {
														System.out.println("Invalid option");
														System.out.println("Select either 1 or 2");
													}
												}
												catch(InputMismatchException e) {
													System.out.println("Invalid input");
													System.out.println("Select either 1 or 2");
												}
												System.out.println("Do you want to continue as a student?");
												sc.nextLine();
												c5=sc.next().charAt(0);
											}while(c5=='y'||c5=='Y');
										}
										else {
											System.out.println("Invalid student password");
										}
									}
									System.out.println("Do you want to continue");

									c6=sc.next().charAt(0);
								}while(c6=='y'||c6=='Y');
							}
							else if(opt2==3)
							{
								break;
							}
							else {
								System.out.println("Invalid option");
								System.out.println("Select either 1, 2 or 3");
							}
						}
						catch(InputMismatchException e) {
							System.out.println("Invalid Input");
							System.out.println("Select either 1,2 or 3 ");
						}
						System.out.println("Do you want to continue logging in as a student?");
						sc.nextLine();
						ca=sc.next().charAt(0);
					}while(ca=='y'||ca=='Y');
				}
				else {
					System.out.println("Invalid Input");
					System.out.println("Select either 1 or 2");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input");
				System.out.println("Select either 1 or 2");
			}
			System.out.println("Do you want to continue logging in library system?");
			sc.nextLine();
			c=sc.next().charAt(0);
		}while(c=='y'||c=='Y');
	}
}