package com.liu.hibernate.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "academy_year")
@Entity
public class AcademyYear {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	@OneToMany
	@JoinColumn(name = "academy_year_id")
	private Set<Registeration> registerations;
	
	@OneToMany
	@JoinColumn(name = "academy_year_id")
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

	@Override
	public String toString() {
		return "AcademyYear [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
