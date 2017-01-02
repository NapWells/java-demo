package com.liu.myTriangle;

import com.liu.myPoint.MyPoint;

public class MyTriangleTest {
	public static void main(String [] args){
		MyTriangle t1 = new MyTriangle(new MyPoint(2,1),new MyPoint(4,5),new MyPoint(3,8));
		System.out.println(t1.getType());
		System.out.println(t1.getPerimeter());
		System.out.println(t1);
		
		MyTriangle t2 = new MyTriangle(new MyPoint(2,2),new MyPoint(4,4),new MyPoint(3,3));
		System.out.println(t2.getType());
		System.out.println(t2.getPerimeter());
		System.out.println(t2);
		
		MyTriangle t3 = new MyTriangle(new MyPoint(2,2),new MyPoint(2,8),new MyPoint(3,3));
		System.out.println(t3.getType());
		System.out.println(t3.getPerimeter());
		System.out.println(t3);
	}
}
