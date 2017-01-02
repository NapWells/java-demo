package com.liu.date;

public class DateTest {
	public static void main(String [] args){
		Date d = new Date(23,2,1992);
		System.out.println(d);
		d.setDay(22);
		System.out.println(d);
		d.setDay(21);
		System.out.println(d);
		d.setMonth(21);
		System.out.println(d);
		d.setDate(31, 9, 2015);
		System.out.println(d);
	}
}
