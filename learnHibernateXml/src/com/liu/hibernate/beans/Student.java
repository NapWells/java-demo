package com.liu.hibernate.beans;

import java.sql.Date;

public class Student {
	private int id;
	private int sid;
	private String firstname;
	private String lastname;
	private String gender;
	private String phone;
	private String email;
	private Date dateOfBirth;
	private StudentLogin login;
	private StudentStatus status;
	public StudentStatus getStatus() {
		return status;
	}
	public void setStatus(StudentStatus status) {
		this.status = status;
	}
	public StudentLogin getLogin() {
		return login;
	}
	public void setLogin(StudentLogin login) {
		this.login = login;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sid=" + sid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
