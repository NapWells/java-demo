package com.liu.hibernate.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Registeration> registerations;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private StudentLogin login;
	
	
	@ManyToOne
	@JoinColumn(name = "student_status_id")
	private StudentStatus status;
	
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Enrollment> enrollments;
	
	@ManyToMany
	@JoinTable(name = "teacher_has_student",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private Set<Teacher> teachers;
	
	@OneToMany
	@JoinColumn(name = "student_id")
	private Set<Accommodation> accommodations;
	
	
	public Set<Accommodation> getAccommodations() {
		return accommodations;
	}
	public void setAccommodations(Set<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	
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
	public Set<Registeration> getRegisterations() {
		return registerations;
	}
	public void setRegisterations(Set<Registeration> registerations) {
		this.registerations = registerations;
	}
	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sid=" + sid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
