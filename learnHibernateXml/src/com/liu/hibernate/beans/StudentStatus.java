package com.liu.hibernate.beans;

import java.util.Set;

public class StudentStatus {
	private int id;
	
	private String code;
	
	private String name;
	
	private String description;

	private Set<Student> students;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "StudentStatus2 [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
	}
	
}
