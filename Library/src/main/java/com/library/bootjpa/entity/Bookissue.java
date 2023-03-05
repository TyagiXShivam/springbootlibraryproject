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
@Table(name = "Book_issue")
@Component
public class Bookissue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ISSUE_ID")
	private Long issueId; 
	@Column(name="BOOK_ID")
	private Long bookId;
	@Column(name="STUDENT_ID")
	private Long stId;
	@Column(name="ISSUING_DATE")
	private String issueDate;
	@Column(name="RETURNING_DATE")
	private String returnDate;
	@Column(name="RETURN_STATUS")
	private String returnStatus;
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getStId() {
		return stId;
	}
	public void setStId(Long id) {
		this.stId = id;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
}
