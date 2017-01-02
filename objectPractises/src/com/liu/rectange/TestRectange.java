package com.liu.rectange;

public class TestRectange {

	public static void main(String [] args){
		Rectangle r1 = new Rectangle();
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getPerimeter());
		System.out.println("------------------");
		
		Rectangle r2 = new Rectangle(2,4);
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getPerimeter());
		System.out.println("------------------");
		
	}
}
