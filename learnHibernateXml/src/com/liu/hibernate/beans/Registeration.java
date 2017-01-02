package com.liu.hibernate.beans;

import java.sql.Date;

public class Registeration {
	private int id;
	
	private Date createDate;
	
	private int studentId;
	
	private int majorId;
	
	private int academyYearId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getAcademyYearId() {
		return academyYearId;
	}

	public void setAcademyYearId(int academyYearId) {
		this.academyYearId = academyYearId;
	}

	@Override
	public String toString() {
		return "Registeration [id=" + id + ", createDate=" + createDate + ", studentId=" + studentId + ", majorId="
				+ majorId + ", academyYearId=" + academyYearId + "]";
	}
	
	
}
