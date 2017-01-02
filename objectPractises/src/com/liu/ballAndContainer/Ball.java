package com.liu.ballAndContainer;

public class Ball {
	private float x;
	private float y;
	private int radius;
	private float xDelat;
	private float yDelat;
	public Ball(float x, float y, int radius,int speed, int direction) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		xDelat = (float) (speed*Math.cos(direction));
		yDelat = (float) (speed*Math.sin(direction));
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public float getxDelat() {
		return xDelat;
	}
	public void setxDelat(float xDelat) {
		this.xDelat = xDelat;
	}
	public float getyDelat() {
		return yDelat;
	}
	public void setyDelat(float yDelat) {
		this.yDelat = yDelat;
	}
	public void move(){
		x += xDelat;
		y += yDelat;
	}
	public void reflectHorizontal(){
		xDelat = -xDelat;
	}
	public void reflectVertical(){
		yDelat = - yDelat;
	}
	public String toString(){
		return "球在("+x+","+y+"),速度是"+xDelat+","+yDelat+"";
	}
}