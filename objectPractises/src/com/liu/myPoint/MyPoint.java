package com.liu.myPoint;

public class MyPoint {
	private int x;
	private int y;
	public MyPoint() {}
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int[] getXY(){
		int[] result = {x,y};
		return result;
	}
	
	public double distance(int x,int y){
		return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
	}
	public double distance(MyPoint another){
		return Math.sqrt((this.x-another.getX())*(this.x-another.getX())+(this.y-another.getY())*(this.y-another.getY()));
	}
	public double distance(){
		return Math.sqrt(x*x+y*y);
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	
}
