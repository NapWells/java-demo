package register;

public class Info implements java.io.Serializable{
	private String username;
	private String passwd;
	private String sex;
	private String age;
	private String degree;
	private String hobby[];
	
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	
	public void setPassword(String passwd){
		this.passwd = passwd;
	}
	public String getPassword(){
		return passwd;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return sex;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	public String getAge(){
		return age;
	}
	
	public void setDegree(String degree){
		this.degree = degree;
	}
	public String getDegree(){
		return degree;
	}
	
	public void setHobby(String hobby[]){
		this.hobby = hobby;
	}
	public String []getHobby(){
		return hobby;
	}
}
