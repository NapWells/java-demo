package com.liu.hibernate.beans;


public class Major {
	private int id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	private int collegeId;

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

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", collegeId="
				+ collegeId + "]";
	}

	
}
