package com.liu.myCircle;

import com.liu.myPoint.MyPoint;

public class TestMyCircle {
	public static void main(String [] args){
		MyCircle c1 = new MyCircle(3,4,7);
		MyCircle c2 = new MyCircle(new MyPoint(3,8),14);

		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println(c1.distance(c2));
	}
}
