package com.liu.hibernate.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "accommodation")
@Entity
public class Accommodation {
	@Id
	@Column(name = "id" )
	private int id;
	
	@Column(name = "create_datetime")
	private Date createDateTime;
	
	@Column(name = "expired_datetime")
	private Date expiredDatetime;
	
	@ManyToOne
	@JoinColumn(name = "apartment_id")
	private  Apartment apartment;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getExpiredDatetime() {
		return expiredDatetime;
	}

	public void setExpiredDatetime(Date expiredDatetime) {
		this.expiredDatetime = expiredDatetime;
	}

	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", createDateTime=" + createDateTime + ", expiredDatetime=" + expiredDatetime
				 + "]";
	}
	
	

}
