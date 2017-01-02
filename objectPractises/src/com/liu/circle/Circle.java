package com.liu.circle;

public class Circle {
	private double radius = 1;
	private String color = "red";
	
	public Circle(){}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public Circle(double r,String color){
		radius = r;
		this.color = color;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double getradius(){
		return radius;
	}

	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return color;
	}

	public double getArea(){
		return Math.PI*radius*radius;
	}
	
	public double getCircumference(){
		return Math.PI*2*radius;
	}
	public String toString(){
		return "Circle[radius="+radius+",color="+color+"]";
	}
}
