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

@Table(name = "course_template")
@Entity
public class CourseTemplate {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "credit")
	private int credit;
	
	@Column(name = "create_datetime")
	private Date createDatetime;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "major_id")
	private Major major;
	
	@ManyToOne
	@JoinColumn(name = "academy_year_id")
	private AcademyYear academyYear;
	
	@ManyToOne
	@JoinColumn(name = "course_template_type_id")
	private CourseTemplateType courseTemplateType;
	
	@OneToMany
	@JoinColumn(name = "course_template_id")
	private Set<CourseTemplateType> courseTemplateTypes;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public AcademyYear getAcademyYear() {
		return academyYear;
	}

	public void setAcademyYear(AcademyYear academyYear) {
		this.academyYear = academyYear;
	}

	public CourseTemplateType getCourseTemplateType() {
		return courseTemplateType;
	}

	public void setCourseTemplateType(CourseTemplateType courseTemplateType) {
		this.courseTemplateType = courseTemplateType;
	}

	public Set<CourseTemplateType> getCourseTemplateTypes() {
		return courseTemplateTypes;
	}

	public void setCourseTemplateTypes(Set<CourseTemplateType> courseTemplateTypes) {
		this.courseTemplateTypes = courseTemplateTypes;
	}

	
	
	
}
