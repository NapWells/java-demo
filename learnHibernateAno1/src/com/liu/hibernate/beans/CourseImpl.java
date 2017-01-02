package com.liu.hibernate.beans;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "course_impl")
@Entity
public class CourseImpl {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "capacity")
	private int  capacity;
	
	@Column(name = "remain")
	private int remain;
	
	@Column(name = "create_datetime")
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "course_template_id")
	private CourseTemplate courseTemplate;
	
	@ManyToOne
	@JoinColumn(name = "lecture_id")
	private Lecturer lecturer;
	
	@OneToMany
	@JoinColumn(name = "course_impl_id")
	private Set<Enrollment> enrollments;

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public CourseTemplate getCourseTemplate() {
		return courseTemplate;
	}

	public void setCourseTemplate(CourseTemplate courseTemplate) {
		this.courseTemplate = courseTemplate;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	
	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
