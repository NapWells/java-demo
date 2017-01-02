package com.liu.myCircle;

import com.liu.myPoint.MyPoint;

public class MyCircle {
	private MyPoint center = new MyPoint(0,0);
	private int centerX;
	private int centerY;
	private int radius = 1;
	public MyCircle() {}
	public MyCircle(int x,int y,int radius){
		this.centerX = x;
		this.centerY = y;
		this.radius = radius;
	}
	public MyCircle(MyPoint center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	public MyPoint getCenter() {
		if(centerX!=0||centerY!=0)
			center = new MyPoint(centerX,centerY);
		return center;
	}
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public int getCenterY() {
		return centerY;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	public int [] getCenterXY(){
		int [] result = new int[]{centerX,centerY};
		return result;
	}
	public void setCenterXY(int x,int y){
		centerX = x;
		centerY =y;
	}
	@Override
	public String toString() {
		return "MyCircle [center=("  + this.getCenter()+ "), radius=" + radius+ "]";
	}
	
	public double getArea(){
		return Math.PI*radius*radius;
	}
	
	public double getCircumference(){
		return Math.PI*2*radius;
	}
	
	public double distance(MyCircle another){
		return another.getCenter().distance(this.getCenter());
	}
}
