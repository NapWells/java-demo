package com.liu.beans;

public class HelloChinaBean {
	private String message = "m";
	private String message2 = "m2";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	
	public void init(){
		System.out.println("init HelloWorldBean!");
	}
	
	public void destroy(){
		System.out.println("destroy HelloWorldBean!");
	}
}
