package jspJavaBean;

public class studentInfo implements java.io.Serializable {
	private String stuId;
	private String stuName;
	private String course;
	private String grade;
	public studentInfo(){};
	
	public String getStuId(){
		return stuId;
	}
	
	public void setStuId(String stuId){
		this.stuId=stuId;
	}
	
	public String getStuName(){
		return stuName;
	}
	
	public void setStuName(String stuName){
		this.stuName=stuName;
	}
	
	public String getCourse(){
		return course;
	}
	
	public void setCourse(String course){
		this.course=course;
	}
	
	public String getGrade(){
		return grade;
	}
	
	public void setGrade(String grade){
		this.grade=grade;
	}
	
}
