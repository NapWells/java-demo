package com.liu.hibernate.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "evaluation")
@Entity
public class Evaluation {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "create_datetime")
	private Date createDatetime;
	
	@Column(name = "score")
	private int score;
	
	@ManyToOne
	private Enrollment enrollment;

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

	public Enrollment getEnrollent() {
		return enrollment;
	}

	public void setEnrollent(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	
	
}



