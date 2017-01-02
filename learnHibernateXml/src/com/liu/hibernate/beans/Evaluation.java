package com.liu.hibernate.beans;

import java.sql.Date;


public class Evaluation {
	private int id;
	
	private Date createDatetime;
	
	private int score;
	
	private int enrollmentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", createDatetime=" + createDatetime + ", score=" + score + ", enrollmentId="
				+ enrollmentId + "]";
	}
	
	
}



