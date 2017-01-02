package com.liu.myTime;

public class MyTimeTest {
	public static void main(String [] args){
		MyTime  time = new MyTime(23,1,34);
		System.out.println(time);
		System.out.println(time.nextSecond());
		System.out.println(time.nextSecond());
		System.out.println(time.nextHour());
		System.out.println(time.nextMinute());
		
		MyTime  time1 = new MyTime(23,59,59);
		System.out.println(time1);
		System.out.println(time1.nextSecond());
		System.out.println(time1.nextSecond());
		time1.setHour(34);
	}
}
