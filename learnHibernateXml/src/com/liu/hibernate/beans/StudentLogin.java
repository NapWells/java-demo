package com.liu.hibernate.beans;

public class StudentLogin {
	private int id;
	
	private String username;
	
	private String password;

	private Student student;
	
	public int getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentLogin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
