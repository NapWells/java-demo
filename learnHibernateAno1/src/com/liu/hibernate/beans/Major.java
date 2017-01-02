package com.liu.hibernate.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Major")
@Entity
public class Major {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "college_id")
	private College college;
	
	@OneToMany
	@JoinColumn(name = "major_id")
	private Set<Registeration> registerations;
	
	@OneToMany
	@JoinColumn(name = "major_id")
	private Set<CourseTemplate> courseTemplates;

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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Set<Registeration> getRegisterations() {
		return registerations;
	}

	public void setRegisterations(Set<Registeration> registerations) {
		this.registerations = registerations;
	}

	public Set<CourseTemplate> getCourseTemplates() {
		return courseTemplates;
	}

	public void setCourseTemplates(Set<CourseTemplate> courseTemplates) {
		this.courseTemplates = courseTemplates;
	}

	
}
