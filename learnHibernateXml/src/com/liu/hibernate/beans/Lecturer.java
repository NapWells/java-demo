package com.liu.hibernate.beans;


public class Lecturer {
	private int id;
	
	private String uid;
	
	private String firstname;
	
	private String lastname;
	
	private String phone;
	
	private int collegeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	@Override
	public String toString() {
		return "Lecturer [id=" + id + ", uid=" + uid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phone=" + phone + ", collegeId=" + collegeId + "]";
	}
	
}
