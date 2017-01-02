package com.liu.myTriangle;

import com.liu.myPoint.MyPoint;

public class MyTriangle {
	private MyPoint p1;
	private MyPoint p2;
	private MyPoint p3;
	public MyTriangle(int x1,int y1,int x2,int y2,int x3,int y3){
		p1 =new MyPoint(x1,y1);
		p2 =new MyPoint(x2,y2);
		p3 =new MyPoint(x3,y3);
	}
	public MyTriangle(MyPoint p1, MyPoint p2, MyPoint p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	@Override
	public String toString() {
		return "MyTriangle [v1=(" +p1+ ", v2=" + p2 + ", v3=" + p3 + "]";
	}
	public double getPerimeter(){
		return p1.distance(p2)+p2.distance(p3)+p3.distance(p1);
	}
	
	public String getType(){
		String result = "";
		if((p1.distance(p2)+p2.distance(p3)>p3.distance(p1))&&(p2.distance(p3)+p3.distance(p1)>p1.distance(p2))){
			if(p1.distance(p2)==p2.distance(p3)&&p2.distance(p3)==p1.distance(p3))
				result = "等边三角形";
			else if(p1.distance(p2)==p2.distance(p3)||p2.distance(p3)==p1.distance(p3)||p1.distance(p2)==p1.distance(p3))
				result = "等腰三角形";
			else
				result = "普通三角形";
		}
		else
			result = "不构成三角形";
		return result;
	}
	
}
