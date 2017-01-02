package com.liu.hibernate.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "student")
@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "sid")
	private int sid;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
//	@OneToMany
//	@JoinColumn(name = "student_id")
//	private Set<Registeration> registerations;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private StudentLogin login;
	
//	@ManyToOne
//	@JoinColumn(name = "student_id")
//	private Accommodation accommodation;
	
	@ManyToOne
	@JoinColumn(name = "student_status_id")
	private StudentStatus status;
	
//	
//	@OneToMany
//	@JoinColumn(name = "student_id")
//	private Set<Enrollment> enrollments;
	
	@ManyToMany
	@JoinTable(name = "teacher_has_student",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private Set<Teacher> teachers;
	

//	public Accommodation getAccommodation() {
//		return accommodation;
//	}
//	public void setAccommodation(Accommodation accommodation) {
//		this.accommodation = accommodation;
//	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public StudentStatus getStatus() {
		return status;
	}
	public void setStatus(StudentStatus status) {
		this.status = status;
	}
	public StudentLogin getLogin() {
		return login;
	}
	public void setLogin(StudentLogin login) {
		this.login = login;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sid=" + sid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
