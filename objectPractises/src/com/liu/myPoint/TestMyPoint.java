package com.liu.myPoint;

public class TestMyPoint {
	public static void main(String [] args){
		MyPoint p1 = new MyPoint(3, 4);
		MyPoint p2 = new MyPoint(13, 4);
		System.out.println(p1.distance(3, 11));
		System.out.println(p1.distance());
		System.out.println(p2.distance(p1));
		
		MyPoint [] point = new MyPoint[10];
		for(int i=0;i<10;i++)
			point[i] = new MyPoint(i+1,i+1);
		for(MyPoint p:point)
			System.out.println(p);
	}
}
