package com.liu.hibernate.beans;

import java.sql.Date;


public class CourseImpl {
	private int id;
	
	private int  capacity;
	
	private int remain;
	
	private Date createDate;
	
	private int courseTemplateId;
	
	private int lectureId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCourseTemplateId() {
		return courseTemplateId;
	}

	public void setCourseTemplateId(int courseTemplateId) {
		this.courseTemplateId = courseTemplateId;
	}

	public int getLectureId() {
		return lectureId;
	}

	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}

	@Override
	public String toString() {
		return "CourseImpl [id=" + id + ", capacity=" + capacity + ", remain=" + remain + ", createDate=" + createDate
				+ ", courseTemplateId=" + courseTemplateId + ", lectureId=" + lectureId + "]";
	}
	
	
}
