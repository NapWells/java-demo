package com.liu.circle;

public class TestCircle {
	public static void main(String [] args){
		Circle c = new Circle();
		System.out.println(c.getradius());
		System.out.println(c.getArea());
		System.out.println("-----------------");
		
		Circle c1 = new Circle(4);
		System.out.println(c1.getradius());
		System.out.println(c1.getArea());
		System.out.println("-----------------");
		
		Circle c2 = new Circle(2,"gray");
		System.out.println("面积:"+c2.getArea());
		System.out.println("周长:"+c2.getCircumference());
		System.out.println(c2);
		System.out.println("-----------------");
		
	}
}
