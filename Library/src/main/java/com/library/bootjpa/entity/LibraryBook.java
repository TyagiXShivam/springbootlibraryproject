package com.library.bootjpa.entity;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "LibraryBook_REG")
@Component
public class LibraryBook{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOK_ID")
	private Long bookId;
	@Column(name="BOOK_NAME")
	private String bookname;
	@Column(name="BOOK_TYPE")
	private String booktype;
	@Column(name="QUANTITY")
	private int quantity;
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}