package com.liu.hibernate.beans;

import java.sql.Date;


public class Accommodation {
	private int id;
	
	private Date createDateTime;
	
	private Date expiredDatetime;
	
	private int apartmentId;
	
	private int studentId;

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

	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", createDateTime=" + createDateTime + ", expiredDatetime=" + expiredDatetime
				+ ", apartmentId=" + apartmentId + ", studentId=" + studentId + "]";
	}
	
	

}
