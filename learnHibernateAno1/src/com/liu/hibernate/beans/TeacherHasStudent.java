package com.liu.hibernate.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "teacher_has_student")
@Entity
public class TeacherHasStudent implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "student_id")
	private int studentId;
	
	@Id
	@Column(name = "teacher_id")
	private int teacherId;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
}
