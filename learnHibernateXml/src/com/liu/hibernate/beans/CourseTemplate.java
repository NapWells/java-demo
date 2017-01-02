package com.liu.hibernate.beans;

import java.sql.Date;

public class CourseTemplate {
	private int id;
	
	private int credit;
	
	private Date createDatetime;
	
	private int courseId;
	
	private int majorId;
	
	private int academyYearId;
	
	private int courseTemplateTypeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getAcademyYearId() {
		return academyYearId;
	}

	public void setAcademyYearId(int academyYearId) {
		this.academyYearId = academyYearId;
	}

	public int getCourseTemplateTypeId() {
		return courseTemplateTypeId;
	}

	public void setCourseTemplateTypeId(int courseTemplateTypeId) {
		this.courseTemplateTypeId = courseTemplateTypeId;
	}

	@Override
	public String toString() {
		return "CourseTemplate [id=" + id + ", credit=" + credit + ", createDatetime=" + createDatetime + ", courseId="
				+ courseId + ", majorId=" + majorId + ", academyYearId=" + academyYearId + ", courseTemplateTypeId="
				+ courseTemplateTypeId + "]";
	}
	
	
}
