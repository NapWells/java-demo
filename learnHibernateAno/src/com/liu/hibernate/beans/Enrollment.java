package com.liu.hibernate.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "enrollment")
@Entity
public class Enrollment {
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "course_impl_id")
	private CourseImpl courseImpl;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@OneToMany
	@JoinColumn(name = "enrollment_id")
	private Set<Evaluation> evaluations;
	
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseImpl getCourseImpl() {
		return courseImpl;
	}

	public void setCourseImpl(CourseImpl courseImpl) {
		this.courseImpl = courseImpl;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}



	
	
}
