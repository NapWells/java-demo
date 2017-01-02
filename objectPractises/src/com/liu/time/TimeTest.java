package com.liu.time;

public class TimeTest {
	public static void main(String  [] args){
		Time t = new Time(21,55,11);
		System.out.println(t);
		t.setHour(22);
		System.out.println(t);
		
		t = t.nextSecond();
		System.out.println(t);
		
		t = t.previousSecond();
		System.out.println(t);
	}
}
