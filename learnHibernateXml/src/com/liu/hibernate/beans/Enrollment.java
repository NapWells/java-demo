package com.liu.hibernate.beans;


public class Enrollment {
	private int id;
	
	private int courseImplId;
	
	private int studentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseImplId() {
		return courseImplId;
	}

	public void setCourseImplId(int courseImplId) {
		this.courseImplId = courseImplId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", courseImplId=" + courseImplId + ", studentId=" + studentId + "]";
	}
	
	
}
