package com.library.bootjpa.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.library.bootjpa.entity.Address;
@Entity
@Table(name = "Student_REG")
@Component
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stid;
	@Column(name="STUDENT_NAME")
	private String stname;
	@Column(name="STUDENT_PHONE")
	private Long stphone;
	@Column(name="STUDENT_EMAIL")
	private String stemail;
	@Column(name="STUDENT_BRANCH")
	private String stbranch;
	@Column(name="STUDENT_SEMESTER")
	private int stsem;
	@Column(name="STUDENT_PASSWORD")
	private String stpassword;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Long getStid() {
		return stid;
	}
	public void setStid(Long stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public Long getStphone() {
		return stphone;
	}
	public void setStphone(Long stphone) {
		this.stphone = stphone;
	}
	public String getStemail() {
		return stemail;
	}
	public void setStemail(String stemail) {
		this.stemail = stemail;
	}
	public String getStbranch() {
		return stbranch;
	}
	public void setStbranch(String stbranch) {
		this.stbranch = stbranch;
	}
	public int getStsem() {
		return stsem;
	}
	public void setStsem(int stsem) {
		this.stsem = stsem;
	}
	public String getStpassword() {
		return stpassword;
	}
	public void setStpassword(String stpassword) {
		this.stpassword = stpassword;
	}
}
